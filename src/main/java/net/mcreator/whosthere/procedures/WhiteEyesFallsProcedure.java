package net.mcreator.whosthere.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingFallEvent;

import net.minecraft.world.entity.Entity;

import net.mcreator.whosthere.entity.WhiteEyeEntity;
import net.mcreator.whosthere.entity.GhostPlayerEntity;
import net.mcreator.whosthere.entity.EmptySteveEntity;
import net.mcreator.whosthere.entity.EmptyAlexEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class WhiteEyesFallsProcedure {
	@SubscribeEvent
	public static void onEntityFall(LivingFallEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity());
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof WhiteEyeEntity || entity instanceof GhostPlayerEntity || entity instanceof EmptySteveEntity || entity instanceof EmptyAlexEntity) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			} else if (event != null && event.hasResult()) {
				event.setResult(Event.Result.DENY);
			}
		}
	}
}
