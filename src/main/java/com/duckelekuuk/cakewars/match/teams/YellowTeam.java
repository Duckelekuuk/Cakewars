package com.duckelekuuk.cakewars.match.teams;

import com.duckelekuuk.cakewars.match.GameManager;
import com.duckelekuuk.cakewars.match.GamePlayer;
import com.duckelekuuk.cakewars.match.Generator;
import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.Location;

import java.util.Set;
import java.util.stream.Collectors;

public class YellowTeam implements ITeam {

    private GameManager gameManager;
    private Generator ironGenerator;
    private Generator goldGenerator;

    public YellowTeam(GameManager gameManager) {
        this.gameManager = gameManager;
        this.ironGenerator = new Generator(Generator.Type.IRON, gameManager.getActiveMatch().getMapConfig().getYellow().getIronGenerator(), 16, 5, true);
        this.goldGenerator = new Generator(Generator.Type.GOLD, gameManager.getActiveMatch().getMapConfig().getYellow().getIronGenerator(), 16, 5, true);
    }

    @Override
    public String getTeamName() {
        return "YELLOW";
    }

    @Override
    public ChatColor getPrefix() {
        return ChatColor.YELLOW;
    }

    @Override
    public GameManager getGameManager() {
        return gameManager;
    }

    @Override
    public Location getSpawnLocation() {
        return gameManager.getActiveMatch().getMapConfig().getYellow().getSpawn();
    }

    @Override
    public Location getEggLocation() {
        return gameManager.getActiveMatch().getMapConfig().getYellow().getEgg();
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
