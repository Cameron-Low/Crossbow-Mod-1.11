package com.cameron.crossbowmod.items.BaseClasses;

import java.util.ArrayList;

import javax.annotation.Nullable;

import com.cameron.crossbowmod.CrossbowModMain;
import com.cameron.crossbowmod.Ref;
import com.cameron.crossbowmod.enums.Bolts;
import com.cameron.crossbowmod.enums.Materials;
import com.cameron.crossbowmod.enums.Upgrades;
import com.cameron.crossbowmod.inventory.InventoryDiamondCrossbow;
import com.cameron.crossbowmod.inventory.InventoryIronCrossbow;
import com.cameron.crossbowmod.inventory.InventoryStoneCrossbow;
import com.cameron.crossbowmod.items.entity.EntityDiamondBolt;
import com.cameron.crossbowmod.items.entity.EntityExplosiveBolt;
import com.cameron.crossbowmod.items.entity.EntityFlameBolt;
import com.cameron.crossbowmod.items.entity.EntityFreezeBolt;
import com.cameron.crossbowmod.items.entity.EntityGoldBolt;
import com.cameron.crossbowmod.items.entity.EntityIronBolt;
import com.cameron.crossbowmod.items.entity.EntitySpectralBolt;
import com.cameron.crossbowmod.items.entity.EntityStoneBolt;
import com.cameron.crossbowmod.items.entity.EntityTeleportBolt;
import com.cameron.crossbowmod.items.entity.EntityTorchBolt;
import com.cameron.crossbowmod.items.entity.EntityWoodBolt;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemCrossbow extends Item
{
	public float strength;
	final Materials material;
	float multiplier;
	Bolts bolt;
	boolean fromStorage;
	int slot;
	public ArrayList<Upgrades> upgrades = new ArrayList<Upgrades>();
	
    public ItemCrossbow(String name, CreativeTabs creativeTab, final Materials material, final float multiplier)
    {
    	this.material = material;
    	this.multiplier = multiplier;
    	this.bolt = material.bolt;
        this.maxStackSize = 1;
        this.strength = material.strength * multiplier;
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setMaxDamage((int) (material.durability * multiplier));
        this.setCreativeTab(creativeTab);
        this.fromStorage = false;
        this.slot = 0;
        this.addPropertyOverride(new ResourceLocation("pull"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                return entityIn == null ? 0.0F : (entityIn.getActiveItemStack().getItem() instanceof ItemCrossbow) && !((ItemCrossbow) entityIn.getActiveItemStack().getItem()).upgrades.contains(Upgrades.AUTO_RELOAD) ? (float)(stack.getMaxItemUseDuration() - entityIn.getItemInUseCount()) / (material.drawbackSpeed * multiplier): 0.0F;
            }
        });
        this.addPropertyOverride(new ResourceLocation("pulling"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });
        
    }
    
    @Override
    public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
    	super.onEntitySwing(entityLiving, stack);
    	if (entityLiving instanceof EntityPlayer){
    		EntityPlayer player = (EntityPlayer) entityLiving;
    		if (!player.world.isRemote)
    		{
    			int guiId = 0;
    			switch (this.material) {
				case DIAMOND:
					guiId = Ref.DIAMOND_CROSSBOW_GUI_ID;
					break;
				case GOLD:
					guiId = Ref.IRON_CROSSBOW_GUI_ID;
					break;
				case IRON:
					guiId = Ref.IRON_CROSSBOW_GUI_ID;
					break;
				case STONE:
					guiId = Ref.STONE_CROSSBOW_GUI_ID;
					break;
				case WOOD:
					guiId = Ref.STONE_CROSSBOW_GUI_ID;
					break;
				default:
					break;
				}
    			player.openGui(CrossbowModMain.instance, guiId, player.world, (int)player.posX, (int)player.posY, (int)player.posZ);
    		}
    		return false;
    	}
    	return true;
    }

    private ItemStack findAmmo(EntityPlayer player)
    {
        if (this.isBolt(player.getHeldItem(EnumHand.OFF_HAND)))
        {
            return player.getHeldItem(EnumHand.OFF_HAND);
        }
        else if (this.isBolt(player.getHeldItem(EnumHand.MAIN_HAND)))
        {
            return player.getHeldItem(EnumHand.MAIN_HAND);
        }
        else
        {
            for (int i = 0; i < player.inventory.getSizeInventory(); ++i)
            {
                ItemStack itemstack = player.inventory.getStackInSlot(i);
                if(itemstack.getItem() instanceof ItemCrossbow){
                	int invSize = 0;
        			switch (this.material) {
    				case DIAMOND:
    					invSize = InventoryDiamondCrossbow.INV_SIZE;
    					break;
    				case GOLD:
    					invSize = InventoryIronCrossbow.INV_SIZE;
    					break;
    				case IRON:
    					invSize = InventoryIronCrossbow.INV_SIZE;
    					break;
    				case STONE:
    					invSize = InventoryStoneCrossbow.INV_SIZE;
    					break;
    				case WOOD:
    					invSize = InventoryStoneCrossbow.INV_SIZE;
    					break;
    				default:
    					break;
    				}
                	for (int j = 0; j < invSize; ++j){
						ItemStack temp = ((ItemCrossbow)itemstack.getItem()).readFromNBT(itemstack.getTagCompound(), j);
						if (isBolt(temp)){
							fromStorage = true;
							slot = j;
							return temp;
						}
					}
                }
                fromStorage = false;
                if (this.isBolt(itemstack))
                {
                    return itemstack;
                }
            }

            return ItemStack.EMPTY;
        }
    }

    protected boolean isBolt(ItemStack stack)
    {
    	if (stack.getItem() instanceof ItemBolt){
    		this.bolt = ((ItemBolt)stack.getItem()).getBolt();
    		
    		return this.bolt.tier <= this.material.tier;
    	}
    	return false;
    }

    /**
     * Called when the player stops using an Item (stops holding the right mouse button).
     */
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft)
    {
        if (entityLiving instanceof EntityPlayer)
        {
            EntityPlayer entityplayer = (EntityPlayer)entityLiving;
            boolean flag = entityplayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
            ItemStack itemstack = this.findAmmo(entityplayer);
            if (this.upgrades.contains(Upgrades.AUTO_RELOAD)) return;
            int i = this.getMaxItemUseDuration(stack) - timeLeft;
            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, entityplayer, i, !itemstack.isEmpty() || flag);
            if (i < 0) return;

            if (!itemstack.isEmpty() || flag)
            {
            	if (itemstack == ItemStack.EMPTY)
                {
            		itemstack = new ItemStack(material.bolt.bolt);
                }
            }
            fireBolt(stack, worldIn, entityplayer, i);
        }
    }

    /**
     * Gets the velocity of the arrow entity from the bow's charge
     */
    public float getBoltVelocity(int charge)
    {
    	float f = (float) (charge / (material.drawbackSpeed * multiplier));
    	
        if (f > 1.0F)
        {
            f = 1.0F;
        }

        return f;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack stack)
    {
        return this.upgrades.contains(Upgrades.AUTO_RELOAD) ? 0 : 72000;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return this.upgrades.contains(Upgrades.AUTO_RELOAD) ? EnumAction.NONE : EnumAction.BOW;
    }
    
    public EntityBolt selectBolt(World worldIn, EntityPlayer entityplayer ){
    	switch (this.bolt) {
		case WOOD:
			return new EntityWoodBolt(worldIn, entityplayer, this.bolt);
		case STONE:
			return new EntityStoneBolt(worldIn, entityplayer, this.bolt);
		case IRON:
			return new EntityIronBolt(worldIn, entityplayer, this.bolt);
		case GOLD:
			return new EntityGoldBolt(worldIn, entityplayer, this.bolt);
		case DIAMOND:
			return new EntityDiamondBolt(worldIn, entityplayer, this.bolt);
		case EXPLOSIVE:
			return new EntityExplosiveBolt(worldIn, entityplayer, this.bolt);
		case FLAME:
			return new EntityFlameBolt(worldIn, entityplayer, this.bolt);
		case TELEPORT:
			return new EntityTeleportBolt(worldIn, entityplayer, this.bolt);
		case TORCH:
			return new EntityTorchBolt(worldIn, entityplayer, this.bolt);
		case FREEZE:
			return new EntityFreezeBolt(worldIn, entityplayer, this.bolt);
		case SPECTRAL:
			return new EntitySpectralBolt(worldIn, entityplayer, this.bolt);
		default:
			return new EntityBolt(worldIn, entityplayer, this.bolt);
    	}
    }
    
    public void fireBolt(ItemStack stack, World worldIn, EntityPlayer entityplayer, int i){
    	ItemStack itemstack = this.findAmmo(entityplayer);
    	if (fromStorage){
        	((ItemCrossbow)stack.getItem()).writeToNBT(stack.getTagCompound(), this.slot);
        }
    	float f = getBoltVelocity(i);

        if ((double)f >= 0.1D)
        {
            boolean flag1 = entityplayer.capabilities.isCreativeMode || (itemstack.getItem() instanceof ItemBolt && ((ItemBolt) itemstack.getItem()).isInfinite(itemstack, stack, entityplayer));
	    	if (!worldIn.isRemote)
	        {
	        	EntityBolt entityBolt;
	        	entityBolt = selectBolt(worldIn, entityplayer);
	           
	            
	            if (this.bolt == Bolts.FLAME){
	            	entityBolt.setFire(100);
	            }
	            if (f == 1.0F)
	            {
	            	entityBolt.setIsCritical(true);
	            }
	
	            int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);
	
	            if (j > 0)
	            {
	            	entityBolt.setDamage(entityBolt.getDamage() + (double)j * 0.5D + 0.5D);
	            }
	
	            int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);
	
	            if (k > 0)
	            {
	            	entityBolt.setKnockbackStrength(k);
	            }
	
	            if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0)
	            {
	            	entityBolt.setFire(100);
	            }
	            
	            if (!(this.upgrades.contains(Upgrades.REINFORCED_LIMBS))){
	            	stack.damageItem(1, entityplayer);
	            }
	            
	
	            if (flag1 || entityplayer.capabilities.isCreativeMode)
	            {
	            	entityBolt.pickupStatus = EntityBolt.PickupStatus.CREATIVE_ONLY;
	            }
	            
	            if (this.upgrades.contains(Upgrades.TRI_SHOT)){
	            	entityBolt.setAim(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F, f * this.material.strength, 1.0F);
	            	worldIn.spawnEntity(entityBolt);
	            	entityBolt.pickupStatus = EntityBolt.PickupStatus.DISALLOWED;
	            	entityBolt = selectBolt(worldIn, entityplayer);
	            	entityBolt.setAim(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw-7, 0.0F, f * this.material.strength, 1.0F);
	            	worldIn.spawnEntity(entityBolt);
	            	entityBolt.pickupStatus = EntityBolt.PickupStatus.DISALLOWED;
	            	entityBolt = selectBolt(worldIn, entityplayer);
	            	entityBolt.setAim(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw+7, 0.0F, f * this.material.strength, 1.0F);
	            	worldIn.spawnEntity(entityBolt);
	            } else {
	            	entityBolt.setAim(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F, f * this.material.strength, 1.0F);
	            	worldIn.spawnEntity(entityBolt);
	            }
	            
	        }
	
	        worldIn.playSound((EntityPlayer)null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
	
	        if (!flag1 && !entityplayer.capabilities.isCreativeMode)
	        {
	        	itemstack.shrink(1);
	
	            if (itemstack.isEmpty())
	            {
	                entityplayer.inventory.deleteStack(itemstack);
	            }
	        }
	
	        entityplayer.addStat(StatList.getObjectUseStats(this));
        }
    }
    
    @Override
    /**
     * Called when the equipped item is right clicked.
     */
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack crossbow = playerIn.getHeldItem(handIn);
        if(crossbow.getItem() instanceof ItemCrossbow){
        	this.upgrades = new ArrayList<Upgrades>();
        	int invSize = 0;
			switch (this.material) {
			case DIAMOND:
				invSize = InventoryDiamondCrossbow.INV_SIZE;
				break;
			case GOLD:
				invSize = InventoryIronCrossbow.INV_SIZE;
				break;
			case IRON:
				invSize = InventoryIronCrossbow.INV_SIZE;
				break;
			default:
				break;
			}
        	for (int j = 0; j < invSize; ++j){
				ItemStack temp = ((ItemCrossbow)crossbow.getItem()).readFromNBT(crossbow.getTagCompound(), j);
				
				if (temp.getItem() instanceof ItemUpgrade){
					this.upgrades.add(((ItemUpgrade) temp.getItem()).getUpgrade());
				}
			}
        }
        
        boolean flag = !this.findAmmo(playerIn).isEmpty();

        ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(crossbow, worldIn, playerIn, handIn, flag);
        if (ret != null && !this.upgrades.contains(Upgrades.AUTO_RELOAD)) return ret;

        if (!playerIn.capabilities.isCreativeMode && !flag)
        {
            return flag ? new ActionResult<ItemStack>(EnumActionResult.PASS, crossbow) : new ActionResult<ItemStack>(EnumActionResult.FAIL, crossbow);
        }
        else
        {
            playerIn.setActiveHand(handIn);
			
			if (this.upgrades.contains(Upgrades.AUTO_RELOAD)){
				fireBolt(crossbow ,worldIn, playerIn, 72000);
			}
			
            return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, crossbow);
        }
        
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return 1;
    }
    
    public ItemStack readFromNBT(NBTTagCompound compound, int index)
	{
		if (compound == null){
			return ItemStack.EMPTY;
		}
		NBTTagList items = compound.getTagList("InventoryCrossbow", Constants.NBT.TAG_COMPOUND);
		NBTTagCompound item = (NBTTagCompound) items.getCompoundTagAt(index);
		return new ItemStack(item);
	}
	
	public void writeToNBT(NBTTagCompound tagcompound, int index)
	{
		NBTTagList items = tagcompound.getTagList("InventoryCrossbow", Constants.NBT.TAG_COMPOUND);
		NBTTagCompound item = (NBTTagCompound) items.getCompoundTagAt(index);
		int currentCount = item.getInteger("Count");
		if (currentCount == 1){
			items.removeTag(index);
		} else {
			item.setInteger("Count", currentCount-1);
		}
	}
}