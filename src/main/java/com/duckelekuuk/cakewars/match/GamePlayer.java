package com.duckelekuuk.cakewars.match;

import lombok.Getter;
import org.bukkit.entity.Player;

@Getter
public class GamePlayer {

    private Player player;

    private boolean spectator;

    public GamePlayer(Player player){
        this.player = player;
    }
}
