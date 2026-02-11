
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.whosthere.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.whosthere.client.renderer.WhiteEyeRenderer;
import net.mcreator.whosthere.client.renderer.GhostPlayerRenderer;
import net.mcreator.whosthere.client.renderer.EmptySteveRenderer;
import net.mcreator.whosthere.client.renderer.EmptyAlexRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class WhosThereModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(WhosThereModEntities.GHOST_PLAYER.get(), GhostPlayerRenderer::new);
		event.registerEntityRenderer(WhosThereModEntities.WHITE_EYE.get(), WhiteEyeRenderer::new);
		event.registerEntityRenderer(WhosThereModEntities.EMPTY_STEVE.get(), EmptySteveRenderer::new);
		event.registerEntityRenderer(WhosThereModEntities.EMPTY_ALEX.get(), EmptyAlexRenderer::new);
	}
}
