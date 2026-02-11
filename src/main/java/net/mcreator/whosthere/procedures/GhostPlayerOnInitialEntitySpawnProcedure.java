package net.mcreator.whosthere.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.whosthere.network.WhosThereModVariables;
import net.mcreator.whosthere.configuration.GhostPlayersConfigConfiguration;

public class GhostPlayerOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double numberOfNames = 0;
		double randomName = 0;
		double temp = 0;
		String chosenName = "";
		if (Math.random() < 0.35) {
			entity.getPersistentData().putBoolean("shy", true);
		}
		if (GhostPlayersConfigConfiguration.ALLOWUSELIST.get() == true) {
			if (GhostPlayersConfigConfiguration.ONLYLIST.get() == true) {
				GhostPlayerNameFromListProcedure.execute(entity);
			} else {
				if (Math.random() < (double) GhostPlayersConfigConfiguration.RECENTPLAYERNAMESCHANCE.get() && WhosThereModVariables.MapVariables.get(world).PlayerJoinCount > 0) {
					GhostPlayerServerPlayerNameProcedure.execute(world, entity);
				} else if (Math.random() < (double) GhostPlayersConfigConfiguration.SPOOKYNAMECHANCE.get()) {
					GhostPlayerSpookyNameProcedure.execute(entity);
				} else {
					if (Math.random() < (double) GhostPlayersConfigConfiguration.LISTNAMECHANCE.get()) {
						GhostPlayerNameFromListProcedure.execute(entity);
					} else if (GhostPlayersConfigConfiguration.GENERATERANDOMNAME.get() == true) {
						GhostPlayerRandomNameProcedure.execute(entity);
					}
				}
			}
		} else {
			if (Math.random() < (double) GhostPlayersConfigConfiguration.RECENTPLAYERNAMESCHANCE.get() && WhosThereModVariables.MapVariables.get(world).PlayerJoinCount > 0) {
				GhostPlayerServerPlayerNameProcedure.execute(world, entity);
			} else if (Math.random() < (double) GhostPlayersConfigConfiguration.SPOOKYNAMECHANCE.get()) {
				GhostPlayerSpookyNameProcedure.execute(entity);
			} else if (GhostPlayersConfigConfiguration.GENERATERANDOMNAME.get() == true) {
				GhostPlayerRandomNameProcedure.execute(entity);
			}
		}
		entity.getPersistentData().putDouble("random_pathx", (Mth.nextInt(RandomSource.create(), -30, 30)));
		entity.getPersistentData().putDouble("random_pathy", (Mth.nextInt(RandomSource.create(), -3, 3)));
		entity.getPersistentData().putDouble("random_pathz", (Mth.nextInt(RandomSource.create(), -30, 30)));
	}
}
