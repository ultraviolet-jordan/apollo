package org.apollo.game.release.r299;

import org.apollo.game.message.impl.ConfigMessage;
import org.apollo.net.codec.game.DataType;
import org.apollo.net.codec.game.GamePacket;
import org.apollo.net.codec.game.GamePacketBuilder;
import org.apollo.net.release.MessageEncoder;

public final class ConfigMessageEncoder extends MessageEncoder<ConfigMessage> {

	@Override
	public GamePacket encode(ConfigMessage message) {
		GamePacketBuilder builder;
		int value = message.getValue();

		if (value > Byte.MIN_VALUE && value < Byte.MAX_VALUE) {
			builder = new GamePacketBuilder(213);

			builder.put(DataType.SHORT, message.getId());
			builder.put(DataType.BYTE, value & 0xFF);
		} else {
			builder = new GamePacketBuilder(145);

			builder.put(DataType.SHORT, message.getId());
			builder.put(DataType.INT, value);
		}

		return builder.toGamePacket();
	}

}