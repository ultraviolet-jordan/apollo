package org.apollo.game.release.r274;

import org.apollo.game.message.impl.SwitchTabInterfaceMessage;
import org.apollo.net.codec.game.DataType;
import org.apollo.net.codec.game.GamePacket;
import org.apollo.net.codec.game.GamePacketBuilder;
import org.apollo.net.release.MessageEncoder;

public final class SwitchTabInterfaceMessageEncoder extends MessageEncoder<SwitchTabInterfaceMessage> {

	@Override
	public GamePacket encode(SwitchTabInterfaceMessage message) {
		GamePacketBuilder builder = new GamePacketBuilder(215);
		builder.put(DataType.SHORT, message.getInterfaceId());
		builder.put(DataType.BYTE, message.getTabId());
		return builder.toGamePacket();
	}

}