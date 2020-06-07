import org.apollo.game.message.impl.*
import org.apollo.game.model.World
import org.apollo.game.model.entity.Player
import org.apollo.game.model.entity.setting.PrivacyState
import org.apollo.game.model.entity.setting.ServerStatus
import org.apollo.game.model.event.impl.LoginEvent

on { AddFriendMessage::class }
    .then { player ->
        if (player.friendsWith(username)) {
            return@then
        }

        player.addFriend(username)

        val friend = player.world.getPlayer(username)

        if (friend == null || friend.friendPrivacy == PrivacyState.OFF) {
            player.send(SendFriendMessage(username, 0))
            return@then
        } else {
            player.send(SendFriendMessage(username, friend.worldId))
        }

        if (friend.friendsWith(player.username) && player.friendPrivacy != PrivacyState.OFF) {
            friend.send(SendFriendMessage(player.username, player.worldId))
        }
    }

on { RemoveFriendMessage::class }
    .then { player ->
        if (!player.friendsWith(username)) {
            return@then
        }

        val friendUsername = username
        val playerUsername = player.username

        player.removeFriend(friendUsername)
        if (world.isPlayerOnline(friendUsername)) {
            val friend = world.getPlayer(friendUsername)

            if (friend.friendsWith(playerUsername) && player.friendPrivacy != PrivacyState.ON) {
                friend.send(SendFriendMessage(playerUsername, 0))
            }
        }
    }

on_player_event { LoginEvent::class }
    .then {player ->
        player.send(FriendServerStatusMessage(ServerStatus.CONNECTING))
        if (player.ignoredUsernames.size > 0) {
            player.send(IgnoreListMessage(player.ignoredUsernames))
        }

        val username = player.username
        val iterator = player.friendUsernames.iterator();

        while (iterator.hasNext()) {
            val friendUsername = iterator.next()
            val friend = world.getPlayer(friendUsername)
            val world = if (friend == null || !viewable(friend, username)) 0 else friend.worldId

            player.send(SendFriendMessage(friendUsername, world))
        }

        player.send(FriendServerStatusMessage(ServerStatus.ONLINE))
        updateFriends(player, world)
    }

on { PrivacyOptionMessage::class }
    .then { player ->
        player.chatPrivacy = chatPrivacy
        player.friendPrivacy = friendPrivacy
        player.tradePrivacy = tradePrivacy

        updateFriends(player, world)
    }

fun viewable(player: Player, otherUsername: String): Boolean {
    val privacy = player.friendPrivacy
    return privacy != PrivacyState.OFF && player.friendsWith(otherUsername) || privacy == PrivacyState.ON
}

fun updateFriends(player: Player, world: World) {
    val iterator = world.playerRepository.iterator()
    val username = player.username

    while (iterator.hasNext()) {
        val other = iterator.next()
        if (!other.friendsWith(username) || other == player) continue

        val worldId = if (viewable(player, other.username)) player.worldId else 0
        other.send(SendFriendMessage(username, worldId))
    }
}