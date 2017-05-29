package com.cameron.crossbowmod.enums;

import com.cameron.crossbowmod.ModItems;

import net.minecraft.item.Item;

public enum Bolts {
	WOOD(1.0d, ModItems.woodBolt, "wood_bolt_render_images",1),
	STONE(1.5d, ModItems.stoneBolt, "stone_bolt_render_images",2),
	IRON(2.0d, ModItems.ironBolt, "iron_bolt_render_images",3),
	GOLD(3.0d, ModItems.goldBolt, "gold_bolt_render_images",3),
	DIAMOND(4.0d, ModItems.diamondBolt, "diamond_bolt_render_images",4),
	EXPLOSIVE(2.0d, ModItems.explosiveBolt, "explosive_bolt_render_images",3),
	FLAME(2.0d, ModItems.flameBolt, "flame_bolt_render_images",3),
	SPECTRAL(2.0d, ModItems.spectralBolt, "spectral_bolt_render_images",3),
	TELEPORT(0.0d, ModItems.teleportBolt, "teleport_bolt_render_images",3),
	TORCH(0.0d, ModItems.torchBolt, "torch_bolt_render_images",3),
	FREEZE(1.5d, ModItems.freezeBolt, "freeze_bolt_render_images",3),
	NULL(0.0d, null, "", 0);
	
	public double damage;
	public Item bolt;
	public String boltTexture;
	public int tier;
	
	private Bolts(double damage, Item bolt, String boltTexture, int tier) {
		this.damage = damage;
		this.bolt = bolt;
		this.boltTexture = boltTexture;
		this.tier = tier;
	}
}
