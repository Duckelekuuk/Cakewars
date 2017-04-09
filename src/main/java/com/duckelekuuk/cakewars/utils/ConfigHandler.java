package com.duckelekuuk.cakewars.utils;

import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;
import org.json.simple.JSONObject;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

public class ConfigHandler extends JSONConfig {

    private @Getter Global global;
    private @Getter Prices prices;

    public ConfigHandler(JavaPlugin plugin) {
        super(plugin, "","config.json");

        this.global = new Global();
        this.prices = new Prices();

        initialize();
    }

    @Getter
    public class Global {
        private boolean readyToPlay = false;
        private String mapPath = "game/map";
        private String mapConfigPath = "game";
        private String mapConfigFileName = "config.json";
        private int minimumPlayers = 4;
        private int teamSize = 3;

    }

    @Getter
    public class Prices {
        private boolean testbool = true;
    }
}
