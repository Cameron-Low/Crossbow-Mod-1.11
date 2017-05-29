package com.cameron.crossbowmod.items.BaseClasses;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBinding extends Item {
	public ItemBinding(String name, CreativeTabs creativeTab){
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(creativeTab);
	}
}
