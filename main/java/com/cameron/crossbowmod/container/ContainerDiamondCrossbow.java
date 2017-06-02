package com.cameron.crossbowmod.container;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.cameron.crossbowmod.container.slots.BoltSlot;
import com.cameron.crossbowmod.container.slots.UpgradeSlot;
import com.cameron.crossbowmod.inventory.InventoryDiamondCrossbow;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;

public class ContainerDiamondCrossbow extends Container{
	public ContainerDiamondCrossbow(EntityPlayer par1Player, InventoryPlayer inventoryPlayer, InventoryDiamondCrossbow inventoryItem)
	{
		addStorageSlots(inventoryItem);
		addUpgradeSlots(inventoryItem);
        addPlayerSlots(inventoryPlayer);
    }

    private void addPlayerSlots(IInventory playerInventory) {
        // Slots for the main inventory 10-45
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                int x = 8 + col * 18;
                int y = row * 18 + 84;
                this.addSlotToContainer(new Slot(playerInventory, col + row * 9 + 10, x, y));
            }
        }

        // Slots for the hotbar 0-9
        for (int row = 0; row < 9; ++row) {
            int x = 8 + row * 18;
            int y = 142;
            this.addSlotToContainer(new Slot(playerInventory, row, x, y));
        }
    }

    private void addStorageSlots(IInventory inventory) {
        int x = 62;
        int y = 26;

        int slotIndex = 0;
        int slotCount = 0;
        for (int i = 0; i < InventoryDiamondCrossbow.INV_SIZE-2; i++){ 
        	slotCount++;
        	this.addSlotToContainer(new BoltSlot(inventory, slotIndex, x, y));
            slotIndex++;
            x += 18;
            if (slotCount == 3){
            	y += 18;
            	x = 62;
            }
        }
    }
    private void addUpgradeSlots(IInventory inventory) {
        int x = 142;
        int y = 26;

        int slotIndex = InventoryDiamondCrossbow.INV_SIZE-2;
        int slotCount = 0;
        for (int i = 0; i < 2; i++){ 
        	slotCount++;
        	this.addSlotToContainer(new UpgradeSlot(inventory, slotIndex, x, y));
            slotIndex++;
            x += 18;
            if (slotCount == 1){
            	y += 18;
            	x = 142;
            }
        }
    }
	
	@Override
	public boolean canInteractWith(@Nonnull EntityPlayer player)
	{
		return true;
	}
	
    @Nullable
    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            
            if (index < InventoryDiamondCrossbow.INV_SIZE) {
                if (!this.mergeItemStack(itemstack1,InventoryDiamondCrossbow.INV_SIZE, this.inventorySlots.size(), true)) {
                	return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemstack1, 0, InventoryDiamondCrossbow.INV_SIZE, false)) {
            	return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
        }
        
        return itemstack;
    }

	@Override
	public ItemStack slotClick(int slot, int button, ClickType flag, EntityPlayer player) {
		// this will prevent the player from interacting with the item that opened the inventory:
		if (slot >= 0 && getSlot(slot) != null && getSlot(slot).getStack() == player.getHeldItem(EnumHand.MAIN_HAND)) {
			return ItemStack.EMPTY;
		}
		return super.slotClick(slot, button, flag, player);
	}
}
