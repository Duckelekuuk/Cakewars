package com.duckelekuuk.cakewars.events;

import com.duckelekuuk.cakewars.match.Match;
import com.duckelekuuk.cakewars.match.MatchStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Getter
@AllArgsConstructor
public class StatusChangeEvent extends Event {

    private static final HandlerList HANDLERLIST = new HandlerList();

    private Match match;
    private MatchStatus oldStatus;
    private MatchStatus newStatus;

    @Override
    public HandlerList getHandlers() {
        return HANDLERLIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERLIST;
    }
}
