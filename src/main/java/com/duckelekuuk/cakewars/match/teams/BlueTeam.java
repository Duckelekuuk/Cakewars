package com.duckelekuuk.cakewars.match.teams;

import com.duckelekuuk.cakewars.match.GameManager;
import com.duckelekuuk.cakewars.match.Generator;
import org.bukkit.ChatColor;
import org.bukkit.Location;

public class BlueTeam extends AbstractTeam {
    private Generator ironGenerator;
    private Generator goldGenerator;

    public BlueTeam(GameManager gameManager) {
        super(gameManager);
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
    public Location getSpawnLocation() {
        return getGameManager().getActiveMatch().getMapConfig().getBlue().getSpawn();
    }

    @Override
    public Location getEggLocation() {
        return getGameManager().getActiveMatch().getMapConfig().getBlue().getEgg();
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
