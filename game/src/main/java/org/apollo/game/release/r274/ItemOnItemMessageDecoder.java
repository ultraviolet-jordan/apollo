package org.apollo.game.release.r274;

import org.apollo.game.message.impl.ItemOnItemMessage;
import org.apollo.net.codec.game.DataType;
import org.apollo.net.codec.game.GamePacket;
import org.apollo.net.codec.game.GamePacketReader;
import org.apollo.net.release.MessageDecoder;

public final class ItemOnItemMessageDecoder extends MessageDecoder<ItemOnItemMessage> {

	@Override
	public ItemOnItemMessage decode(GamePacket packet) {
		GamePacketReader reader = new GamePacketReader(packet);

		//TODO The targetInterface and usedInterface might be wrong order.
		int targetId = (int) reader.getSigned(DataType.SHORT);
		int targetSlot = (int) reader.getUnsigned(DataType.SHORT);
		int targetInterface = (int) reader.getUnsigned(DataType.SHORT);
		int usedId = (int) reader.getSigned(DataType.SHORT);
		int usedSlot = (int) reader.getUnsigned(DataType.SHORT);
		int usedInterface = (int) reader.getUnsigned(DataType.SHORT);

		return new ItemOnItemMessage(usedInterface, usedId, usedSlot, targetInterface, targetId, targetSlot);
	}

}