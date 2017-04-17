package com.duckelekuuk.cakewars.listeners;

import com.duckelekuuk.cakewars.Cakewars;
import lombok.Getter;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBurnEvent;

public class BlockBurnListener implements Listener {

    @Getter
    private Cakewars plugin;

    public BlockBurnListener(Cakewars plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBurn(BlockBurnEvent event) {
        if (plugin.getGameManager().getActiveMatch().isLoaded()) {
            event.setCancelled(true);
        }
    }
}
