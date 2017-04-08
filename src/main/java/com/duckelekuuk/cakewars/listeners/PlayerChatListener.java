package com.duckelekuuk.cakewars.listeners;

import com.duckelekuuk.cakewars.Cakewars;
import com.duckelekuuk.cakewars.match.GamePlayer;
import lombok.Getter;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChatListener implements Listener {

    @Getter
    private Cakewars plugin;

    public PlayerChatListener(Cakewars plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        GamePlayer gamePlayer = plugin.getGameManager().getGameplayer(event.getPlayer(), false);
        switch (plugin.getGameManager().getActiveMatch().getMatchStatus()) {
            case INGAME:
            case END:
                if (gamePlayer.isSpectator()) {
                    event.setFormat("§7[SPECTATOR]" + " %1$s: §f%2$s");
                    event.getRecipients().clear();
                    plugin.getGameManager().getGamePlayers().stream().filter(GamePlayer::isSpectator).forEach(gamePlayer1 -> event.getRecipients().add(gamePlayer1.getPlayer()));
                    return;
                }

                event.setFormat(gamePlayer.getTeam().getPrefix() + "[" + gamePlayer.getTeam().getTeamName() + "]" + " %1$s: §f%2$s");
                event.getRecipients().clear();
                gamePlayer.getTeam().getMembers().forEach(member -> event.getRecipients().add(member.getPlayer()));
                break;

            default:
                event.setFormat("%1$s: %2$s");
                break;
        }
    }
}
