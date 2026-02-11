
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.whosthere.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.whosthere.entity.WhiteEyeEntity;
import net.mcreator.whosthere.entity.GhostPlayerEntity;
import net.mcreator.whosthere.entity.EmptySteveEntity;
import net.mcreator.whosthere.entity.EmptyAlexEntity;
import net.mcreator.whosthere.WhosThereMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class WhosThereModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, WhosThereMod.MODID);
	public static final RegistryObject<EntityType<GhostPlayerEntity>> GHOST_PLAYER = register("ghost_player", EntityType.Builder.<GhostPlayerEntity>of(GhostPlayerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GhostPlayerEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<WhiteEyeEntity>> WHITE_EYE = register("white_eye",
			EntityType.Builder.<WhiteEyeEntity>of(WhiteEyeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(WhiteEyeEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<EmptySteveEntity>> EMPTY_STEVE = register("empty_steve", EntityType.Builder.<EmptySteveEntity>of(EmptySteveEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(EmptySteveEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<EmptyAlexEntity>> EMPTY_ALEX = register("empty_alex", EntityType.Builder.<EmptyAlexEntity>of(EmptyAlexEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64)
			.setUpdateInterval(3).setCustomClientFactory(EmptyAlexEntity::new).fireImmune().sized(0.6f, 1.8f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			GhostPlayerEntity.init();
			WhiteEyeEntity.init();
			EmptySteveEntity.init();
			EmptyAlexEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(GHOST_PLAYER.get(), GhostPlayerEntity.createAttributes().build());
		event.put(WHITE_EYE.get(), WhiteEyeEntity.createAttributes().build());
		event.put(EMPTY_STEVE.get(), EmptySteveEntity.createAttributes().build());
		event.put(EMPTY_ALEX.get(), EmptyAlexEntity.createAttributes().build());
	}
}
