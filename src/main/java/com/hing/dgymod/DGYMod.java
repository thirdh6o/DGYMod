package com.hing.dgymod;

import com.hing.dgymod.block.ModBlocks;
import com.hing.dgymod.item.ModItemGroups;
import com.hing.dgymod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DGYMod implements ModInitializer {
	public static final String MOD_ID = "dgymod";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.


		ModItems.registerModItems();
		ModItemGroups.registerModItemGroups();
		ModBlocks.registerModBlocks();
		LOGGER.info("Hello Fabric world!");

		// 燃料最快捷的注册方法是用Fabric的API实现，参数分别为燃料和燃烧时间（tick）
		FuelRegistry.INSTANCE.add(ModItems.DGY_COAL, 32000);
	}
}