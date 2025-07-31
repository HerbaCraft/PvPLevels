package me.MathiasMC.PvPLevels.listeners;

import me.MathiasMC.PvPLevels.PvPLevels;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public final class EntityDamageByEntity implements Listener {
	private final PvPLevels plugin;

	public EntityDamageByEntity(final PvPLevels plugin) {
		this.plugin = plugin;
	}

	@EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
	public void onEntity(EntityDamageByEntityEvent e) {
		if (!(e.getEntity() instanceof Player player) || !(e.getDamager() instanceof Player)) {
			return;
		}
		if (!plugin.getStatsManager().canProgress(player)) {
			return;
		}
		plugin.lastDamagers.put(player.getUniqueId(), e.getDamager().getUniqueId());
	}
}