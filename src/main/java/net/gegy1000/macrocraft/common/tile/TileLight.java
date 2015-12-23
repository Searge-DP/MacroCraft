package net.gegy1000.macrocraft.common.tile;

import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;

public class TileLight extends TileEntity implements IUpdatePlayerListBox
{
    public int ticks;

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);

        ticks = nbt.getInteger("Ticks");
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);

        nbt.setInteger("Ticks", ticks);
    }

    @Override
    public void update()
    {
        ticks += 1;

        if (ticks > 2)
        {
            worldObj.setBlockState(pos, Blocks.air.getDefaultState());
        }
    }
}
