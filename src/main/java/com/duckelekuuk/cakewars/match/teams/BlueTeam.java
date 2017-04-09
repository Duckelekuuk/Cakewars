package com.duckelekuuk.cakewars.match.teams;

import com.duckelekuuk.cakewars.match.GameManager;
import com.duckelekuuk.cakewars.match.GamePlayer;
import com.duckelekuuk.cakewars.match.Generator;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;

import java.util.Set;
import java.util.stream.Collectors;

public class BlueTeam implements ITeam {

    private GameManager gameManager;
    private Generator ironGenerator;
    private Generator goldGenerator;

    public BlueTeam(GameManager gameManager) {
        this.gameManager = gameManager;
        this.ironGenerator = new Generator(Generator.Type.IRON, gameManager.getActiveMatch().getMapConfig().getBlue().getIronGenerator(), 16, 5, true);
        this.goldGenerator = new Generator(Generator.Type.GOLD, gameManager.getActiveMatch().getMapConfig().getBlue().getIronGenerator(), 16, 5, true);
    }

    @Override
    public String getTeamName() {
        return "BLUE";
    }

    @Override
    public ChatColor getPrefix() {
        return ChatColor.BLUE;
    }

    @Override
    public GameManager getGameManager() {
        return gameManager;
    }

    @Override
    public Location getSpawnLocation() {
        return gameManager.getActiveMatch().getMapConfig().getBlue().getSpawn();
    }

    @Override
    public Location getEggLocation() {
        return gameManager.getActiveMatch().getMapConfig().getBlue().getEgg();
    }

    @Override
    public Generator getIronGenerator() {
        return ironGenerator;
    }

    @Override
    public Generator getGoldGenerator() {
        return goldGenerator;
    }
}
