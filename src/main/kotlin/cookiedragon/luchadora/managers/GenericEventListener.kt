package cookiedragon.luchadora.managers

import cookiedragon.luchadora.Luchadora
import cookiedragon.luchadora.event.api.EventDispatcher
import cookiedragon.luchadora.event.api.Subscriber
import cookiedragon.luchadora.event.lwjgl.SetDisplayTitleEvent

/**
 * @author cookiedragon234 12/Jan/2020
 */
object GenericEventListener {
	fun init() {
		EventDispatcher.register(this)
		EventDispatcher.subscribe(this)
	}
	
	@Subscriber
	private fun onSetDisplayTitle(event: SetDisplayTitleEvent) {
		event.newTitle = Luchadora.getBrand()
	}
}
