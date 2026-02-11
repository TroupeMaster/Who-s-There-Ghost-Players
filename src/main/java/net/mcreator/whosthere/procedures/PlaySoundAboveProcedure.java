package net.mcreator.whosthere.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.whosthere.entity.GhostPlayerEntity;
import net.mcreator.whosthere.configuration.GhostPlayersConfigConfiguration;

import java.util.Comparator;

public class PlaySoundAboveProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).isEmpty() == true) {
			if (entity.getPersistentData().getDouble("breakSoundCount") == 0) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX(), ((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY(), ((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.hit")), SoundSource.BLOCKS,
								(float) (double) GhostPlayersConfigConfiguration.BLOCKBREAKINGDISTANCE.get(), (float) 0.5);
					} else {
						_level.playLocalSound((((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX()), (((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY()), (((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.hit")), SoundSource.BLOCKS,
								(float) (double) GhostPlayersConfigConfiguration.BLOCKBREAKINGDISTANCE.get(), (float) 0.5, false);
					}
				}
			} else if (entity.getPersistentData().getDouble("breakSoundCount") == 4) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX(), ((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY(), ((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.hit")), SoundSource.BLOCKS,
								(float) (double) GhostPlayersConfigConfiguration.BLOCKBREAKINGDISTANCE.get(), (float) 0.5);
					} else {
						_level.playLocalSound((((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX()), (((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY()), (((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.hit")), SoundSource.BLOCKS,
								(float) (double) GhostPlayersConfigConfiguration.BLOCKBREAKINGDISTANCE.get(), (float) 0.5, false);
					}
				}
			} else if (entity.getPersistentData().getDouble("breakSoundCount") == 8) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX(), ((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY(), ((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.hit")), SoundSource.BLOCKS,
								(float) (double) GhostPlayersConfigConfiguration.BLOCKBREAKINGDISTANCE.get(), (float) 0.5);
					} else {
						_level.playLocalSound((((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX()), (((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY()), (((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.hit")), SoundSource.BLOCKS,
								(float) (double) GhostPlayersConfigConfiguration.BLOCKBREAKINGDISTANCE.get(), (float) 0.5, false);
					}
				}
			} else if (entity.getPersistentData().getDouble("breakSoundCount") == 12) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX(), ((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY(), ((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.hit")), SoundSource.BLOCKS,
								(float) (double) GhostPlayersConfigConfiguration.BLOCKBREAKINGDISTANCE.get(), (float) 0.5);
					} else {
						_level.playLocalSound((((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX()), (((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY()), (((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.hit")), SoundSource.BLOCKS,
								(float) (double) GhostPlayersConfigConfiguration.BLOCKBREAKINGDISTANCE.get(), (float) 0.5, false);
					}
				}
			} else if (entity.getPersistentData().getDouble("breakSoundCount") == 16) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX(), ((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY(), ((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.hit")), SoundSource.BLOCKS,
								(float) (double) GhostPlayersConfigConfiguration.BLOCKBREAKINGDISTANCE.get(), (float) 0.5);
					} else {
						_level.playLocalSound((((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX()), (((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY()), (((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.hit")), SoundSource.BLOCKS,
								(float) (double) GhostPlayersConfigConfiguration.BLOCKBREAKINGDISTANCE.get(), (float) 0.5, false);
					}
				}
			} else if (entity.getPersistentData().getDouble("breakSoundCount") == 20) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX(), ((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY(), ((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.hit")), SoundSource.BLOCKS,
								(float) (double) GhostPlayersConfigConfiguration.BLOCKBREAKINGDISTANCE.get(), (float) 0.5);
					} else {
						_level.playLocalSound((((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX()), (((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY()), (((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.hit")), SoundSource.BLOCKS,
								(float) (double) GhostPlayersConfigConfiguration.BLOCKBREAKINGDISTANCE.get(), (float) 0.5, false);
					}
				}
			} else if (entity.getPersistentData().getDouble("breakSoundCount") == 24) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX(), ((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY(), ((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.hit")), SoundSource.BLOCKS,
								(float) (double) GhostPlayersConfigConfiguration.BLOCKBREAKINGDISTANCE.get(), (float) 0.5);
					} else {
						_level.playLocalSound((((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX()), (((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY()), (((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.hit")), SoundSource.BLOCKS,
								(float) (double) GhostPlayersConfigConfiguration.BLOCKBREAKINGDISTANCE.get(), (float) 0.5, false);
					}
				}
			} else if (entity.getPersistentData().getDouble("breakSoundCount") == 28) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX(), ((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY(), ((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.hit")), SoundSource.BLOCKS,
								(float) (double) GhostPlayersConfigConfiguration.BLOCKBREAKINGDISTANCE.get(), (float) 0.5);
					} else {
						_level.playLocalSound((((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX()), (((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY()), (((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.hit")), SoundSource.BLOCKS,
								(float) (double) GhostPlayersConfigConfiguration.BLOCKBREAKINGDISTANCE.get(), (float) 0.5, false);
					}
				}
			} else if (entity.getPersistentData().getDouble("breakSoundCount") == 32) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX(), ((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY(), ((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.hit")), SoundSource.BLOCKS,
								(float) (double) GhostPlayersConfigConfiguration.BLOCKBREAKINGDISTANCE.get(), (float) 0.5);
					} else {
						_level.playLocalSound((((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX()), (((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY()), (((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.hit")), SoundSource.BLOCKS,
								(float) (double) GhostPlayersConfigConfiguration.BLOCKBREAKINGDISTANCE.get(), (float) 0.5, false);
					}
				}
			} else if (entity.getPersistentData().getDouble("breakSoundCount") == 36) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX(), ((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY(), ((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.hit")), SoundSource.BLOCKS,
								(float) (double) GhostPlayersConfigConfiguration.BLOCKBREAKINGDISTANCE.get(), (float) 0.5);
					} else {
						_level.playLocalSound((((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX()), (((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY()), (((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.hit")), SoundSource.BLOCKS,
								(float) (double) GhostPlayersConfigConfiguration.BLOCKBREAKINGDISTANCE.get(), (float) 0.5, false);
					}
				}
			} else if (entity.getPersistentData().getDouble("breakSoundCount") == 40) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX(), ((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY(), ((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.break")), SoundSource.BLOCKS,
								(float) (double) GhostPlayersConfigConfiguration.BLOCKBREAKINGDISTANCE.get(), (float) 0.8);
					} else {
						_level.playLocalSound((((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX()), (((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY()), (((Entity) world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.break")), SoundSource.BLOCKS,
								(float) (double) GhostPlayersConfigConfiguration.BLOCKBREAKINGDISTANCE.get(), (float) 0.8, false);
					}
				}
				entity.getPersistentData().putBoolean("playBreakSoundAbove", false);
				entity.getPersistentData().putBoolean("playBreakSoundBelow", false);
				entity.getPersistentData().putDouble("breakSoundCount", 0);
			}
			if (entity.getPersistentData().getDouble("breakSoundCount") < 40) {
				entity.getPersistentData().putDouble("breakSoundCount", (entity.getPersistentData().getDouble("breakSoundCount") + 1));
			}
		} else {
			entity.getPersistentData().putBoolean("playBreakSoundAbove", false);
			entity.getPersistentData().putBoolean("playBreakSoundBelow", false);
			entity.getPersistentData().putDouble("breakSoundCount", 0);
		}
	}
}
