package me.MathiasMC.PvPLevels.listeners;

import me.MathiasMC.PvPLevels.PvPLevels;
import me.MathiasMC.PvPLevels.data.PlayerConnect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public final class BlockBreak implements Listener {
	private final PvPLevels plugin;

	public BlockBreak(final PvPLevels plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		final Location location = event.getBlock().getLocation();
		final Player player = event.getPlayer();
		final PlayerConnect playerConnect = plugin.getPlayerConnect(player.getUniqueId());
		if (plugin.getXPManager().isMaxLevel(playerConnect)) {
			return;
		}
		final Material material = event.getBlock().getType();
		if (!event.getBlock().getLocation().getBlock().getType().equals(Material.AIR)) {
			return;
		}
		if (!plugin.blocksList.contains(location)) {
			plugin.getXPManager().getXP(player, null, material);
		}
		plugin.blocksList.remove(location);
	}
}
