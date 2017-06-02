package com.cameron.crossbowmod.achievements;

import com.cameron.crossbowmod.ModItems;

import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class AchievementList {
	  public static final Achievement FIRST_CROSSBOW = new Achievement("achievement.firstcrossbow", "firstcrossbow", 0, 0, ModItems.woodCrossbow, (Achievement)null);
	  public static final Achievement BETTER_FIREPOWER = new Achievement("achievement.betterfirepower", "betterfirepower", 2, 0, ModItems.ironCrossbow, FIRST_CROSSBOW);
	  public static final Achievement UPGRADES = new Achievement("achievement.upgrades", "upgrades", 2, -2, ModItems.scopeUpgrade, BETTER_FIREPOWER);
	  public static final Achievement FULL_AUTO = new Achievement("achievement.fullauto", "fullauto", 2, -4, ModItems.autoReloadUpgrade, UPGRADES);
	  public static final Achievement ULTIMATE_KILLING_MACHINE = new Achievement("achievement.ultimatekillingmachine", "ultimatekillingmachine", 4, 0, ModItems.diamondCrossbow, BETTER_FIREPOWER);
	  public static final Achievement TIME_TO_KILL = new Achievement("achievement.timetokill", "timetokill", 0, -2, ModItems.woodBolt, FIRST_CROSSBOW);
	  public static final Achievement BETTER_BOLTS = new Achievement("achievement.betterbolts", "betterbolts", 2, 2, ModItems.ironBolt, BETTER_FIREPOWER);
	  public static final Achievement JUST_ONE_SHOT = new Achievement("achievement.justoneshot", "justoneshot", 4, -2, ModItems.diamondBolt, ULTIMATE_KILLING_MACHINE);
	  public static final Achievement PYRO = new Achievement("achievement.pyro", "pyro", 2, 4, ModItems.flameBolt, BETTER_BOLTS);
	  public static final Achievement ANYWHERE_BUT_HERE = new Achievement("achievement.anywherebuthere", "anywherebuthere", 4, 2, ModItems.teleportBolt, BETTER_BOLTS);
	  public static final Achievement WALLHACKER = new Achievement("achievement.wallhacker", "wallhacker", 0, 2, ModItems.spectralBolt, BETTER_BOLTS);
	  public static final Achievement TIME_FOR_FUN = new Achievement("achievement.timeforefun", "timeforefun", 1, 3, ModItems.explosiveBolt, BETTER_BOLTS);
	  public static final Achievement BRAINFREEZE = new Achievement("achievement.brainfreeze", "brainfreeze", 3, 3, ModItems.freezeBolt, BETTER_BOLTS);
	  public static final Achievement ADVANCED_CAVING = new Achievement("achievement.advancedcaving", "advancedcaving", -2, 0, ModItems.torchBolt, FIRST_CROSSBOW);
	  public static AchievementPage CrossbowAchievements = new AchievementPage("Crossbows", new Achievement[] { FIRST_CROSSBOW, BETTER_FIREPOWER, ULTIMATE_KILLING_MACHINE, TIME_TO_KILL, BETTER_BOLTS, JUST_ONE_SHOT, PYRO, ANYWHERE_BUT_HERE, WALLHACKER, TIME_FOR_FUN, BRAINFREEZE, ADVANCED_CAVING, UPGRADES, FULL_AUTO});
	  
	  public static void initAchievements()
	  {
	    FIRST_CROSSBOW.registerStat();
	    BETTER_FIREPOWER.registerStat();
	    UPGRADES.registerStat();
	    FULL_AUTO.registerStat();
	    ULTIMATE_KILLING_MACHINE.registerStat();
	    TIME_TO_KILL.registerStat();
	    BETTER_BOLTS.registerStat();
	    JUST_ONE_SHOT.registerStat();
	    PYRO.registerStat();
	    ANYWHERE_BUT_HERE.registerStat();
	    WALLHACKER.registerStat();
	    TIME_FOR_FUN.registerStat();
	    BRAINFREEZE.registerStat();
	    ADVANCED_CAVING.registerStat();
	    AchievementPage.registerAchievementPage(CrossbowAchievements);
	  }
}