package com.brainandeyes.tandimensions.init;

import com.brainandeyes.tandimensions.config.json.DimensionTemperatureData;
import com.brainandeyes.tandimensions.util.config.JsonUtil;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


import java.io.File;
import java.util.Map;

public class ModConfig {
    public static File configDirectory;

    public static DimensionTemperatureData dimensionTemperatureData;

    public static void preInit(FMLPreInitializationEvent event) {
        configDirectory = new File(event.getModConfigurationDirectory(), ModGlobals.CONFIG_DIRECOTRY);
        dimensionTemperatureData = new DimensionTemperatureData();

        //Create with default values or get the config file and set the values
        Map<String, Integer> dimensionTemperatures = JsonUtil.getOrCreateConfigFile(
                configDirectory,
                "dimension_temperature.json",
                dimensionTemperatureData.getDefaulDimensionsTemperatureJson(),
                dimensionTemperatureData.getDimensionTemperatureDataType()
        );
        dimensionTemperatureData.setDimensionsTemperature(dimensionTemperatures);
    }

    public static void init() {}
}
