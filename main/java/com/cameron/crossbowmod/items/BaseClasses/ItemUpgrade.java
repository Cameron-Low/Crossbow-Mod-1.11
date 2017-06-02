package com.cameron.crossbowmod.items.BaseClasses;

import com.cameron.crossbowmod.enums.Upgrades;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemUpgrade extends Item {
	public Upgrades upgrade;
	
	public ItemUpgrade(String name, CreativeTabs creativeTab, Upgrades upgrade){
		this.upgrade = upgrade;
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(creativeTab);
		this.setMaxStackSize(1);
	}
	
	public Upgrades getUpgrade(){
		return this.upgrade;
	}
}