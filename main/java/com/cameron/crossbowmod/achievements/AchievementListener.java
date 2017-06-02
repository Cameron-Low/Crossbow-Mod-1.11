package com.cameron.crossbowmod.achievements;

import com.cameron.crossbowmod.ModItems;
import com.cameron.crossbowmod.items.BaseClasses.ItemUpgrade;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class AchievementListener
{
  @SubscribeEvent
  public void onItemCrafted(PlayerEvent.ItemCraftedEvent event)
  {
    if (event.crafting.getItem() == ModItems.woodCrossbow) {
      event.player.addStat(AchievementList.FIRST_CROSSBOW, 1);
    } else if (event.crafting.getItem() == ModItems.ironCrossbow) {
      event.player.addStat(AchievementList.BETTER_FIREPOWER, 1);
    } else if (event.crafting.getItem() instanceof ItemUpgrade) {
      event.player.addStat(AchievementList.UPGRADES, 1);
    } else if (event.crafting.getItem() == ModItems.autoReloadUpgrade) {
      event.player.addStat(AchievementList.FULL_AUTO, 1);
    } else if (event.crafting.getItem() == ModItems.diamondCrossbow) {
      event.player.addStat(AchievementList.ULTIMATE_KILLING_MACHINE, 1);
    } else if (event.crafting.getItem() == ModItems.woodBolt) {
      event.player.addStat(AchievementList.TIME_TO_KILL, 1);
    } else if (event.crafting.getItem() == ModItems.ironBolt) {
      event.player.addStat(AchievementList.BETTER_BOLTS, 1);
    } else if (event.crafting.getItem() == ModItems.diamondBolt) {
      event.player.addStat(AchievementList.JUST_ONE_SHOT, 1);
    } else if (event.crafting.getItem() == ModItems.teleportBolt) {
      event.player.addStat(AchievementList.ANYWHERE_BUT_HERE, 1);
    } else if (event.crafting.getItem() == ModItems.flameBolt) {
      event.player.addStat(AchievementList.PYRO, 1);
    } else if (event.crafting.getItem() == ModItems.spectralBolt) {
      event.player.addStat(AchievementList.WALLHACKER, 1);
    } else if (event.crafting.getItem() == ModItems.explosiveBolt) {
      event.player.addStat(AchievementList.TIME_FOR_FUN, 1);
    } else if (event.crafting.getItem() == ModItems.freezeBolt) {
      event.player.addStat(AchievementList.BRAINFREEZE, 1);
    } else if (event.crafting.getItem() == ModItems.torchBolt) {
      event.player.addStat(AchievementList.ADVANCED_CAVING, 1);
    }
  }
}