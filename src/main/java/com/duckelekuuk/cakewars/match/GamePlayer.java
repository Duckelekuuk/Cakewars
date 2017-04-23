package com.duckelekuuk.cakewars.match;

import com.duckelekuuk.cakewars.Cakewars;
import com.duckelekuuk.cakewars.match.teams.AbstractTeam;
import com.duckelekuuk.cakewars.utils.ColorHelper;
import com.duckelekuuk.cakewars.utils.ItemStackBuilder;
import com.duckelekuuk.cakewars.utils.LocationHelper;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.DyeColor;
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
        getPlayer().teleport(LocationHelper.getMiddleOfBlock(team.getGameManager().getActiveMatch().getMapConfig().getUtils().getSpawnSpectator()));
    }

    public void giveInventory() {
        player.getInventory().setItem(0, new ItemStack(Material.WOOD_PICKAXE));

        player.getInventory().setHelmet(new ItemStackBuilder(Material.LEATHER_HELMET).setColor(ColorHelper.hexToColor(getTeam().getHexColor())).setUnbreakable(true).build());
        player.getInventory().setChestplate(new ItemStackBuilder(Material.LEATHER_CHESTPLATE).setColor(ColorHelper.hexToColor(getTeam().getHexColor())).setUnbreakable(true).build());
        player.getInventory().setLeggings(new ItemStackBuilder(Material.LEATHER_LEGGINGS).setColor(ColorHelper.hexToColor(getTeam().getHexColor())).setUnbreakable(true).build());
        player.getInventory().setBoots(new ItemStackBuilder(Material.LEATHER_BOOTS).setColor(ColorHelper.hexToColor(getTeam().getHexColor())).setUnbreakable(true).build());

        player.getInventory().addItem((new ItemStackBuilder(Material.WOOL)).setDurability(DyeColor.valueOf(team.getTeamName()).getData()).setUnbreakable(true).build());
    }
}
