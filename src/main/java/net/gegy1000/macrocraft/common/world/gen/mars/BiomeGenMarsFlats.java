package net.gegy1000.macrocraft.common.world.gen.mars;

import net.gegy1000.macrocraft.common.block.MacroCraftBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;

import java.util.Random;

public class BiomeGenMarsFlats extends BiomeGenBase
{
    public BiomeGenMarsFlats(int id)
    {
        super(id);
        this.setTemperatureRainfall(0.8F, 0.4F);
        this.setHeight(height_LowPlains);
        this.theBiomeDecorator.treesPerChunk = -999;
        this.theBiomeDecorator.flowersPerChunk = -999;
        this.theBiomeDecorator.grassPerChunk = -999;
        this.topBlock = this.fillerBlock = MacroCraftBlocks.martian_soil.getDefaultState();
        this.spawnableCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();
    }

    public void genTerrainBlocks(World world, Random random, ChunkPrimer chunkPrimer, int x, int z, double noise)
    {
        IBlockState topBlock = this.topBlock;
        IBlockState fillerBlock = this.fillerBlock;
        int chunkX = x & 15;
        int chunkZ = z & 15;

        IBlockState stoneBlock = MacroCraftBlocks.martian_rock.getDefaultState();

        boolean top = false;

        for (int y = 255; y >= 0; --y)
        {
            if (y <= random.nextInt(5))
            {
                chunkPrimer.setBlockState(chunkZ, y, chunkX, Blocks.bedrock.getDefaultState());
            }
            else
            {
                IBlockState previousBlock = chunkPrimer.getBlockState(chunkZ, y, chunkX);

                if (previousBlock.getBlock().getMaterial() == Material.air)
                {
                    top = true;
                }
                else if (previousBlock == stoneBlock)
                {
                    if (top)
                    {
                        if (y >= 62)
                        {
                            chunkPrimer.setBlockState(chunkZ, y, chunkX, topBlock);
                        }
                        else
                        {
                            chunkPrimer.setBlockState(chunkZ, y, chunkX, fillerBlock);
                        }
                    }
                }
            }
        }

        super.genTerrainBlocks(world, random, chunkPrimer, x, z, noise);
    }

    public void decorate(World world, Random rand, BlockPos pos)
    {
        int x = rand.nextInt(16) + 8;
        int z = rand.nextInt(16) + 8;
        int y = world.getHorizon(pos.add(x, 0, z)).getY();

        world.setBlockState(pos.add(x, y, z), MacroCraftBlocks.martian_rock.getDefaultState());

        super.decorate(world, rand, pos);
    }
}