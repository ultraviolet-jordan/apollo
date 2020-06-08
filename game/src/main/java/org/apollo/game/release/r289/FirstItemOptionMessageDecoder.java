package org.apollo.game.release.r289;

import org.apollo.game.message.impl.ItemOptionMessage;
import org.apollo.net.codec.game.*;
import org.apollo.net.release.MessageDecoder;

public final class FirstItemOptionMessageDecoder extends MessageDecoder<ItemOptionMessage> {

	@Override
	public ItemOptionMessage decode(GamePacket packet) {
		GamePacketReader reader = new GamePacketReader(packet);

		int id = (int) reader.getSigned(DataType.SHORT);
		int slot = (int) reader.getUnsigned(DataType.SHORT);
		int interfaceId = (int) reader.getSigned(DataType.SHORT);

		return new ItemOptionMessage(1, interfaceId, id, slot);
	}

}