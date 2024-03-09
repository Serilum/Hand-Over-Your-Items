package com.natamus.handoveryouritems.events;

import com.natamus.collective.functions.ItemFunctions;
import com.natamus.collective.functions.MessageFunctions;
import com.natamus.handoveryouritems.config.ConfigHandler;
import net.minecraft.ChatFormatting;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class HandOverEvent {
	public static InteractionResult onPlayerClick(Player player, Level level, InteractionHand hand, Entity target, EntityHitResult hitResult) {
		if (!hand.equals(InteractionHand.MAIN_HAND)) {
			return InteractionResult.PASS;
		}
		
		if (!(target instanceof Player)) {
			return InteractionResult.PASS;
		}
		
		ItemStack stacktogive = player.getItemInHand(hand);
		if (stacktogive.isEmpty()) {
			return InteractionResult.PASS;
		}
		
		if (ConfigHandler.mustCrouchToGiveItem) {
			if (!player.isCrouching()) {
				return InteractionResult.PASS;
			}
		}
		
		int stacksize = stacktogive.getCount();
		String itemstring = ItemFunctions.itemToReadableString(stacktogive.getItem());
		
		Player playertarget = (Player)target;
		ItemFunctions.giveOrDropItemStack(playertarget, stacktogive.copy());
		stacktogive.setCount(0);

		if (!level.isClientSide) {
			if (ConfigHandler.sendItemReceivedMessage) {
				MessageFunctions.sendMessage(playertarget, "You have been given " + stacksize + " " + itemstring + " by " + player.getName().getString() + ".", ChatFormatting.DARK_GREEN);
			}

			if (ConfigHandler.sendItemGivenMessage) {
				MessageFunctions.sendMessage(player, "You have given " + stacksize + " " + itemstring + " to " + target.getName().getString() + ".", ChatFormatting.BLUE);
			}
		}
		
		player.getInventory().setChanged();
		playertarget.getInventory().setChanged();
		
		return InteractionResult.FAIL;
	}
}
