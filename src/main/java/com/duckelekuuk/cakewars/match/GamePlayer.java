package com.duckelekuuk.cakewars.match;

import com.duckelekuuk.cakewars.match.teams.AbstractTeam;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;

@Getter
public class GamePlayer {

    private Player player;
    private @Setter AbstractTeam team;

    private @Setter boolean spectator;

    public GamePlayer(Player player){
        this.player = player;
    }

    public void makeSpectator() {

    }
}
