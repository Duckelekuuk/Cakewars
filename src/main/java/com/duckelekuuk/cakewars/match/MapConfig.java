package com.duckelekuuk.cakewars.match;

import com.duckelekuuk.cakewars.Cakewars;
import com.duckelekuuk.cakewars.utils.JSONConfig;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

public class MapConfig extends JSONConfig {

    private @Getter Global global;
    private @Getter Locations locations;


    public MapConfig(Cakewars plugin) {
        super(plugin, plugin.getConfigHandler().getGlobal().getMapConfigPath(),  plugin.getConfigHandler().getGlobal().getMapConfigFileName());

        this.global = new Global();
        this.locations = new Locations();

        initialize();
    }

    @Getter
    public class Global {
        private String mapName = "Example";
    }

    @Getter
    public class Locations {
        private Location lobbyLocation = new Location(Bukkit.getWorld("world"), 0, 0, 0);
        private Location spawnSpectator = new Location(Bukkit.getWorld("world"), 0, 0, 0);
        private Location spawnBlue = new Location(Bukkit.getWorld("world"), 0, 0, 0);
        private Location spawnGreen = new Location(Bukkit.getWorld("world"), 0, 0, 0);
        private Location spawnRed = new Location(Bukkit.getWorld("world"), 0, 0, 0);
        private Location spawnYellow = new Location(Bukkit.getWorld("world"), 0, 0, 0);

        private Location emeraldGenerator1 = new Location(Bukkit.getWorld("world"), 0, 0, 0);
        private Location emeraldGenerator2 = new Location(Bukkit.getWorld("world"), 0, 0, 0);

        private Location diamondGenerator1 = new Location(Bukkit.getWorld("world"), 0, 0, 0);
        private Location diamondGenerator2 = new Location(Bukkit.getWorld("world"), 0, 0, 0);
        private Location diamondGenerator3 = new Location(Bukkit.getWorld("world"), 0, 0, 0);
        private Location diamondGenerator4 = new Location(Bukkit.getWorld("world"), 0, 0, 0);
    }
}
