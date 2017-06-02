package com.cameron.crossbowmod.container.slots;

import com.cameron.crossbowmod.items.BaseClasses.ItemBolt;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class BoltSlot extends Slot{

	public BoltSlot(IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack)
    {
        if (stack.getItem() instanceof ItemBolt){
        	return true;
        }
        return false;
    }

}
