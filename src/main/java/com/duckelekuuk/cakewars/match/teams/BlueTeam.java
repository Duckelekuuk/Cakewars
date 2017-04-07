package com.duckelekuuk.cakewars.match.teams;

import com.duckelekuuk.cakewars.match.GamePlayer;
import org.bukkit.ChatColor;

import java.util.Set;

public class BlueTeam implements ITeam {

    private Set<GamePlayer> members;

    public BlueTeam(Set<GamePlayer> members) {
        this.members = members;
    }

    @Override
    public String getTeamName() {
        return "BLUE";
    }

    @Override
    public ChatColor getPrefix() {
        return ChatColor.BLUE;
    }

    @Override
    public Set<GamePlayer> getMembers() {
        return members;
    }
}
