package me.MathiasMC.PvPLevels.listeners;

import me.MathiasMC.PvPLevels.PvPLevels;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public final class PlayerMove implements Listener {
	private final PvPLevels plugin;

	public PlayerMove(final PvPLevels plugin) {
		this.plugin = plugin;
	}

	@EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
	public void onMove(PlayerMoveEvent e) {
		final Player player = e.getPlayer();
		if (!(player.getLocation().getY() <= plugin.deathY) || player.isDead()) {
			return;
		}
		player.setHealth(0D);
		if (!plugin.isRespawn) {
			return;
		}
		player.spigot().respawn();
	}
}