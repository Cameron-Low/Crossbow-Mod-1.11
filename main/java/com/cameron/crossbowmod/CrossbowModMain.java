package com.cameron.crossbowmod;

import com.cameron.crossbowmod.achievements.AchievementList;
import com.cameron.crossbowmod.crafting.Recipes;
import com.cameron.crossbowmod.gui.GuiScopeOverlay;
import com.cameron.crossbowmod.items.entity.EntityDiamondBolt;
import com.cameron.crossbowmod.items.entity.EntityExplosiveBolt;
import com.cameron.crossbowmod.items.entity.EntityFlameBolt;
import com.cameron.crossbowmod.items.entity.EntityFreezeBolt;
import com.cameron.crossbowmod.items.entity.EntityGoldBolt;
import com.cameron.crossbowmod.items.entity.EntityIronBolt;
import com.cameron.crossbowmod.items.entity.EntitySpectralBolt;
import com.cameron.crossbowmod.items.entity.EntityStoneBolt;
import com.cameron.crossbowmod.items.entity.EntityTeleportBolt;
import com.cameron.crossbowmod.items.entity.EntityTorchBolt;
import com.cameron.crossbowmod.items.entity.EntityWoodBolt;
import com.cameron.crossbowmod.proxies.CommonProxy;
import com.cameron.crossbowmod.util.GuiHandler;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

@Mod(modid=Ref.MODID, name=Ref.MODNAME, version=Ref.VERSION, acceptedMinecraftVersions=Ref.ACCEPTEDMINECRAFTVERSION)
public class CrossbowModMain {
	@Instance
	public static CrossbowModMain instance;
	
	@SidedProxy(clientSide="com.cameron.crossbowmod.proxies.ClientProxy", serverSide="com.cameron.crossbowmod.proxies.ServerProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		ModItems.init();
		ModItems.register();
		
		AchievementList.initAchievements();
		
		EntityRegistry.registerModEntity(new ResourceLocation("crossbowmod:wood_bolt") ,EntityWoodBolt.class, "wood_bolt", 0, this, 128, 20, true);
		EntityRegistry.registerModEntity(new ResourceLocation("crossbowmod:stone_bolt") ,EntityStoneBolt.class, "stone_bolt", 1, this, 128, 20, true);
		EntityRegistry.registerModEntity(new ResourceLocation("crossbowmod:iron_bolt") ,EntityIronBolt.class, "iron_bolt", 2, this, 128, 20, true);
		EntityRegistry.registerModEntity(new ResourceLocation("crossbowmod:gold_bolt") ,EntityGoldBolt.class, "gold_bolt", 3, this, 128, 20, true);
		EntityRegistry.registerModEntity(new ResourceLocation("crossbowmod:diamond_bolt") ,EntityDiamondBolt.class, "diamond_bolt", 4, this, 128, 20, true);
		EntityRegistry.registerModEntity(new ResourceLocation("crossbowmod:explosive_bolt") ,EntityExplosiveBolt.class, "explosive_bolt", 5, this, 128, 20, true);
		EntityRegistry.registerModEntity(new ResourceLocation("crossbowmod:flame_bolt") ,EntityFlameBolt.class, "flame_bolt", 6, this, 128, 20, true);
		EntityRegistry.registerModEntity(new ResourceLocation("crossbowmod:spectral_bolt") ,EntitySpectralBolt.class, "spectral_bolt", 7, this, 128, 20, true);
		EntityRegistry.registerModEntity(new ResourceLocation("crossbowmod:teleport_bolt") ,EntityTeleportBolt.class, "teleport_bolt", 8, this, 128, 20, true);
		EntityRegistry.registerModEntity(new ResourceLocation("crossbowmod:torch_bolt") ,EntityTorchBolt.class, "torch_bolt", 9, this, 128, 20, true);
		EntityRegistry.registerModEntity(new ResourceLocation("crossbowmod:freeze_bolt") ,EntityFreezeBolt.class, "freeze_bolt", 10, this, 128, 20, true);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		proxy.init();
		Recipes.init();
	}
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		MinecraftForge.EVENT_BUS.register(new GuiScopeOverlay());
		MinecraftForge.EVENT_BUS.register(new KeyHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
		
	}
}
