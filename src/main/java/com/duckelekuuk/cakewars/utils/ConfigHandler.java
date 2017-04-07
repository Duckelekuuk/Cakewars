package com.duckelekuuk.cakewars.utils;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import org.json.simple.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

public class ConfigHandler extends JSONConfig {

    private @Getter Global global;
    private @Getter Prices prices;

    public ConfigHandler(JavaPlugin plugin) {
        super(plugin);

        this.global = new Global();
        this.prices = new Prices();

        initialize();
    }

    @Getter
    private class Global {
        private String defaultWorld = "lobby";

    }

    @Getter
    private class Prices {
        private boolean testbool = true;
    }
}
