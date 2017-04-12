package com.duckelekuuk.cakewars.match;

import com.duckelekuuk.cakewars.match.teams.AbstractTeam;
import com.duckelekuuk.cakewars.utils.ColorHelper;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

@Getter
public class GamePlayer {

    private Player player;
    private @Setter AbstractTeam team;

    private @Setter boolean spectator;

    public GamePlayer(Player player){
        this.player = player;
    }

    public void makeSpectator() {

    }

    public void GiveInventory() {
        ItemStack itemStack = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta itemMeta = (LeatherArmorMeta) itemStack.getItemMeta();
        itemMeta.setColor(ColorHelper.getColorFromJcolor(ColorHelper.chatColorToJColor(team.getPrefix())));
    }
}
