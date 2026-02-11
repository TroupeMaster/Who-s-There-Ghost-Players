package net.mcreator.whosthere.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.whosthere.network.WhosThereModVariables;

public class JumpscareEffectExpiresProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = 0;
			entity.getCapability(WhosThereModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.eyes = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
