package org.apollo.game.release.r289;

import org.apollo.game.message.impl.IdAssignmentMessage;
import org.apollo.net.codec.game.*;
import org.apollo.net.release.MessageEncoder;

public final class IdAssignmentMessageEncoder extends MessageEncoder<IdAssignmentMessage> {

	@Override
	public GamePacket encode(IdAssignmentMessage message) {
		GamePacketBuilder builder = new GamePacketBuilder(120);
		builder.put(DataType.SHORT, message.getId());
		builder.put(DataType.BYTE, message.isMembers() ? 1 : 0);
		return builder.toGamePacket();
	}

}