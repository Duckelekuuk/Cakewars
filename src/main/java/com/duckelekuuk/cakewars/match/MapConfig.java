package com.duckelekuuk.cakewars.match;

import com.duckelekuuk.cakewars.Cakewars;
import com.duckelekuuk.cakewars.utils.JSONConfig;

public class MapConfig extends JSONConfig {

    public MapConfig(Cakewars plugin) {
        super(plugin, plugin.getConfigHandler().getGlobal().getMapConfigPath() + "config.json");
    }
}
