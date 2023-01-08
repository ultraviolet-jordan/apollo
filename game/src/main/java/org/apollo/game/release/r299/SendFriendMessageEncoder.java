package org.apollo.game.release.r299;

import org.apollo.game.message.impl.SendFriendMessage;
import org.apollo.net.codec.game.DataType;
import org.apollo.net.codec.game.GamePacket;
import org.apollo.net.codec.game.GamePacketBuilder;
import org.apollo.net.release.MessageEncoder;
import org.apollo.util.NameUtil;

public final class SendFriendMessageEncoder extends MessageEncoder<SendFriendMessage> {

	@Override
	public GamePacket encode(SendFriendMessage message) {
		GamePacketBuilder builder = new GamePacketBuilder(149);
		builder.put(DataType.LONG, NameUtil.encodeBase37(message.getUsername()));
		builder.put(DataType.BYTE, message.getEncodedWorld());
		return builder.toGamePacket();
	}

}