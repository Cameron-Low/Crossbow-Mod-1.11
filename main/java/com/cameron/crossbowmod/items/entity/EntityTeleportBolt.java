package com.cameron.crossbowmod.items.entity;

import com.cameron.crossbowmod.enums.Bolts;
import com.cameron.crossbowmod.items.BaseClasses.EntityBolt;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class EntityTeleportBolt extends EntityBolt{

	public EntityTeleportBolt(World worldIn) {
		super(worldIn);
		this.bolt = Bolts.TELEPORT;
	}
	
	public EntityTeleportBolt(World worldIn, double x, double y, double z)
	{
	    super(worldIn, x, y, z);
	    this.bolt = Bolts.TELEPORT;
	}
	
	public EntityTeleportBolt(World worldIn, EntityLivingBase shooter, Bolts bolt){
		super(worldIn, shooter, bolt);
		this.bolt = Bolts.TELEPORT;
	}
}
