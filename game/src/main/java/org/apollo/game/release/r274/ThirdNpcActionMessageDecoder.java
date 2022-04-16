package org.apollo.game.release.r274;

import org.apollo.game.message.impl.NpcActionMessage;
import org.apollo.net.codec.game.DataType;
import org.apollo.net.codec.game.GamePacket;
import org.apollo.net.codec.game.GamePacketReader;
import org.apollo.net.release.MessageDecoder;

public final class ThirdNpcActionMessageDecoder extends MessageDecoder<NpcActionMessage> {

	@Override
	public NpcActionMessage decode(GamePacket packet) {
		GamePacketReader reader = new GamePacketReader(packet);
		int index = (int) reader.getSigned(DataType.SHORT);
		return new NpcActionMessage(3, index);
	}

}