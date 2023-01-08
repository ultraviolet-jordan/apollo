package org.apollo.game.release.r299;

import org.apollo.game.message.impl.IdAssignmentMessage;
import org.apollo.net.codec.game.DataType;
import org.apollo.net.codec.game.GamePacket;
import org.apollo.net.codec.game.GamePacketBuilder;
import org.apollo.net.release.MessageEncoder;

public final class IdAssignmentMessageEncoder extends MessageEncoder<IdAssignmentMessage> {

	@Override
	public GamePacket encode(IdAssignmentMessage message) {
		GamePacketBuilder builder = new GamePacketBuilder(185);
		builder.put(DataType.SHORT, message.getId());
		builder.put(DataType.SHORT, message.isMembers() ? 1 : 0);
		return builder.toGamePacket();
	}

}