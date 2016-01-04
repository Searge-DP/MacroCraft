package net.gegy1000.macrocraft.common.entity;

import net.gegy1000.macrocraft.MacroCraft;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class MacroCraftEntityRegistry
{
    private int entityId;

    public void register()
    {
        registerEntity(EntitySpaceship.class, "spaceship_blocks");
    }

    private void registerEntity(Class<? extends Entity> entity, String name)
    {
        String formattedName = name.toLowerCase().replaceAll(" ", "_");

        EntityRegistry.registerModEntity(entity, formattedName, entityId++, MacroCraft.instance, 1024, 1, true);
    }
}
