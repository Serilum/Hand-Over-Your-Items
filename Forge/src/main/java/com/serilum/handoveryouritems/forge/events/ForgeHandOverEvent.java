package com.serilum.handoveryouritems.forge.events;

import com.serilum.handoveryouritems.events.HandOverEvent;
import net.minecraft.world.InteractionResult;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ForgeHandOverEvent {
	@SubscribeEvent
	public static void onPlayerClick(PlayerInteractEvent.EntityInteract e) {
		if (HandOverEvent.onPlayerClick(e.getEntity(), e.getLevel(), e.getHand(), e.getTarget(), null).equals(InteractionResult.FAIL)) {
			e.setCanceled(true);
			e.setResult(Result.DENY);
		}
	}
}
