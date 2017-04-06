package com.duckelekuuk.cakewars.utils;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import org.json.simple.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

@Getter
public class ConfigHandler {

    @Ignore
    private JavaPlugin plugin;

    private @Getter Global global;
    private @Getter Prices prices;

    public ConfigHandler(JavaPlugin plugin) {
        this.plugin = plugin;

        this.global = new Global();
        this.prices = new Prices();

        // Testing purposes
        try {
            load();
            save();
        } catch(IllegalAccessException e){
            e.printStackTrace();
        }
    }

    @Getter
    private class Global {
        private String defaultWorld = "lobby";

    }

    @Getter
    private class Prices {

        @Getter
        private class items {

            private String wool = "10I";
            private String obsidian = "4";
        }

        @Getter
        private class teamUpgrades {

        }
    }


    public void save() throws IllegalAccessException {
        // Lets recursively save this class
        JSONObject obj = saveRecursive(this);
        new JSONLoader(this.plugin, "config.json").save(obj);
    }

    public JSONObject saveRecursive(Object object) throws IllegalAccessException {
        JSONObject JsonObject = new JSONObject();

        Field[] fields = object.getClass().getDeclaredFields();

        for(Field field : fields){
            // We don't want static fields
            if(Modifier.isStatic(field.getModifiers()))
                continue;

            // Make sure we only use fields that DO NOT contain the Ignore annotation
            if(field.isAnnotationPresent(Ignore.class))
                continue;

            field.setAccessible(true); // Because circumventing private modifier protection is that easy.

            // Grab the object
            Object clazz = field.get(object);

            // "this" is seen as a field, so lets exclude that too
            if(clazz == this)
                continue;

            // Is the clazz one of the primitive data types?
            if(!isWrapperType(clazz)){
                // If the field is not one of the primitive data types we want to recursively save it
                JsonObject.put(field.getName(), saveRecursive(clazz));
            } else {
                // If it IS a primitive type, we just want to save it and continue to the next one
                JsonObject.put(field.getName(), clazz);
            }
        }

        return JsonObject;
    }


    public void load() throws IllegalAccessException {
        JSONObject object = (JSONObject) new JSONLoader(this.plugin, "config.json").load();

        if (object == null) {
            return;
        }

        loadRecursive(object, this);
    }

    public void loadRecursive(JSONObject jsonObject, Object object) throws IllegalAccessException {
        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {
            // We don't want static fields
            if (Modifier.isStatic(field.getModifiers())) {
                continue;
            }

            // Make sure we only use fields that DO NOT contain the Ignore annotation
            if (field.isAnnotationPresent(Ignore.class)) {
                continue;
            }

            // Check if the name of the field is in the object
            if (!jsonObject.containsKey(field.getName())) {
                continue;
            }

            // Grab the object from the JsonObject
            Object targetObject = jsonObject.get(field.getName());

            field.setAccessible(true); // Because circumventing private modifier protection is that easy.

            // Grab the object
            Object clazz = field.get(object);

            // "this" is seen as a field, so lets exclude that too
            if (clazz == this) {
                continue;
            }

            // Is the clazz one of the primitive data types?
            if (!isWrapperType(clazz)) {
                loadRecursive((JSONObject) targetObject, clazz);
                continue;
            }

            // Check if the class found in the config has the same primitive object as the field
            if (clazz.getClass() != targetObject.getClass()) {
                continue;
            }

            // Set the field equal to the value in the config
            field.set(object, targetObject);
        }
    }


    /**
     * Everything below here is to check if the object is a primitive object or not
     * In this case I will see a String as a primitive object as well,
     * because, let's be honest, saving a String as a list of chars isn't a lot of fun.
     */

    private static final Set<Class<?>> WRAPPER_TYPES;

        static {
        WRAPPER_TYPES = new HashSet<Class<?>>() {
            {
                add(Boolean.class);
                add(Character.class);
                add(Byte.class);
                add(Short.class);
                add(Integer.class);
                add(Long.class);
                add(Float.class);
                add(Double.class);
                add(Void.class);
                add(String.class);
            }
        };
    }

    private static boolean isWrapperType(Object clazz) {
        return WRAPPER_TYPES.contains(clazz.getClass());
    }
}
