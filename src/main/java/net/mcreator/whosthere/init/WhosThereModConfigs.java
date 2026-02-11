package net.mcreator.whosthere.init;

import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.mcreator.whosthere.configuration.GhostPlayersConfigConfiguration;
import net.mcreator.whosthere.WhosThereMod;

@Mod.EventBusSubscriber(modid = WhosThereMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class WhosThereModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, GhostPlayersConfigConfiguration.SPEC, "Ghost Players Config.toml");
		});
	}
}
