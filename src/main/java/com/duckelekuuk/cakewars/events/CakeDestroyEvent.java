package com.duckelekuuk.cakewars.events;

import com.duckelekuuk.cakewars.match.GamePlayer;
import com.duckelekuuk.cakewars.match.Match;
import com.duckelekuuk.cakewars.match.teams.AbstractTeam;
import lombok.Getter;
import org.bukkit.block.Block;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Getter
public class CakeDestroyEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERLIST = new HandlerList();
    private boolean canceled = false;

    private Match match;
    private Block block;
    private AbstractTeam team;
    private GamePlayer destroyer;

    public CakeDestroyEvent(Match match, Block block, AbstractTeam team, GamePlayer destroyer) {
        this.match = match;
        this.block = block;
        this.team = team;
        this.destroyer = destroyer;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERLIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERLIST;
    }

    @Override
    public boolean isCancelled() {
        return canceled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.canceled = cancel;
    }
}
