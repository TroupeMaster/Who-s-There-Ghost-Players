package net.mcreator.whosthere.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;

public class GhostPlayerSpookyNameProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double random = 0;
		String name = "";
		random = Mth.nextInt(RandomSource.create(), 1, 6);
		if (random == 1) {
			name = "SeeYou";
		} else if (random == 2) {
			name = "BehindYou";
		} else if (random == 3) {
			name = "ImBehind";
		} else if (random == 4) {
			name = "WatchYourself";
		} else if (random == 5) {
			name = "ImComing";
		} else if (random == 6) {
			name = "ItsTime";
		} else {
			name = "SeeYou";
		}
		entity.setCustomName(Component.literal(("" + name)));
	}
}
