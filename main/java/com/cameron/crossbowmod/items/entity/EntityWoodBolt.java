package com.cameron.crossbowmod.items.entity;

import com.cameron.crossbowmod.enums.Bolts;
import com.cameron.crossbowmod.items.BaseClasses.EntityBolt;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class EntityWoodBolt extends EntityBolt{

	public EntityWoodBolt(World worldIn) {
		super(worldIn);
		this.bolt = Bolts.WOOD;
	}
	
	public EntityWoodBolt(World worldIn, double x, double y, double z)
	{
	    super(worldIn, x, y, z);
	    this.bolt = Bolts.WOOD;
	}
	
	public EntityWoodBolt(World worldIn, EntityLivingBase shooter, Bolts bolt){
		super(worldIn, shooter, bolt);
		this.bolt = Bolts.WOOD;
	}
}
