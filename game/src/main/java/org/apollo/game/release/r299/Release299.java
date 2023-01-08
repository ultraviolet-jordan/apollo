package org.apollo.game.release.r299;

import org.apollo.net.meta.PacketMetaDataGroup;
import org.apollo.net.release.Release;

public class Release299 extends Release {

	/**
	 * The incoming packet lengths array.
	 */
	public static final int[] PACKET_LENGTHS = {
			0, 0, 4, 1, 0, 0, 0, 4, 0, 2,
			0, 0, 0, -2, 0, 0, 0, 0, 0, 1,
			0, 0, 2, 0, 0, 0, 0, 1, 0, 0,
			15, 0, 0, 3, 0, 0, 0, 0, 2, 0,
			0, 0, 0, 0, 2, 5, 0, 0, 0, 0,
			0, 3, 0, 3, 0, 6, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 2, 0, 0,
			0, 8, 0, 0, 0, 4, 0, 6, 0, 0,
			0, 0, 4, 0, 2, 0, 0, 0, -1, 0,
			0, 0, 0, 0, 0, -2, 0, 0, -2, 0,
			0, 0, 0, 0, 0, 6, 0, 0, 1, 10,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			6, 1, 0, 0, 0, 0, 4, 7, 0, 0,
			0, 3, 0, 0, 0, 6, 0, 5, 0, 9,
			0, 6, 0, 6, 0, 0, 2, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, -2,
			4, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 1, 0, 4, 0, 4, 4, 0, -2, 0,
			0, 14, 0, 6, 0, -2, -2, 0, 0, 0,
			0, 0, 0, 0, 2, 0, 3, 0, 0, 0,
			0, 2, 0, 3, 4, 0, 0, 0, 0, 0,
			0, 0, 4, 0, -1, 0, 0, 0, 2, 0,
			0, 0, 0, 0, 0, 0, 2, 2, -1, 0,
			0, 6, 0, 0, 0, 4, 2, 0, 0, 0,
			0, 0, 0, 7, 0, 0, 0
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
	}
}
