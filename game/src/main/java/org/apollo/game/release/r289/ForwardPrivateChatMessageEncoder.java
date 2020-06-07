package org.apollo.game.release.r289;

import org.apollo.game.message.impl.ForwardPrivateChatMessage;
import org.apollo.net.codec.game.DataType;
import org.apollo.net.codec.game.GamePacket;
import org.apollo.net.codec.game.GamePacketBuilder;
import org.apollo.net.meta.PacketType;
import org.apollo.net.release.MessageEncoder;
import org.apollo.util.NameUtil;

import java.util.concurrent.atomic.AtomicInteger;

public final class ForwardPrivateChatMessageEncoder extends MessageEncoder<ForwardPrivateChatMessage> {

	/**
	 * The amount of messages sent globally, offset by a random variable x, {@code 0 <= x < 100,000,000}.
	 */
	private static AtomicInteger messageCounter = new AtomicInteger((int) (Math.random() * 100_000_000));

	@Override
	public GamePacket encode(ForwardPrivateChatMessage message) {
		GamePacketBuilder builder = new GamePacketBuilder(243, PacketType.VARIABLE_BYTE);

		builder.put(DataType.LONG, NameUtil.encodeBase37(message.getSenderUsername()));
		builder.put(DataType.INT, messageCounter.incrementAndGet());
		builder.put(DataType.BYTE, message.getSenderPrivilege().toInteger());
		builder.putBytes(message.getCompressedMessage());
		return builder.toGamePacket();
	}

}