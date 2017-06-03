package com.cameron.crossbowmod.items.BaseClasses;

import com.cameron.crossbowmod.ModItems;
import com.cameron.crossbowmod.enums.Bolts;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;

public class EntityBolt extends EntityArrow implements IEntityAdditionalSpawnData{
	public Bolts bolt;
	
	public EntityBolt(World worldIn) {
		super(worldIn);
	}
	
	public EntityBolt(World worldIn, double x, double y, double z)
	{
	    this(worldIn);
	    this.setPosition(x, y, z);
	}
	
	public EntityBolt(World worldIn, EntityLivingBase shooter, Bolts bolt)
	{
	    this(worldIn, shooter.posX, shooter.posY + (double)shooter.getEyeHeight() - 0.10000000149011612D, shooter.posZ);
	    this.shootingEntity = shooter;
	    if (shooter instanceof EntityPlayer)
        {
            this.pickupStatus = EntityArrow.PickupStatus.ALLOWED;
        }
	    
	    this.bolt = bolt;
	    
	    this.setDamage(bolt.damage);
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
	    if (this.inGround)
	    {
	    	if (!this.world.isRemote){
		    	switch (this.bolt) {
				case EXPLOSIVE:
					this.world.createExplosion(this, this.posX, this.posY + (double)(this.height / 16.0F), this.posZ, (float) this.bolt.damage, true);
					this.setDead();
					break;
				case TORCH:
					this.world.setBlockState(this.getPosition(), Blocks.TORCH.getStateForPlacement(world, this.getPosition(), EnumFacing.UP, (float)this.posX, (float)this.posY, (float)this.posZ, 0, (EntityLivingBase) this.shootingEntity, EnumHand.MAIN_HAND));
					this.setDead();
				default:
					break;
				}
	    	}
	    } else {
		    if (!this.hasNoGravity())
	        {
	            this.motionY += 0.01000000074505806D;
	        }
	    }
	}
	
	@Override
	protected void onHit(RayTraceResult raytraceResultIn) {
		super.onHit(raytraceResultIn);
	    if(!this.world.isRemote){
	        if (this.bolt == Bolts.TELEPORT){
	        	if(shootingEntity.world == this.world){
					EnderTeleportEvent event = new EnderTeleportEvent((EntityLivingBase) shootingEntity, this.posX, this.posY, this.posZ, 5.0F);
					if(!MinecraftForge.EVENT_BUS.post(event)){	
						this.shootingEntity.setPositionAndUpdate(event.getTargetX(), event.getTargetY(), event.getTargetZ());
						this.shootingEntity.fallDistance = 0.0F;
						this.setDead();
						return;
					}
				}
	        }
	    }
	}
	
	public Bolts getBolt() {
		return this.bolt;
	}
	
	@Override
	public boolean getIsCritical()
	{
	    return false;
	}
	
	@Override
	protected ItemStack getArrowStack() {
		switch (this.bolt) {
		case WOOD:
			return new ItemStack(ModItems.woodBolt);
		case STONE:
			return new ItemStack(ModItems.stoneBolt);
		case IRON:
			return new ItemStack(ModItems.ironBolt);
		case GOLD:
			return new ItemStack(ModItems.goldBolt);
		case DIAMOND:
			return new ItemStack(ModItems.diamondBolt);
		case EXPLOSIVE:
			return new ItemStack(ModItems.explosiveBolt);
		case FLAME:
			return new ItemStack(ModItems.flameBolt);
		case TELEPORT:
			return new ItemStack(ModItems.teleportBolt);
		case TORCH:
			return new ItemStack(ModItems.torchBolt);
		case FREEZE:
			return new ItemStack(ModItems.freezeBolt);
		case SPECTRAL:
			return new ItemStack(ModItems.spectralBolt);
		default:
			return new ItemStack(ModItems.woodBolt);
		}
	}
	
	@Override
	protected void arrowHit(EntityLivingBase living)
	{
		if (this.bolt == Bolts.SPECTRAL){
	        PotionEffect potioneffect = new PotionEffect(MobEffects.GLOWING, 100, 1);
	        living.addPotionEffect(potioneffect);
		} else if (this.bolt == Bolts.FREEZE){
	        PotionEffect potioneffect = new PotionEffect(MobEffects.SLOWNESS, 100, 3);
	        living.addPotionEffect(potioneffect);
		}
	}

    public void onCollideWithPlayer(EntityPlayer entityIn)
    {
        if (!this.world.isRemote && this.inGround && this.arrowShake <= 0)
        {
            boolean flag = this.pickupStatus == EntityArrow.PickupStatus.ALLOWED || this.pickupStatus == EntityArrow.PickupStatus.CREATIVE_ONLY && entityIn.capabilities.isCreativeMode;
            if (this.pickupStatus == EntityArrow.PickupStatus.ALLOWED && !entityIn.inventory.addItemStackToInventory(this.getArrowStack()))
            {
                flag = false;
            }
            if (flag)
            {
                entityIn.onItemPickup(this, 1);
                this.setDead();
            }
        }
    }

	@Override
	public void writeSpawnData(ByteBuf buffer) {
		try {
			buffer.writeInt(this.shootingEntity.getEntityId());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void readSpawnData(ByteBuf additionalData) {
		Entity shooter = world.getEntityByID(additionalData.readInt());
		if (shooter instanceof EntityLivingBase) {
		shootingEntity = (EntityLivingBase) shooter;
		}
	}
}