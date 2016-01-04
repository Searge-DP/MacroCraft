package net.gegy1000.macrocraft.common.space.celestial.planet;

import net.gegy1000.macrocraft.common.space.celestial.moon.Moon;
import net.gegy1000.macrocraft.common.world.gen.mars.MarsGen;
import net.gegy1000.macrocraft.common.world.provider.WorldProviderMars;
import net.minecraft.world.WorldProvider;

public class PlanetMars extends Planet
{
    @Override
    public double getGravityMultiplier()
    {
        return 0.7;
    }

    @Override
    public WorldProvider getWorldProvider()
    {
        return new WorldProviderMars();
    }

    @Override
    public Class<? extends Moon>[] getMoons()
    {
        return new Class[0];
    }

    @Override
    public int getDimensionId()
    {
        return MarsGen.DIMENSION_ID;
    }

    @Override
    public String getName()
    {
        return "Mars";
    }
}
