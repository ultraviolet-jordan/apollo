package org.apollo.game.release.r299;

import org.apollo.game.message.impl.PlayerSynchronizationMessage;
import org.apollo.game.message.impl.RegionChangeMessage;
import org.apollo.game.message.impl.SwitchTabInterfaceMessage;
import org.apollo.game.message.impl.UpdateItemsMessage;
import org.apollo.game.message.impl.UpdateSlottedItemsMessage;
import org.apollo.net.meta.PacketMetaDataGroup;
import org.apollo.net.release.Release;

public class Release299 extends Release {

	/**
	 * The incoming packet lengths array.
	 */
	public static final int[] PACKET_LENGTHS = {
			7, 0, 6, 0, 0, 0, 0, 0, 0, 2, // 0
			0, 0, -1, 8, 0, 0, 0, 0, 0, 0, // 10
			4, 0, 0, 0, 1, 10, 4, 0, 0, 0, // 20
			0, 0, 0, 0, 0, 0, 8, -1, 7, 12, // 30
			0, 10, 6, 0, 0, 0, 6, -1, 0, 0, // 40
			0, 0, 1, 4, 0, 0, 0, 0, 4, 0, // 50
			6, 0, 2, 0, 0, 0, 0, 0, 0, 0, // 60
			-1, 0, 2, 1, 6, 0, 0, 0, 0, 0, // 70
			0, 0, 6, 0, 0, 0, -1, 0, 0, 0, // 80
			-1, 8, 0, 7, 1, 0, 0, 0, 2, 0, // 90
			0, 8, 4, 6, 0, 0, 8, 0, 6, 2, // 100
			0, 0, 0, 0, 0, 0, 0, 6, 0, 0, // 110
			0, 0, 0, 6, 0, 13, 0, 6, 0, 0, // 120
			0, 0, 0, 0, 0, 8, 12, 10, -1, -1, // 130
			0, -1, 0, 0, 0, 0, 0, 2, 0, -1, // 140
			8, 0, 0, 0, 3, 0, 0, 6, 0, 0, // 150
			0, 0, 0, 0, 0, 0, 2, 0, 0, 6, // 160
			0, 0, 0, 0, 2, 0, 0, 0, 0, 6, // 170
			0, 4, 0, 0, 0, 6, 0, 6, 1, 2, // 180
			0, 0, 0, 0, 0, 8, -1, 0, 0, 0, // 190
			0, 2, 0, 0, 0, 0, 0, -1, 0, 0, // 200
			0, 0, 0, 6, 0, 6, 6, 0, 0, 4, // 210
			0, 0, -1, 2, -1, 0, 0, 0, 0, 0, // 220
			1, 0, 0, 2, 0, 3, 4, 0, 0, 6, // 230
			4, 0, 3, 0, 0, 0, 0, 1, -1, 0, // 240
			8, 0, 0, -1, 0, 8 // 250-255
	};

	/**
	 * Creates and initialises this release.
	 */
	public Release299() {
		super(299, PacketMetaDataGroup.createFromArray(PACKET_LENGTHS));
		init();
	}

	/**
	 * Initialises this release by registering encoders and decoders.
	 */
	private void init() {
		// decoders
		register(37, new PublicChatMessageDecoder());
		register(62, new ButtonMessageDecoder());
		register(248, new CommandMessageDecoder());

		// encoders
		register(RegionChangeMessage.class, new RegionChangeMessageEncoder());
		register(PlayerSynchronizationMessage.class, new PlayerSynchronizationMessageEncoder());
		register(SwitchTabInterfaceMessage.class, new SwitchTabInterfaceMessageEncoder());
		register(UpdateItemsMessage.class, new UpdateItemsMessageEncoder());
		register(UpdateSlottedItemsMessage.class, new UpdateSlottedItemsMessageEncoder());
	}
}
