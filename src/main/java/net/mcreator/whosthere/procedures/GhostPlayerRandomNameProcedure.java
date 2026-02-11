package net.mcreator.whosthere.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;

public class GhostPlayerRandomNameProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("first_name", (Mth.nextInt(RandomSource.create(), 1, 21)));
		entity.getPersistentData().putDouble("second_name", (Mth.nextInt(RandomSource.create(), 1, 20)));
		if (entity.getPersistentData().getDouble("first_name") > 0 && entity.getPersistentData().getDouble("second_name") > 0) {
			if (entity.getPersistentData().getDouble("first_name") == 1) {
				entity.getPersistentData().putString("first_name_text", "xXMinecraft");
			}
			if (entity.getPersistentData().getDouble("first_name") == 2) {
				entity.getPersistentData().putString("first_name_text", "xXDemon");
			}
			if (entity.getPersistentData().getDouble("first_name") == 3) {
				entity.getPersistentData().putString("first_name_text", "xXPvP");
			}
			if (entity.getPersistentData().getDouble("first_name") == 4) {
				entity.getPersistentData().putString("first_name_text", "Behind");
				entity.getPersistentData().putString("second_name_text", "You");
			}
			if (entity.getPersistentData().getDouble("first_name") == 5) {
				entity.getPersistentData().putString("first_name_text", "BLO0DY");
			}
			if (entity.getPersistentData().getDouble("first_name") == 6) {
				entity.getPersistentData().putString("first_name_text", "666");
			}
			if (entity.getPersistentData().getDouble("first_name") == 7) {
				entity.getPersistentData().putString("first_name_text", "XYZ");
			}
			if (entity.getPersistentData().getDouble("first_name") == 8) {
				entity.getPersistentData().putString("first_name_text", "Nya");
			}
			if (entity.getPersistentData().getDouble("first_name") == 9) {
				entity.getPersistentData().putString("first_name_text", "xXPro");
			}
			if (entity.getPersistentData().getDouble("first_name") == 10) {
				entity.getPersistentData().putString("first_name_text", "MasteR");
			}
			if (entity.getPersistentData().getDouble("first_name") == 11) {
				entity.getPersistentData().putString("first_name_text", "Slayer");
			}
			if (entity.getPersistentData().getDouble("first_name") == 12) {
				entity.getPersistentData().putString("first_name_text", "xXSlayer");
			}
			if (entity.getPersistentData().getDouble("first_name") == 13) {
				entity.getPersistentData().putString("first_name_text", "Im");
			}
			if (entity.getPersistentData().getDouble("first_name") == 14) {
				entity.getPersistentData().putString("first_name_text", "Qwerty");
			}
			if (entity.getPersistentData().getDouble("first_name") == 14) {
				entity.getPersistentData().putString("first_name_text", "See");
				entity.getPersistentData().putString("second_name_text", "You");
			}
			if (entity.getPersistentData().getDouble("first_name") == 15) {
				entity.getPersistentData().putString("first_name_text", "H3LL");
			}
			if (entity.getPersistentData().getDouble("first_name") == 16) {
				entity.getPersistentData().putString("first_name_text", "GatEK33PeR");
			}
			if (entity.getPersistentData().getDouble("first_name") == 17) {
				entity.getPersistentData().putString("first_name_text", "GatEK33PeR");
			}
			if (entity.getPersistentData().getDouble("first_name") == 18) {
				entity.getPersistentData().putString("first_name_text", "MC");
			}
			if (entity.getPersistentData().getDouble("first_name") == 19) {
				entity.getPersistentData().putString("first_name_text", "H0ly");
			}
			if (entity.getPersistentData().getDouble("first_name") == 20) {
				entity.getPersistentData().putString("first_name_text", "Whispering");
			}
			if (entity.getPersistentData().getDouble("first_name") == 21) {
				entity.getPersistentData().putString("first_name_text", "Wh1sp3r1ng");
			}
		} else {
			entity.getPersistentData().putString("first_name_text", "863");
		}
		if (entity.getPersistentData().getDouble("first_name") > 0 && entity.getPersistentData().getDouble("second_name") > 0) {
			if (entity.getPersistentData().getDouble("second_name") == 1) {
				entity.getPersistentData().putString("second_name_text", "MinecraftXx");
			}
			if (entity.getPersistentData().getDouble("second_name") == 2) {
				entity.getPersistentData().putString("second_name_text", "Slay3rXx");
			}
			if (entity.getPersistentData().getDouble("second_name") == 3) {
				entity.getPersistentData().putString("second_name_text", "MasterXx");
			}
			if (entity.getPersistentData().getDouble("second_name") == 5) {
				entity.getPersistentData().putString("second_name_text", "863");
			}
			if (entity.getPersistentData().getDouble("second_name") == 6) {
				entity.getPersistentData().putString("second_name_text", "666");
			}
			if (entity.getPersistentData().getDouble("second_name") == 7) {
				entity.getPersistentData().putString("second_name_text", "35");
			}
			if (entity.getPersistentData().getDouble("second_name") == 8) {
				entity.getPersistentData().putString("second_name_text", "King");
			}
			if (entity.getPersistentData().getDouble("second_name") == 9) {
				entity.getPersistentData().putString("second_name_text", "MC");
			}
			if (entity.getPersistentData().getDouble("second_name") == 10) {
				entity.getPersistentData().putString("second_name_text", "Ass4ss1n");
			}
			if (entity.getPersistentData().getDouble("second_name") == 11) {
				entity.getPersistentData().putString("second_name_text", "R3ap3R");
			}
			if (entity.getPersistentData().getDouble("second_name") == 12) {
				entity.getPersistentData().putString("second_name_text", "Xx");
			}
			if (entity.getPersistentData().getDouble("second_name") == 13) {
				entity.getPersistentData().putString("second_name_text", "B0O");
			}
			if (entity.getPersistentData().getDouble("second_name") == 14) {
				entity.getPersistentData().putString("second_name_text", "153");
			}
			if (entity.getPersistentData().getDouble("second_name") == 15) {
				entity.getPersistentData().putString("second_name_text", "H3LL");
			}
			if (entity.getPersistentData().getDouble("second_name") == 16) {
				entity.getPersistentData().putString("second_name_text", "GatEK33PeR");
			}
			if (entity.getPersistentData().getDouble("second_name") == 17) {
				entity.getPersistentData().putString("second_name_text", "P0ly");
			}
			if (entity.getPersistentData().getDouble("second_name") == 18) {
				entity.getPersistentData().putString("second_name_text", "Blocky");
			}
			if (entity.getPersistentData().getDouble("second_name") == 19) {
				entity.getPersistentData().putString("second_name_text", "H0ly");
			}
			if (entity.getPersistentData().getDouble("second_name") == 20) {
				entity.getPersistentData().putString("second_name_text", "Holl0w");
			}
			if (entity.getPersistentData().getDouble("second_name") == 21) {
				entity.getPersistentData().putString("second_name_text", "Jump3r");
			}
		} else {
			entity.getPersistentData().putString("second_name_text", "153");
		}
		entity.setCustomName(Component.literal((entity.getPersistentData().getString("first_name_text") + "" + entity.getPersistentData().getString("second_name_text"))));
	}
}
