package me.MathiasMC.PvPLevels.api.events;

import me.MathiasMC.PvPLevels.PvPLevels;
import me.MathiasMC.PvPLevels.data.PlayerConnect;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PlayerLostKillStreakEvent extends Event implements Cancellable {
	private static final HandlerList handlers = new HandlerList();

	private final PvPLevels plugin;
	private final Player player;
	private final PlayerConnect playerConnect;
	private boolean cancelled = false;
	private long killstreak;

	private List<String> commands = null;

	public PlayerLostKillStreakEvent(final Player player, final PlayerConnect playerConnect, final long killstreak) {
		this.plugin = PvPLevels.getInstance();
		this.player = player;
		this.playerConnect = playerConnect;
		this.killstreak = killstreak;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

	public Player getPlayer() {
		return this.player;
	}

	public PlayerConnect getPlayerConnect() {
		return this.playerConnect;
	}

	public long getKillstreak() {
		return this.killstreak;
	}

	public void setKillstreak(final long killstreak) {
		this.killstreak = killstreak;
	}

	public List<String> getCommands() {
		return this.commands;
	}

	public void setCommands(final List<String> commands) {
		this.commands = commands;
	}

	public List<String> getDefaultCommands() {
		final String path = "killstreak." + playerConnect.getGroup() + "." + killstreak + ".lost";
		if (plugin.getFileUtils().config.contains(path)) {
			return plugin.getFileUtils().config.getStringList(path);
		}
		return null;
	}

	public void execute() {
		plugin.getXPManager().sendCommands(player, commands);
		playerConnect.setKillstreak(0L);
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

