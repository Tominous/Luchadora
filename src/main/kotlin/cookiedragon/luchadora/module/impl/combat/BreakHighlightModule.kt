package cookiedragon.luchadora.module.impl.combat

import cookiedragon.luchadora.event.api.Subscriber
import cookiedragon.luchadora.event.client.Render3dEvent
import cookiedragon.luchadora.mixin.mixins.world.IMixinRenderGlobal
import cookiedragon.luchadora.module.AbstractModule
import cookiedragon.luchadora.module.Category
import cookiedragon.luchadora.util.RenderUtils
import cookiedragon.luchadora.value.values.ColourValue
import net.minecraft.client.renderer.GlStateManager
import net.minecraft.util.math.AxisAlignedBB
import java.awt.Color

/**
 * @author cookiedragon234 10/Jan/2020
 */
class BreakHighlightModule : AbstractModule("Break Highlight", "Highlight blocks that other players are breaking", Category.COMBAT) {
	private val colourValue = ColourValue("Colour", Color(0, 64, 255, 100))
	private val damagedBlocks = (mc.renderGlobal as IMixinRenderGlobal).damagedBlocks
	
	@Subscriber
	private fun onRenderWorld(event: Render3dEvent) {
		if (damagedBlocks.isEmpty())
			return
		
		GlStateManager.glLineWidth(5f)
		
		val colour = colourValue.value
		
		for (value in damagedBlocks.values)
			RenderUtils.drawSelectionBox(AxisAlignedBB(value.position), colour)
		
		GlStateManager.glLineWidth(1f)
	}
}
