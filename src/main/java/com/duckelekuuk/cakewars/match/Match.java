package com.duckelekuuk.cakewars.match;

import com.duckelekuuk.cakewars.Cakewars;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.util.FileUtil;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

@Getter
public class Match {

    private Cakewars cakewars;

    private String mapName;

    private MatchStatus matchStatus;
    private MapConfig mapConfig;

    private Set<Generator> generators;

    private boolean loaded;

    public Match(Cakewars cakewars) {
        this.cakewars = cakewars;
        this.matchStatus = MatchStatus.LOBBY;
        this.generators = new HashSet<>();
        this.loaded = true;
    }

    public void setupMap() {
        File mirror = new File(cakewars.getDataFolder().getAbsolutePath() + File.separatorChar + cakewars.getConfigHandler().getGlobal().getMapPath());
        this.mapName = mirror.getName();

        if (Bukkit.getServer().getWorld(mirror.getName()) != null) {
            return;
        }

        if (!mirror.exists()) {
            System.out.println("Mirror world not found. Shutting down....");
            Bukkit.getServer().shutdown();
            return;
        }

        cakewars.getLogger().info("Loading in world: " + mirror.getName());

        FileUtil.copy(mirror, Bukkit.getServer().getWorldContainer());
        Bukkit.getServer().createWorld(new WorldCreator(mirror.getName()).type(WorldType.CUSTOMIZED)).setAutoSave(false);
    }

    public void setupConfig() {
        this.mapConfig = new MapConfig(cakewars);
    }

    public void setupGenerators() {
        generators.add(new Generator(Generator.Type.EMERALD, mapConfig.getLocations().getEmeraldGenerator1(), 16, 30,true));
        generators.add(new Generator(Generator.Type.EMERALD, mapConfig.getLocations().getEmeraldGenerator2(), 16, 30,true));

        generators.add(new Generator(Generator.Type.DIAMOND, mapConfig.getLocations().getDiamondGenerator1(), 16, 20,true));
        generators.add(new Generator(Generator.Type.DIAMOND, mapConfig.getLocations().getDiamondGenerator2(), 16, 20,true));
        generators.add(new Generator(Generator.Type.DIAMOND, mapConfig.getLocations().getDiamondGenerator3(), 16, 20,true));
        generators.add(new Generator(Generator.Type.DIAMOND, mapConfig.getLocations().getDiamondGenerator4(), 16, 20,true));
    }

    public void upgradeGenerators(Generator.Type type, int spawnRate) {
        generators.stream().filter(generator -> generator.getType().equals(type)).forEach(generator -> generator.setSpawnRate(spawnRate));
    }

    public void startGenerators() {
        this.generators.forEach(generator -> generator.runTaskTimer(cakewars, 0, 20));
    }
}
