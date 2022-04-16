package org.apollo.game.release.r274;

import org.apollo.game.message.impl.SendObjectMessage;
import org.apollo.net.codec.game.DataType;
import org.apollo.net.codec.game.GamePacket;
import org.apollo.net.codec.game.GamePacketBuilder;
import org.apollo.net.release.MessageEncoder;

public final class SendObjectMessageEncoder extends MessageEncoder<SendObjectMessage> {

	@Override
	public GamePacket encode(SendObjectMessage message) {
		GamePacketBuilder builder = new GamePacketBuilder(138);
		builder.put(DataType.BYTE, message.getPositionOffset());
		builder.put(DataType.BYTE, message.getType() << 2 | message.getOrientation());
		builder.put(DataType.SHORT, message.getId());
		return builder.toGamePacket();
	}

}