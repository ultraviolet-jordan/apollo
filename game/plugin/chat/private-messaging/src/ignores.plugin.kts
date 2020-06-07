import org.apollo.game.message.impl.AddIgnoreMessage
import org.apollo.game.message.impl.RemoveIgnoreMessage

on { AddIgnoreMessage::class }
        .then { player ->
            if (player.hasIgnored(username) || player.friendsWith(username)) {
                return@then
            }

            player.addIgnore(username)
        }

on { RemoveIgnoreMessage::class }
        .then { player ->
            if (!player.hasIgnored(username)) {
                return@then
            }

            player.removeIgnore(username)
        }