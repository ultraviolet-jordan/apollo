import org.apollo.game.message.impl.ButtonMessage
import org.apollo.game.message.impl.ConfigMessage
import org.apollo.game.model.entity.setting.ScreenBrightness
import org.apollo.game.model.event.impl.LoginEvent

val DARK_BUTTON_ID = 906
val NORMAL_BUTTON_ID = 908
val BRIGHT_BUTTON_ID = 910
val VERY_BRIGHT_BUTTON_ID = 912

on { ButtonMessage::class }
    .where { widgetId == DARK_BUTTON_ID || widgetId == NORMAL_BUTTON_ID || widgetId == BRIGHT_BUTTON_ID || widgetId == VERY_BRIGHT_BUTTON_ID }
    .then { player ->
        player.screenBrightness = ScreenBrightness.valueOf((widgetId - 906) / 2)
        player.send(ConfigMessage(166, player.screenBrightness.toInteger() + 1))
    }

on_player_event { LoginEvent::class }
    .then { player ->
        player.send(ConfigMessage(166, player.screenBrightness.toInteger()))
    }