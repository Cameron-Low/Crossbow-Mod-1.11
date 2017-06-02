package com.cameron.crossbowmod.util;

import com.cameron.crossbowmod.Ref;
import com.cameron.crossbowmod.container.ContainerCrossbow;
import com.cameron.crossbowmod.gui.GuiCrossbow;
import com.cameron.crossbowmod.inventory.InventoryCrossbow;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{
	
	// When called by server, no need for a gui
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
    	
    	if (ID == Ref.CROSSBOW_GUI_ID){
            return new ContainerCrossbow(player, player.inventory, new InventoryCrossbow(player.getHeldItem(EnumHand.MAIN_HAND)));
     	}
    	return new Object();
    }

    // When called by client, client needs a gui
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
    	if (ID == Ref.CROSSBOW_GUI_ID){
    		return new GuiCrossbow(new ContainerCrossbow(player, player.inventory, new InventoryCrossbow(player.getHeldItem(EnumHand.MAIN_HAND))));
     	}
    	return new Object();
    }
}
