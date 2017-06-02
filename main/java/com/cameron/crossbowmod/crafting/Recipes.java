package com.cameron.crossbowmod.crafting;

import com.cameron.crossbowmod.ModItems;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Recipes {
	public static void init(){
		//Wood
		GameRegistry.addRecipe(new ItemStack(ModItems.woodBinding, 2),
				new Object[]{
				"AB",
				"BA",
				'A', Blocks.PLANKS,
				'B', Items.STICK});

		GameRegistry.addRecipe(new ItemStack(ModItems.woodBindingLight, 2),
				new Object[]{
				"BA",
				'A', Blocks.PLANKS,
				'B', Items.STICK});
		
		GameRegistry.addRecipe(new ItemStack(ModItems.woodBindingStrong, 2),
				new Object[]{
				"BBA",
				"BAB",
				"ABB",
				'A', Blocks.PLANKS,
				'B', Items.STICK});

		GameRegistry.addRecipe(new ItemStack(ModItems.woodBolt, 4),
				new Object[]{
				"A",
				"B",
				'A', Blocks.PLANKS,
				'B', Items.STICK});
		
		GameRegistry.addRecipe(new ItemStack(ModItems.woodCrossbow),
				new Object[]{
				"AAA",
				"ABC",
				"ACB",
				'A', Blocks.PLANKS,
				'B', Items.STICK,
				'C', ModItems.woodBinding});

		GameRegistry.addRecipe(new ItemStack(ModItems.woodCrossbowLight),
				new Object[]{
				"AAA",
				"ABC",
				"ACB",
				'A', Blocks.PLANKS,
				'B', Items.STICK,
				'C', ModItems.woodBindingLight});
		
		GameRegistry.addRecipe(new ItemStack(ModItems.woodCrossbowStrong),
				new Object[]{
				"AAA",
				"ABC",
				"ACB",
				'A', Blocks.PLANKS,
				'B', Items.STICK,
				'C', ModItems.woodBindingStrong});
		
		//Stone
		GameRegistry.addRecipe(new ItemStack(ModItems.stoneBinding, 2),
				new Object[]{
				"AB",
				"BA",
				'A', Blocks.STONE,
				'B', Items.STICK});

		GameRegistry.addRecipe(new ItemStack(ModItems.stoneBindingLight, 2),
				new Object[]{
				"BA",
				'A', Blocks.STONE,
				'B', Items.STICK});
		
		GameRegistry.addRecipe(new ItemStack(ModItems.stoneBindingStrong, 2),
				new Object[]{
				"BBA",
				"BAB",
				"ABB",
				'A', Blocks.STONE,
				'B', Items.STICK});
		
		GameRegistry.addRecipe(new ItemStack(ModItems.stoneBolt, 4),
				new Object[]{
				"A",
				"B",
				'A', Blocks.STONE,
				'B', Items.STICK});
		
		GameRegistry.addRecipe(new ItemStack(ModItems.stoneCrossbow),
				new Object[]{
				"AAA",
				"ABC",
				"ACB",
				'A', Blocks.STONE,
				'B', Items.STICK,
				'C', ModItems.stoneBinding});
		
		GameRegistry.addRecipe(new ItemStack(ModItems.stoneCrossbowLight),
				new Object[]{
				"AAA",
				"ABC",
				"ACB",
				'A', Blocks.STONE,
				'B', Items.STICK,
				'C', ModItems.stoneBindingLight});
		
		GameRegistry.addRecipe(new ItemStack(ModItems.stoneCrossbowStrong),
				new Object[]{
				"AAA",
				"ABC",
				"ACB",
				'A', Blocks.STONE,
				'B', Items.STICK,
				'C', ModItems.stoneBindingStrong});
		
		//Iron
		GameRegistry.addRecipe(new ItemStack(ModItems.ironBinding, 2),
				new Object[]{
				"AB",
				"BA",
				'A', Items.IRON_INGOT,
				'B', Items.STICK});

		GameRegistry.addRecipe(new ItemStack(ModItems.ironBindingLight, 2),
				new Object[]{
				"BA",
				'A', Items.IRON_INGOT,
				'B', Items.STICK});
		
		GameRegistry.addRecipe(new ItemStack(ModItems.ironBindingStrong, 2),
				new Object[]{
				"BBA",
				"BAB",
				"ABB",
				'A', Items.IRON_INGOT,
				'B', Items.STICK});
		
		GameRegistry.addRecipe(new ItemStack(ModItems.ironBolt, 4),
				new Object[]{
				"A",
				"B",
				'A', Items.IRON_INGOT,
				'B', Items.STICK});
		
		GameRegistry.addRecipe(new ItemStack(ModItems.ironCrossbow),
				new Object[]{
				"AAA",
				"ABC",
				"ACB",
				'A', Items.IRON_INGOT,
				'B', Items.STICK,
				'C', ModItems.ironBinding});
		
		GameRegistry.addRecipe(new ItemStack(ModItems.ironCrossbowLight),
				new Object[]{
				"AAA",
				"ABC",
				"ACB",
				'A', Items.IRON_INGOT,
				'B', Items.STICK,
				'C', ModItems.ironBindingLight});
		
		GameRegistry.addRecipe(new ItemStack(ModItems.ironCrossbowStrong),
				new Object[]{
				"AAA",
				"ABC",
				"ACB",
				'A', Items.IRON_INGOT,
				'B', Items.STICK,
				'C', ModItems.ironBindingStrong});
		
		//Gold
		GameRegistry.addRecipe(new ItemStack(ModItems.goldBinding, 2),
				new Object[]{
				"AB",
				"BA",
				'A', Items.GOLD_INGOT,
				'B', Items.STICK});

		GameRegistry.addRecipe(new ItemStack(ModItems.goldBindingLight, 2),
				new Object[]{
				"BA",
				'A', Items.GOLD_INGOT,
				'B', Items.STICK});
		
		GameRegistry.addRecipe(new ItemStack(ModItems.goldBindingStrong, 2),
				new Object[]{
				"BBA",
				"BAB",
				"ABB",
				'A', Items.GOLD_INGOT,
				'B', Items.STICK});

		GameRegistry.addRecipe(new ItemStack(ModItems.goldBolt, 4),
				new Object[]{
				"A",
				"B",
				'A', Items.GOLD_INGOT,
				'B', Items.STICK});
		
		GameRegistry.addRecipe(new ItemStack(ModItems.goldCrossbow),
				new Object[]{
				"AAA",
				"ABC",
				"ACB",
				'A', Items.GOLD_INGOT,
				'B', Items.STICK,
				'C', ModItems.goldBinding});
		
		GameRegistry.addRecipe(new ItemStack(ModItems.goldCrossbowLight),
				new Object[]{
				"AAA",
				"ABC",
				"ACB",
				'A', Items.GOLD_INGOT,
				'B', Items.STICK,
				'C', ModItems.goldBindingLight});
		
		GameRegistry.addRecipe(new ItemStack(ModItems.goldCrossbowStrong),
				new Object[]{
				"AAA",
				"ABC",
				"ACB",
				'A', Items.GOLD_INGOT,
				'B', Items.STICK,
				'C', ModItems.goldBindingStrong});
		
		//Diamond
		GameRegistry.addRecipe(new ItemStack(ModItems.diamondBinding, 2),
				new Object[]{
				"AB",
				"BA",
				'A', Items.DIAMOND,
				'B', Items.STICK});

		GameRegistry.addRecipe(new ItemStack(ModItems.diamondBindingLight, 2),
				new Object[]{
				"BA",
				'A', Items.DIAMOND,
				'B', Items.STICK});
		
		GameRegistry.addRecipe(new ItemStack(ModItems.diamondBindingStrong, 2),
				new Object[]{
				"BBA",
				"BAB",
				"ABB",
				'A', Items.DIAMOND,
				'B', Items.STICK});
		
		GameRegistry.addRecipe(new ItemStack(ModItems.diamondBolt, 4),
				new Object[]{
				"A",
				"B",
				'A', Items.DIAMOND,
				'B', Items.STICK});
		
		GameRegistry.addRecipe(new ItemStack(ModItems.diamondCrossbow),
				new Object[]{
				"AAA",
				"ABC",
				"ACB",
				'A', Items.DIAMOND,
				'B', Items.STICK,
				'C', ModItems.diamondBinding});
		
		GameRegistry.addRecipe(new ItemStack(ModItems.diamondCrossbowLight),
				new Object[]{
				"AAA",
				"ABC",
				"ACB",
				'A', Items.DIAMOND,
				'B', Items.STICK,
				'C', ModItems.diamondBindingLight});
		
		GameRegistry.addRecipe(new ItemStack(ModItems.diamondCrossbowStrong),
				new Object[]{
				"AAA",
				"ABC",
				"ACB",
				'A', Items.DIAMOND,
				'B', Items.STICK,
				'C', ModItems.diamondBindingStrong});
		
		//Explosive
		GameRegistry.addRecipe(new ItemStack(ModItems.explosiveBolt, 8),
				new Object[]{
				"A",
				"B",
				'A', Blocks.TNT,
				'B', Items.STICK});
		
		//Flame
		GameRegistry.addRecipe(new ItemStack(ModItems.flameBolt, 8),
				new Object[]{
				"A",
				"B",
				'A', Items.FLINT_AND_STEEL,
				'B', Items.STICK});
		
		//Teleport
		GameRegistry.addRecipe(new ItemStack(ModItems.teleportBolt, 8),
				new Object[]{
				"A",
				"B",
				'A', Items.ENDER_PEARL,
				'B', Items.STICK});
		
		//Spectral
		GameRegistry.addRecipe(new ItemStack(ModItems.spectralBolt, 8),
				new Object[]{
				"A",
				"B",
				'A', Blocks.GLOWSTONE,
				'B', Items.STICK});
		
		//Torch
		GameRegistry.addRecipe(new ItemStack(ModItems.torchBolt, 8),
				new Object[]{
				"A",
				"B",
				'A', Blocks.TORCH,
				'B', Items.STICK});
				
		//Freeze
		GameRegistry.addRecipe(new ItemStack(ModItems.freezeBolt, 8),
				new Object[]{
				"A",
				"B",
				'A', Items.SNOWBALL,
				'B', Items.STICK});
		
		//Upgrades
		GameRegistry.addRecipe(new ItemStack(ModItems.scopeUpgrade, 1),
				new Object[]{
				"ABA",
				"BCB",
				"ABA",
				'A', Items.IRON_INGOT,
				'B', Blocks.GLASS_PANE,
				'C', Items.REDSTONE});
		
		GameRegistry.addRecipe(new ItemStack(ModItems.autoReloadUpgrade, 1),
				new Object[]{
				"ABA",
				"BCB",
				"ABA",
				'A', Items.IRON_INGOT,
				'B', Items.DIAMOND,
				'C', Items.REDSTONE});
		
		GameRegistry.addRecipe(new ItemStack(ModItems.triShotUpgrade, 1),
				new Object[]{
				"ABA",
				"BCB",
				"ABA",
				'A', Items.IRON_INGOT,
				'B', Blocks.OBSIDIAN,
				'C', Items.REDSTONE});
	}
}
