package net.gegy1000.macrocraft.common.entity;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;

public class EntitySpaceship extends Entity
{
    private Map<BlockPos, SpaceshipBlockContainer> blocks = new HashMap<BlockPos, SpaceshipBlockContainer>();

    public EntitySpaceship(World world)
    {
        super(world);
    }

    @Override
    protected void entityInit()
    {

    }

    public void setBlockState(BlockPos pos, IBlockState state)
    {
        SpaceshipBlockContainer container = getBlockContainer(pos);
        container.setState(state);

        setBlockContainer(pos, container);
    }

    public IBlockState getBlockState(BlockPos pos)
    {
        return getBlockContainer(pos).getState();
    }

    public void setTileEntity(BlockPos pos, TileEntity tile)
    {
        SpaceshipBlockContainer container = getBlockContainer(pos);
        container.setTileEntity(tile);

        setBlockContainer(pos, container);
    }

    public TileEntity getTileEntity(BlockPos pos)
    {
        return getBlockContainer(pos).getTileEntity();
    }

    public SpaceshipBlockContainer getBlockContainer(BlockPos pos)
    {
        SpaceshipBlockContainer container = blocks.get(pos);

        if (container == null)
        {
            container = new SpaceshipBlockContainer(null, null);
        }

        return container;
    }

    public void setBlockContainer(BlockPos pos, SpaceshipBlockContainer container)
    {
        blocks.put(pos, container);
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound tagCompund)
    {
        NBTTagList blockList = tagCompund.getTagList("Blocks", 10);

        for (int i = 0; i < blockList.tagCount(); i++)
        {
            NBTTagCompound blockTag = blockList.getCompoundTagAt(i);

            SpaceshipBlockContainer block = new SpaceshipBlockContainer(null, null);
            block.readFromNBT(blockTag);

            blocks.put(BlockPos.fromLong(blockTag.getLong("Position")), block);
        }
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound tagCompound)
    {
        NBTTagList blockList = new NBTTagList();

        for (Map.Entry<BlockPos, SpaceshipBlockContainer> entry : blocks.entrySet())
        {
            NBTTagCompound blockNBT = new NBTTagCompound();

            entry.getValue().writeToNBT(blockNBT);

            blockNBT.setLong("Position", entry.getKey().toLong());

            blockList.appendTag(blockNBT);
        }

        tagCompound.setTag("Blocks", blockList);
    }

    public Map<BlockPos, SpaceshipBlockContainer> getBlocks()
    {
        return blocks;
    }

    public void setBlocks(Map<BlockPos, SpaceshipBlockContainer> blocks)
    {
        this.blocks = blocks;
    }
}
