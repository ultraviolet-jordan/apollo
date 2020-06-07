package org.apollo.game.release.r289;

import org.apollo.game.message.impl.UpdateWeightMessage;
import org.apollo.net.codec.game.DataType;
import org.apollo.net.codec.game.GamePacket;
import org.apollo.net.codec.game.GamePacketBuilder;
import org.apollo.net.release.MessageEncoder;

public final class UpdateWeightMessageEncoder extends MessageEncoder<UpdateWeightMessage> {

	@Override
	public GamePacket encode(UpdateWeightMessage message) {
		GamePacketBuilder builder = new GamePacketBuilder(46);
		builder.put(DataType.SHORT, message.getWeight());
		return builder.toGamePacket();
	}

}