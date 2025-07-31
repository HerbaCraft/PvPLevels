package me.MathiasMC.PvPLevels.listeners;

import me.MathiasMC.PvPLevels.PvPLevels;
import me.MathiasMC.PvPLevels.data.PlayerConnect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public final class PlayerJoin implements Listener {
	private final PvPLevels plugin;

	public PlayerJoin(final PvPLevels plugin) {
		this.plugin = plugin;
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onJoin(PlayerJoinEvent event) {
		final Player player = event.getPlayer();
		if (!plugin.getFileUtils().config.getBoolean("multiplier-quit", true)) {
			return;
		}

		final PlayerConnect playerConnect = plugin.getPlayerConnect(player.getUniqueId());
		if (playerConnect.getMultiplier() == 0) {
			return;
		}
		plugin.getXPManager().sendCommands(player, plugin.getFileUtils().language.getStringList("multiplier.join"));
		plugin.multipliers.add(player.getUniqueId());
	}
}
