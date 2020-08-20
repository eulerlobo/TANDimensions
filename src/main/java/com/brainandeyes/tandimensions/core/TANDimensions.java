package com.brainandeyes.tandimensions.core;

import com.brainandeyes.tandimensions.init.ModGlobals;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = ModGlobals.MODID, name = ModGlobals.NAME, version = ModGlobals.VERSION, dependencies = ModGlobals.DEPENDANCIES)
public class TANDimensions {

    @SidedProxy(clientSide = ModGlobals.CLIENT_PROXY, serverSide = ModGlobals.SERVER_PROXY)
    public static CommonProxy proxy;

    @Instance(ModGlobals.MODID)
    public static TANDimensions instance;

    public static Logger logger = LogManager.getLogger(ModGlobals.MODID);

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        instance = this;
        proxy.preInit(e);
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }
}
