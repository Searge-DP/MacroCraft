package net.gegy1000.macrocraft.common.block;

import net.gegy1000.macrocraft.common.tile.TileLight;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MacroCraftBlocks
{
    public static BlockMartianSoil martian_soil;
    public static BlockMartianRock martian_rock;

    public static BlockLight light;

    public void register()
    {
        martian_soil = new BlockMartianSoil();
        martian_rock = new BlockMartianRock();
        light = new BlockLight();

        GameRegistry.registerBlock(martian_soil, "martian_soil");
        GameRegistry.registerBlock(martian_rock, "martian_rock");
        GameRegistry.registerBlock(light, "light_source");
        GameRegistry.registerTileEntity(TileLight.class, "light_source");
    }
}
