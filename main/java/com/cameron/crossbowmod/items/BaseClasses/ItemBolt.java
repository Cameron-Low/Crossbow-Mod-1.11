package com.cameron.crossbowmod.items.BaseClasses;

import com.cameron.crossbowmod.enums.Bolts;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemBolt extends Item {
	public Bolts bolt;
	
	public ItemBolt(String name, CreativeTabs creativeTab, Bolts bolt){
		this.bolt = bolt;
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(creativeTab);
	}

    public boolean isInfinite(ItemStack stack, ItemStack crossbow, net.minecraft.entity.player.EntityPlayer player)
    {
        int enchant = net.minecraft.enchantment.EnchantmentHelper.getEnchantmentLevel(net.minecraft.init.Enchantments.INFINITY, crossbow);
        return enchant <= 0 ? false : this.getClass() == ItemBolt.class;
    }

	public Bolts getBolt() {
		return this.bolt;
	}

}
