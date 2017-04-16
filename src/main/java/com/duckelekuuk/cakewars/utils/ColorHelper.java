package com.duckelekuuk.cakewars.utils;

import org.bukkit.Color;

public final class ColorHelper {

    private ColorHelper() {}

    public static Color hexToColor(String color) {
        java.awt.Color jColor = java.awt.Color.decode(color);
        return Color.fromRGB(jColor.getRed(), jColor.getGreen(), jColor.getBlue());
    }
}
