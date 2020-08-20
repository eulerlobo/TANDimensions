package com.brainandeyes.tandimensions.config.json;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class DimensionTemperatureData {
    Map<String, Integer> dimensionsTemperature;

    public Map<String, Integer> getDefaulDimensionsTemperatureJson() {
        Map<String, Integer> defaultDimensionsTemperature = new HashMap<String, Integer>();

        //Default temperatures for Overworld, Nether and End
        defaultDimensionsTemperature.put("1", 0);
        defaultDimensionsTemperature.put("0", 0);
        defaultDimensionsTemperature.put("-1", 0);

        return defaultDimensionsTemperature;
    }

    public void setDimensionsTemperature(Map<String, Integer> dimensionsTemperature) {
        this.dimensionsTemperature = dimensionsTemperature;
    }

    public Map<String, Integer> getDimensionsTemperature(){
        return this.dimensionsTemperature;
    }

    public Type getDimensionTemperatureDataType() {
        return new TypeToken<Map<String, Integer>>(){}.getType();
    }
}
