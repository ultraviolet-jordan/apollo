package org.apollo.game.release.r274;

import org.apollo.game.message.impl.IgnoreListMessage;
import org.apollo.net.codec.game.DataType;
import org.apollo.net.codec.game.GamePacket;
import org.apollo.net.codec.game.GamePacketBuilder;
import org.apollo.net.meta.PacketType;
import org.apollo.net.release.MessageEncoder;
import org.apollo.util.NameUtil;

import java.util.List;

public final class IgnoreListMessageEncoder extends MessageEncoder<IgnoreListMessage> {

	@Override
	public GamePacket encode(IgnoreListMessage message) {
		GamePacketBuilder builder = new GamePacketBuilder(3, PacketType.VARIABLE_SHORT);

		List<String> usernames = message.getUsernames();
		for (String username : usernames) {
			builder.put(DataType.LONG, NameUtil.encodeBase37(username));
		}

		return builder.toGamePacket();
	}

}