
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.whosthere.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.whosthere.WhosThereMod;

public class WhosThereModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, WhosThereMod.MODID);
	public static final RegistryObject<SoundEvent> DOOR_KNOCK1 = REGISTRY.register("door_knock1", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("whos_there", "door_knock1")));
	public static final RegistryObject<SoundEvent> DOOR_KNOCK2 = REGISTRY.register("door_knock2", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("whos_there", "door_knock2")));
	public static final RegistryObject<SoundEvent> DOOR_KNOCK3 = REGISTRY.register("door_knock3", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("whos_there", "door_knock3")));
	public static final RegistryObject<SoundEvent> GHOST_BREATHE = REGISTRY.register("ghost_breathe", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("whos_there", "ghost_breathe")));
	public static final RegistryObject<SoundEvent> GHOST_HEY = REGISTRY.register("ghost_hey", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("whos_there", "ghost_hey")));
	public static final RegistryObject<SoundEvent> GHOST_SCREAM = REGISTRY.register("ghost_scream", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("whos_there", "ghost_scream")));
	public static final RegistryObject<SoundEvent> CAVE_AMBIENCE = REGISTRY.register("cave_ambience", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("whos_there", "cave_ambience")));
}
