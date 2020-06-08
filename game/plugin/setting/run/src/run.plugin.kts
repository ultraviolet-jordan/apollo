import org.apollo.game.message.impl.ButtonMessage
import org.apollo.game.message.impl.ConfigMessage
import org.apollo.game.message.impl.UpdateRunEnergyMessage
import org.apollo.game.model.entity.Player
import org.apollo.game.model.event.impl.LoginEvent

val WALK_BUTTON_ID = 152
val RUN_BUTTON_ID = 153

on { ButtonMessage::class }
    .where { widgetId == WALK_BUTTON_ID || widgetId == RUN_BUTTON_ID }
    .then { player ->
        player.toggleRunning(widgetId == RUN_BUTTON_ID)
    }

on_player_event { LoginEvent::class }
    .then { player ->
        player.toggleRunning(player.isRunning)
    }