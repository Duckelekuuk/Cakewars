package com.duckelekuuk.cakewars.match.teams;

import com.duckelekuuk.cakewars.match.GamePlayer;
import org.bukkit.ChatColor;

import java.util.Set;

public class RedTeam implements ITeam {

    private Set<GamePlayer> members;

    public RedTeam(Set<GamePlayer> members) {
        this.members = members;
    }

    @Override
    public String getTeamName() {
        return "RED";
    }

    @Override
    public ChatColor getPrefix() {
        return ChatColor.RED;
    }

    @Override
    public Set<GamePlayer> getMembers() {
        return members;
    }
}
