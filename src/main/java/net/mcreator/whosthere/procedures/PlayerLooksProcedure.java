package net.mcreator.whosthere.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.whosthere.entity.WhiteEyeEntity;
import net.mcreator.whosthere.entity.GhostPlayerEntity;
import net.mcreator.whosthere.WhosThereMod;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class PlayerLooksProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double distance = 0;
		if (!(new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
				}
				return false;
			}
		}.checkGamemode(entity)) && !(new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
				}
				return false;
			}
		}.checkGamemode(entity))) {
			if (!world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).isEmpty()) {
				distance = 1;
				for (int index0 = 0; index0 < 40; index0++) {
					{
						final Vec3 _center = new Vec3((entity.getX() + entity.getLookAngle().x * distance), (entity.getY() + entity.getLookAngle().y * distance), (entity.getZ() + entity.getLookAngle().z * distance));
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof GhostPlayerEntity) {
								if (entityiterator.getPersistentData().getBoolean("shy") == true) {
									if ((entityiterator.getDisplayName().getString()).equals("BehindYou") || (entityiterator.getDisplayName().getString()).equals("ImBehind") || (entityiterator.getDisplayName().getString()).equals("WatchYourself")) {
										if (!entityiterator.level().isClientSide())
											entityiterator.discard();
										WhosThereMod.queueServerWork(40, () -> {
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(
															null, BlockPos
																	.containing(
																			entity.level()
																					.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-2))), ClipContext.Block.OUTLINE,
																							ClipContext.Fluid.NONE, entity))
																					.getBlockPos().getX(),
																			y,
																			entity.level()
																					.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-2))), ClipContext.Block.OUTLINE,
																							ClipContext.Fluid.NONE, entity))
																					.getBlockPos().getZ()),
															ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.creeper.primed")), SoundSource.HOSTILE, 1, 1);
												} else {
													_level.playLocalSound(
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-2))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getX()),
															y,
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-2))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getZ()),
															ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.creeper.primed")), SoundSource.HOSTILE, 1, 1, false);
												}
											}
										});
									} else if ((entityiterator.getDisplayName().getString()).equals("ImComing") || (entityiterator.getDisplayName().getString()).equals("ItsTime")) {
										if (!entityiterator.level().isClientSide())
											entityiterator.discard();
										WhosThereMod.queueServerWork(40, () -> {
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(
															null, BlockPos
																	.containing(
																			entity.level()
																					.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-7))), ClipContext.Block.OUTLINE,
																							ClipContext.Fluid.NONE, entity))
																					.getBlockPos().getX(),
																			y,
																			entity.level()
																					.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-7))), ClipContext.Block.OUTLINE,
																							ClipContext.Fluid.NONE, entity))
																					.getBlockPos().getZ()),
															ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.step")), SoundSource.PLAYERS, 1, 1);
												} else {
													_level.playLocalSound(
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-7))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getX()),
															y,
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-7))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getZ()),
															ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.step")), SoundSource.PLAYERS, 1, 1, false);
												}
											}
										});
										WhosThereMod.queueServerWork(50, () -> {
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(
															null, BlockPos
																	.containing(
																			entity.level()
																					.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-6))), ClipContext.Block.OUTLINE,
																							ClipContext.Fluid.NONE, entity))
																					.getBlockPos().getX(),
																			y,
																			entity.level()
																					.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-6))), ClipContext.Block.OUTLINE,
																							ClipContext.Fluid.NONE, entity))
																					.getBlockPos().getZ()),
															ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.step")), SoundSource.PLAYERS, 1, 1);
												} else {
													_level.playLocalSound(
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-6))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getX()),
															y,
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-6))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getZ()),
															ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.step")), SoundSource.PLAYERS, 1, 1, false);
												}
											}
										});
										WhosThereMod.queueServerWork(60, () -> {
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(
															null, BlockPos
																	.containing(
																			entity.level()
																					.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-5))), ClipContext.Block.OUTLINE,
																							ClipContext.Fluid.NONE, entity))
																					.getBlockPos().getX(),
																			y,
																			entity.level()
																					.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-5))), ClipContext.Block.OUTLINE,
																							ClipContext.Fluid.NONE, entity))
																					.getBlockPos().getZ()),
															ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.step")), SoundSource.PLAYERS, 1, 1);
												} else {
													_level.playLocalSound(
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-5))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getX()),
															y,
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-5))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getZ()),
															ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.step")), SoundSource.PLAYERS, 1, 1, false);
												}
											}
										});
										WhosThereMod.queueServerWork(70, () -> {
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(
															null, BlockPos
																	.containing(
																			entity.level()
																					.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-4))), ClipContext.Block.OUTLINE,
																							ClipContext.Fluid.NONE, entity))
																					.getBlockPos().getX(),
																			y,
																			entity.level()
																					.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-4))), ClipContext.Block.OUTLINE,
																							ClipContext.Fluid.NONE, entity))
																					.getBlockPos().getZ()),
															ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.step")), SoundSource.PLAYERS, 1, 1);
												} else {
													_level.playLocalSound(
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-4))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getX()),
															y,
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-4))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getZ()),
															ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.step")), SoundSource.PLAYERS, 1, 1, false);
												}
											}
										});
										WhosThereMod.queueServerWork(80, () -> {
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(
															null, BlockPos
																	.containing(
																			entity.level()
																					.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-3))), ClipContext.Block.OUTLINE,
																							ClipContext.Fluid.NONE, entity))
																					.getBlockPos().getX(),
																			y,
																			entity.level()
																					.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-3))), ClipContext.Block.OUTLINE,
																							ClipContext.Fluid.NONE, entity))
																					.getBlockPos().getZ()),
															ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.step")), SoundSource.PLAYERS, 1, 1);
												} else {
													_level.playLocalSound(
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-3))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getX()),
															y,
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-3))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getZ()),
															ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.step")), SoundSource.PLAYERS, 1, 1, false);
												}
											}
										});
										WhosThereMod.queueServerWork(90, () -> {
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(
															null, BlockPos
																	.containing(
																			entity.level()
																					.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-2))), ClipContext.Block.OUTLINE,
																							ClipContext.Fluid.NONE, entity))
																					.getBlockPos().getX(),
																			y,
																			entity.level()
																					.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-2))), ClipContext.Block.OUTLINE,
																							ClipContext.Fluid.NONE, entity))
																					.getBlockPos().getZ()),
															ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.step")), SoundSource.PLAYERS, 1, 1);
												} else {
													_level.playLocalSound(
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-2))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getX()),
															y,
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale((-2))), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getZ()),
															ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.step")), SoundSource.PLAYERS, 1, 1, false);
												}
											}
										});
									} else if ((entityiterator.getDisplayName().getString()).equals("SeeYou")) {
										entityiterator.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() * 1.5), (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z() * 1.5)));
									} else {
										if (!entityiterator.level().isClientSide())
											entityiterator.discard();
										WhosThereMod.queueServerWork(5, () -> {
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.AMBIENT, 2, 1);
												} else {
													_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.AMBIENT, 2, 1, false);
												}
											}
										});
									}
								}
							}
						}
					}
					distance = distance + 1;
				}
			}
			if (!world.getEntitiesOfClass(WhiteEyeEntity.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).isEmpty()) {
				distance = 1;
				for (int index1 = 0; index1 < 40; index1++) {
					{
						final Vec3 _center = new Vec3((entity.getX() + entity.getLookAngle().x * distance), (entity.getY() + entity.getLookAngle().y * distance), (entity.getZ() + entity.getLookAngle().z * distance));
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof WhiteEyeEntity) {
								if (Math.random() < 0.008) {
									entityiterator.getPersistentData().putBoolean("whos_there:aggressive", true);
								}
							}
						}
					}
					distance = distance + 1;
				}
			}
		}
	}
}
