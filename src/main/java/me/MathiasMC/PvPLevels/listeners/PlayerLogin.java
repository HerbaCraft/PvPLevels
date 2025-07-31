package me.MathiasMC.PvPLevels.listeners;

import me.MathiasMC.PvPLevels.PvPLevels;
import me.MathiasMC.PvPLevels.data.PlayerConnect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public final class PlayerLogin implements Listener {
	private final PvPLevels plugin;

	public PlayerLogin(final PvPLevels plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		plugin.database.insert(player.getUniqueId());
		plugin.getServer().getScheduler().runTaskLaterAsynchronously(plugin, () -> {
			plugin.updatePlayerConnect(player.getUniqueId());
		}, plugin.getConfig().getInt("mysql.update") * 20L);
		if (!plugin.getFileUtils().config.contains("groups")) {
			return;
		}
		for (String group : plugin.getFileUtils().config.getConfigurationSection("groups").getKeys(false)) {
			String permission = plugin.getFileUtils().config.getString("groups." + group);
			if (!player.hasPermission(permission)) {
				continue;
			}
			PlayerConnect playerConnect = plugin.getPlayerConnect(player.getUniqueId());
			if (playerConnect.getGroup().equals(group)) {
				return;
			}
			playerConnect.setGroup(group);
			break;
		}
	}
}