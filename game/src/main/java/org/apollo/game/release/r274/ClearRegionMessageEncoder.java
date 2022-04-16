package org.apollo.game.release.r274;

import org.apollo.game.message.impl.ClearRegionMessage;
import org.apollo.game.model.Position;
import org.apollo.net.codec.game.DataType;
import org.apollo.net.codec.game.GamePacket;
import org.apollo.net.codec.game.GamePacketBuilder;
import org.apollo.net.release.MessageEncoder;

public final class ClearRegionMessageEncoder extends MessageEncoder<ClearRegionMessage> {

	@Override
	public GamePacket encode(ClearRegionMessage message) {
		GamePacketBuilder builder = new GamePacketBuilder(153);
		Position player = message.getPlayerPosition(), region = message.getRegionPosition();

		builder.put(DataType.BYTE, region.getLocalX(player));
		builder.put(DataType.BYTE, region.getLocalY(player));

		return builder.toGamePacket();
	}

}