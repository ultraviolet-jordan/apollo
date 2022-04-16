package org.apollo.game.release.r274;

import org.apollo.game.message.impl.*;
import org.apollo.net.meta.PacketMetaDataGroup;
import org.apollo.net.release.Release;

public class Release274 extends Release {

	/**
	 * The incoming packet lengths array.
	 */
	public static final int[] PACKET_LENGTHS = {
			7, 0, 6, 0, 0, 0, 0, 0, 0, 2, // 0
			0, 0, -1, 8, 0, 0, 0, 0, 0, 0, // 10
			4, 0, 0, 0, 9, 10, 0, 0, 0, 0, // 20
			0, 0, 0, 0, 0, 0, 8, 0, 0, 12, // 30
			0, 10, 6, 0, 0, 0, 6, 0, 0, 0, // 40
			0, 0, 1, 4, 0, 0, 0, 0, 0, 0, // 50
			6, 0, 6, 0, 0, 0, 0, 0, 0, 0, // 60
			0, 0, 2, 1, 6, 0, 0, 0, 0, 0, // 70
			3, 0, 6, 0, 0, 0, -1, 0, 0, 0, // 80
			0, 8, 0, 7, 1, 0, 0, 0, 2, 0, // 90
			0, 8, 4, 6, 0, 0, 8, 0, 6, 2, // 100
			0, 0, 0, 0, 0, 0, 0, 6, 0, 0, // 110
			0, 0, 0, 6, 0, 13, 0, 6, 0, 0, // 120
			0, 0, 0, 0, 0, 8, 12, 10, -1, -1, // 130
			0, 0, 0, 0, 0, 0, 0, 2, 0, -1, // 140
			8, 0, 0, 0, 3, 0, 0, 6, 0, 0, // 150
			0, 0, 0, 0, 0, 0, 2, 0, 0, 6, // 160
			0, 0, 0, 0, 2, 0, 0, 0, 0, 6, // 170
			0, 4, 0, 0, 0, 6, 0, 6, 1, 2, // 180
			0, 0, 0, 0, 0, 0, 2, 0, 0, 0, // 190
			0, 2, 0, 0, 0, 0, 0, -1, 0, 0, // 200
			0, 0, 0, 6, 0, 6, 6, 0, 0, 4, // 210
			0, 0, -1, 2, -1, 0, 0, 0, 0, 0, // 220
			1, 0, 0, 2, 0, 3, 2, 0, 0, 6, // 230
			4, 0, 0, 0, 0, 0, 0, 6, 0, 0, // 240
			8, 0, 0, -1, 0, 8 // 250-255
	};

	/**
	 * Creates and initialises this release.
	 */
	public Release274() {
		super(274, PacketMetaDataGroup.createFromArray(PACKET_LENGTHS));
		init();
	}

	/**
	 * Initialises this release by registering encoders and decoders.
	 */
	private void init() {
		//decoders
		WalkMessageDecoder walkMessageDecoder = new WalkMessageDecoder();
		register(207, walkMessageDecoder);
		register(86, walkMessageDecoder);
		register(138, walkMessageDecoder);

		register(253, new PublicChatMessageDecoder());
		register(9, new ButtonMessageDecoder());
		register(224, new CommandMessageDecoder());
		register(53, new ArrowKeyMessageDecoder());
		register(51, new ClosedInterfaceMessageDecoder());
		register(73, new FocusUpdateMessageDecoder());
		register(89, new KeepAliveMessageDecoder());

		register(185, new FirstItemOptionMessageDecoder());
		register(2, new SecondItemOptionMessageDecoder());

		register(74, new FirstItemActionMessageDecoder());

		register(236, new FirstNpcActionMessageDecoder());
		register(233, new SecondNpcActionMessageDecoder());
		register(223, new ThirdNpcActionMessageDecoder());
		register(147, new FourthNpcActionMessageDecoder());
		register(189, new FifthNpcActionMessageDecoder());

		register(215, new FirstObjectActionMessageDecoder());

		register(93, new SwitchItemMessageDecoder());
		register(136, new ItemOnItemMessageDecoder());

		register(13, new AddFriendMessageDecoder());
		register(106, new RemoveFriendMessageDecoder());
		register(255, new AddIgnoreMessageDecoder());
		register(101, new RemoveIgnoreMessageDecoder());
		register(154, new PrivacyOptionMessageDecoder());
		register(139, new PrivateChatMessageDecoder());

		//encoders
		register(RegionChangeMessage.class, new RegionChangeMessageEncoder());
		register(PlayerSynchronizationMessage.class, new PlayerSynchronizationMessageEncoder());
		register(SwitchTabInterfaceMessage.class, new SwitchTabInterfaceMessageEncoder());
		register(ServerChatMessage.class, new ServerMessageMessageEncoder());
		register(UpdateSkillMessage.class, new UpdateSkillMessageEncoder());
		register(ConfigMessage.class, new ConfigMessageEncoder());
		register(IdAssignmentMessage.class, new IdAssignmentMessageEncoder());
		register(FriendServerStatusMessage.class, new FriendServerStatusMessageEncoder());
		register(IgnoreListMessage.class, new IgnoreListMessageEncoder());
		register(SendFriendMessage.class, new SendFriendMessageEncoder());
		register(UpdateItemsMessage.class, new UpdateItemsMessageEncoder());
		register(UpdateSlottedItemsMessage.class, new UpdateSlottedItemsMessageEncoder());
		register(NpcSynchronizationMessage.class, new NpcSynchronizationMessageEncoder());
		register(PrivacyOptionMessage.class, new PrivacyOptionMessageEncoder());
		register(ForwardPrivateChatMessage.class, new ForwardPrivateChatMessageEncoder());
		register(OpenInterfaceSidebarMessage.class, new OpenInterfaceSidebarMessageEncoder());
		register(UpdateRunEnergyMessage.class, new UpdateRunEnergyMessageEncoder());
		register(UpdateWeightMessage.class, new UpdateWeightMessageEncoder());
		register(SetPlayerActionMessage.class, new SetPlayerActionMessageEncoder());
		register(LogoutMessage.class, new LogoutMessageEncoder());
		register(GroupedRegionUpdateMessage.class, new GroupedRegionUpdateMessageEncoder(this));
		register(ClearRegionMessage.class, new ClearRegionMessageEncoder());
		register(RemoveObjectMessage.class, new RemoveObjectMessageEncoder());
		register(SendObjectMessage.class, new SendObjectMessageEncoder());
		register(DisplayCrossbonesMessage.class, new DisplayCrossbonesMessageEncoder());
	}
}
