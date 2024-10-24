package com.natamus.handoveryouritems;

import com.natamus.collective.check.RegisterMod;
import com.natamus.collective.check.ShouldLoadCheck;
import com.natamus.handoveryouritems.events.HandOverEvent;
import com.natamus.handoveryouritems.util.Reference;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;

public class ModFabric implements ModInitializer {
	
	@Override
	public void onInitialize() {
		if (!ShouldLoadCheck.shouldLoad(Reference.MOD_ID)) {
			return;
		}

		setGlobalConstants();
		ModCommon.init();

		loadEvents();

		RegisterMod.register(Reference.NAME, Reference.MOD_ID, Reference.VERSION, Reference.ACCEPTED_VERSIONS);
	}

	private void loadEvents() {
		UseEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
			return HandOverEvent.onPlayerClick(player, world, hand, entity, hitResult);
		});
	}

	private static void setGlobalConstants() {

	}
}
