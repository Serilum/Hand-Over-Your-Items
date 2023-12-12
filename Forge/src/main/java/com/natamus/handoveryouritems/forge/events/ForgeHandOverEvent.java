package com.natamus.handoveryouritems.forge.events;

import com.natamus.handoveryouritems.events.HandOverEvent;
import net.minecraft.world.InteractionResult;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class ForgeHandOverEvent {
	@SubscribeEvent
	public void onPlayerClick(PlayerInteractEvent.EntityInteract e) {
		if (HandOverEvent.onPlayerClick(e.getEntity(), e.getLevel(), e.getHand(), e.getTarget(), null).equals(InteractionResult.FAIL)) {
			e.setCanceled(true);
			e.setResult(Result.DENY);
		}
	}
}
