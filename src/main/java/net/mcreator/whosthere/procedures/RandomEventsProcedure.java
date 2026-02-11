package net.mcreator.whosthere.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.whosthere.network.WhosThereModVariables;
import net.mcreator.whosthere.configuration.GhostPlayersConfigConfiguration;
import net.mcreator.whosthere.WhosThereMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class RandomEventsProcedure {
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
		if (GhostPlayersConfigConfiguration.RANDOMSOUNDEVENT.get() == true) {
			if (y < 50 && !world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
				if ((entity.getCapability(WhosThereModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WhosThereModVariables.PlayerVariables())).randomEvent == false) {
					if (Math.random() < (double) GhostPlayersConfigConfiguration.RANDOMSOUNDEVENTCHANCE.get()) {
						{
							boolean _setval = true;
							entity.getCapability(WhosThereModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.randomEvent = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
			}
			if ((entity.getCapability(WhosThereModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WhosThereModVariables.PlayerVariables())).randomEvent == true) {
				{
					double _setval = Mth.nextInt(RandomSource.create(), 1, 2);
					entity.getCapability(WhosThereModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.randomEventChoose = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if ((entity.getCapability(WhosThereModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WhosThereModVariables.PlayerVariables())).randomEventChoose == 1) {
					if ((entity.getCapability(WhosThereModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WhosThereModVariables.PlayerVariables())).eventPlaying == false) {
						{
							boolean _setval = true;
							entity.getCapability(WhosThereModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.eventPlaying = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						entity.getPersistentData().putDouble("whos_there:stonebreak", (Mth.nextInt(RandomSource.create(), -15, 15)));
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null,
										BlockPos.containing(entity.getPersistentData().getDouble("whos_there:stonebreak"), entity.getPersistentData().getDouble("whos_there:stonebreak"), entity.getPersistentData().getDouble("whos_there:stonebreak")),
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.hit")), SoundSource.BLOCKS, (float) 1.4, 1);
							} else {
								_level.playLocalSound((entity.getPersistentData().getDouble("whos_there:stonebreak")), (entity.getPersistentData().getDouble("whos_there:stonebreak")), (entity.getPersistentData().getDouble("whos_there:stonebreak")),
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.hit")), SoundSource.BLOCKS, (float) 1.4, 1, false);
							}
						}
						WhosThereMod.queueServerWork(15, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getPersistentData().getDouble("whos_there:stonebreak"), entity.getPersistentData().getDouble("whos_there:stonebreak"),
											entity.getPersistentData().getDouble("whos_there:stonebreak")), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.hit")), SoundSource.BLOCKS, (float) 1.4, 1);
								} else {
									_level.playLocalSound((entity.getPersistentData().getDouble("whos_there:stonebreak")), (entity.getPersistentData().getDouble("whos_there:stonebreak")),
											(entity.getPersistentData().getDouble("whos_there:stonebreak")), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.hit")), SoundSource.BLOCKS, (float) 1.4, 1, false);
								}
							}
						});
						WhosThereMod.queueServerWork(30, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getPersistentData().getDouble("whos_there:stonebreak"), entity.getPersistentData().getDouble("whos_there:stonebreak"),
											entity.getPersistentData().getDouble("whos_there:stonebreak")), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.hit")), SoundSource.BLOCKS, (float) 1.4, 1);
								} else {
									_level.playLocalSound((entity.getPersistentData().getDouble("whos_there:stonebreak")), (entity.getPersistentData().getDouble("whos_there:stonebreak")),
											(entity.getPersistentData().getDouble("whos_there:stonebreak")), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.hit")), SoundSource.BLOCKS, (float) 1.4, 1, false);
								}
							}
						});
						WhosThereMod.queueServerWork(45, () -> {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getPersistentData().getDouble("whos_there:stonebreak"), entity.getPersistentData().getDouble("whos_there:stonebreak"),
											entity.getPersistentData().getDouble("whos_there:stonebreak")), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.break")), SoundSource.BLOCKS, (float) 1.4, 1);
								} else {
									_level.playLocalSound((entity.getPersistentData().getDouble("whos_there:stonebreak")), (entity.getPersistentData().getDouble("whos_there:stonebreak")),
											(entity.getPersistentData().getDouble("whos_there:stonebreak")), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.break")), SoundSource.BLOCKS, (float) 1.4, 1, false);
								}
							}
							{
								boolean _setval = false;
								entity.getCapability(WhosThereModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.randomEvent = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								boolean _setval = false;
								entity.getCapability(WhosThereModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.eventPlaying = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						});
					}
				}
				if ((entity.getCapability(WhosThereModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WhosThereModVariables.PlayerVariables())).randomEventChoose == 2) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null,
									BlockPos.containing(entity.getX() + Mth.nextInt(RandomSource.create(), -15, 15), entity.getY() + Mth.nextInt(RandomSource.create(), -2, 2), entity.getZ() + Mth.nextInt(RandomSource.create(), -15, 15)),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("whos_there:cave_ambience")), SoundSource.BLOCKS, (float) 1.4, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2));
						} else {
							_level.playLocalSound((entity.getX() + Mth.nextInt(RandomSource.create(), -15, 15)), (entity.getY() + Mth.nextInt(RandomSource.create(), -2, 2)), (entity.getZ() + Mth.nextInt(RandomSource.create(), -15, 15)),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("whos_there:cave_ambience")), SoundSource.BLOCKS, (float) 1.4, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2), false);
						}
					}
					{
						boolean _setval = false;
						entity.getCapability(WhosThereModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.randomEvent = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						boolean _setval = false;
						entity.getCapability(WhosThereModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.eventPlaying = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		}
	}
}
