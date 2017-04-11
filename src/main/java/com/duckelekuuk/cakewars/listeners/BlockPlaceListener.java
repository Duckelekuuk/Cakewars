package com.duckelekuuk.cakewars.listeners;

import com.duckelekuuk.cakewars.Cakewars;
import com.duckelekuuk.cakewars.match.teams.AbstractTeam;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockPlaceListener implements Listener {

    private Cakewars cakewars;

    public BlockPlaceListener(Cakewars cakewars) {
        this.cakewars = cakewars;
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if (event.getBlock().getType().equals(Material.CAKE)) {
            AbstractTeam cakeTeam = cakewars.getGameManager().getTeamBelongsToEgg(event.getBlock().getLocation());

            event.getBlock().setType(Material.AIR);

            event.setCancelled(true);
        }
    }
}
