package org.apollo.game.release.r299;

import org.apollo.game.message.impl.ClearRegionMessage;
import org.apollo.game.message.impl.ConfigMessage;
import org.apollo.game.message.impl.ForwardPrivateChatMessage;
import org.apollo.game.message.impl.FriendServerStatusMessage;
import org.apollo.game.message.impl.GroupedRegionUpdateMessage;
import org.apollo.game.message.impl.IdAssignmentMessage;
import org.apollo.game.message.impl.IgnoreListMessage;
import org.apollo.game.message.impl.LogoutMessage;
import org.apollo.game.message.impl.NpcSynchronizationMessage;
import org.apollo.game.message.impl.OpenInterfaceSidebarMessage;
import org.apollo.game.message.impl.PlayerSynchronizationMessage;
import org.apollo.game.message.impl.PrivacyOptionMessage;
import org.apollo.game.message.impl.RegionChangeMessage;
import org.apollo.game.message.impl.SendFriendMessage;
import org.apollo.game.message.impl.ServerChatMessage;
import org.apollo.game.message.impl.SetPlayerActionMessage;
import org.apollo.game.message.impl.SwitchTabInterfaceMessage;
import org.apollo.game.message.impl.UpdateItemsMessage;
import org.apollo.game.message.impl.UpdateRunEnergyMessage;
import org.apollo.game.message.impl.UpdateSkillMessage;
import org.apollo.game.message.impl.UpdateSlottedItemsMessage;
import org.apollo.game.message.impl.UpdateWeightMessage;
import org.apollo.net.meta.PacketMetaDataGroup;
import org.apollo.net.release.Release;

public class Release299 extends Release {

	/**
	 * The incoming packet lengths array.
	 */
	public static final int[] PACKET_LENGTHS = {
			7, 0, 6, 0, 2, 6, 0, 0, 0, 2, // 0
			0, 0, -1, 8, 0, 0, 0, 0, 0, 0, // 10
			4, 0, 2, 0, 1, 10, 4, 0, 0, 0, // 20
			0, 0, 0, 0, 0, 2, 8, -1, 7, 12, // 30
			0, 10, 6, 0, 0, 0, 6, -1, 0, 0, // 40
			0, 0, 1, 4, 0, 0, 0, 0, 4, 0, // 50
			6, 0, 2, 0, 6, 0, 0, 0, 0, 0, // 60
			-1, 0, 2, 1, 6, 0, 0, 0, 0, 0, // 70
			0, 0, 6, 0, 0, 0, -1, 0, 0, 0, // 80
			-1, 8, 0, 7, 1, 0, 0, 4, 6, 0, // 90
			0, 8, 4, 6, 0, 0, 8, 0, 6, 2, // 100
			0, 0, 0, 0, 0, 0, 0, 6, 0, 0, // 110
			0, 0, 0, 6, 8, 13, 0, 6, 0, 0, // 120
			0, 0, 0, 0, 0, 8, 12, 10, -1, -1, // 130
			0, -1, 0, 0, 0, 0, 0, 2, 0, -1, // 140
			8, 0, 0, 0, 3, 0, 6, 6, 0, 0, // 150
			0, 0, 0, 0, 0, 0, 2, 0, 0, 4, // 160
			0, 0, 0, 0, 2, 0, 0, 0, 0, 6, // 170
			0, 4, 0, 0, 0, 6, 0, 6, 2, 2, // 180
			0, 0, 0, 0, 0, 8, -1, 0, 0, 0, // 190
			0, 2, 0, 0, 0, 0, 0, 6, 0, 0, // 200
			0, 0, 0, 6, 0, 12, 6, 0, 0, 4, // 210
			0, 0, -1, 2, -1, 0, 0, 0, 0, 0, // 220
			1, 0, 0, 2, 0, 3, 4, 0, 6, 2, // 230
			4, 0, 3, 0, 0, 0, 0, 1, -1, 0, // 240
			8, 0, 0, 6, 6, 8 // 250-255
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
		WalkMessageDecoder walkMessageDecoder = new WalkMessageDecoder();
		register(141, walkMessageDecoder);
		register(196, walkMessageDecoder);
		register(70, walkMessageDecoder);

		register(37, new PublicChatMessageDecoder());
		register(62, new ButtonMessageDecoder());
		register(248, new CommandMessageDecoder());
		register(238, new FirstObjectActionMessageDecoder());
		register(156, new FirstItemActionMessageDecoder());
		register(169, new ArrowKeyMessageDecoder());

		// encoders
		register(RegionChangeMessage.class, new RegionChangeMessageEncoder());
		register(PlayerSynchronizationMessage.class, new PlayerSynchronizationMessageEncoder());
		register(NpcSynchronizationMessage.class, new NpcSynchronizationMessageEncoder());
		register(SwitchTabInterfaceMessage.class, new SwitchTabInterfaceMessageEncoder());
		register(UpdateItemsMessage.class, new UpdateItemsMessageEncoder());
		register(UpdateSlottedItemsMessage.class, new UpdateSlottedItemsMessageEncoder());
		register(UpdateSkillMessage.class, new UpdateSkillMessageEncoder());
		register(ServerChatMessage.class, new ServerMessageMessageEncoder());
		register(ConfigMessage.class, new ConfigMessageEncoder());
		register(IdAssignmentMessage.class, new IdAssignmentMessageEncoder());
		register(FriendServerStatusMessage.class, new FriendServerStatusMessageEncoder());
		register(IgnoreListMessage.class, new IgnoreListMessageEncoder());
		register(SendFriendMessage.class, new SendFriendMessageEncoder());
		register(PrivacyOptionMessage.class, new PrivacyOptionMessageEncoder());
		register(ForwardPrivateChatMessage.class, new ForwardPrivateChatMessageEncoder());
		register(OpenInterfaceSidebarMessage.class, new OpenInterfaceSidebarMessageEncoder());
		register(UpdateRunEnergyMessage.class, new UpdateRunEnergyMessageEncoder());
		register(UpdateWeightMessage.class, new UpdateWeightMessageEncoder());
		register(SetPlayerActionMessage.class, new SetPlayerActionMessageEncoder());
		register(LogoutMessage.class, new LogoutMessageEncoder());
		register(GroupedRegionUpdateMessage.class, new GroupedRegionUpdateMessageEncoder(this));
		register(ClearRegionMessage.class, new ClearRegionMessageEncoder());
	}
}
