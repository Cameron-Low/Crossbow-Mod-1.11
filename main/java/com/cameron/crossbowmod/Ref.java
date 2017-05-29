package com.cameron.crossbowmod;

import net.minecraft.creativetab.CreativeTabs;

public class Ref {
	//Mod Details
    public static final String MODID = "crossbowmod";
    public static final String MODNAME = "Crossbow Mod";
    public static final String VERSION = "1.5";
    public static final String ACCEPTEDMINECRAFTVERSION = "[1.11.2]";
	
    //Creative Tab
    public static CreativeTabs tabCustom = new CrossbowTab(CreativeTabs.getNextID(), "Crossbow Mod");
    
	//Item Stats
    public static final float LightWeightMultiplier = 0.8f;
    public static final float StrengthMultiplier = 1.35f;
}
