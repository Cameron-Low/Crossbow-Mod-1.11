package com.cameron.crossbowmod.enums;

public enum Materials {
	WOOD(32, 2.0f, 20.0f, Bolts.WOOD, 1),
	STONE(64, 2.5f, 15.0f, Bolts.STONE, 2),
	IRON(256, 3.75f, 10.0f, Bolts.IRON, 3),
	GOLD(64, 3.0f, 5.0f, Bolts.GOLD, 3),
	DIAMOND(1024, 5.0f, 10.0f, Bolts.DIAMOND, 4),
	NULL(0, 0, 0, Bolts.NULL, 0);
	
	public int durability;
	public float strength;
	public float drawbackSpeed;
	public Bolts bolt;
	public int tier;
	
	private Materials(int durability, float strength, float drawBackSpeed, Bolts bolt, int tier) {
		this.durability = durability;
		this.strength = strength;
		this.drawbackSpeed = drawBackSpeed;
		this.bolt = bolt;
		this.tier = tier;
	}
}
