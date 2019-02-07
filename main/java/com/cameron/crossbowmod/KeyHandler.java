package com.cameron.crossbowmod;

import org.lwjgl.input.Keyboard;

import com.cameron.crossbowmod.enums.Upgrades;
import com.cameron.crossbowmod.items.BaseClasses.ItemCrossbow;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class KeyHandler {
	private final Minecraft mc;
	public static boolean isZoom;
	private static float baseFov;
	/** Key index for easy handling and retrieval of keys and key descriptions */
	public static final byte KEY_ZOOM = 0;

	/** Key descriptions - this is what the player sees when changing key bindings in-game */
	public static final String[] desc = { "Zoom" };

	/** Default key values */
	private static final int[] keyValues = { Keyboard.KEY_LCONTROL};

	public static final KeyBinding[] keys = new KeyBinding[desc.length];

	public KeyHandler() {
		this.mc = Minecraft.getMinecraft();
		this.baseFov = this.mc.gameSettings.fovSetting;
		for (int i = 0; i < desc.length; ++i) {
			keys[i] = new KeyBinding("key.rgm." + desc[i] + ".desc", keyValues[i], "None");
			ClientRegistry.registerKeyBinding(keys[i]);
		}
	}
	
	@SubscribeEvent
	public void onKeyInput(KeyInputEvent event) {
		if (Keyboard.getEventKeyState()) {
			onKeyPressed(mc, Keyboard.getEventKey());
		}
	}
	
	public static void onKeyPressed(Minecraft mc, int kb) {
		if (mc.inGameHasFocus && mc.player != null) {
			ItemStack heldItem = (mc.player.getHeldItem(EnumHand.MAIN_HAND));
			if (heldItem.getItem() instanceof ItemCrossbow){
				ItemCrossbow crossbow = (ItemCrossbow) heldItem.getItem();
				if (crossbow.upgrades.contains(Upgrades.SCOPE)){
					if (kb == keys[KEY_ZOOM].getKeyCode()) {
						if(!isZoom) baseFov = Minecraft.getMinecraft().gameSettings.fovSetting;
						Minecraft.getMinecraft().gameSettings.fovSetting -= 20f;
						isZoom = true;
						if (Minecraft.getMinecraft().gameSettings.fovSetting < 10f){
							Minecraft.getMinecraft().gameSettings.fovSetting = baseFov;
							isZoom = false;
						}
					}else if(isZoom){
						Minecraft.getMinecraft().gameSettings.fovSetting = baseFov;
						isZoom = false;
					}
				}
			} else if(isZoom){
				isZoom = false;
				Minecraft.getMinecraft().gameSettings.fovSetting = baseFov;
			}
		}
	}
}
