package com.duckelekuuk.cakewars.listeners;

import com.duckelekuuk.cakewars.Cakewars;
import com.duckelekuuk.cakewars.match.GamePlayer;
import com.duckelekuuk.cakewars.match.MatchStatus;
import lombok.Getter;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener {

    @Getter
    private Cakewars plugin;

    public BlockPlaceListener(Cakewars plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        if (!plugin.getConfigHandler().getGlobal().isReadyToPlay()) {
            return;
        }

        if (!plugin.getGameManager().getActiveMatch().getMatchStatus().equals(MatchStatus.INGAME)) {
            event.setCancelled(true);
            return;
        }

        GamePlayer gamePlayer = plugin.getGameManager().getGameplayer(event.getPlayer(), false);

        if(gamePlayer == null) {
            event.setCancelled(true);
            return;
        }

        if (gamePlayer.isSpectator()) {
            event.setCancelled(true);
            return;
        }

        plugin.getGameManager().getActiveMatch().getBlocks().add(event.getBlockPlaced());
    }
}
