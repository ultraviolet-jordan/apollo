package org.apollo.game.scheduling.impl;

import org.apollo.game.model.entity.Player;
import org.apollo.game.model.entity.Skill;
import org.apollo.game.model.entity.WalkingQueue;
import org.apollo.game.scheduling.ScheduledTask;

public class PlayerEnergyTask extends ScheduledTask {

	/**
	 * The player to set this task to.
	 */
	private final Player player;

	/**
	 * Creates a new scheduled task.
	 * @param player The player.
	 */
	public PlayerEnergyTask(Player player) {
		super(1, false);
		this.player = player;
	}

	@Override
	public void execute() {
		if (player.isActive()) {
			//https://oldschool.runescape.wiki/w/Energy

			if (player.getWalkingQueue().size() > 0 && player.isRunning()) {
				//TODO Add weight into this calc
				player.setRunEnergy(Math.max(0, player.getRunEnergy() - 64));

				if (player.getRunEnergy() < 1) {
					player.toggleRunning(false);
				}
			} else {
				//TODO Add weight into this calc
				double restore = 8 + Math.floor(player.getSkillSet().getCurrentLevel(Skill.AGILITY) / 6);
				player.setRunEnergy(Math.min(10_000, player.getRunEnergy() + (int) restore));
			}
		} else {
			stop();
		}
	}

}
