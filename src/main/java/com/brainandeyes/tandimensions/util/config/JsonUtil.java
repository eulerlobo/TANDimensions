package com.brainandeyes.tandimensions.util.config;

import com.brainandeyes.tandimensions.core.TANDimensions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.lang.reflect.Type;

public class JsonUtil {
    public static final Gson SERIALIZER = new GsonBuilder().setPrettyPrinting().create();
    public static final String ENCODING_UTF_8 = "UTF-8";

    public static <T> T getOrCreateConfigFile(File configDir, String configName, T defaults, Type type) {
        File configFile = new File(configDir, configName);

        //If no config file, create one with default values
        if (!configFile.exists()) {
            writeFile(configFile, defaults);
        }

        try {
            return (T) SERIALIZER.fromJson(FileUtils.readFileToString(configFile, ENCODING_UTF_8), type);
        } catch (Exception e) {
            TANDimensions.logger.error("Error parsing config from json: " + configFile.toString(), e);
        }

        return null;
    }

    protected static boolean writeFile(File outputFile, Object obj) {
        try {
            FileUtils.write(outputFile, SERIALIZER.toJson(obj), ENCODING_UTF_8);

            return true;
        } catch (Exception e) {
            TANDimensions.logger.error("Error writing config file " + outputFile.getAbsolutePath() + ": " + e.getMessage());

            return false;
        }
    }
}
