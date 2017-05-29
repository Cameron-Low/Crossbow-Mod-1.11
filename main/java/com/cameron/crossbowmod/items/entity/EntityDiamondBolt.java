package com.cameron.crossbowmod.items.entity;

import com.cameron.crossbowmod.enums.Bolts;
import com.cameron.crossbowmod.items.BaseClasses.EntityBolt;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class EntityDiamondBolt extends EntityBolt{

	public EntityDiamondBolt(World worldIn) {
		super(worldIn);
		this.bolt = Bolts.DIAMOND;
	}
	
	public EntityDiamondBolt(World worldIn, double x, double y, double z)
	{
	    super(worldIn, x, y, z);
	    this.bolt = Bolts.DIAMOND;
	}
	
	public EntityDiamondBolt(World worldIn, EntityLivingBase shooter, Bolts bolt){
		super(worldIn, shooter, bolt);
		this.bolt = Bolts.DIAMOND;
	}
}
