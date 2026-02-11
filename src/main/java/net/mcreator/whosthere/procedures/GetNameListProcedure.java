package net.mcreator.whosthere.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.whosthere.network.WhosThereModVariables;

public class GetNameListProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("Name List: " + WhosThereModVariables.MapVariables.get(world).playerName1 + " , " + WhosThereModVariables.MapVariables.get(world).playerName2 + " , "
					+ WhosThereModVariables.MapVariables.get(world).playerName3 + " , " + WhosThereModVariables.MapVariables.get(world).playerName4 + " .")), false);
	}
}
