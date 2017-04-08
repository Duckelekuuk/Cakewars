package com.duckelekuuk.cakewars.match.teams;

import com.duckelekuuk.cakewars.match.GameManager;
import com.duckelekuuk.cakewars.match.GamePlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scoreboard.Team;

import java.util.Set;
import java.util.stream.Collectors;

public interface ITeam {

    String getTeamName();

    ChatColor getPrefix();

    GameManager getGameManager();

    default Set<GamePlayer> getMembers() {

        return getGameManager()
                .getGamePlayers()
                .stream()
                .filter(gamePlayer -> gamePlayer.getTeam().getTeamName().equals(getTeamName()))
                .collect(Collectors.toSet());
    }

    default void setColoredNames() {
        Team team = Bukkit.getServer().getScoreboardManager().getMainScoreboard().getTeam(getTeamName());
        if (team ==null) {
            team = Bukkit.getServer().getScoreboardManager().getMainScoreboard().registerNewTeam(getTeamName());
            team.setPrefix(getPrefix() + "[" + getTeamName() + "]");
            team.setAllowFriendlyFire(false);
            team.setDisplayName(getTeamName());

        }
        Team finalTeam = team;
        getMembers().forEach(gamePlayer -> {
            finalTeam.addEntry(gamePlayer.getPlayer().getUniqueId().toString());
            gamePlayer.getPlayer().setPlayerListName(getPrefix() + "[" + getTeamName() + "] " + gamePlayer.getPlayer().getName());
        });

    }
}
