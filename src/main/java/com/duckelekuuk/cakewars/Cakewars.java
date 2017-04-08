package com.duckelekuuk.cakewars;

import com.duckelekuuk.cakewars.commands.CommandManager;
import com.duckelekuuk.cakewars.listeners.PlayerJoinListener;
import com.duckelekuuk.cakewars.listeners.PlayerPreJoinListener;
import com.duckelekuuk.cakewars.match.GameManager;
import com.duckelekuuk.cakewars.menus.MenuManager;
import com.duckelekuuk.cakewars.utils.ConfigHandler;
import lombok.Getter;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Cakewars extends JavaPlugin {

    private @Getter ConfigHandler configHandler;
    private @Getter CommandManager commandHandler;
    private @Getter GameManager gameManager;
    private @Getter MenuManager menuManager;

    @Override
    public void onEnable() {
        this.configHandler = new ConfigHandler(this);
        this.commandHandler = new CommandManager(this);
        this.gameManager = new GameManager(this);
        this.menuManager = new MenuManager(this);

        registerListeners();
        this.gameManager.initialize();

        getServer().getOnlinePlayers().forEach(o -> gameManager.getGameplayer(o, true));
    }

    public void registerListeners() {
        PluginManager pluginManager = getServer().getPluginManager();

        pluginManager.registerEvents(new PlayerJoinListener(this), this);
        pluginManager.registerEvents(new PlayerPreJoinListener(this), this);
    }
}
