package org.apollo.game.release.r274;

import org.apollo.game.message.impl.SwitchItemMessage;
import org.apollo.net.codec.game.DataType;
import org.apollo.net.codec.game.GamePacket;
import org.apollo.net.codec.game.GamePacketReader;
import org.apollo.net.release.MessageDecoder;

public final class SwitchItemMessageDecoder extends MessageDecoder<SwitchItemMessage> {

	@Override
	public SwitchItemMessage decode(GamePacket packet) {
		GamePacketReader reader = new GamePacketReader(packet);
		int interfaceId = (int) reader.getUnsigned(DataType.SHORT);
		int oldSlot = (int) reader.getUnsigned(DataType.SHORT);
		int newSlot = (int) reader.getUnsigned(DataType.SHORT);
		boolean inserting = reader.getUnsigned(DataType.BYTE) == 1;
		return new SwitchItemMessage(interfaceId, inserting, oldSlot, newSlot);
	}

}