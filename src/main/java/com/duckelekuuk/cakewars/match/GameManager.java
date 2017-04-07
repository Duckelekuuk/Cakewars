package com.duckelekuuk.cakewars.match;

import com.duckelekuuk.cakewars.Cakewars;
import com.duckelekuuk.cakewars.match.teams.*;
import lombok.Getter;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public class GameManager {

    private @Getter Cakewars cakewars;
    private @Getter Set<ITeam> teams;
    private @Getter Match activeMatch;

    public GameManager(Cakewars cakewars) {
        this.cakewars = cakewars;
        this.teams = new HashSet<ITeam>() {{
            add(new BlueTeam());
            add(new GreenTeam());
            add(new RedTeam());
            add(new YellowTeam());
        }};
    }

    public GamePlayer getGamePlayer(CommandSender player) {
        if(!(player instanceof Player)){
            return null;
        }

        for(ITeam team : teams) {
            for (GamePlayer teamPlayer : team.getMembers()) {
                if (teamPlayer.equals(player)) return teamPlayer;
            }
        }

        return null;
    }

    public void assignTeam(GamePlayer player, ITeam team) {
        if (!teams.contains(team)) teams.add(team);

        for (ITeam iTeam : teams) {
            if (iTeam.getMembers().contains(player)) iTeam.getMembers().remove(player);
        }

        team.getMembers().add(player);
    }

    public ITeam getTeam(String teamName) {
        for (ITeam team : teams) {
            if (team.getTeamName().equalsIgnoreCase(teamName)) return team;
        }

        return null;
    }

    public ITeam getTeam(GamePlayer gamePlayer) {
        for (ITeam team : teams) {
            if (team.getMembers().contains(gamePlayer)) return team;
        }

        return null;
    }
}
