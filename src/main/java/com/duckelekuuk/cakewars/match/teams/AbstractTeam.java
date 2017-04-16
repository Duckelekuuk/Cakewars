package com.duckelekuuk.cakewars.match.teams;

import com.duckelekuuk.cakewars.match.GameManager;
import com.duckelekuuk.cakewars.match.GamePlayer;
import com.duckelekuuk.cakewars.match.Generator;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.scoreboard.Team;

import java.util.Set;
import java.util.stream.Collectors;

public abstract class AbstractTeam {

    private GameManager gameManager;

    public AbstractTeam(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public abstract String getTeamName();

    public abstract ChatColor getPrefix();

    public abstract String getHexColor();

    public GameManager getGameManager() {
        return gameManager;
    }

    public Set<GamePlayer> getMembers() {

        return getGameManager()
                .getGamePlayers()
                .stream()
                .filter(gamePlayer -> gamePlayer.getTeam() != null && gamePlayer.getTeam().getTeamName().equals(getTeamName()))
                .collect(Collectors.toSet());
    }

    public boolean isAlive() {
        return getEggLocation().getBlock().getType().equals(Material.CAKE);
    }

    public void setColoredNames() {
        Team team = Bukkit.getServer().getScoreboardManager().getMainScoreboard().getTeam(getTeamName());
        if (team == null) {
            Bukkit.getServer().broadcastMessage("Creating new Team!");

            team = Bukkit.getServer().getScoreboardManager().getMainScoreboard().registerNewTeam(getTeamName());

            team.setAllowFriendlyFire(false);
            team.setDisplayName(getTeamName());

            team.setPrefix(getPrefix() + "");

            team.setOption(Team.Option.COLLISION_RULE, Team.OptionStatus.NEVER);
            team.setOption(Team.Option.NAME_TAG_VISIBILITY, Team.OptionStatus.ALWAYS);
        }

        Team finalTeam = team;
        getMembers().forEach(gamePlayer -> {
            finalTeam.addEntry(gamePlayer.getPlayer().getName());
            gamePlayer.getPlayer().setPlayerListName(getPrefix() + "[" + getTeamName() + "] " + gamePlayer.getPlayer().getName());
        });
    }

    public abstract Location getSpawnLocation();
    public abstract Location getEggLocation();

    public abstract Generator getIronGenerator();
    public abstract Generator getGoldGenerator();
}
