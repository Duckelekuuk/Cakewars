package com.duckelekuuk.cakewars.match.teams;

import com.duckelekuuk.cakewars.match.GameManager;
import com.duckelekuuk.cakewars.match.Generator;
import org.bukkit.ChatColor;
import org.bukkit.Location;

public class GreenTeam extends AbstractTeam {

    private Generator ironGenerator;
    private Generator goldGenerator;

    public GreenTeam(GameManager gameManager) {
        super(gameManager);
        this.ironGenerator = new Generator(Generator.Type.IRON, gameManager.getActiveMatch().getMapConfig().getGreen().getIronGenerator(), 16, 5, true);
        this.goldGenerator = new Generator(Generator.Type.GOLD, gameManager.getActiveMatch().getMapConfig().getGreen().getGoldGenerator(), 16, 5, true);
    }

    @Override
    public String getTeamName() {
        return "GREEN";
    }

    @Override
    public ChatColor getPrefix() {
        return ChatColor.GREEN;
    }

    @Override
    public String getHexColor() {
        return "#00FF00";
    }

    @Override
    public Location getSpawnLocation() {
        return getGameManager().getActiveMatch().getMapConfig().getGreen().getSpawn();
    }

    @Override
    public Location getEggLocation() {
        return getGameManager().getActiveMatch().getMapConfig().getGreen().getEgg();
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
