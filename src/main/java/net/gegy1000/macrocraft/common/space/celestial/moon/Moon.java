package net.gegy1000.macrocraft.common.space.celestial.moon;

import net.gegy1000.macrocraft.common.space.celestial.planet.Planet;

public abstract class Moon extends Planet
{
    public Class<? extends Moon>[] getMoons()
    {
        return new Class[0];
    }
}
