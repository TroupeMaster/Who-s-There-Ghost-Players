
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.whosthere.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.item.Item;

import net.mcreator.whosthere.WhosThereMod;

public class WhosThereModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, WhosThereMod.MODID);
	public static final RegistryObject<Item> GHOST_PLAYER_SPAWN_EGG = REGISTRY.register("ghost_player_spawn_egg", () -> new ForgeSpawnEggItem(WhosThereModEntities.GHOST_PLAYER, -1, -1, new Item.Properties()));
	public static final RegistryObject<Item> WHITE_EYE_SPAWN_EGG = REGISTRY.register("white_eye_spawn_egg", () -> new ForgeSpawnEggItem(WhosThereModEntities.WHITE_EYE, -1, -1, new Item.Properties()));
	public static final RegistryObject<Item> EMPTY_STEVE_SPAWN_EGG = REGISTRY.register("empty_steve_spawn_egg", () -> new ForgeSpawnEggItem(WhosThereModEntities.EMPTY_STEVE, -1, -11652070, new Item.Properties()));
	public static final RegistryObject<Item> EMPTY_ALEX_SPAWN_EGG = REGISTRY.register("empty_alex_spawn_egg", () -> new ForgeSpawnEggItem(WhosThereModEntities.EMPTY_ALEX, -1, -1733313, new Item.Properties()));
	// Start of user code block custom items
	// End of user code block custom items
}
