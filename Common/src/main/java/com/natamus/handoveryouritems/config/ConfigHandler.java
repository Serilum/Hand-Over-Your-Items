package com.natamus.handoveryouritems.config;

import com.natamus.collective.config.DuskConfig;
import com.natamus.handoveryouritems.util.Reference;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ConfigHandler extends DuskConfig {
	public static HashMap<String, List<String>> configMetaData = new HashMap<String, List<String>>();

	@Entry public static boolean sendItemReceivedMessage = true;
	@Entry public static boolean sendItemGivenMessage = true;
	@Entry public static boolean mustCrouchToGiveItem = true;

	public static void initConfig() {
		configMetaData.put("sendItemReceivedMessage", Arrays.asList(
			"If enabled, players will receive a message when they have been given an item."
		));
		configMetaData.put("sendItemGivenMessage", Arrays.asList(
			"If enabled, players will receive a message when they give an item."
		));
		configMetaData.put("mustCrouchToGiveItem", Arrays.asList(
			"If enabled, players will only be able to give items when they are crouching/sneaking."
		));

		DuskConfig.init(Reference.NAME, Reference.MOD_ID, ConfigHandler.class);
	}
}