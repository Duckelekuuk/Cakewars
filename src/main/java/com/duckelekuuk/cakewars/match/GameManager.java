package com.duckelekuuk.cakewars.match;

import com.duckelekuuk.cakewars.Cakewars;
import com.duckelekuuk.cakewars.match.teams.*;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;

import java.util.HashSet;
import java.util.Set;

public class GameManager {

    private @Getter Cakewars plugin;
    private @Getter Set<AbstractTeam> teams;
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

    public AbstractTeam getTeamBelongsToEgg(Location location) {
        if (getTeams().stream().noneMatch(abstractTeam -> abstractTeam.getEggLocation().equals(location))) {
            return null;
        }

        return getTeams().stream().filter(abstractTeam -> abstractTeam.getEggLocation().equals(location)).findFirst().get();
    }

    public void assignTeam(GamePlayer gamePlayer, AbstractTeam team) {
        gamePlayer.setTeam(team);
    }

    public AbstractTeam getTeam(String team) {
        for (AbstractTeam abstractTeam : getTeams()) {
            if (abstractTeam.getTeamName().equalsIgnoreCase(team)) return abstractTeam;
        }
        return null;
    }

    public void initialize() {

        if (plugin.getConfigHandler().getGlobal().isReadyToPlay()) {
            this.activeMatch.setupMap();
            this.activeMatch.setupConfig();
            this.activeMatch.setupGenerators();


            this.teams = new HashSet<AbstractTeam>() {{
                add(new BlueTeam(plugin.getGameManager()));
                add(new GreenTeam(plugin.getGameManager()));
                add(new RedTeam(plugin.getGameManager()));
                add(new YellowTeam(plugin.getGameManager()));
            }};
            Scoreboard mainScoreboard = plugin.getServer().getScoreboardManager().getMainScoreboard();
            teams.stream()
                    .filter(abstractTeam -> mainScoreboard.getTeam(abstractTeam.getTeamName()) != null)
                    .forEach(abstractTeam -> mainScoreboard.getTeam(abstractTeam.getTeamName()).unregister());
        }
    }
}
