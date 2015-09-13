package org.apollo.game.message.handler;

import org.apollo.cache.def.ItemDefinition;
import org.apollo.game.message.impl.ItemOnItemMessage;
import org.apollo.game.model.Item;
import org.apollo.game.model.World;
import org.apollo.game.model.entity.Player;
import org.apollo.game.model.inter.bank.BankConstants;
import org.apollo.game.model.inv.Inventory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Player.class, ItemDefinition.class})
public class ItemOnItemVerificationHandlerTest {

	private World world = new World();

	private ItemOnItemVerificationHandler itemOnItemVerificationHandler = new ItemOnItemVerificationHandler(world);
	private ItemVerificationHandler itemVerificationHandler = new ItemVerificationHandler(world);

	@BeforeClass
	public static void setupTestItemDefinitions() {
		mockStatic(ItemDefinition.class);
		when(ItemDefinition.lookup(4151)).thenReturn(new ItemDefinition(4151));
	}

	@Test
	public void testTerminateWithNoSourceItem() throws Exception {
		Player player = mock(Player.class);
		Inventory inventory = new Inventory(28);
		inventory.set(1, new Item(4151, 1));

		when(player.getInventory()).thenReturn(inventory);

		ItemOnItemMessage itemOnItemMessage = new ItemOnItemMessage(BankConstants.SIDEBAR_INVENTORY_ID, 500, 1,
				BankConstants.SIDEBAR_INVENTORY_ID, 4151, 1);

		itemVerificationHandler.handle(player, itemOnItemMessage);
		itemOnItemVerificationHandler.handle(player, itemOnItemMessage);

		assertTrue("ItemOnItemVerificationHandler: failed terminating message with invalid source item", itemOnItemMessage.terminated());
	}

	@Test
	public void testTerminateWithNoTargetItem() throws Exception {
		Player player = mock(Player.class);
		Inventory inventory = new Inventory(28);
		inventory.set(1, new Item(4151, 1));

		when(player.getInventory()).thenReturn(inventory);

		ItemOnItemMessage itemOnItemMessage = new ItemOnItemMessage(BankConstants.SIDEBAR_INVENTORY_ID, 4151, 1,
				BankConstants.SIDEBAR_INVENTORY_ID, 4152, 2);

		itemVerificationHandler.handle(player, itemOnItemMessage);
		itemOnItemVerificationHandler.handle(player, itemOnItemMessage);

		assertTrue("ItemOnItemVerificationHandler: failed terminating message with invalid target item", itemOnItemMessage.terminated());
	}
}