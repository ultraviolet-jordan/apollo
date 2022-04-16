package org.apollo.game.release.r274;

import org.apollo.game.message.impl.ObjectActionMessage;
import org.apollo.game.model.Position;
import org.apollo.net.codec.game.DataType;
import org.apollo.net.codec.game.GamePacket;
import org.apollo.net.codec.game.GamePacketReader;
import org.apollo.net.release.MessageDecoder;

public final class FirstObjectActionMessageDecoder extends MessageDecoder<ObjectActionMessage> {

	@Override
	public ObjectActionMessage decode(GamePacket packet) {
		GamePacketReader reader = new GamePacketReader(packet);
		int x = (int) reader.getUnsigned(DataType.SHORT);
		int y = (int) reader.getUnsigned(DataType.SHORT);
		int id = (int) reader.getUnsigned(DataType.SHORT);
		return new ObjectActionMessage(1, id, new Position(x, y));
	}

}