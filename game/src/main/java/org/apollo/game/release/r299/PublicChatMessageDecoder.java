package org.apollo.game.release.r299;

import org.apollo.game.message.impl.PublicChatMessage;
import org.apollo.net.codec.game.DataType;
import org.apollo.net.codec.game.GamePacket;
import org.apollo.net.codec.game.GamePacketReader;
import org.apollo.net.release.MessageDecoder;
import org.apollo.util.TextUtil;

public final class PublicChatMessageDecoder extends MessageDecoder<PublicChatMessage> {

	@Override
	public PublicChatMessage decode(GamePacket packet) {
		GamePacketReader reader = new GamePacketReader(packet);

		int effects = (int) reader.getUnsigned(DataType.BYTE);
		int color = (int) reader.getUnsigned(DataType.BYTE);
		int length = packet.getLength() - 2;

		byte[] originalCompressed = new byte[length];
		reader.getBytes(originalCompressed);

		String uncompressed = TextUtil.decompress(originalCompressed, length);
		uncompressed = TextUtil.filterInvalidCharacters(uncompressed);
		uncompressed = TextUtil.capitalize(uncompressed);

		byte[] recompressed = new byte[length];
		TextUtil.compress(uncompressed, recompressed);
		// in case invalid data gets sent, this effectively verifies it

		return new PublicChatMessage(uncompressed, recompressed, color, effects);
	}

}