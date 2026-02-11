package net.mcreator.whosthere.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.whosthere.configuration.GhostPlayersConfigConfiguration;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayDeepslateBreakSoundsProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (GhostPlayersConfigConfiguration.BLOCKBREAKINGSOUND.get() == true) {
			if (entity.getPersistentData().getBoolean("playBreakSoundBelow") == true && entity.getPersistentData().getBoolean("playBreakSoundAbove") == false) {
				PlaySoundBelowProcedure.execute(world, x, y, z, entity);
			} else if (entity.getPersistentData().getBoolean("playBreakSoundAbove") == true && entity.getPersistentData().getBoolean("playBreakSoundBelow") == false) {
				PlaySoundAboveProcedure.execute(world, x, y, z, entity);
			}
		}
	}
}
