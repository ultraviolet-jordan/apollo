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
		6, 0, 0, 0, 0, 0, 8, 0, 0, 0, // 10
		0, 2, 0, 0, 0, 0, 0, 0, 0, 0, // 20
		2, 0, 0, 0, -1, 0, 0, 0, 0, 0, // 30
		6, 0, 0, 0, 6, 0, 0, 0, 0, 0, // 40
		0, 0, 0, 0, 0, 0, 0, 0, 0, 0, // 50
		0, 0, 0, 0, 0, 0, 0, -1, 0, 2, // 60
		0, 0, 0, 0, 0, 0, 6, 0, 0, 6, // 70
		0, 0, 0, 0, 0, 0, 2, 0, 0, 0, // 80
		0, 0, 0, 0, 10, 0, 0, 0, 0, 0, // 90
		0, 0, 0, 0, 0, 0, 0, -1, 0, 0, // 100
		0, 0, 0, 0, 0, 0, 0, 0, 0, 0, // 110
		0, 0, 0, 0, 0, 0, 0, 0, 0, 0, // 120
		-1, 0, 0, 0, 0, 0, 0, 1, 0, 0, // 130
		0, 0, 0, 0, 0, 0, 0, 0, 0, 1, // 140
		0, 0, 0, 0, 0, 0, -1, 0, 0, 0, // 150
		0, 3, 0, 0, 0, 0, 0, 0, 0, 0, // 160
		0, 0, 0, 0, 0, 0, 0, 6, 2, 0, // 170
		0, 0, 0, 0, 0, 0, 0, 2, 0, 0, // 180
		0, 0, 8, 4, 0, 0, 0, 0, 0, 0, // 190
		12, 0, 0, 8, 4, 0, 0, 0, 0, 0, // 200
		0, 0, 0, 0, 0, 0, 0, 0, 0, 0, // 210
		0, 0, 0, 0, 4, 0, 0, 0, 0, 0, // 220
		0, 0, 0, 0, -1, 8, -1, 0, 0, 0, // 230
		0, 0, 0, 0, 0, 0, 0, 2, 0, 0, // 240
		0, 8, 2, 7, 0, 0 // 250
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
		register(34, new CommandMessageDecoder());
		register(193, new ArrowKeyMessageDecoder());
		register(93, new ClosedInterfaceMessageDecoder());
		register(149, new FocusUpdateMessageDecoder());
		register(181, new KeepAliveMessageDecoder());

		register(76, new FirstItemOptionMessageDecoder());
		register(177, new SecondItemOptionMessageDecoder());

		register(44, new FirstItemActionMessageDecoder());

		register(252, new FirstNpcActionMessageDecoder());
		register(21, new SecondNpcActionMessageDecoder());
		register(178, new ThirdNpcActionMessageDecoder());
		register(30, new FourthNpcActionMessageDecoder());
		register(247, new FifthNpcActionMessageDecoder());

		register(10, new FirstObjectActionMessageDecoder());

		register(187, new FirstPlayerActionMessageDecoder());
		register(69, new SecondPlayerActionMessageDecoder());

		register(253, new SwitchItemMessageDecoder());
		register(200, new ItemOnItemMessageDecoder());

		register(235, new AddFriendMessageDecoder());
		register(203, new RemoveFriendMessageDecoder());
		register(192, new AddIgnoreMessageDecoder());
		register(251, new RemoveIgnoreMessageDecoder());
		register(161, new PrivacyOptionMessageDecoder());
		register(107, new PrivateChatMessageDecoder());

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
