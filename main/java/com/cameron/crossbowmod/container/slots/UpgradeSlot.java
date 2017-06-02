package com.cameron.crossbowmod.container.slots;

import com.cameron.crossbowmod.items.BaseClasses.ItemUpgrade;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class UpgradeSlot extends Slot{

	public UpgradeSlot(IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack)
    {
        if (stack.getItem() instanceof ItemUpgrade){
        	return true;
        }
        return false;
    }

}
