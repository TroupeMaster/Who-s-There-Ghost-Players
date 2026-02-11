package net.mcreator.whosthere.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;

import net.mcreator.whosthere.configuration.GhostPlayersConfigConfiguration;

public class GhostPlayerNameFromListProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double numberOfNames = 0;
		double randomName = 0;
		double temp = 0;
		String chosenName = "";
		numberOfNames = 0;
		randomName = 0;
		temp = 0;
		chosenName = "FAILED";
		for (String stringiterator : GhostPlayersConfigConfiguration.NAMELIST.get()) {
			numberOfNames = numberOfNames + 1;
		}
		randomName = Mth.nextInt(RandomSource.create(), 1, (int) numberOfNames);
		for (String stringiterator : GhostPlayersConfigConfiguration.NAMELIST.get()) {
			temp = temp + 1;
			if (temp == randomName) {
				chosenName = stringiterator;
				break;
			}
		}
		entity.setCustomName(Component.literal(chosenName));
	}
}
