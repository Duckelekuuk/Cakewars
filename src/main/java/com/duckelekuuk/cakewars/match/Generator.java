package com.duckelekuuk.cakewars.match;

import com.duckelekuuk.cakewars.utils.HologramSpawner;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
public class Generator extends BukkitRunnable {

    private int ticks;
    private @Setter int spawnRate;

    private Type type;
    private Location location;
    private int maxItemsOnGround;
    private Set<UUID> itemsOnGround;

    private HologramSpawner hologramSpawner;

    public Generator(Type type, Location location, int maxItemsOnGround, int spawnRate, boolean withHologram) {
        this.type = type;
        this.location = new Location(location.getWorld(), location.getBlockX(), location.getY(), location.getBlockZ());
        this.location.add(location.getX() >= 0 ? 0.5 : -0.5, 0.0, location.getZ() >= 0 ? 0.5 : -0.5);
        this.maxItemsOnGround = maxItemsOnGround;
        this.itemsOnGround = new HashSet<>();

        this.ticks = 0;
        this.spawnRate = spawnRate;

        this.location.getChunk().load();
        if (withHologram)
            this.hologramSpawner = new HologramSpawner(type.name() + " will spawn in " + (spawnRate - ticks), this.location);
    }

    @Override
    public void run() {
        ticks++;
        hologramSpawner.setName(type.name() + " will spawn in " + (spawnRate - ticks));
        if (ticks < spawnRate) {
            return;
        }

        this.ticks = 0;

        if (itemsOnGround.size() >= maxItemsOnGround) {
            return;
        }

        itemsOnGround.add(location.getWorld().dropItemNaturally(location.clone().add(0, 1.0, 0), new ItemStack(type.getMaterial())).getUniqueId());
    }

    @Getter
    @AllArgsConstructor
    enum Type {

        EMERALD(Material.EMERALD),
        DIAMOND(Material.DIAMOND),
        IRON(Material.IRON_INGOT),
        GOLD(Material.GOLD_INGOT);

        private Material material;
    }
}
