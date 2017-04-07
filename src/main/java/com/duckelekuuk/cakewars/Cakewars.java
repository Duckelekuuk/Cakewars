package com.duckelekuuk.cakewars;

import com.duckelekuuk.cakewars.commands.CommandManager;
import com.duckelekuuk.cakewars.match.GameManager;
import com.duckelekuuk.cakewars.utils.ConfigHandler;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class Cakewars extends JavaPlugin {

    private @Getter ConfigHandler configHandler;
    private @Getter CommandManager commandHandler;
    private @Getter GameManager gameManager;

    @Override
    public void onEnable() {
        this.configHandler = new ConfigHandler(this);
        this.commandHandler = new CommandManager(this);
        this.gameManager = new GameManager(this);
        // Plugin startup logic

        System.out.println(getConfigHandler().getGlobal().getSpawnLocation());
    }
}
