package me.MathiasMC.PvPLevels.listeners;

import me.MathiasMC.PvPLevels.PvPLevels;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public final class BlockPlace implements Listener {
	private final PvPLevels plugin;

	public BlockPlace(final PvPLevels plugin) {
		this.plugin = plugin;
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlace(BlockPlaceEvent event) {
		String group = plugin.getPlayerConnect(event.getPlayer().getUniqueId()).getGroup();
		if (!plugin.getFileUtils().config.contains("xp." + group + "." + event.getBlock().getType().name().toLowerCase())) {
			return;
		}
		plugin.blocksList.add(event.getBlock().getLocation());
	}
}