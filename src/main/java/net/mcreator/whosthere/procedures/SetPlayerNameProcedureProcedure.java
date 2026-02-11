package net.mcreator.whosthere.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.whosthere.network.WhosThereModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class SetPlayerNameProcedureProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if (DoubleArgumentType.getDouble(arguments, "playerNumber_1to4") == 1) {
			WhosThereModVariables.MapVariables.get(world).playerName1 = StringArgumentType.getString(arguments, "playerName");
			WhosThereModVariables.MapVariables.get(world).syncData(world);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("First name set to: \"" + "" + StringArgumentType.getString(arguments, "playerName") + "\".")), false);
		} else if (DoubleArgumentType.getDouble(arguments, "playerNumber_1to4") == 2) {
			WhosThereModVariables.MapVariables.get(world).playerName2 = StringArgumentType.getString(arguments, "playerName");
			WhosThereModVariables.MapVariables.get(world).syncData(world);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("First name set to: \"" + "" + StringArgumentType.getString(arguments, "playerName") + "\".")), false);
		} else if (DoubleArgumentType.getDouble(arguments, "playerNumber_1to4") == 3) {
			WhosThereModVariables.MapVariables.get(world).playerName3 = StringArgumentType.getString(arguments, "playerName");
			WhosThereModVariables.MapVariables.get(world).syncData(world);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("First name set to: \"" + "" + StringArgumentType.getString(arguments, "playerName") + "\".")), false);
		} else if (DoubleArgumentType.getDouble(arguments, "playerNumber_1to4") == 4) {
			WhosThereModVariables.MapVariables.get(world).playerName4 = StringArgumentType.getString(arguments, "playerName");
			WhosThereModVariables.MapVariables.get(world).syncData(world);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("First name set to: \"" + "" + StringArgumentType.getString(arguments, "playerName") + "\".")), false);
		}
	}
}
