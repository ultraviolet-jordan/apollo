package org.apollo.game.release.r299;

import org.apollo.game.message.impl.ArrowKeyMessage;
import org.apollo.net.codec.game.DataType;
import org.apollo.net.codec.game.GamePacket;
import org.apollo.net.codec.game.GamePacketReader;
import org.apollo.net.release.MessageDecoder;

public final class ArrowKeyMessageDecoder extends MessageDecoder<ArrowKeyMessage> {

	@Override
	public ArrowKeyMessage decode(GamePacket packet) {
		GamePacketReader reader = new GamePacketReader(packet);
		int roll = (int) reader.getUnsigned(DataType.SHORT);
		int yaw = (int) reader.getUnsigned(DataType.SHORT);
		return new ArrowKeyMessage(roll, yaw);
	}
}