package net.mcreator.whosthere.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.whosthere.network.WhosThereModVariables;
import net.mcreator.whosthere.configuration.GhostPlayersConfigConfiguration;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class GhostPlayerSpawnProcedure {
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
		if (y < 50 && !world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z)) && (entity.level().dimension()) == Level.OVERWORLD) {
			if ((entity.getCapability(WhosThereModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WhosThereModVariables.PlayerVariables())).GhostSpawn >= (double) GhostPlayersConfigConfiguration.GHOSTSPAWNTIMER.get()
					&& (entity.getCapability(WhosThereModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WhosThereModVariables.PlayerVariables())).SpawnActive == false) {
				{
					boolean _setval = true;
					entity.getCapability(WhosThereModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SpawnActive = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 0;
					entity.getCapability(WhosThereModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.GhostSpawn = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				if ((entity.getCapability(WhosThereModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WhosThereModVariables.PlayerVariables())).SpawnActive == false) {
					{
						double _setval = (entity.getCapability(WhosThereModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WhosThereModVariables.PlayerVariables())).GhostSpawn + 1;
						entity.getCapability(WhosThereModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.GhostSpawn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		}
	}
}
