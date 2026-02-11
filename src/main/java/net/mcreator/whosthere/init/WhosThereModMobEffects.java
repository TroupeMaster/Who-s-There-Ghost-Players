
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.whosthere.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.whosthere.potion.JumpscareMobEffect;
import net.mcreator.whosthere.WhosThereMod;

public class WhosThereModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, WhosThereMod.MODID);
	public static final RegistryObject<MobEffect> JUMPSCARE = REGISTRY.register("jumpscare", () -> new JumpscareMobEffect());
}
