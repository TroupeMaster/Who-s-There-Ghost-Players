package net.mcreator.whosthere.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.BlockPos;

import net.mcreator.whosthere.entity.WhiteEyeEntity;
import net.mcreator.whosthere.entity.EmptySteveEntity;
import net.mcreator.whosthere.entity.EmptyAlexEntity;
import net.mcreator.whosthere.configuration.GhostPlayersConfigConfiguration;

public class EmptySteveNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < (double) GhostPlayersConfigConfiguration.EMPTYPLAYERCHANCE.get() && GhostPlayersConfigConfiguration.SPAWNEMPTYPLAYER.get() == true && GhostPlayersConfigConfiguration.EMPTYPLAYERCANSPAWNSURFACE.get() == false && y < 50
				&& !world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))
				&& !(!world.getEntitiesOfClass(Player.class,
						AABB.ofSize(new Vec3(x, y, z), ((double) GhostPlayersConfigConfiguration.EMPTYPLAYERSIZETOPLAYER.get()), ((double) GhostPlayersConfigConfiguration.EMPTYPLAYERSIZETOPLAYER.get()),
								((double) GhostPlayersConfigConfiguration.EMPTYPLAYERSIZETOPLAYER.get())),
						e -> true).isEmpty())
				&& !(!world.getEntitiesOfClass(EmptySteveEntity.class,
						AABB.ofSize(new Vec3(x, y, z), ((double) GhostPlayersConfigConfiguration.EMPTYPLAYERSIZE.get()), ((double) GhostPlayersConfigConfiguration.EMPTYPLAYERSIZE.get()),
								((double) GhostPlayersConfigConfiguration.EMPTYPLAYERSIZE.get())),
						e -> true).isEmpty())
				&& !(!world.getEntitiesOfClass(EmptyAlexEntity.class,
						AABB.ofSize(new Vec3(x, y, z), ((double) GhostPlayersConfigConfiguration.EMPTYPLAYERSIZE.get()), ((double) GhostPlayersConfigConfiguration.EMPTYPLAYERSIZE.get()),
								((double) GhostPlayersConfigConfiguration.EMPTYPLAYERSIZE.get())),
						e -> true).isEmpty())
				&& !(!world.getEntitiesOfClass(WhiteEyeEntity.class,
						AABB.ofSize(new Vec3(x, y, z), ((double) GhostPlayersConfigConfiguration.EMPTYPLAYERSIZE.get()), ((double) GhostPlayersConfigConfiguration.EMPTYPLAYERSIZE.get()),
								((double) GhostPlayersConfigConfiguration.EMPTYPLAYERSIZE.get())),
						e -> true).isEmpty())
				&& !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() instanceof LiquidBlock) && world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude()) {
			return true;
		} else if (Math.random() < (double) GhostPlayersConfigConfiguration.EMPTYPLAYERCHANCE.get() && GhostPlayersConfigConfiguration.SPAWNEMPTYPLAYER.get() == true && GhostPlayersConfigConfiguration.EMPTYPLAYERCANSPAWNSURFACE.get() == true
				&& !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() instanceof LiquidBlock) && world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude()
				&& !(!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 45, 45, 45), e -> true).isEmpty()) && !(!world.getEntitiesOfClass(EmptySteveEntity.class, AABB.ofSize(new Vec3(x, y, z), 70, 70, 70), e -> true).isEmpty())
				&& !(!world.getEntitiesOfClass(EmptyAlexEntity.class, AABB.ofSize(new Vec3(x, y, z), 70, 70, 70), e -> true).isEmpty())) {
			return true;
		}
		return false;
	}
}
