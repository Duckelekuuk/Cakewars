package com.duckelekuuk.cakewars.utils;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.Arrays;

/**
 * @AUTHOR: Duckelekuuk
 * Copyright © 2016, Duco Lindner, All rights reserved.
 */

public class ItemStackBuilder {

    private ItemStack itemStack;
    private ItemMeta itemMeta;

    public ItemStackBuilder(Material item) {
        this.itemStack = new ItemStack(item);
        this.itemMeta = itemStack.getItemMeta();
    }

    public ItemStackBuilder(ItemStack itemStack) {
        this.itemStack = itemStack;
        this.itemMeta = itemStack.getItemMeta();
    }

    public ItemStackBuilder setDisplayName(String displayName) {
        itemMeta.setDisplayName(displayName);
        return this;
    }

    public ItemStackBuilder setLore(String... lore) {
        itemMeta.setLore(Arrays.asList(lore));
        return this;
    }

    public ItemStackBuilder setType(Material material) {
        itemStack.setType(material);
        return this;
    }

    public ItemStackBuilder addLore(String lore) {
        itemMeta.getLore().add(lore);
        return this;
    }

    public ItemStackBuilder clearLore() {
        itemMeta.getLore().clear();
        return this;
    }

    public ItemStackBuilder setAmount(int amount) {
        itemStack.setAmount(amount);
        return this;
    }

    public ItemStackBuilder setDurability(int durability) {
        itemStack.setDurability((short) durability);
        return this;
    }

    public ItemStackBuilder setEnchantment(Enchantment enchantment, int level) {
        itemStack.addUnsafeEnchantment(enchantment, level);
        return this;
    }

    public ItemStackBuilder removeEnchantments() {
        itemStack.getEnchantments().clear();
        return this;
    }

    public ItemStackBuilder setUnbreakable(boolean value) {
        itemMeta.spigot().setUnbreakable(value);
        return this;
    }

    public ItemStackBuilder addItemFlag(ItemFlag itemFlag) {
        itemMeta.getItemFlags().add(itemFlag);
        return this;
    }

    public ItemStackBuilder clearItemFlags() {
        itemMeta.getItemFlags().clear();
        return this;
    }

    public ItemStackBuilder setColor(Color color) {
        if (itemStack.getType().equals(Material.LEATHER_HELMET) || itemStack.getType().equals(Material.LEATHER_CHESTPLATE) || itemStack.getType().equals(Material.LEATHER_LEGGINGS) || itemStack.getType().equals(Material.LEATHER_BOOTS))
            ((LeatherArmorMeta) itemMeta).setColor(color);

        return this;
    }

    public ItemStack build() {
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}