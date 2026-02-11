package net.mcreator.whosthere.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.whosthere.entity.GhostPlayerEntity;
import net.mcreator.whosthere.configuration.GhostPlayersConfigConfiguration;
import net.mcreator.whosthere.WhosThereMod;

public class RandomSoundUponSpawningGhostProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (y <= 0) {
			if (!world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).isEmpty() == true) {
				if (Math.random() < (double) GhostPlayersConfigConfiguration.BLOCKBREAKINGCHANCE.get()) {
					entity.getPersistentData().putBoolean("playBreakSoundBelow", true);
					entity.getPersistentData().putBoolean("playBreakSoundAbove", false);
					WhosThereMod.queueServerWork(52, () -> {
						entity.getPersistentData().putBoolean("playBreakSoundBelow", true);
						entity.getPersistentData().putBoolean("playBreakSoundAbove", false);
					});
				}
			}
		} else {
			if (!world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).isEmpty() == true) {
				if (Math.random() < (double) GhostPlayersConfigConfiguration.BLOCKBREAKINGCHANCE.get()) {
					entity.getPersistentData().putBoolean("playBreakSoundAbove", true);
					entity.getPersistentData().putBoolean("playBreakSoundBelow", false);
					WhosThereMod.queueServerWork(52, () -> {
						entity.getPersistentData().putBoolean("playBreakSoundAbove", true);
						entity.getPersistentData().putBoolean("playBreakSoundBelow", false);
					});
				}
			}
		}
	}
}
