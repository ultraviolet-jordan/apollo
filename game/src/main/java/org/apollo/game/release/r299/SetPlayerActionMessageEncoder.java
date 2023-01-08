package org.apollo.game.release.r299;

import org.apollo.game.message.impl.SetPlayerActionMessage;
import org.apollo.net.codec.game.DataType;
import org.apollo.net.codec.game.GamePacket;
import org.apollo.net.codec.game.GamePacketBuilder;
import org.apollo.net.meta.PacketType;
import org.apollo.net.release.MessageEncoder;

public final class SetPlayerActionMessageEncoder extends MessageEncoder<SetPlayerActionMessage> {

	@Override
	public GamePacket encode(SetPlayerActionMessage message) {
		GamePacketBuilder builder = new GamePacketBuilder(98, PacketType.VARIABLE_BYTE);
		builder.put(DataType.BYTE, message.getSlot());
		builder.put(DataType.BYTE, message.isPrimaryAction() ? 0 : 1);
		builder.putString(message.getText());
		return builder.toGamePacket();
	}

}