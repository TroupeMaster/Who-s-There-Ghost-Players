package net.mcreator.whosthere.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.whosthere.configuration.GhostPlayersConfigConfiguration;

public class EmptyPlayersSpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (Math.random() < (double) GhostPlayersConfigConfiguration.EMPTYPLAYERPICKAXE.get()) {
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(Items.IRON_PICKAXE).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
			if (Math.random() < 0.1) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(Blocks.TORCH).copy();
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			}
		} else if (Math.random() < (double) GhostPlayersConfigConfiguration.EMPTYPLAYERPICKAXE.get()) {
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(Items.IRON_SWORD).copy();
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
			if (Math.random() < 0.1) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(Blocks.TORCH).copy();
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			}
		}
		if (Math.random() < (double) GhostPlayersConfigConfiguration.EMPTYPLAYERWALKCHANCE.get()) {
			entity.getPersistentData().putBoolean("menacing", true);
			if (Math.random() < (double) GhostPlayersConfigConfiguration.EMPTYPLAYERAGGRESSIVECHANCE.get()) {
				entity.getPersistentData().putBoolean("aggressive", true);
			}
		} else {
			entity.getPersistentData().putBoolean("watch", true);
		}
		if (!(GhostPlayersConfigConfiguration.EMPTYPLAYERNAME.get()).isEmpty()) {
			entity.setCustomName(Component.literal(("" + GhostPlayersConfigConfiguration.EMPTYPLAYERNAME.get())));
		}
	}
}
