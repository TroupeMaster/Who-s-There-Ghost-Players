package net.mcreator.whosthere.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.whosthere.network.WhosThereModVariables;
import net.mcreator.whosthere.init.WhosThereModEntities;
import net.mcreator.whosthere.entity.WhiteEyeEntity;
import net.mcreator.whosthere.entity.GhostPlayerEntity;
import net.mcreator.whosthere.configuration.GhostPlayersConfigConfiguration;

import javax.annotation.Nullable;

import com.mojang.datafixers.types.templates.Check;

@Mod.EventBusSubscriber
public class GhostPlayerCheckSpawnProcedure {
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
		boolean Check = false;
		boolean Restart = false;
		double CheckingX = 0;
		double CheckingZ = 0;
		double tries = 0;
		double CheckingY = 0;
		if ((entity.getCapability(WhosThereModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WhosThereModVariables.PlayerVariables())).SpawnActive == true) {
			{
				boolean _setval = false;
				entity.getCapability(WhosThereModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.SpawnActive = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			tries = 100;
			Check = false;
		}
		while (!(tries <= 0) || !Check) {
			if (tries <= 0) {
				break;
			} else {
				tries = tries - 1;
			}
			Restart = false;
			CheckingX = x + Mth.nextInt(RandomSource.create(), -40, 40);
			CheckingY = y + Mth.nextInt(RandomSource.create(), -40, 40);
			CheckingZ = z + Mth.nextInt(RandomSource.create(), -40, 40);
			if (CheckingY <= -64) {
				CheckingY = -63;
			} else if (CheckingY >= 50) {
				CheckingY = 49;
			}
			while (!((world.getBlockState(BlockPos.containing(CheckingX, CheckingY, CheckingZ))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(CheckingX, CheckingY + 1, CheckingZ))).getBlock() == Blocks.AIR
					|| (world.getBlockState(BlockPos.containing(CheckingX, CheckingY, CheckingZ))).getBlock() == Blocks.CAVE_AIR || (world.getBlockState(BlockPos.containing(CheckingX, CheckingY + 1, CheckingZ))).getBlock() == Blocks.CAVE_AIR)) {
				if (CheckingY == 318 || CheckingY == y + 33) {
					Restart = true;
					break;
				} else {
					CheckingY = CheckingY + 1;
				}
			}
			if (Restart) {
				continue;
			}
			if (Math.random() < (double) GhostPlayersConfigConfiguration.WHITEEYESCHANCE.get()) {
				if (GhostPlayersConfigConfiguration.SPAWNWHITEEYES.get() == true) {
					if (!world.getEntitiesOfClass(WhiteEyeEntity.class, AABB.ofSize(new Vec3(x, y, z), ((double) GhostPlayersConfigConfiguration.WHITEEYESSIZE.get()), ((double) GhostPlayersConfigConfiguration.WHITEEYESSIZE.get()),
							((double) GhostPlayersConfigConfiguration.WHITEEYESSIZE.get())), e -> true).isEmpty() == false) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = WhosThereModEntities.WHITE_EYE.get().spawn(_level, BlockPos.containing(CheckingX, CheckingY, CheckingZ), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					}
				} else {
					if (!world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), ((double) GhostPlayersConfigConfiguration.GHOSTPLAYERSIZE.get()), ((double) GhostPlayersConfigConfiguration.GHOSTPLAYERSIZE.get()),
							((double) GhostPlayersConfigConfiguration.GHOSTPLAYERSIZE.get())), e -> true).isEmpty() == false) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = WhosThereModEntities.GHOST_PLAYER.get().spawn(_level, BlockPos.containing(CheckingX, CheckingY, CheckingZ), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
						if (GhostPlayersConfigConfiguration.BLOCKBREAKINGSOUND.get() == true) {
							RandomSoundUponSpawningGhostProcedure.execute(world, x, y, z, entity);
						}
					}
				}
			} else {
				if (!world.getEntitiesOfClass(GhostPlayerEntity.class, AABB.ofSize(new Vec3(x, y, z), ((double) GhostPlayersConfigConfiguration.GHOSTPLAYERSIZE.get()), ((double) GhostPlayersConfigConfiguration.GHOSTPLAYERSIZE.get()),
						((double) GhostPlayersConfigConfiguration.GHOSTPLAYERSIZE.get())), e -> true).isEmpty() == false) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = WhosThereModEntities.GHOST_PLAYER.get().spawn(_level, BlockPos.containing(CheckingX, CheckingY, CheckingZ), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					if (GhostPlayersConfigConfiguration.BLOCKBREAKINGSOUND.get() == true) {
						RandomSoundUponSpawningGhostProcedure.execute(world, x, y, z, entity);
					}
				}
			}
		}
	}
}
