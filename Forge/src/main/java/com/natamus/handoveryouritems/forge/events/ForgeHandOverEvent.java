package com.natamus.handoveryouritems.forge.events;

import com.natamus.handoveryouritems.events.HandOverEvent;
import net.minecraft.world.InteractionResult;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;

public class ForgeHandOverEvent {
	public static void registerEventsInBus() {
		// BusGroup.DEFAULT.register(MethodHandles.lookup(), ForgeHandOverEvent.class);

		PlayerInteractEvent.EntityInteract.BUS.addListener(ForgeHandOverEvent::onPlayerClick);
	}

	@SubscribeEvent
	public static boolean onPlayerClick(PlayerInteractEvent.EntityInteract e) {
		if (HandOverEvent.onPlayerClick(e.getEntity(), e.getLevel(), e.getHand(), e.getTarget(), null).equals(InteractionResult.FAIL)) {
			return true;
		}
		return false;
	}
}
