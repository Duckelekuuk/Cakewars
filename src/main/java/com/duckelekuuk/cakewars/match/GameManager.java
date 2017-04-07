package com.duckelekuuk.cakewars.match;

import com.duckelekuuk.cakewars.Cakewars;
import com.duckelekuuk.cakewars.match.teams.ITeam;
import lombok.Getter;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public class GameManager {

    private @Getter Cakewars cakewars;
    private @Getter Set<ITeam> teams;

    public GameManager(Cakewars cakewars) {
        this.cakewars = cakewars;
        this.teams = new HashSet<>();
    }

    public GamePlayer getGameplayer(CommandSender player) {
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
}
