package net.gegy1000.macrocraft.common.message;

import net.gegy1000.macrocraft.MacroCraft;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import sun.plugin2.message.Message;

public class MacroCraftNetworkManager
{
    public SimpleNetworkWrapper wrapper;

    public int discrimator;

    public void init()
    {
        wrapper = new SimpleNetworkWrapper(MacroCraft.modid);

        wrapper.registerMessage(MessageLight.class, MessageLight.class, discrimator++, Side.CLIENT);
        wrapper.registerMessage(MessageLight.class, MessageLight.class, discrimator++, Side.SERVER);
        wrapper.registerMessage(MessageSetBlocks.class, MessageSetBlocks.class, discrimator++, Side.CLIENT);
        wrapper.registerMessage(MessageSetBlocks.class, MessageSetBlocks.class, discrimator++, Side.SERVER);
    }
}
