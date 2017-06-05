package com.cameron.crossbowmod;

import net.minecraft.creativetab.CreativeTabs;

public class Ref {
	//Mod Details
    public static final String MODID = "crossbowmod";
    public static final String MODNAME = "Crossbow Mod";
    public static final String VERSION = "1.6";
    public static final String ACCEPTEDMINECRAFTVERSION = "[1.11.2]";
	
    //Creative Tab
    public static CreativeTabs tabCustom = new CrossbowTab(CreativeTabs.getNextID(), "Crossbow Mod");
    
	//Item Stats
    public static final float LightWeightMultiplier = 0.8f;
    public static final float StrengthMultiplier = 1.35f;
    
    public static final int DIAMOND_CROSSBOW_GUI_ID = 1;
    public static final int IRON_CROSSBOW_GUI_ID = 2;
    public static final int STONE_CROSSBOW_GUI_ID = 3;
}
