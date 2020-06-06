import org.apollo.game.model.entity.setting.PrivilegeLevel

// Gives the player some bis melee items if they are an administrator.
on_command("meleeset", PrivilegeLevel.ADMINISTRATOR)
    .then { player ->
        player.inventory.add(1127)//Rune platebody
        player.inventory.add(1079)//Rune platelegs
        player.inventory.add(1149)//Dragon med helm
        player.inventory.add(3140)//Dragon chainbody
        player.inventory.add(4087)//Dragon platelegs
        player.inventory.add(1305)//Dragon longsword
        player.inventory.add(1704)//Amulet of glory
        player.inventory.add(634)//Boots (white)
    }