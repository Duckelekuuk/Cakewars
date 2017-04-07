package com.duckelekuuk.cakewars.match.teams;

import com.duckelekuuk.cakewars.match.GamePlayer;
import lombok.Getter;
import org.bukkit.ChatColor;

import java.util.HashSet;
import java.util.Set;

public class GreenTeam implements ITeam {

    private @Getter Set<GamePlayer> members;

    public GreenTeam() {
        this.members = new HashSet<>();
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
