package org.apollo.game.release.r274;

import org.apollo.game.message.impl.AddIgnoreMessage;
import org.apollo.net.codec.game.DataType;
import org.apollo.net.codec.game.GamePacket;
import org.apollo.net.codec.game.GamePacketReader;
import org.apollo.net.release.MessageDecoder;
import org.apollo.util.NameUtil;

public final class AddIgnoreMessageDecoder extends MessageDecoder<AddIgnoreMessage> {

	@Override
	public AddIgnoreMessage decode(GamePacket packet) {
		GamePacketReader reader = new GamePacketReader(packet);
		String username = NameUtil.decodeBase37(reader.getSigned(DataType.LONG));
		return new AddIgnoreMessage(username);
	}

}