package com.brainandeyes.tandimensions.init;

import com.brainandeyes.tandimensions.temperature.modifier.DimensionModifier;
import toughasnails.api.temperature.TemperatureHelper;

public class ModDimension {
    public static void init() {
        TemperatureHelper.registerTemperatureModifier(new DimensionModifier("dimension"));
    }
}
