package com.duckelekuuk.cakewars.listeners;

import com.duckelekuuk.cakewars.Cakewars;
import lombok.Getter;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class PlayerPickupItemListener implements Listener {

    @Getter
    private Cakewars plugin;

    public PlayerPickupItemListener(Cakewars plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerPickupItem(PlayerPickupItemEvent event) {
        plugin.getGameManager().getActiveMatch().getGenerators()
                .stream()
                .filter(generator -> generator.getItemsOnGround().contains(event.getItem().getUniqueId()))
                .forEach(generator -> generator.getItemsOnGround().clear());
    }
}
