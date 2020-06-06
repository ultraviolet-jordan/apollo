package org.apollo.game.release.r289;

import org.apollo.game.message.impl.UpdateItemsMessage;
import org.apollo.game.model.Item;
import org.apollo.net.codec.game.*;
import org.apollo.net.meta.PacketType;
import org.apollo.net.release.MessageEncoder;

public final class UpdateItemsMessageEncoder extends MessageEncoder<UpdateItemsMessage> {

	@Override
	public GamePacket encode(UpdateItemsMessage message) {
		GamePacketBuilder builder = new GamePacketBuilder(107, PacketType.VARIABLE_SHORT);

		Item[] items = message.getItems();

		builder.put(DataType.SHORT, message.getInterfaceId());
		builder.put(DataType.SHORT, items.length);

		for (Item item : items) {
			int id = item == null ? -1 : item.getId();
			int amount = item == null ? 0 : item.getAmount();

			builder.put(DataType.SHORT, id + 1);

			if (amount > 254) {
				builder.put(DataType.BYTE, 255);
				builder.put(DataType.INT, amount);
			} else {
				builder.put(DataType.BYTE, amount);
			}
		}

		return builder.toGamePacket();
	}

}