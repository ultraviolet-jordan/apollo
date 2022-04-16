package org.apollo.game.release.r274;

import org.apollo.game.message.impl.DisplayCrossbonesMessage;
import org.apollo.net.codec.game.DataType;
import org.apollo.net.codec.game.GamePacket;
import org.apollo.net.codec.game.GamePacketBuilder;
import org.apollo.net.release.MessageEncoder;

public final class DisplayCrossbonesMessageEncoder extends MessageEncoder<DisplayCrossbonesMessage> {

	@Override
	public GamePacket encode(DisplayCrossbonesMessage message) {
		GamePacketBuilder builder = new GamePacketBuilder(207);
		builder.put(DataType.BYTE, message.isDisplayed() ? 1 : 0);
		return builder.toGamePacket();
	}

}