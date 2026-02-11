package net.mcreator.whosthere.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.whosthere.network.WhosThereModVariables;
import net.mcreator.whosthere.configuration.GhostPlayersConfigConfiguration;

public class SetGhostSpawnProcedureProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = (double) GhostPlayersConfigConfiguration.GHOSTSPAWNTIMER.get();
			entity.getCapability(WhosThereModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.GhostSpawn = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("Summoned a new ghost player"), false);
	}
}
