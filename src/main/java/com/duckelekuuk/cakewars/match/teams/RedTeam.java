package com.duckelekuuk.cakewars.match.teams;

import com.duckelekuuk.cakewars.match.GameManager;
import com.duckelekuuk.cakewars.match.Generator;
import org.bukkit.ChatColor;
import org.bukkit.Location;

public class RedTeam implements ITeam {

    private GameManager gameManager;
    private Generator ironGenerator;
    private Generator goldGenerator;

    public RedTeam(GameManager gameManager) {
        this.gameManager = gameManager;
        this.ironGenerator = new Generator(Generator.Type.IRON, gameManager.getActiveMatch().getMapConfig().getRed().getIronGenerator(), 16, 5, true);
        this.goldGenerator = new Generator(Generator.Type.GOLD, gameManager.getActiveMatch().getMapConfig().getRed().getIronGenerator(), 16, 5, true);
    }

    @Override
    public String getTeamName() {
        return "RED";
    }

    @Override
    public ChatColor getPrefix() {
        return ChatColor.RED;
    }

    @Override
    public GameManager getGameManager() {
        return gameManager;
    }

    @Override
    public Location getSpawnLocation() {
        return gameManager.getActiveMatch().getMapConfig().getRed().getSpawn();
    }

    @Override
    public Location getEggLocation() {
        return gameManager.getActiveMatch().getMapConfig().getRed().getEgg();
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
