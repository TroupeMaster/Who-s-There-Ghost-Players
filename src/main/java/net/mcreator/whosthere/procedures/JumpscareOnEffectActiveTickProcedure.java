package net.mcreator.whosthere.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.commands.arguments.EntityAnchorArgument;

import net.mcreator.whosthere.network.WhosThereModVariables;

import java.util.List;
import java.util.Comparator;

public class JumpscareOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = (entity.getCapability(WhosThereModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new WhosThereModVariables.PlayerVariables())).eyes + 1;
			entity.getCapability(WhosThereModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.eyes = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		entity.setDeltaMovement(new Vec3(0, 0, 0));
		entity.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3((x + Mth.nextDouble(RandomSource.create(), -0.01, 0.01)), (y + 5), (z + Mth.nextDouble(RandomSource.create(), -0.01, 0.01))));
		if (Math.random() < 0.1) {
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
		}
		if (!world.getEntitiesOfClass(Mob.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).isEmpty()) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(60 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if ((entityiterator instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == entity) {
						if (entityiterator instanceof Mob) {
							try {
								((Mob) entityiterator).setTarget(null);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}
}
