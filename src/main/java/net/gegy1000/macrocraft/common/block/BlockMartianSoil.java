package net.gegy1000.macrocraft.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockMartianSoil extends Block
{
    public BlockMartianSoil()
    {
        super(Material.ground);
        this.setHardness(1.0F);
        this.setResistance(1.0F);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setUnlocalizedName("martian_soil");
        this.setStepSound(Block.soundTypeGravel);
    }
}
