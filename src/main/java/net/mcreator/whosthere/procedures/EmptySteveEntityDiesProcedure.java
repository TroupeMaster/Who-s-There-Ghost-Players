package net.mcreator.whosthere.procedures;

import net.minecraft.world.entity.Entity;

public class EmptySteveEntityDiesProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!entity.level().isClientSide())
			entity.discard();
	}
}
