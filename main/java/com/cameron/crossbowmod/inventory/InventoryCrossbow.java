package com.cameron.crossbowmod.inventory;

import java.util.UUID;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.common.util.Constants;

public class InventoryCrossbow implements IInventory{
	private String name = "Inventory Item";
	
	/** Provides NBT Tag Compound to reference */
	private final ItemStack invItem;

	/** Defining your inventory size this way is handy */
	public static final int INV_SIZE = 12;
	
	protected String uniqueID;

	/** Inventory's size must be same as number of slots you add to the Container class */
	private ItemStack[] inventory = new ItemStack[INV_SIZE];
	
	public InventoryCrossbow(ItemStack stack) {
		invItem = stack;
		for (int i = 0; i < inventory.length; i++) {
            inventory[i] = ItemStack.EMPTY;
        }
		// note that it's okay to use stack instead of invItem right there
		// both reference the same memory location, so whatever you change using
		// either reference will change in the other

		uniqueID = "";

		if (!stack.hasTagCompound())
		{
			stack.setTagCompound(new NBTTagCompound());
			// no tag compound means the itemstack does not yet have a UUID, so assign one:
			uniqueID = UUID.randomUUID().toString();
		}
		
		// Read the inventory contents from NBT
		readFromNBT(stack.getTagCompound());
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean hasCustomName() {
		return name.length() > 0;
	}

	@Override
	public ITextComponent getDisplayName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSizeInventory() {
		return inventory.length;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		return inventory[index];
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		ItemStack stack = getStackInSlot(index);
		if(stack != null)
		{
			if(stack.getCount() > count)
			{
				stack = stack.splitStack(count);
				// Don't forget this line or your inventory will not be saved!
				markDirty();
			}
			else
			{
				// this method also calls onInventoryChanged, so we don't need to call it again
				setInventorySlotContents(index, ItemStack.EMPTY);
			}
		}
		return stack;
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		inventory[index] = stack;

		if (stack != null && stack.getCount() > getInventoryStackLimit())
		{
			stack.setCount(getInventoryStackLimit());
		}

		// Don't forget this line or your inventory will not be saved!
		markDirty();
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public void markDirty() {
		for (int i = 0; i < getSizeInventory(); ++i)
		{
			if (getStackInSlot(i) != ItemStack.EMPTY && getStackInSlot(i).isEmpty()) {
				inventory[i] = ItemStack.EMPTY;
			}
		}
		
		// This line here does the work:		
		writeToNBT(invItem.getTagCompound());
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer player) {
		return true;
	}

	@Override
	public void openInventory(EntityPlayer player) {
	}

	@Override
	public void closeInventory(EntityPlayer player) {
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		return true;
	}
	
	/**
	 * A custom method to read our inventory from an ItemStack's NBT compound
	 */
	public void readFromNBT(NBTTagCompound compound)
	{
		if ("".equals(uniqueID))
		{
			// try to read unique ID from NBT
			uniqueID = compound.getString("uniqueID");
			// if it's still "", assign a new one:
			if ("".equals(uniqueID))
			{
				uniqueID = UUID.randomUUID().toString();
			}
		}
		
		// Gets the custom taglist we wrote to this compound, if any
		// 1.7.2+ change to compound.getTagList("ItemInventory", Constants.NBT.TAG_COMPOUND);
		NBTTagList items = compound.getTagList("InventoryCrossbow", Constants.NBT.TAG_COMPOUND);

		for (int i = 0; i < items.tagCount(); ++i)
		{
			// 1.7.2+ change to items.getCompoundTagAt(i)
			NBTTagCompound item = (NBTTagCompound) items.getCompoundTagAt(i);
			int slot = item.getInteger("Slot");

			// Just double-checking that the saved slot index is within our inventory array bounds
			if (slot >= 0 && slot < getSizeInventory()) {
				inventory[slot] = new ItemStack(item);
			}
		}
	}

	/**
	 * A custom method to write our inventory to an ItemStack's NBT compound
	 */
	public void writeToNBT(NBTTagCompound tagcompound)
	{
		tagcompound.setString("uniqueID", this.uniqueID);
		// Create a new NBT Tag List to store itemstacks as NBT Tags
		NBTTagList items = new NBTTagList();

		for (int i = 0; i < getSizeInventory(); ++i)
		{
			// Only write stacks that contain items
			if (getStackInSlot(i) != ItemStack.EMPTY)
			{
				
				// Make a new NBT Tag Compound to write the itemstack and slot index to
				NBTTagCompound item = new NBTTagCompound();
				item.setInteger("Slot", i);
				// Writes the itemstack in slot(i) to the Tag Compound we just made
				getStackInSlot(i).writeToNBT(item);

				// add the tag compound to our tag list
				items.appendTag(item);
			}
		}
		// Add the TagList to the ItemStack's Tag Compound with the name "ItemInventory"
		tagcompound.setTag("InventoryCrossbow", items);
	}
	

	@Override
	public int getField(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setField(int id, int value) {

	}

	@Override
	public int getFieldCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		 for (int i = 0; i < this.getSizeInventory(); i++)
	            this.setInventorySlotContents(i, ItemStack.EMPTY);
	}

}
