package net.gegy1000.macrocraft.common.world.gen.mars;

import net.gegy1000.macrocraft.MacroCraft;
import net.gegy1000.macrocraft.common.block.MacroCraftBlocks;
import net.ilexiconn.llibrary.common.world.gen.gen.WorldHeightmapGenerator;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.biome.BiomeGenBase;

/**
 * @author gegy1000
 */
public class MarsGen extends WorldHeightmapGenerator
{
    public static final int DIMENSION_ID = 25;
    public static final MarsGen MARS_GEN = new MarsGen();

    @Override
    public String getBiomeMapLocation()
    {
        return null;
    }

    @Override
    public String getHeightmapLocation()
    {
        return "assets/macrocraft/heightmap/mars_heightmap.png";
    }

    @Override
    public double getWorldScale()
    {
        return 4;
    }

    @Override
    public double getHeightScale(int height)
    {
        return 1.5;
    }

    @Override
    public int getHeightOffset(int height)
    {
        return -50;
    }

    @Override
    public IBlockState getStoneBlock()
    {
        return MacroCraftBlocks.martian_rock.getDefaultState();
    }

    @Override
    public BiomeGenBase getDefaultBiome()
    {
        return MacroCraft.mars;
    }

    @Override
    public String getName()
    {
        return "Mars";
    }

    @Override
    public int getColourForBiome(BiomeGenBase biome)
    {
        return 0;
    }

    @Override
    public boolean hasOcean()
    {
        return false;
    }

    @Override
    public IBlockState getOceanLiquid()
    {
        return null;
    }

    @Override
    public int getOceanHeight(int x, int z)
    {
        return 0;
    }
}
