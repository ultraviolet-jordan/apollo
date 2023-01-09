package org.apollo.game.release.r254;

import org.apollo.game.message.impl.RegionChangeMessage;
import org.apollo.net.codec.game.DataType;
import org.apollo.net.codec.game.GamePacket;
import org.apollo.net.codec.game.GamePacketBuilder;
import org.apollo.net.release.MessageEncoder;

public final class RegionChangeMessageEncoder extends MessageEncoder<RegionChangeMessage> {

	@Override
	public GamePacket encode(RegionChangeMessage message) {
		GamePacketBuilder builder = new GamePacketBuilder(209);
		builder.put(DataType.SHORT, message.getPosition().getCentralRegionX());
		builder.put(DataType.SHORT, message.getPosition().getCentralRegionY());

		return builder.toGamePacket();
	}

}