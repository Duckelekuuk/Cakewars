package com.duckelekuuk.cakewars.utils;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;

public final class HologramSpawner {

    private ArmorStand armorStand;

    public HologramSpawner(String title, Location location) {
        location = location.add(0, 1, 0);
        this.armorStand = location.getWorld().spawn(location, ArmorStand.class);
        armorStand.setArms(false);
        armorStand.setBasePlate(false);
        armorStand.setAI(false);
        armorStand.setVisible(false);
        armorStand.setGravity(false);
        armorStand.setCustomName(title);
        armorStand.setCustomNameVisible(true);
    }

    public void setName(String name) {
        armorStand.setCustomName(name);
    }
}
