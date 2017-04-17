package com.duckelekuuk.cakewars.utils;

import org.bukkit.Location;

public class LocationHelper {

    private LocationHelper() {}

    public static Location getMiddleOfBlock(Location location) {
        return location.getBlock().getLocation().clone().add(0.5D, 0D,0.5D).setDirection(location.getDirection());
    }
}
