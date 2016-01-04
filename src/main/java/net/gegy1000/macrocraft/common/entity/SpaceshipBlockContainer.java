package net.gegy1000.macrocraft.common.entity;

import io.netty.buffer.ByteBuf;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.network.ByteBufUtils;

public class SpaceshipBlockContainer
{
    private IBlockState state;
    private TileEntity tileEntity;

    public SpaceshipBlockContainer(IBlockState state, TileEntity tileEntity)
    {
        this.state = state;
        this.tileEntity = tileEntity;
    }

    public SpaceshipBlockContainer(IBlockState state)
    {
        this(state, null);
    }

    public IBlockState getState()
    {
        return state;
    }

    public void setState(IBlockState state)
    {
        this.state = state;
    }

    public TileEntity getTileEntity()
    {
        return tileEntity;
    }

    public void setTileEntity(TileEntity tileEntity)
    {
        this.tileEntity = tileEntity;
    }

    public void writeToNBT(NBTTagCompound nbt)
    {
        Block block = state.getBlock();

        nbt.setInteger("BlockId", Block.getIdFromBlock(block));
        nbt.setInteger("Metadata", block.getMetaFromState(state));

        if (tileEntity != null)
        {
            NBTTagCompound tileTag = new NBTTagCompound();

            tileEntity.writeToNBT(tileTag);

            nbt.setTag("TileEntity", tileTag);
        }
    }

    public void readFromNBT(NBTTagCompound nbt)
    {
        Block block = Block.getBlockById(nbt.getInteger("BlockId"));
        state = block.getStateFromMeta(nbt.getInteger("Metadata"));

        if (nbt.hasKey("TileEntity"))
        {
            NBTTagCompound tileTag = nbt.getCompoundTag("TileEntity");

            tileEntity = TileEntity.createAndLoadEntity(tileTag);
        }
    }

    public void toBytes(ByteBuf buf)
    {
        Block block = state.getBlock();

        buf.writeInt(Block.getIdFromBlock(block));
        buf.writeByte(block.getMetaFromState(state));

        if (tileEntity != null)
        {
            NBTTagCompound tileTag = new NBTTagCompound();

            tileEntity.writeToNBT(tileTag);

            ByteBufUtils.writeTag(buf, tileTag);
        }
    }

    public void fromBytes(ByteBuf buf)
    {
        Block block = Block.getBlockById(buf.readInt());
        state = block.getStateFromMeta(buf.readByte());

        NBTTagCompound tileTag = ByteBufUtils.readTag(buf);

        if (tileTag != null)
        {
            tileEntity = TileEntity.createAndLoadEntity(tileTag);
        }
    }
}
