package org.apollo.game.release.r289;

import org.apollo.game.message.impl.*;
import org.apollo.net.meta.PacketMetaDataGroup;
import org.apollo.net.release.Release;

public class Release289 extends Release {

	/**
	 * The incoming packet lengths array.
	 */
	public static final int[] PACKET_LENGTHS = {
		0, 0, 0, 0, 0, 0, 0, 0, 0, 0, // 0
		0, 0, 0, 0, 0, 0, 8, 0, 0, 0, // 10
		0, 0, 0, 0, 0, 0, 0, 0, 0, 0, // 20
		0, 0, 0, 0, 0, 0, 0, 0, 0, 0, // 30
		0, 0, 0, 0, 0, 0, 0, 0, 0, 0, // 40
		0, 0, 0, 0, 0, 0, 0, 0, 0, 0, // 50
		0, 0, 0, 0, 0, 0, 0, -1, 0, 0, // 60
		0, 0, 0, 0, 0, 0, 0, 0, 0, 0, // 70
		0, 0, 0, 0, 0, 0, 2, 0, 0, 0, // 80
		0, 0, 0, 0, 10, 0, 0, 0, 0, 0, // 90
		0, 0, 0, 0, 0, 0, 0, 0, 0, 0, // 100
		0, 0, 0, 0, 0, 0, 0, 0, 0, 0, // 110
		0, 0, 0, 0, 0, 0, 0, 0, 0, 0, // 120
		-1, 0, 0, 0, 0, 0, 0, 1, 0, 0, // 130
		0, 0, 0, 0, 0, 0, 0, 0, 0, 1, // 140
		0, 0, 0, 0, 0, 0, -1, 0, 0, 0, // 150
		0, 3, 0, 0, 0, 0, 0, 0, 0, 0, // 160
		0, 0, 0, 0, 0, 0, 0, 0, 0, 0, // 170
		0, 0, 0, 0, 0, 0, 0, 0, 0, 0, // 180
		0, 0, 0, 4, 0, 0, 0, 0, 0, 0, // 190
		0, 0, 0, 0, 0, 0, 0, 0, 0, 0, // 200
		0, 0, 0, 0, 0, 0, 0, 0, 0, 0, // 210
		0, 0, 0, 0, 4, 0, 0, 0, 0, 0, // 220
		0, 0, 0, 0, -1, 0, -1, 0, 0, 0, // 230
		0, 0, 0, 0, 0, 0, 0, 0, 0, 0, // 240
		0, 0, 0, 0, 0, 0 // 250
	};


	/**
	 * Creates and initialises this release.
	 */
	public Release289() {
		super(289, PacketMetaDataGroup.createFromArray(PACKET_LENGTHS));
		init();
	}

	/**
	 * Initialises this release by registering encoders and decoders.
	 */
	private void init() {
		//decoders
		WalkMessageDecoder walkMessageDecoder = new WalkMessageDecoder();
		register(236, walkMessageDecoder);
		register(234, walkMessageDecoder);
		register(67, walkMessageDecoder);

		register(156, new PublicChatMessageDecoder());
		register(86, new ButtonMessageDecoder());

		//encoders
		register(RegionChangeMessage.class, new RegionChangeMessageEncoder());
		register(PlayerSynchronizationMessage.class, new PlayerSynchronizationMessageEncoder());
		register(SwitchTabInterfaceMessage.class, new SwitchTabInterfaceMessageEncoder());
		register(ServerChatMessage.class, new ServerMessageMessageEncoder());
		register(UpdateSkillMessage.class, new UpdateSkillMessageEncoder());
	}
}
