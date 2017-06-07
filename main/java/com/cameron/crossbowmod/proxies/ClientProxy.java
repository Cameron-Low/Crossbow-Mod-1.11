package com.cameron.crossbowmod.proxies;

import com.cameron.crossbowmod.KeyHandler;
import com.cameron.crossbowmod.ModItems;
import com.cameron.crossbowmod.achievements.AchievementListener;
import com.cameron.crossbowmod.enums.Bolts;
import com.cameron.crossbowmod.gui.GuiScopeOverlay;
import com.cameron.crossbowmod.items.BaseClasses.RenderBolt;
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

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy implements CommonProxy{
	
	@Override
	public void preInit(){}
	
	@SuppressWarnings("deprecation")
	@Override
	public void init() {
		ModItems.registerRenders();
		RenderManager manager = Minecraft.getMinecraft().getRenderManager();
		RenderingRegistry.registerEntityRenderingHandler(EntityWoodBolt.class, new RenderBolt<EntityWoodBolt>(manager,Bolts.WOOD));
		RenderingRegistry.registerEntityRenderingHandler(EntityStoneBolt.class, new RenderBolt<EntityStoneBolt>(manager,Bolts.STONE));
		RenderingRegistry.registerEntityRenderingHandler(EntityIronBolt.class, new RenderBolt<EntityIronBolt>(manager,Bolts.IRON));
		RenderingRegistry.registerEntityRenderingHandler(EntityGoldBolt.class, new RenderBolt<EntityGoldBolt>(manager,Bolts.GOLD));
		RenderingRegistry.registerEntityRenderingHandler(EntityDiamondBolt.class, new RenderBolt<EntityDiamondBolt>(manager,Bolts.DIAMOND));
		RenderingRegistry.registerEntityRenderingHandler(EntityExplosiveBolt.class, new RenderBolt<EntityExplosiveBolt>(manager,Bolts.EXPLOSIVE));
		RenderingRegistry.registerEntityRenderingHandler(EntityFlameBolt.class, new RenderBolt<EntityFlameBolt>(manager,Bolts.FLAME));
		RenderingRegistry.registerEntityRenderingHandler(EntityTeleportBolt.class, new RenderBolt<EntityTeleportBolt>(manager,Bolts.TELEPORT));
		RenderingRegistry.registerEntityRenderingHandler(EntitySpectralBolt.class, new RenderBolt<EntitySpectralBolt>(manager,Bolts.SPECTRAL));
		RenderingRegistry.registerEntityRenderingHandler(EntityTorchBolt.class, new RenderBolt<EntityTorchBolt>(manager,Bolts.TORCH));
		RenderingRegistry.registerEntityRenderingHandler(EntityFreezeBolt.class, new RenderBolt<EntityFreezeBolt>(manager,Bolts.FREEZE));
		
		MinecraftForge.EVENT_BUS.register(new AchievementListener());
		MinecraftForge.EVENT_BUS.register(new GuiScopeOverlay());
		MinecraftForge.EVENT_BUS.register(new KeyHandler());
	}

	@Override
	public void postInit() {}

}
