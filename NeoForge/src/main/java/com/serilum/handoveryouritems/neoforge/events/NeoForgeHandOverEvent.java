package com.serilum.handoveryouritems.neoforge.events;

import com.serilum.handoveryouritems.events.HandOverEvent;
import net.minecraft.world.InteractionResult;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

public class NeoForgeHandOverEvent {
	@SubscribeEvent
	public static void onPlayerClick(PlayerInteractEvent.EntityInteract e) {
		if (HandOverEvent.onPlayerClick(e.getEntity(), e.getLevel(), e.getHand(), e.getTarget(), null).equals(InteractionResult.FAIL)) {
			e.setCanceled(true);
			e.setCancellationResult(InteractionResult.FAIL);
		}
	}
}
