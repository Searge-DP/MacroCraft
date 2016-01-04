package net.gegy1000.macrocraft.common.space.celestial.planet;

import net.gegy1000.macrocraft.common.space.celestial.CelestialBody;
import net.minecraft.world.WorldProvider;

public abstract class Planet extends CelestialBody
{
    public abstract double getGravityMultiplier();

    public abstract WorldProvider getWorldProvider();

    public abstract Class[] getMoons();

    public abstract int getDimensionId();
}
