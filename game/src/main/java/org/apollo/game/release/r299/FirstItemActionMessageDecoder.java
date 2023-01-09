package org.apollo.game.release.r299;

import org.apollo.game.message.impl.ItemActionMessage;
import org.apollo.net.codec.game.DataType;
import org.apollo.net.codec.game.GamePacket;
import org.apollo.net.codec.game.GamePacketReader;
import org.apollo.net.release.MessageDecoder;

public final class FirstItemActionMessageDecoder extends MessageDecoder<ItemActionMessage> {

	@Override
	public ItemActionMessage decode(GamePacket packet) {
		GamePacketReader reader = new GamePacketReader(packet);
		int id = (int) reader.getUnsigned(DataType.SHORT);
		int slot = (int) reader.getUnsigned(DataType.SHORT);
		int interfaceId = (int) reader.getUnsigned(DataType.SHORT);
		return new ItemActionMessage(1, interfaceId, id, slot);
	}

}