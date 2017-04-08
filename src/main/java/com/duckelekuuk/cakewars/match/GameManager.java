package com.duckelekuuk.cakewars.match;

import com.duckelekuuk.cakewars.Cakewars;
import com.duckelekuuk.cakewars.match.teams.*;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public class GameManager {

    private @Getter Cakewars plugin;
    private @Getter Set<ITeam> teams;
    private @Getter Set<GamePlayer> gamePlayers;
    private @Getter Match activeMatch;

    public GameManager(Cakewars plugin) {
        this.plugin = plugin;
        this.activeMatch = new Match(plugin);
        this.gamePlayers = new HashSet<>();
    }

    public GamePlayer getGameplayer(CommandSender player, boolean createIfNull) {
        if(!(player instanceof Player)){
            return null;
        }

        for (GamePlayer gamePlayer : gamePlayers) {
            if (gamePlayer.getPlayer().getUniqueId() == ((Player) player).getUniqueId()) return gamePlayer;
        }

        if (createIfNull) {

            GamePlayer gamePlayer = new GamePlayer((Player) player);
            gamePlayers.add(gamePlayer);
            return gamePlayer;
        }

        return null;
    }

    public void assignTeam(GamePlayer gamePlayer, ITeam team) {
        gamePlayer.setTeam(team);
    }

    public ITeam getTeam(String team) {
        for (ITeam iTeam : getTeams()) {
            if (iTeam.getTeamName().equalsIgnoreCase(team)) return iTeam;
        }
        return null;
    }

    public void initialize() {
        this.teams = new HashSet<ITeam>() {{
            add(new BlueTeam(plugin.getGameManager()));
            add(new GreenTeam(plugin.getGameManager()));
            add(new RedTeam(plugin.getGameManager()));
            add(new YellowTeam(plugin.getGameManager()));
        }};

        if (plugin.getConfigHandler().getGlobal().isReadyToPlay()) {
            this.activeMatch.setupMap();
            this.activeMatch.setupConfig();
            this.activeMatch.setupGenerators();
        }
    }
}
