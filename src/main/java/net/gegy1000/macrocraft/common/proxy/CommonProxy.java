package net.gegy1000.macrocraft.common.proxy;

import net.gegy1000.macrocraft.common.event.CommonEventHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class CommonProxy
{
    public void preInit()
    {
        CommonEventHandler eventHandler = new CommonEventHandler();

        MinecraftForge.EVENT_BUS.register(eventHandler);
        FMLCommonHandler.instance().bus().register(eventHandler);
    }

    public void init()
    {

    }

    public void postInit()
    {
    }
}
