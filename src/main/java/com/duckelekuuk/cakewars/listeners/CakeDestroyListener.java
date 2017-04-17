package com.duckelekuuk.cakewars.listeners;

import com.duckelekuuk.cakewars.Cakewars;
import com.duckelekuuk.cakewars.events.CakeDestroyEvent;
import com.duckelekuuk.cakewars.utils.ColorHelper;
import com.duckelekuuk.cakewars.utils.InstantFirework;
import com.duckelekuuk.cakewars.utils.LocationHelper;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class CakeDestroyListener implements Listener {

    @Getter
    private Cakewars plugin;

    public CakeDestroyListener(Cakewars plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onCakeDestoy(CakeDestroyEvent event) {
        Bukkit.getServer().broadcastMessage(event.getDestroyer().getTeam().getPrefix() + event.getDestroyer().getPlayer().getName() + "§f destroyed the " + event.getTeam().getPrefix() + event.getTeam().getTeamName().toLowerCase() + "§f cake.");
        event.getBlock().setType(Material.AIR);

        new InstantFirework(FireworkEffect.builder()
                .with(FireworkEffect.Type.BALL)
                .withColor(ColorHelper.hexToColor(event.getTeam().getHexColor()))
                .build(), LocationHelper.getMiddleOfBlock(event.getBlock().getLocation()));

    }
}
