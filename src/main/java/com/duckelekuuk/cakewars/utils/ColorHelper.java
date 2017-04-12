package com.duckelekuuk.cakewars.utils;

import org.bukkit.*;

import java.awt.*;
import java.awt.Color;

public final class ColorHelper {

    private ColorHelper() {}

    public static String colorToHex(Color color) {
        return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
    }

    public static Color chatColorToJColor(ChatColor chatColor) {
        return Color.getColor(chatColor.name());
    }

    public static String chatColorToHex(ChatColor chatColor) {
        return colorToHex(chatColorToJColor(chatColor));
    }

    public static org.bukkit.Color getColorFromJcolor(Color color) {
        return org.bukkit.Color.fromRGB(color.getRGB());
    }
}
