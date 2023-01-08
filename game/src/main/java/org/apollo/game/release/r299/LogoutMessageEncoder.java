package org.apollo.game.release.r299;

import org.apollo.game.message.impl.LogoutMessage;
import org.apollo.net.codec.game.GamePacket;
import org.apollo.net.codec.game.GamePacketBuilder;
import org.apollo.net.release.MessageEncoder;

public final class LogoutMessageEncoder extends MessageEncoder<LogoutMessage> {

	@Override
	public GamePacket encode(LogoutMessage message) {
		GamePacketBuilder builder = new GamePacketBuilder(75);
		return builder.toGamePacket();
	}

}