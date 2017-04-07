package com.duckelekuuk.cakewars.match.teams;

import com.duckelekuuk.cakewars.match.GamePlayer;
import org.bukkit.ChatColor;

import java.util.HashSet;
import java.util.Set;

public class YellowTeam implements ITeam {

    private Set<GamePlayer> members;

    public YellowTeam() {
        this.members = new HashSet<>();
    }

    @Override
    public String getTeamName() {
        return "YELLOW";
    }

    @Override
    public ChatColor getPrefix() {
        return ChatColor.YELLOW;
    }

    @Override
    public Set<GamePlayer> getMembers() {
        return members;
    }
}
