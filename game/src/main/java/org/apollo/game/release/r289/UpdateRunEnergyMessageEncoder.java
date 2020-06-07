package org.apollo.game.release.r289;

import org.apollo.game.message.impl.UpdateRunEnergyMessage;
import org.apollo.net.codec.game.DataType;
import org.apollo.net.codec.game.GamePacket;
import org.apollo.net.codec.game.GamePacketBuilder;
import org.apollo.net.release.MessageEncoder;

public final class UpdateRunEnergyMessageEncoder extends MessageEncoder<UpdateRunEnergyMessage> {

	@Override
	public GamePacket encode(UpdateRunEnergyMessage message) {
		GamePacketBuilder builder = new GamePacketBuilder(195);
		builder.put(DataType.BYTE, message.getEnergy());
		return builder.toGamePacket();
	}

}