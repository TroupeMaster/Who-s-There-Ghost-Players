package net.mcreator.whosthere.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.whosthere.network.WhosThereModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerJoinsProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((WhosThereModVariables.MapVariables.get(world).playerName1).equals("EMPTY")) {
			WhosThereModVariables.MapVariables.get(world).playerName1 = "" + entity.getDisplayName().getString();
			WhosThereModVariables.MapVariables.get(world).syncData(world);
			WhosThereModVariables.MapVariables.get(world).PlayerJoinCount = 1;
			WhosThereModVariables.MapVariables.get(world).syncData(world);
		} else if ((WhosThereModVariables.MapVariables.get(world).playerName2).equals("EMPTY")) {
			WhosThereModVariables.MapVariables.get(world).playerName2 = "" + entity.getDisplayName().getString();
			WhosThereModVariables.MapVariables.get(world).syncData(world);
			WhosThereModVariables.MapVariables.get(world).PlayerJoinCount = 2;
			WhosThereModVariables.MapVariables.get(world).syncData(world);
		} else if ((WhosThereModVariables.MapVariables.get(world).playerName3).equals("EMPTY")) {
			WhosThereModVariables.MapVariables.get(world).playerName3 = "" + entity.getDisplayName().getString();
			WhosThereModVariables.MapVariables.get(world).syncData(world);
			WhosThereModVariables.MapVariables.get(world).PlayerJoinCount = 3;
			WhosThereModVariables.MapVariables.get(world).syncData(world);
		} else if ((WhosThereModVariables.MapVariables.get(world).playerName4).equals("EMPTY")) {
			WhosThereModVariables.MapVariables.get(world).playerName4 = "" + entity.getDisplayName().getString();
			WhosThereModVariables.MapVariables.get(world).syncData(world);
			WhosThereModVariables.MapVariables.get(world).PlayerJoinCount = 4;
			WhosThereModVariables.MapVariables.get(world).syncData(world);
		} else {
			if (!(WhosThereModVariables.MapVariables.get(world).playerName1).equals("EMPTY") && !(WhosThereModVariables.MapVariables.get(world).playerName2).equals("EMPTY")
					&& !(WhosThereModVariables.MapVariables.get(world).playerName3).equals("EMPTY") && !(WhosThereModVariables.MapVariables.get(world).playerName4).equals("EMPTY") && WhosThereModVariables.MapVariables.get(world).NameCount == 0) {
				WhosThereModVariables.MapVariables.get(world).playerName1 = "" + entity.getDisplayName().getString();
				WhosThereModVariables.MapVariables.get(world).syncData(world);
				WhosThereModVariables.MapVariables.get(world).NameCount = WhosThereModVariables.MapVariables.get(world).NameCount + 1;
				WhosThereModVariables.MapVariables.get(world).syncData(world);
			} else if (!(WhosThereModVariables.MapVariables.get(world).playerName1).equals("EMPTY") && !(WhosThereModVariables.MapVariables.get(world).playerName2).equals("EMPTY")
					&& !(WhosThereModVariables.MapVariables.get(world).playerName3).equals("EMPTY") && !(WhosThereModVariables.MapVariables.get(world).playerName4).equals("EMPTY") && WhosThereModVariables.MapVariables.get(world).NameCount == 1) {
				WhosThereModVariables.MapVariables.get(world).playerName2 = "" + entity.getDisplayName().getString();
				WhosThereModVariables.MapVariables.get(world).syncData(world);
				WhosThereModVariables.MapVariables.get(world).NameCount = WhosThereModVariables.MapVariables.get(world).NameCount + 1;
				WhosThereModVariables.MapVariables.get(world).syncData(world);
			} else if (!(WhosThereModVariables.MapVariables.get(world).playerName1).equals("EMPTY") && !(WhosThereModVariables.MapVariables.get(world).playerName2).equals("EMPTY")
					&& !(WhosThereModVariables.MapVariables.get(world).playerName3).equals("EMPTY") && !(WhosThereModVariables.MapVariables.get(world).playerName4).equals("EMPTY") && WhosThereModVariables.MapVariables.get(world).NameCount == 2) {
				WhosThereModVariables.MapVariables.get(world).playerName3 = "" + entity.getDisplayName().getString();
				WhosThereModVariables.MapVariables.get(world).syncData(world);
				WhosThereModVariables.MapVariables.get(world).NameCount = WhosThereModVariables.MapVariables.get(world).NameCount + 1;
				WhosThereModVariables.MapVariables.get(world).syncData(world);
			} else if (!(WhosThereModVariables.MapVariables.get(world).playerName1).equals("EMPTY") && !(WhosThereModVariables.MapVariables.get(world).playerName2).equals("EMPTY")
					&& !(WhosThereModVariables.MapVariables.get(world).playerName3).equals("EMPTY") && !(WhosThereModVariables.MapVariables.get(world).playerName4).equals("EMPTY") && WhosThereModVariables.MapVariables.get(world).NameCount == 3) {
				WhosThereModVariables.MapVariables.get(world).playerName4 = "" + entity.getDisplayName().getString();
				WhosThereModVariables.MapVariables.get(world).syncData(world);
				WhosThereModVariables.MapVariables.get(world).NameCount = 0;
				WhosThereModVariables.MapVariables.get(world).syncData(world);
			}
		}
	}
}
