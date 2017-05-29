package com.cameron.crossbowmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CrossbowTab extends CreativeTabs {

	public CrossbowTab(int index, String label) {
		super(index, label);
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.diamondCrossbow);
	}
}
