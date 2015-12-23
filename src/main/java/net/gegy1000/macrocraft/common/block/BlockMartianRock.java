package net.gegy1000.macrocraft.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockMartianRock extends Block
{
    public BlockMartianRock()
    {
        super(Material.rock);
        this.setHardness(2.0F);
        this.setResistance(2.0F);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setUnlocalizedName("martian_rock");
    }
}
