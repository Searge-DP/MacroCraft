package net.gegy1000.macrocraft.common.world.provider;

import net.gegy1000.macrocraft.common.world.gen.mars.MarsGen;
import net.ilexiconn.llibrary.common.world.gen.ChunkProviderHeightmap;
import net.ilexiconn.llibrary.common.world.gen.WorldChunkManagerHeightmap;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WorldProviderMars extends WorldProvider
{
    /**
     * creates a new world chunk manager for WorldProvider
     */
    public void registerWorldChunkManager()
    {
        this.worldChunkMgr = new WorldChunkManagerHeightmap(worldObj, MarsGen.MARS_GEN);
        this.dimensionId = MarsGen.DIMENSION_ID;
    }

    /**
     * Return Vec3D with biome specific fog color
     */
    @SideOnly(Side.CLIENT)
    public Vec3 getFogColor(float p_76562_1_, float p_76562_2_)
    {
        return new Vec3(1.0D, 0.6980392156862745D, 0.4980392156862745D);
    }

    /**
     * Returns a new chunk provider which generates chunks for this world
     */
    public IChunkProvider createChunkGenerator()
    {
        return new ChunkProviderHeightmap(this.worldObj, this.worldObj.getSeed(), MarsGen.MARS_GEN);
    }

    /**
     * Returns 'true' if in the "main surface world", but 'false' if in the Nether or End dimensions.
     */
    public boolean isSurfaceWorld()
    {
        return false;
    }

    /**
     * Will check if the x, z position specified is alright to be set as the map spawn point
     */
    public boolean canCoordinateBeSpawn(int x, int z)
    {
        return false;
    }

    /**
     * Calculates the angle of sun and moon in the sky relative to a specified time (usually worldTime)
     */
    public float calculateCelestialAngle(long worldtime, float p_76563_3_)
    {
        return super.calculateCelestialAngle(worldtime, p_76563_3_) * 1.1F;
    }

    /**
     * True if the player can respawn in this dimension (true = overworld, false = nether).
     */
    public boolean canRespawnHere()
    {
        return false;
    }

    /**
     * Returns true if the given X,Z coordinate should show environmental fog.
     */
    @SideOnly(Side.CLIENT)
    public boolean doesXZShowFog(int x, int z)
    {
        return true;
    }

    @Override
    public String getDimensionName()
    {
        return "Mars";
    }

    @Override
    public String getInternalNameSuffix()
    {
        return "_mars";
    }
}
