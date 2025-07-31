package me.MathiasMC.PvPLevels.api.events;

import me.MathiasMC.PvPLevels.PvPLevels;
import me.MathiasMC.PvPLevels.data.PlayerConnect;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PlayerGetXPEvent extends Event implements Cancellable {
	private static final HandlerList handlers = new HandlerList();

	private final PvPLevels plugin;
	private final Player player;
	private final Entity entity;
	private final PlayerConnect playerConnect;
	private boolean cancelled = false;
	private long xp;

	private String key;

	private List<String> commands = null;

	public PlayerGetXPEvent(final Player player, final Entity entity, final PlayerConnect playerConnect, final long xp) {
		this.plugin = PvPLevels.getInstance();
		this.player = player;
		this.entity = entity;
		this.playerConnect = playerConnect;
		this.xp = xp;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

	public Player getPlayer() {
		return this.player;
	}

	public Entity getEntity() {
		return this.entity;
	}

	public PlayerConnect getPlayerConnect() {
		return this.playerConnect;
	}

	public long getXp() {
		return this.xp;
	}

	public void setXp(final long xp) {
		this.xp = xp;
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(final String key) {
		this.key = key;
	}

	public List<String> getCommands() {
		return this.commands;
	}

	public void setCommands(final List<String> commands) {
		this.commands = commands;
	}

	public List<String> getDefaultCommands() {
		final String path = playerConnect.getGroup() + "." + playerConnect.getLevel() + ".override";
		if (!plugin.getFileUtils().levels.contains(path)) {
			return plugin.getFileUtils().execute.getStringList(plugin.getFileUtils().levels.getString(playerConnect.getGroup() + ".execute") + ".xp." + key);
		}
		return plugin.getFileUtils().execute.getStringList(plugin.getFileUtils().levels.getString(path) + ".xp." + key);
	}

	public void execute() {
		if (!plugin.getXPManager().isMaxLevel(playerConnect)) {
			playerConnect.setXp(xp);
		}
		final boolean getLevel = plugin.getXPManager().getLevel(player, entity, playerConnect);
		if (!getLevel) {
			plugin.getXPManager().sendCommands(player, commands);
		}
		if (playerConnect.getSave() >= plugin.getFileUtils().config.getInt("mysql.save")) {
			playerConnect.save();
			playerConnect.setSave(0);
			return;
		}
		playerConnect.setSave(playerConnect.getSave() + 1);
	}

	@Override
	public boolean isCancelled() {
		return cancelled;
	}

	@Override
	public void setCancelled(boolean set) {
		cancelled = set;
	}

	@Override
	public @NotNull HandlerList getHandlers() {
		return handlers;
	}
}
