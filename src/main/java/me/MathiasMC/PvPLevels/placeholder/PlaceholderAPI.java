package me.MathiasMC.PvPLevels.placeholder;

import me.MathiasMC.PvPLevels.PvPLevels;
import me.MathiasMC.PvPLevels.data.PlayerConnect;
import me.MathiasMC.PvPLevels.utils.Utils;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PlaceholderAPI extends PlaceholderExpansion {

	private final PvPLevels plugin;

	public PlaceholderAPI(PvPLevels plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean persist() {
		return true;
	}

	@Override
	public boolean canRegister() {
		return true;
	}

	@Override
	public String getAuthor() {
		return plugin.getDescription().getAuthors().toString();
	}

	@Override
	public String getIdentifier() {
		return "pvplevels";
	}

	@Override
	public String getVersion() {
		return plugin.getDescription().getVersion();
	}

	@Override
	public String onPlaceholderRequest(Player player, @NotNull String identifier) {
		if (player == null) {
			return "";
		}
		final PlayerConnect playerConnect = plugin.getPlayerConnect(player.getUniqueId());
		return switch (identifier) {
			case "kills" -> String.valueOf(playerConnect.getKills());
			case "deaths" -> String.valueOf(playerConnect.getDeaths());
			case "xp" -> String.valueOf(playerConnect.getXp());
			case "level" -> String.valueOf(playerConnect.getLevel());
			case "level_next" -> String.valueOf(playerConnect.getLevel() + 1);
			case "killstreak" -> String.valueOf(playerConnect.getKillstreak());
			case "killstreak_top" -> String.valueOf(playerConnect.getKillstreakTop());
			case "kdr" -> plugin.getStatsManager().getKDR(playerConnect);
			case "kill_factor" -> plugin.getStatsManager().getKillFactor(playerConnect);
			case "xp_need" -> String.valueOf(plugin.getStatsManager().getXPNeeded(playerConnect));
			case "xp_required" -> String.valueOf(plugin.getStatsManager().getXPRequired(playerConnect, false));
			case "xp_required_next" -> String.valueOf(plugin.getStatsManager().getXPRequired(playerConnect, true));
			case "xp_progress" -> String.valueOf(plugin.getStatsManager().getXPProgress(playerConnect));
			case "xp_progress_style" ->
					String.valueOf(plugin.getStatsManager().getXPProgressStyle(playerConnect, "xp-progress-style"));
			case "xp_progress_style_2" ->
					String.valueOf(plugin.getStatsManager().getXPProgressStyle(playerConnect, "xp-progress-style-2"));
			case "time" ->
					String.valueOf(plugin.getStatsManager().getTime(System.currentTimeMillis() - playerConnect.getTime().getTime()));
			case "group" -> playerConnect.getGroup();
			case "level_group" -> plugin.getStatsManager().getGroup(playerConnect);
			case "level_prefix" -> plugin.getStatsManager().getPrefix(player, playerConnect);
			case "level_suffix" -> plugin.getStatsManager().getSuffix(player, playerConnect);
			case "xp_type" -> plugin.getStatsManager().getType(playerConnect);
			case "xp_get" -> plugin.getStatsManager().getGet(playerConnect);
			case "xp_lost" -> plugin.getStatsManager().getLost(playerConnect);
			case "xp_item" -> plugin.getStatsManager().getItem(playerConnect);
			case "multiplier" -> plugin.getStatsManager().getMultiplier(playerConnect);
			case "multiplier_time" -> plugin.getStatsManager().getMultiplierTime(playerConnect);
			case "multiplier_time_left" -> plugin.getStatsManager().getMultiplierTimeLeft(playerConnect);
			case "top_1_kills_name" -> plugin.getStatsManager().getTopKills(1, true);
			case "top_1_kills" -> plugin.getStatsManager().getTopKills(1, false);
			case "top_2_kills_name" -> plugin.getStatsManager().getTopKills(2, true);
			case "top_2_kills" -> plugin.getStatsManager().getTopKills(2, false);
			case "top_3_kills_name" -> plugin.getStatsManager().getTopKills(3, true);
			case "top_3_kills" -> plugin.getStatsManager().getTopKills(3, false);
			case "top_4_kills_name" -> plugin.getStatsManager().getTopKills(4, true);
			case "top_4_kills" -> plugin.getStatsManager().getTopKills(4, false);
			case "top_5_kills_name" -> plugin.getStatsManager().getTopKills(5, true);
			case "top_5_kills" -> plugin.getStatsManager().getTopKills(5, false);
			case "top_6_kills_name" -> plugin.getStatsManager().getTopKills(6, true);
			case "top_6_kills" -> plugin.getStatsManager().getTopKills(6, false);
			case "top_7_kills_name" -> plugin.getStatsManager().getTopKills(7, true);
			case "top_7_kills" -> plugin.getStatsManager().getTopKills(7, false);
			case "top_8_kills_name" -> plugin.getStatsManager().getTopKills(8, true);
			case "top_8_kills" -> plugin.getStatsManager().getTopKills(8, false);
			case "top_9_kills_name" -> plugin.getStatsManager().getTopKills(9, true);
			case "top_9_kills" -> plugin.getStatsManager().getTopKills(9, false);
			case "top_10_kills_name" -> plugin.getStatsManager().getTopKills(10, true);
			case "top_10_kills" -> plugin.getStatsManager().getTopKills(10, false);
			case "top_11_kills_name" -> plugin.getStatsManager().getTopKills(11, true);
			case "top_11_kills" -> plugin.getStatsManager().getTopKills(11, false);
			case "top_12_kills_name" -> plugin.getStatsManager().getTopKills(12, true);
			case "top_12_kills" -> plugin.getStatsManager().getTopKills(12, false);
			case "top_13_kills_name" -> plugin.getStatsManager().getTopKills(13, true);
			case "top_13_kills" -> plugin.getStatsManager().getTopKills(13, false);
			case "top_14_kills_name" -> plugin.getStatsManager().getTopKills(14, true);
			case "top_14_kills" -> plugin.getStatsManager().getTopKills(14, false);
			case "top_15_kills_name" -> plugin.getStatsManager().getTopKills(15, true);
			case "top_15_kills" -> plugin.getStatsManager().getTopKills(15, false);
			case "top_1_deaths_name" -> plugin.getStatsManager().getTopDeaths(1, true);
			case "top_1_deaths" -> plugin.getStatsManager().getTopDeaths(1, false);
			case "top_2_deaths_name" -> plugin.getStatsManager().getTopDeaths(2, true);
			case "top_2_deaths" -> plugin.getStatsManager().getTopDeaths(2, false);
			case "top_3_deaths_name" -> plugin.getStatsManager().getTopDeaths(3, true);
			case "top_3_deaths" -> plugin.getStatsManager().getTopDeaths(3, false);
			case "top_4_deaths_name" -> plugin.getStatsManager().getTopDeaths(4, true);
			case "top_4_deaths" -> plugin.getStatsManager().getTopDeaths(4, false);
			case "top_5_deaths_name" -> plugin.getStatsManager().getTopDeaths(5, true);
			case "top_5_deaths" -> plugin.getStatsManager().getTopDeaths(5, false);
			case "top_6_deaths_name" -> plugin.getStatsManager().getTopDeaths(6, true);
			case "top_6_deaths" -> plugin.getStatsManager().getTopDeaths(6, false);
			case "top_7_deaths_name" -> plugin.getStatsManager().getTopDeaths(7, true);
			case "top_7_deaths" -> plugin.getStatsManager().getTopDeaths(7, false);
			case "top_8_deaths_name" -> plugin.getStatsManager().getTopDeaths(8, true);
			case "top_8_deaths" -> plugin.getStatsManager().getTopDeaths(8, false);
			case "top_9_deaths_name" -> plugin.getStatsManager().getTopDeaths(9, true);
			case "top_9_deaths" -> plugin.getStatsManager().getTopDeaths(9, false);
			case "top_10_deaths_name" -> plugin.getStatsManager().getTopDeaths(10, true);
			case "top_10_deaths" -> plugin.getStatsManager().getTopDeaths(10, false);
			case "top_11_deaths_name" -> plugin.getStatsManager().getTopDeaths(11, true);
			case "top_11_deaths" -> plugin.getStatsManager().getTopDeaths(11, false);
			case "top_12_deaths_name" -> plugin.getStatsManager().getTopDeaths(12, true);
			case "top_12_deaths" -> plugin.getStatsManager().getTopDeaths(12, false);
			case "top_13_deaths_name" -> plugin.getStatsManager().getTopDeaths(13, true);
			case "top_13_deaths" -> plugin.getStatsManager().getTopDeaths(13, false);
			case "top_14_deaths_name" -> plugin.getStatsManager().getTopDeaths(14, true);
			case "top_14_deaths" -> plugin.getStatsManager().getTopDeaths(14, false);
			case "top_15_deaths_name" -> plugin.getStatsManager().getTopDeaths(15, true);
			case "top_15_deaths" -> plugin.getStatsManager().getTopDeaths(15, false);
			case "top_1_xp_name" -> plugin.getStatsManager().getTopXp(1, true);
			case "top_1_xp" -> plugin.getStatsManager().getTopXp(1, false);
			case "top_2_xp_name" -> plugin.getStatsManager().getTopXp(2, true);
			case "top_2_xp" -> plugin.getStatsManager().getTopXp(2, false);
			case "top_3_xp_name" -> plugin.getStatsManager().getTopXp(3, true);
			case "top_3_xp" -> plugin.getStatsManager().getTopXp(3, false);
			case "top_4_xp_name" -> plugin.getStatsManager().getTopXp(4, true);
			case "top_4_xp" -> plugin.getStatsManager().getTopXp(4, false);
			case "top_5_xp_name" -> plugin.getStatsManager().getTopXp(5, true);
			case "top_5_xp" -> plugin.getStatsManager().getTopXp(5, false);
			case "top_6_xp_name" -> plugin.getStatsManager().getTopXp(6, true);
			case "top_6_xp" -> plugin.getStatsManager().getTopXp(6, false);
			case "top_7_xp_name" -> plugin.getStatsManager().getTopXp(7, true);
			case "top_7_xp" -> plugin.getStatsManager().getTopXp(7, false);
			case "top_8_xp_name" -> plugin.getStatsManager().getTopXp(8, true);
			case "top_8_xp" -> plugin.getStatsManager().getTopXp(8, false);
			case "top_9_xp_name" -> plugin.getStatsManager().getTopXp(9, true);
			case "top_9_xp" -> plugin.getStatsManager().getTopXp(9, false);
			case "top_10_xp_name" -> plugin.getStatsManager().getTopXp(10, true);
			case "top_10_xp" -> plugin.getStatsManager().getTopXp(10, false);
			case "top_11_xp_name" -> plugin.getStatsManager().getTopXp(11, true);
			case "top_11_xp" -> plugin.getStatsManager().getTopXp(11, false);
			case "top_12_xp_name" -> plugin.getStatsManager().getTopXp(12, true);
			case "top_12_xp" -> plugin.getStatsManager().getTopXp(12, false);
			case "top_13_xp_name" -> plugin.getStatsManager().getTopXp(13, true);
			case "top_13_xp" -> plugin.getStatsManager().getTopXp(13, false);
			case "top_14_xp_name" -> plugin.getStatsManager().getTopXp(14, true);
			case "top_14_xp" -> plugin.getStatsManager().getTopXp(14, false);
			case "top_15_xp_name" -> plugin.getStatsManager().getTopXp(15, true);
			case "top_15_xp" -> plugin.getStatsManager().getTopXp(15, false);
			case "top_1_level_name" -> plugin.getStatsManager().getTopLevel(1, true);
			case "top_1_level" -> plugin.getStatsManager().getTopLevel(1, false);
			case "top_2_level_name" -> plugin.getStatsManager().getTopLevel(2, true);
			case "top_2_level" -> plugin.getStatsManager().getTopLevel(2, false);
			case "top_3_level_name" -> plugin.getStatsManager().getTopLevel(3, true);
			case "top_3_level" -> plugin.getStatsManager().getTopLevel(3, false);
			case "top_4_level_name" -> plugin.getStatsManager().getTopLevel(4, true);
			case "top_4_level" -> plugin.getStatsManager().getTopLevel(4, false);
			case "top_5_level_name" -> plugin.getStatsManager().getTopLevel(5, true);
			case "top_5_level" -> plugin.getStatsManager().getTopLevel(5, false);
			case "top_6_level_name" -> plugin.getStatsManager().getTopLevel(6, true);
			case "top_6_level" -> plugin.getStatsManager().getTopLevel(6, false);
			case "top_7_level_name" -> plugin.getStatsManager().getTopLevel(7, true);
			case "top_7_level" -> plugin.getStatsManager().getTopLevel(7, false);
			case "top_8_level_name" -> plugin.getStatsManager().getTopLevel(8, true);
			case "top_8_level" -> plugin.getStatsManager().getTopLevel(8, false);
			case "top_9_level_name" -> plugin.getStatsManager().getTopLevel(9, true);
			case "top_9_level" -> plugin.getStatsManager().getTopLevel(9, false);
			case "top_10_level_name" -> plugin.getStatsManager().getTopLevel(10, true);
			case "top_10_level" -> plugin.getStatsManager().getTopLevel(10, false);
			case "top_11_level_name" -> plugin.getStatsManager().getTopLevel(11, true);
			case "top_11_level" -> plugin.getStatsManager().getTopLevel(11, false);
			case "top_12_level_name" -> plugin.getStatsManager().getTopLevel(12, true);
			case "top_12_level" -> plugin.getStatsManager().getTopLevel(12, false);
			case "top_13_level_name" -> plugin.getStatsManager().getTopLevel(13, true);
			case "top_13_level" -> plugin.getStatsManager().getTopLevel(13, false);
			case "top_14_level_name" -> plugin.getStatsManager().getTopLevel(14, true);
			case "top_14_level" -> plugin.getStatsManager().getTopLevel(14, false);
			case "top_15_level_name" -> plugin.getStatsManager().getTopLevel(15, true);
			case "top_15_level" -> plugin.getStatsManager().getTopLevel(15, false);
			case "top_1_killstreak_name" -> plugin.getStatsManager().getTopKillStreak(1, true);
			case "top_1_killstreak" -> plugin.getStatsManager().getTopKillStreak(1, false);
			case "top_2_killstreak_name" -> plugin.getStatsManager().getTopKillStreak(2, true);
			case "top_2_killstreak" -> plugin.getStatsManager().getTopKillStreak(2, false);
			case "top_3_killstreak_name" -> plugin.getStatsManager().getTopKillStreak(3, true);
			case "top_3_killstreak" -> plugin.getStatsManager().getTopKillStreak(3, false);
			case "top_4_killstreak_name" -> plugin.getStatsManager().getTopKillStreak(4, true);
			case "top_4_killstreak" -> plugin.getStatsManager().getTopKillStreak(4, false);
			case "top_5_killstreak_name" -> plugin.getStatsManager().getTopKillStreak(5, true);
			case "top_5_killstreak" -> plugin.getStatsManager().getTopKillStreak(5, false);
			case "top_6_killstreak_name" -> plugin.getStatsManager().getTopKillStreak(6, true);
			case "top_6_killstreak" -> plugin.getStatsManager().getTopKillStreak(6, false);
			case "top_7_killstreak_name" -> plugin.getStatsManager().getTopKillStreak(7, true);
			case "top_7_killstreak" -> plugin.getStatsManager().getTopKillStreak(7, false);
			case "top_8_killstreak_name" -> plugin.getStatsManager().getTopKillStreak(8, true);
			case "top_8_killstreak" -> plugin.getStatsManager().getTopKillStreak(8, false);
			case "top_9_killstreak_name" -> plugin.getStatsManager().getTopKillStreak(9, true);
			case "top_9_killstreak" -> plugin.getStatsManager().getTopKillStreak(9, false);
			case "top_10_killstreak_name" -> plugin.getStatsManager().getTopKillStreak(10, true);
			case "top_10_killstreak" -> plugin.getStatsManager().getTopKillStreak(10, false);
			case "top_11_killstreak_name" -> plugin.getStatsManager().getTopKillStreak(11, true);
			case "top_11_killstreak" -> plugin.getStatsManager().getTopKillStreak(11, false);
			case "top_12_killstreak_name" -> plugin.getStatsManager().getTopKillStreak(12, true);
			case "top_12_killstreak" -> plugin.getStatsManager().getTopKillStreak(12, false);
			case "top_13_killstreak_name" -> plugin.getStatsManager().getTopKillStreak(13, true);
			case "top_13_killstreak" -> plugin.getStatsManager().getTopKillStreak(13, false);
			case "top_14_killstreak_name" -> plugin.getStatsManager().getTopKillStreak(14, true);
			case "top_14_killstreak" -> plugin.getStatsManager().getTopKillStreak(14, false);
			case "top_15_killstreak_name" -> plugin.getStatsManager().getTopKillStreak(15, true);
			case "top_15_killstreak" -> plugin.getStatsManager().getTopKillStreak(15, false);
			case "top_1_killstreak_top_name" -> plugin.getStatsManager().getTopKillStreakTop(1, true);
			case "top_1_killstreak_top" -> plugin.getStatsManager().getTopKillStreakTop(1, false);
			case "top_2_killstreak_top_name" -> plugin.getStatsManager().getTopKillStreakTop(2, true);
			case "top_2_killstreak_top" -> plugin.getStatsManager().getTopKillStreakTop(2, false);
			case "top_3_killstreak_top_name" -> plugin.getStatsManager().getTopKillStreakTop(3, true);
			case "top_3_killstreak_top" -> plugin.getStatsManager().getTopKillStreakTop(3, false);
			case "top_4_killstreak_top_name" -> plugin.getStatsManager().getTopKillStreakTop(4, true);
			case "top_4_killstreak_top" -> plugin.getStatsManager().getTopKillStreakTop(4, false);
			case "top_5_killstreak_top_name" -> plugin.getStatsManager().getTopKillStreakTop(5, true);
			case "top_5_killstreak_top" -> plugin.getStatsManager().getTopKillStreakTop(5, false);
			case "top_6_killstreak_top_name" -> plugin.getStatsManager().getTopKillStreakTop(6, true);
			case "top_6_killstreak_top" -> plugin.getStatsManager().getTopKillStreakTop(6, false);
			case "top_7_killstreak_top_name" -> plugin.getStatsManager().getTopKillStreakTop(7, true);
			case "top_7_killstreak_top" -> plugin.getStatsManager().getTopKillStreakTop(7, false);
			case "top_8_killstreak_top_name" -> plugin.getStatsManager().getTopKillStreakTop(8, true);
			case "top_8_killstreak_top" -> plugin.getStatsManager().getTopKillStreakTop(8, false);
			case "top_9_killstreak_top_name" -> plugin.getStatsManager().getTopKillStreakTop(9, true);
			case "top_9_killstreak_top" -> plugin.getStatsManager().getTopKillStreakTop(9, false);
			case "top_10_killstreak_top_name" -> plugin.getStatsManager().getTopKillStreakTop(10, true);
			case "top_10_killstreak_top" -> plugin.getStatsManager().getTopKillStreakTop(10, false);
			case "top_11_killstreak_top_name" -> plugin.getStatsManager().getTopKillStreakTop(11, true);
			case "top_11_killstreak_top" -> plugin.getStatsManager().getTopKillStreakTop(11, false);
			case "top_12_killstreak_top_name" -> plugin.getStatsManager().getTopKillStreakTop(12, true);
			case "top_12_killstreak_top" -> plugin.getStatsManager().getTopKillStreakTop(12, false);
			case "top_13_killstreak_top_name" -> plugin.getStatsManager().getTopKillStreakTop(13, true);
			case "top_13_killstreak_top" -> plugin.getStatsManager().getTopKillStreakTop(13, false);
			case "top_14_killstreak_top_name" -> plugin.getStatsManager().getTopKillStreakTop(14, true);
			case "top_14_killstreak_top" -> plugin.getStatsManager().getTopKillStreakTop(14, false);
			case "top_15_killstreak_top_name" -> plugin.getStatsManager().getTopKillStreakTop(15, true);
			case "top_15_killstreak_top" -> plugin.getStatsManager().getTopKillStreakTop(15, false);
			case "helmet_remaining_durability" ->
					String.valueOf(Utils.getDurability(player.getInventory().getHelmet())[0]);
			case "helmet_max_durability" -> String.valueOf(Utils.getDurability(player.getInventory().getHelmet())[1]);
			case "chestplate_remaining_durability" ->
					String.valueOf(Utils.getDurability(player.getInventory().getChestplate())[0]);
			case "chestplate_max_durability" ->
					String.valueOf(Utils.getDurability(player.getInventory().getChestplate())[1]);
			case "leggings_remaining_durability" ->
					String.valueOf(Utils.getDurability(player.getInventory().getLeggings())[0]);
			case "leggings_max_durability" ->
					String.valueOf(Utils.getDurability(player.getInventory().getLeggings())[1]);
			case "boots_remaining_durability" ->
					String.valueOf(Utils.getDurability(player.getInventory().getBoots())[0]);
			case "boots_max_durability" -> String.valueOf(Utils.getDurability(player.getInventory().getBoots())[1]);
			case "item_in_mainhand_remaining_durability" ->
					String.valueOf(Utils.getDurability(Utils.getHandItemStack(player, true))[0]);
			case "item_in_mainhand_max_durability" ->
					String.valueOf(Utils.getDurability(Utils.getHandItemStack(player, true))[1]);
			case "item_in_offhand_remaining_durability" ->
					String.valueOf(Utils.getDurability(Utils.getHandItemStack(player, false))[0]);
			case "item_in_offhand_max_durability" ->
					String.valueOf(Utils.getDurability(Utils.getHandItemStack(player, false))[1]);
			default -> null;
		};
	}
}