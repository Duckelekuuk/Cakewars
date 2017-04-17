package com.duckelekuuk.cakewars.listeners;

import com.duckelekuuk.cakewars.Cakewars;
import com.duckelekuuk.cakewars.events.CakeDestroyEvent;
import com.duckelekuuk.cakewars.match.GamePlayer;
import com.duckelekuuk.cakewars.match.MatchStatus;
import com.duckelekuuk.cakewars.match.teams.AbstractTeam;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {

    @Getter
    private Cakewars plugin;

    public BlockBreakListener(Cakewars plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
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

        if (event.getBlock().getType().equals(Material.CAKE_BLOCK)) {
            AbstractTeam cakeTeam = plugin.getGameManager().getTeamBelongsToEgg(event.getBlock().getLocation());

            if (cakeTeam == null) return;

            if (gamePlayer.getTeam().equals(cakeTeam)) {
                gamePlayer.getPlayer().sendMessage("§cYou can't destroy your own cake!");
                event.setCancelled(true);
                return;
            }

            Bukkit.getServer().getPluginManager().callEvent(
                    new CakeDestroyEvent(
                            plugin.getGameManager().getActiveMatch(),
                            event.getBlock(),
                            cakeTeam,
                            gamePlayer));
            return;
        }

        if (!plugin.getGameManager().getActiveMatch().getBlocks().contains(event.getBlock())) {
            event.setCancelled(true);
            return;
        }

        plugin.getGameManager().getActiveMatch().getBlocks().remove(event.getBlock());
    }
}
