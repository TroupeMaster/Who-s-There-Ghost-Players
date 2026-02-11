package net.mcreator.whosthere.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.whosthere.entity.EmptySteveEntity;
import net.mcreator.whosthere.entity.EmptyAlexEntity;
import net.mcreator.whosthere.configuration.GhostPlayersConfigConfiguration;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class EntitiesAttemptSpawningNextToEmptyPlayerProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity && !(entity instanceof Player) && !(entity instanceof ServerPlayer) && !entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("whos_there:ghosts")))
				&& !entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("whos_there:protected_from_spawn_deny"))) && GhostPlayersConfigConfiguration.EMPTYPLAYERDENYSPAWNS.get() == true) {
			if (!world.getEntitiesOfClass(EmptyAlexEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).isEmpty() || !world.getEntitiesOfClass(EmptySteveEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).isEmpty()) {
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				} else if (event != null && event.hasResult()) {
					event.setResult(Event.Result.DENY);
				}
			}
		}
	}
}
