package com.cameron.crossbowmod.items.BaseClasses;

import javax.annotation.Nullable;

import com.cameron.crossbowmod.enums.Bolts;
import com.cameron.crossbowmod.enums.Materials;
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
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemCrossbow extends Item
{
	public float strength;
	final Materials material;
	float multiplier;
	Bolts bolt;
	
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
        this.addPropertyOverride(new ResourceLocation("pull"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                return entityIn == null ? 0.0F : (entityIn.getActiveItemStack().getItem() instanceof ItemCrossbow) ? (float)(stack.getMaxItemUseDuration() - entityIn.getItemInUseCount()) / (material.drawbackSpeed * multiplier): 0.0F;
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

            int i = this.getMaxItemUseDuration(stack) - timeLeft;
            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, entityplayer, i, !itemstack.isEmpty() || flag);
            if (i < 0) return;

            if (!itemstack.isEmpty() || flag)
            {
            	if (itemstack == ItemStack.EMPTY)
                {
            		itemstack = new ItemStack(bolt.bolt);
                }
                float f = getBoltVelocity(i);

                if ((double)f >= 0.1D)
                {
                    boolean flag1 = entityplayer.capabilities.isCreativeMode || (itemstack.getItem() instanceof ItemBolt && ((ItemBolt) itemstack.getItem()).isInfinite(itemstack, stack, entityplayer));

                    if (!worldIn.isRemote)
                    {
                    	EntityBolt entityBolt;
                    	switch (this.bolt) {
							case WOOD:
								entityBolt = new EntityWoodBolt(worldIn, entityplayer, this.bolt);
								break;
							case STONE:
								 entityBolt = new EntityStoneBolt(worldIn, entityplayer, this.bolt);
								 break;
							case IRON:
								entityBolt = new EntityIronBolt(worldIn, entityplayer, this.bolt);
								break;
							case GOLD:
								 entityBolt = new EntityGoldBolt(worldIn, entityplayer, this.bolt);
								 break;
							case DIAMOND:
								entityBolt = new EntityDiamondBolt(worldIn, entityplayer, this.bolt);
								break;
							case EXPLOSIVE:
								 entityBolt = new EntityExplosiveBolt(worldIn, entityplayer, this.bolt);
								 break;
							case FLAME:
								entityBolt = new EntityFlameBolt(worldIn, entityplayer, this.bolt);
								break;
							case TELEPORT:
								 entityBolt = new EntityTeleportBolt(worldIn, entityplayer, this.bolt);
								 break;
							case TORCH:
								entityBolt = new EntityTorchBolt(worldIn, entityplayer, this.bolt);
								break;
							case FREEZE:
								 entityBolt = new EntityFreezeBolt(worldIn, entityplayer, this.bolt);
								 break;
							case SPECTRAL:
								entityBolt = new EntitySpectralBolt(worldIn, entityplayer, this.bolt);
								break;
							default:
								entityBolt = new EntityBolt(worldIn, entityplayer, this.bolt);
						}
                       
                        entityBolt.setAim(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F, f * this.material.strength, 1.0F);
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

                        stack.damageItem(1, entityplayer);

                        if (flag1 || entityplayer.capabilities.isCreativeMode && (itemstack.getItem() == Items.SPECTRAL_ARROW || itemstack.getItem() == Items.TIPPED_ARROW))
                        {
                        	entityBolt.pickupStatus = EntityBolt.PickupStatus.CREATIVE_ONLY;
                        }
                        worldIn.spawnEntity(entityBolt);
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
        }
    }

    /**
     * Gets the velocity of the arrow entity from the bow's charge
     */
    public float getBoltVelocity(int charge)
    {
        float f = (float)charge / 1.8f;
        f = f / (this.material.drawbackSpeed * this.multiplier);
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
        return 72000;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.BOW;
    }

    /**
     * Called when the equipped item is right clicked.
     */
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        boolean flag = !this.findAmmo(playerIn).isEmpty();

        ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, worldIn, playerIn, handIn, flag);
        if (ret != null) return ret;

        if (!playerIn.capabilities.isCreativeMode && !flag)
        {
            return flag ? new ActionResult<ItemStack>(EnumActionResult.PASS, itemstack) : new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
        }
        else
        {
            playerIn.setActiveHand(handIn);
            return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
        }
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return 1;
    }
}