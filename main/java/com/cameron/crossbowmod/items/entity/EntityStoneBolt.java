package com.cameron.crossbowmod.items.entity;

import com.cameron.crossbowmod.enums.Bolts;
import com.cameron.crossbowmod.items.BaseClasses.EntityBolt;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class EntityStoneBolt extends EntityBolt{

	public EntityStoneBolt(World worldIn) {
		super(worldIn);
		this.bolt = Bolts.STONE;
	}
	
	public EntityStoneBolt(World worldIn, double x, double y, double z)
	{
	    super(worldIn, x, y, z);
	    this.bolt = Bolts.STONE;
	}
	
	public EntityStoneBolt(World worldIn, EntityLivingBase shooter, Bolts bolt){
		super(worldIn, shooter, bolt);
		this.bolt = Bolts.STONE;
	}
}
