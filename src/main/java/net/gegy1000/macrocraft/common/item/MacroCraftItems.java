package net.gegy1000.macrocraft.common.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MacroCraftItems
{
    public static ItemArmor.ArmorMaterial SPACESUIT = EnumHelper.addArmorMaterial("SPACESUIT", "spacesuit", 15, new int[]{2, 6, 5, 2}, 9);

    public static ItemSpacesuit space_helmet;

    public void register()
    {
        space_helmet = new ItemSpacesuit(SPACESUIT, 0);

        registerItem(space_helmet, "space_helmet");
    }

    public void registerItem(Item item, String name)
    {
        item.setUnlocalizedName(name);
        GameRegistry.registerItem(item, name);
    }
}
