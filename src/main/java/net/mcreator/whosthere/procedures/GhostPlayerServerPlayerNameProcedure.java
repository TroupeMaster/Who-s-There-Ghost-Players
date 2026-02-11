package net.mcreator.whosthere.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;

import net.mcreator.whosthere.network.WhosThereModVariables;

public class GhostPlayerServerPlayerNameProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double random = 0;
		String name = "";
		random = Mth.nextInt(RandomSource.create(), 1, (int) WhosThereModVariables.MapVariables.get(world).PlayerJoinCount);
		if (random == 1 && !(WhosThereModVariables.MapVariables.get(world).playerName1).equals("EMPTY")) {
			name = WhosThereModVariables.MapVariables.get(world).playerName1;
		} else if (random == 2 && !(WhosThereModVariables.MapVariables.get(world).playerName2).equals("EMPTY")) {
			name = WhosThereModVariables.MapVariables.get(world).playerName2;
		} else if (random == 3 && !(WhosThereModVariables.MapVariables.get(world).playerName3).equals("EMPTY")) {
			name = WhosThereModVariables.MapVariables.get(world).playerName3;
			entity.getPersistentData().putString("first_name_text", WhosThereModVariables.MapVariables.get(world).playerName3);
		} else if (random == 4 && !(WhosThereModVariables.MapVariables.get(world).playerName4).equals("EMPTY")) {
			name = WhosThereModVariables.MapVariables.get(world).playerName4;
		} else {
			name = "SeeYou";
		}
		entity.setCustomName(Component.literal(("" + name)));
	}
}
