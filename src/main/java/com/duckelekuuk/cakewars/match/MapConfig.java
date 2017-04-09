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
    private @Getter Blue blue;
    private @Getter Green green;
    private @Getter Red red;
    private @Getter Yellow yellow;

    private @Getter EmeraldGenerators emeraldGenerators;
    private @Getter DiamondGenerators diamondGenerators;
    private @Getter Utils utils;



    public MapConfig(Cakewars plugin) {
        super(plugin, plugin.getConfigHandler().getGlobal().getMapConfigPath(),  plugin.getConfigHandler().getGlobal().getMapConfigFileName());

        this.global = new Global();
        this.blue = new Blue();
        this.green = new Green();
        this.red = new Red();
        this.yellow = new Yellow();
        this.emeraldGenerators = new EmeraldGenerators();
        this.diamondGenerators = new DiamondGenerators();
        this.utils = new Utils();

        initialize();
    }

    @Getter
    public class Global {
        private String mapName = "Example";
    }

    @Getter
    public class Blue {
        private Location spawn = new Location(Bukkit.getWorld("world"), 0, 0, 0);
        private Location egg = new Location(Bukkit.getWorld("world"), 0, 0, 0);
        private Location ironGenerator = new Location(Bukkit.getWorld("world"), 0, 0, 0);
        private Location goldGenerator = new Location(Bukkit.getWorld("world"), 0, 0, 0);
    }

    @Getter
    public class Green {
        private Location spawn = new Location(Bukkit.getWorld("world"), 0, 0, 0);
        private Location egg = new Location(Bukkit.getWorld("world"), 0, 0, 0);
        private Location ironGenerator = new Location(Bukkit.getWorld("world"), 0, 0, 0);
        private Location goldGenerator = new Location(Bukkit.getWorld("world"), 0, 0, 0);
    }

    @Getter
    public class Red {
        private Location spawn = new Location(Bukkit.getWorld("world"), 0, 0, 0);
        private Location egg = new Location(Bukkit.getWorld("world"), 0, 0, 0);
        private Location ironGenerator = new Location(Bukkit.getWorld("world"), 0, 0, 0);
        private Location goldGenerator = new Location(Bukkit.getWorld("world"), 0, 0, 0);
    }

    @Getter
    public class Yellow {
        private Location spawn = new Location(Bukkit.getWorld("world"), 0, 0, 0);
        private Location egg = new Location(Bukkit.getWorld("world"), 0, 0, 0);
        private Location ironGenerator = new Location(Bukkit.getWorld("world"), 0, 0, 0);
        private Location goldGenerator = new Location(Bukkit.getWorld("world"), 0, 0, 0);
    }

    @Getter
    public class EmeraldGenerators {
        private Location generator1 = new Location(Bukkit.getWorld("world"), 0, 0, 0);
        private Location gnerator2 = new Location(Bukkit.getWorld("world"), 0, 0, 0);
    }

    @Getter
    public class DiamondGenerators {

        private Location generator1 = new Location(Bukkit.getWorld("world"), 0, 0, 0);
        private Location generator2 = new Location(Bukkit.getWorld("world"), 0, 0, 0);
        private Location generator3 = new Location(Bukkit.getWorld("world"), 0, 0, 0);
        private Location generator4 = new Location(Bukkit.getWorld("world"), 0, 0, 0);
    }

    @Getter
    public class Utils {
        private Location lobbyLocation = new Location(Bukkit.getWorld("world"), 0, 0, 0);
        private Location spawnSpectator = new Location(Bukkit.getWorld("world"), 0, 0, 0);
    }
}
