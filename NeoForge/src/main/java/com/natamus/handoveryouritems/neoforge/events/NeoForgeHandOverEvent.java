package com.natamus.handoveryouritems.neoforge.events;

import com.natamus.handoveryouritems.events.HandOverEvent;
import net.minecraft.world.InteractionResult;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@EventBusSubscriber
public class NeoForgeHandOverEvent {
	@SubscribeEvent
	public static void onPlayerClick(PlayerInteractEvent.EntityInteract e) {
		if (HandOverEvent.onPlayerClick(e.getEntity(), e.getLevel(), e.getHand(), e.getTarget(), null).equals(InteractionResult.FAIL)) {
			e.setCanceled(true);
			e.setCancellationResult(InteractionResult.FAIL);
		}
	}
}
