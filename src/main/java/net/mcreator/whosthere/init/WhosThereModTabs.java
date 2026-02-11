
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.whosthere.init;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.mcreator.whosthere.WhosThereMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class WhosThereModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, WhosThereMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(WhosThereModItems.GHOST_PLAYER_SPAWN_EGG.get());
			tabData.accept(WhosThereModItems.WHITE_EYE_SPAWN_EGG.get());
			tabData.accept(WhosThereModItems.EMPTY_STEVE_SPAWN_EGG.get());
			tabData.accept(WhosThereModItems.EMPTY_ALEX_SPAWN_EGG.get());
		}
	}
}
