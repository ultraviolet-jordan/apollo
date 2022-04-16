package org.apollo.game.release.r274;

import org.apollo.game.message.impl.KeepAliveMessage;
import org.apollo.net.codec.game.GamePacket;
import org.apollo.net.release.MessageDecoder;

public final class KeepAliveMessageDecoder extends MessageDecoder<KeepAliveMessage> {

	@Override
	public KeepAliveMessage decode(GamePacket packet) {
		return new KeepAliveMessage();
	}

}