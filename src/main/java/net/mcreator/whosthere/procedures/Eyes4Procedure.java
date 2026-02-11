package net.mcreator.whosthere.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.whosthere.network.WhosThereModVariables;

public class Eyes4Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getCapability(WhosThereModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WhosThereModVariables.PlayerVariables())).eyes <= 145
				&& (entity.getCapability(WhosThereModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WhosThereModVariables.PlayerVariables())).eyes > 116) {
			return true;
		}
		return false;
	}
}
