package com.brainandeyes.tandimensions.temperature.modifier;

import com.brainandeyes.tandimensions.init.ModConfig;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import toughasnails.api.temperature.IModifierMonitor;
import toughasnails.api.temperature.Temperature;
import toughasnails.temperature.modifier.TemperatureModifier;

public class DimensionModifier extends TemperatureModifier {
    public DimensionModifier(String id) {
        super(id);
    }

    @Override
    public Temperature applyEnvironmentModifiers(World world, BlockPos pos, Temperature initialTemperature, IModifierMonitor monitor) {
        Integer rawTemperatureLevel = initialTemperature.getRawValue();
        Integer playerDimension = world.provider.getDimension();
        Integer newRawTemperatureLevel = 0;

        boolean containDimension = ModConfig.dimensionTemperatureData.getDimensionsTemperature().containsKey(playerDimension.toString());
        if (containDimension) {
            newRawTemperatureLevel = ModConfig.dimensionTemperatureData.getDimensionsTemperature().get(playerDimension.toString());
        }
        rawTemperatureLevel += newRawTemperatureLevel;

        monitor.addEntry(new IModifierMonitor.Context(this.getId(), "Dimension Temperature", initialTemperature, new Temperature(rawTemperatureLevel)));

        return new Temperature(rawTemperatureLevel);
    }

    @Override
    public boolean isPlayerSpecific() { return false; }
}
