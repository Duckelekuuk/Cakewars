package com.duckelekuuk.cakewars.match.teams;

import com.duckelekuuk.cakewars.match.GamePlayer;
import org.bukkit.ChatColor;

import java.util.Set;

public interface ITeam {

    String getTeamName();

    ChatColor getPrefix();

    Set<GamePlayer> getMembers();
}
