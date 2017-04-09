package com.duckelekuuk.cakewars.utils;

import org.bukkit.Location;

public class LocationHelper {

    private LocationHelper() {}

    public static Location getMiddleOfBlock(Location location) {
        return  location.clone().add(location.getX() >= 0 ? 0.5 : -0.5, 0.0, location.getZ() >= 0 ? 0.5 : -0.5);
    }
}
