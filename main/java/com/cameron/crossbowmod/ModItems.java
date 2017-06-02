package com.cameron.crossbowmod;

import com.cameron.crossbowmod.enums.Bolts;
import com.cameron.crossbowmod.enums.Materials;
import com.cameron.crossbowmod.enums.Upgrades;
import com.cameron.crossbowmod.items.BaseClasses.ItemBinding;
import com.cameron.crossbowmod.items.BaseClasses.ItemBolt;
import com.cameron.crossbowmod.items.BaseClasses.ItemCrossbow;
import com.cameron.crossbowmod.items.BaseClasses.ItemUpgrade;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	//Wood
	public static Item woodBolt;
	public static Item woodCrossbow;
	public static Item woodCrossbowLight;
	public static Item woodCrossbowStrong;
	public static Item woodBinding;
	public static Item woodBindingLight;
	public static Item woodBindingStrong;
	
	//Stone
	public static Item stoneBolt;
	public static Item stoneCrossbow;
	public static Item stoneCrossbowLight;
	public static Item stoneCrossbowStrong;
	public static Item stoneBinding;
	public static Item stoneBindingLight;
	public static Item stoneBindingStrong;
	
	//Iron
	public static Item ironBolt;
	public static Item ironCrossbow;
	public static Item ironCrossbowLight;
	public static Item ironCrossbowStrong;
	public static Item ironBinding;
	public static Item ironBindingLight;
	public static Item ironBindingStrong;
	
	//Gold
	public static Item goldBolt;
	public static Item goldCrossbow;
	public static Item goldCrossbowLight;
	public static Item goldCrossbowStrong;
	public static Item goldBinding;
	public static Item goldBindingLight;
	public static Item goldBindingStrong;

	//Diamond
	public static Item diamondBolt;
	public static Item diamondCrossbow;
	public static Item diamondCrossbowLight;
	public static Item diamondCrossbowStrong;
	public static Item diamondBinding;
	public static Item diamondBindingLight;
	public static Item diamondBindingStrong;
	
	//Explosive
	public static Item explosiveBolt;
	
	//Flame
	public static Item flameBolt;
	
	//Teleport
	public static Item teleportBolt;
	
	//Spectral
	public static Item spectralBolt;
	
	//Torch
	public static Item torchBolt;
	
	//Freeze
	public static Item freezeBolt;
	
	//Upgrades
	public static Item scopeUpgrade;
	public static Item autoReloadUpgrade;
	public static Item triShotUpgrade;
	public static Item reinforcedUpgrade;
	
	public static void init(){
		//Bolts
		woodBolt = new ItemBolt("wood_bolt", Ref.tabCustom, Bolts.WOOD);
		stoneBolt = new ItemBolt("stone_bolt", Ref.tabCustom, Bolts.STONE);
		ironBolt = new ItemBolt("iron_bolt", Ref.tabCustom, Bolts.IRON);
		goldBolt = new ItemBolt("gold_bolt", Ref.tabCustom, Bolts.GOLD);
		diamondBolt = new ItemBolt("diamond_bolt", Ref.tabCustom, Bolts.DIAMOND);
		explosiveBolt = new ItemBolt("explosive_bolt", Ref.tabCustom, Bolts.EXPLOSIVE);
		flameBolt = new ItemBolt("flame_bolt", Ref.tabCustom, Bolts.FLAME);
		teleportBolt = new ItemBolt("teleport_bolt", Ref.tabCustom, Bolts.TELEPORT);
		spectralBolt = new ItemBolt("spectral_bolt", Ref.tabCustom, Bolts.SPECTRAL);
		torchBolt = new ItemBolt("torch_bolt", Ref.tabCustom, Bolts.TORCH);
		freezeBolt = new ItemBolt("freeze_bolt", Ref.tabCustom, Bolts.FREEZE);
		
		diamondCrossbow = new ItemCrossbow("diamond_crossbow", Ref.tabCustom, Materials.DIAMOND, 1);
		goldCrossbow = new ItemCrossbow("gold_crossbow", Ref.tabCustom, Materials.GOLD, 1);
		ironCrossbow = new ItemCrossbow("iron_crossbow", Ref.tabCustom, Materials.IRON, 1);
		stoneCrossbow = new ItemCrossbow("stone_crossbow", Ref.tabCustom, Materials.STONE, 1);
		woodCrossbow = new ItemCrossbow("wood_crossbow", Ref.tabCustom, Materials.WOOD, 1);
		
		diamondCrossbowLight = new ItemCrossbow("diamond_crossbow_light", Ref.tabCustom, Materials.DIAMOND, Ref.LightWeightMultiplier);
		goldCrossbowLight = new ItemCrossbow("gold_crossbow_light", Ref.tabCustom, Materials.GOLD, Ref.LightWeightMultiplier);
		ironCrossbowLight = new ItemCrossbow("iron_crossbow_light", Ref.tabCustom, Materials.IRON, Ref.LightWeightMultiplier);
		stoneCrossbowLight = new ItemCrossbow("stone_crossbow_light", Ref.tabCustom, Materials.STONE, Ref.LightWeightMultiplier);
		woodCrossbowLight = new ItemCrossbow("wood_crossbow_light", Ref.tabCustom, Materials.WOOD, Ref.LightWeightMultiplier);
		
		diamondCrossbowStrong = new ItemCrossbow("diamond_crossbow_strong", Ref.tabCustom, Materials.DIAMOND, Ref.StrengthMultiplier);
		goldCrossbowStrong = new ItemCrossbow("gold_crossbow_strong", Ref.tabCustom, Materials.GOLD, Ref.StrengthMultiplier);
		ironCrossbowStrong = new ItemCrossbow("iron_crossbow_strong", Ref.tabCustom, Materials.IRON, Ref.StrengthMultiplier);
		stoneCrossbowStrong = new ItemCrossbow("stone_crossbow_strong", Ref.tabCustom, Materials.STONE, Ref.StrengthMultiplier);
		woodCrossbowStrong = new ItemCrossbow("wood_crossbow_strong", Ref.tabCustom, Materials.WOOD, Ref.StrengthMultiplier);
		
		diamondBinding = new ItemBinding("diamond_binding", Ref.tabCustom);
		goldBinding = new ItemBinding("gold_binding", Ref.tabCustom);
		ironBinding = new ItemBinding("iron_binding", Ref.tabCustom);
		stoneBinding = new ItemBinding("stone_binding", Ref.tabCustom);
		woodBinding = new ItemBinding("wood_binding", Ref.tabCustom);
		
		diamondBindingLight = new ItemBinding("diamond_binding_light", Ref.tabCustom);
		goldBindingLight = new ItemBinding("gold_binding_light", Ref.tabCustom);
		ironBindingLight = new ItemBinding("iron_binding_light", Ref.tabCustom);
		stoneBindingLight = new ItemBinding("stone_binding_light", Ref.tabCustom);
		woodBindingLight = new ItemBinding("wood_binding_light", Ref.tabCustom);
		
		diamondBindingStrong = new ItemBinding("diamond_binding_strong", Ref.tabCustom);
		goldBindingStrong = new ItemBinding("gold_binding_strong", Ref.tabCustom);
		ironBindingStrong = new ItemBinding("iron_binding_strong", Ref.tabCustom);
		stoneBindingStrong = new ItemBinding("stone_binding_strong", Ref.tabCustom);
		woodBindingStrong = new ItemBinding("wood_binding_strong", Ref.tabCustom);
		
		scopeUpgrade = new ItemUpgrade("scope_upgrade", Ref.tabCustom, Upgrades.SCOPE);
		autoReloadUpgrade = new ItemUpgrade("auto_reload_upgrade", Ref.tabCustom, Upgrades.AUTO_RELOAD);
		triShotUpgrade = new ItemUpgrade("tri_shot_upgrade", Ref.tabCustom, Upgrades.TRI_SHOT);
		reinforcedUpgrade = new ItemUpgrade("reinforced_limbs_upgrade", Ref.tabCustom, Upgrades.REINFORCED_LIMBS);
	} 
	public static void register(){
		//Bolts
		GameRegistry.register(woodBolt);
		GameRegistry.register(stoneBolt);
		GameRegistry.register(ironBolt);
		GameRegistry.register(goldBolt);
		GameRegistry.register(diamondBolt);
		GameRegistry.register(explosiveBolt);
		GameRegistry.register(flameBolt);
		GameRegistry.register(spectralBolt);
		GameRegistry.register(teleportBolt);
		GameRegistry.register(torchBolt);
		GameRegistry.register(freezeBolt);
		
		GameRegistry.register(diamondCrossbow);
		GameRegistry.register(goldCrossbow);
		GameRegistry.register(ironCrossbow);
		GameRegistry.register(stoneCrossbow);
		GameRegistry.register(woodCrossbow);
		
		GameRegistry.register(woodCrossbowLight);
		GameRegistry.register(woodCrossbowStrong);
		GameRegistry.register(woodBinding);
		GameRegistry.register(woodBindingLight);
		GameRegistry.register(woodBindingStrong);
		
		GameRegistry.register(stoneCrossbowLight);
		GameRegistry.register(stoneCrossbowStrong);
		GameRegistry.register(stoneBinding);
		GameRegistry.register(stoneBindingLight);
		GameRegistry.register(stoneBindingStrong);
		
		GameRegistry.register(ironCrossbowLight);
		GameRegistry.register(ironCrossbowStrong);
		GameRegistry.register(ironBinding);
		GameRegistry.register(ironBindingLight);
		GameRegistry.register(ironBindingStrong);
		
		GameRegistry.register(goldCrossbowLight);
		GameRegistry.register(goldCrossbowStrong);
		GameRegistry.register(goldBinding);
		GameRegistry.register(goldBindingLight);
		GameRegistry.register(goldBindingStrong);

		GameRegistry.register(diamondCrossbowLight);
		GameRegistry.register(diamondCrossbowStrong);
		GameRegistry.register(diamondBinding);
		GameRegistry.register(diamondBindingLight);
		GameRegistry.register(diamondBindingStrong);
		
		GameRegistry.register(scopeUpgrade);
		GameRegistry.register(autoReloadUpgrade);
		GameRegistry.register(triShotUpgrade);
		GameRegistry.register(reinforcedUpgrade);
	} 
	public static void registerRenders(){
		//Bolts
		registerRender(woodBolt);
		registerRender(stoneBolt);
		registerRender(ironBolt);
		registerRender(goldBolt);
		registerRender(diamondBolt);
		registerRender(explosiveBolt);
		registerRender(flameBolt);
		registerRender(spectralBolt);
		registerRender(teleportBolt);
		registerRender(torchBolt);
		registerRender(freezeBolt);
		
		registerRender(diamondCrossbow);
		registerRender(goldCrossbow);
		registerRender(ironCrossbow);
		registerRender(stoneCrossbow);
		registerRender(woodCrossbow);
		
		registerRender(woodCrossbowLight);
		registerRender(woodCrossbowStrong);
		registerRender(woodBinding);
		registerRender(woodBindingLight);
		registerRender(woodBindingStrong);
		
		registerRender(stoneCrossbowLight);
		registerRender(stoneCrossbowStrong);
		registerRender(stoneBinding);
		registerRender(stoneBindingLight);
		registerRender(stoneBindingStrong); 
		
		registerRender(ironCrossbowLight);
		registerRender(ironCrossbowStrong);
		registerRender(ironBinding);
		registerRender(ironBindingLight);
		registerRender(ironBindingStrong); 

		registerRender(goldCrossbowLight);
		registerRender(goldCrossbowStrong);
		registerRender(goldBinding);
		registerRender(goldBindingLight);
		registerRender(goldBindingStrong); 

		registerRender(diamondCrossbowLight);
		registerRender(diamondCrossbowStrong);
		registerRender(diamondBinding);	
		registerRender(diamondBindingLight);
		registerRender(diamondBindingStrong);
		
		registerRender(scopeUpgrade);
		registerRender(autoReloadUpgrade);
		registerRender(triShotUpgrade);
		registerRender(reinforcedUpgrade);
	} 
	public static void registerRender(Item item){
		//ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	} 
}
