package net.gegy1000.macrocraft;

import net.gegy1000.macrocraft.common.block.MacroCraftBlocks;
import net.gegy1000.macrocraft.common.entity.MacroCraftEntityRegistry;
import net.gegy1000.macrocraft.common.item.MacroCraftItems;
import net.gegy1000.macrocraft.common.message.MacroCraftNetworkManager;
import net.gegy1000.macrocraft.common.proxy.CommonProxy;
import net.gegy1000.macrocraft.common.world.gen.mars.BiomeGenMarsFlats;
import net.gegy1000.macrocraft.common.world.gen.mars.MarsGen;
import net.gegy1000.macrocraft.common.world.provider.WorldProviderMars;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MacroCraft.modid, name = "MacroCraft", version = "${version}")
public class MacroCraft
{
    public static final String modid = "macrocraft";

    @Mod.Instance(MacroCraft.modid)
    public static MacroCraft instance;

    @SidedProxy(clientSide = "net.gegy1000.macrocraft.client.proxy.ClientProxy", serverSide = "net.gegy1000.macrocraft.common.proxy.CommonProxy")
    public static CommonProxy proxy;

    public static MacroCraftBlocks blocks;
    public static MacroCraftItems items;
    public static MacroCraftNetworkManager networkManager;
    public static MacroCraftEntityRegistry entityRegistry;

    public static BiomeGenBase mars;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit();

        blocks = new MacroCraftBlocks();
        blocks.register();

        items = new MacroCraftItems();
        items.register();

        entityRegistry = new MacroCraftEntityRegistry();
        entityRegistry.register();

        networkManager = new MacroCraftNetworkManager();
        networkManager.init();

        mars = new BiomeGenMarsFlats(95).setBiomeName("Mars Flats");

        DimensionManager.registerProviderType(MarsGen.DIMENSION_ID, WorldProviderMars.class, false);
        DimensionManager.registerDimension(MarsGen.DIMENSION_ID, MarsGen.DIMENSION_ID);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit();
    }
}
