package com.cameron.crossbowmod.util;

import com.cameron.crossbowmod.Ref;
import com.cameron.crossbowmod.container.ContainerDiamondCrossbow;
import com.cameron.crossbowmod.container.ContainerIronCrossbow;
import com.cameron.crossbowmod.container.ContainerStoneCrossbow;
import com.cameron.crossbowmod.gui.GuiDiamondCrossbow;
import com.cameron.crossbowmod.gui.GuiIronCrossbow;
import com.cameron.crossbowmod.gui.GuiStoneCrossbow;
import com.cameron.crossbowmod.inventory.InventoryDiamondCrossbow;
import com.cameron.crossbowmod.inventory.InventoryIronCrossbow;
import com.cameron.crossbowmod.inventory.InventoryStoneCrossbow;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{
	
	// When called by server, no need for a gui
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
    	
    	if (ID == Ref.DIAMOND_CROSSBOW_GUI_ID){
            return new ContainerDiamondCrossbow(player, player.inventory, new InventoryDiamondCrossbow(player.getHeldItem(EnumHand.MAIN_HAND)));
     	} else if (ID == Ref.IRON_CROSSBOW_GUI_ID){
            return new ContainerIronCrossbow(player, player.inventory, new InventoryIronCrossbow(player.getHeldItem(EnumHand.MAIN_HAND)));
     	} else if (ID == Ref.STONE_CROSSBOW_GUI_ID){
            return new ContainerStoneCrossbow(player, player.inventory, new InventoryStoneCrossbow(player.getHeldItem(EnumHand.MAIN_HAND)));
     	}
    	return new Object();
    }

    // When called by client, client needs a gui
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
    	if (ID == Ref.DIAMOND_CROSSBOW_GUI_ID){
    		return new GuiDiamondCrossbow(new ContainerDiamondCrossbow(player, player.inventory, new InventoryDiamondCrossbow(player.getHeldItem(EnumHand.MAIN_HAND))));
     	} else if (ID == Ref.IRON_CROSSBOW_GUI_ID){
    		return new GuiIronCrossbow(new ContainerIronCrossbow(player, player.inventory, new InventoryIronCrossbow(player.getHeldItem(EnumHand.MAIN_HAND))));
     	} else if (ID == Ref.STONE_CROSSBOW_GUI_ID){
    		return new GuiStoneCrossbow(new ContainerStoneCrossbow(player, player.inventory, new InventoryStoneCrossbow(player.getHeldItem(EnumHand.MAIN_HAND))));
     	}
    	return new Object();
    }
}
