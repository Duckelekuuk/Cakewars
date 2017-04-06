package com.duckelekuuk.cakewars.match.teams;

import com.duckelekuuk.cakewars.match.GamePlayer;
import org.bukkit.ChatColor;

import java.util.Set;

public class GreenTeam implements ITeam {

    private Set<GamePlayer> members;

    public GreenTeam(Set<GamePlayer> members) {
        this.members = members;
    }

    @Override
    public String getTeamName() {
        return "GREEN";
    }

    @Override
    public ChatColor getPrefix() {
        return ChatColor.GREEN;
    }

    @Override
    public Set<GamePlayer> getMembers() {
        return members;
    }
}
