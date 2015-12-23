package net.gegy1000.macrocraft.common.event;

import net.gegy1000.macrocraft.common.block.MacroCraftBlocks;
import net.gegy1000.macrocraft.common.item.MacroCraftItems;
import net.gegy1000.macrocraft.common.tile.TileLight;
import net.gegy1000.macrocraft.common.world.gen.mars.MarsGen;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

public class CommonEventHandler
{
    public static List<EntityPlayer> playersShining = new ArrayList<EntityPlayer>();

    @SubscribeEvent
    public void onJump(LivingEvent.LivingJumpEvent event)
    {
        EntityLivingBase entity = event.entityLiving;

        if (entity.dimension == MarsGen.DIMENSION_ID)
        {
            event.entityLiving.motionY /= 0.7;
        }
    }

    @SubscribeEvent
    public void update(LivingEvent.LivingUpdateEvent event)
    {
        EntityLivingBase entity = event.entityLiving;

        if (entity.dimension == MarsGen.DIMENSION_ID && entity.motionY < 0)
        {
            entity.motionY *= 0.8;
        }

        if (entity instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) entity;

            if (playersShining.contains(player))
            {
                ItemStack helmet = player.getCurrentArmor(3);

                if (helmet != null && helmet.getItem() == MacroCraftItems.space_helmet)
                {
                    MovingObjectPosition mop = rayTrace(player, 25, 1.0F);

                    if (!(mop.typeOfHit == MovingObjectPosition.MovingObjectType.MISS))
                    {
                        BlockPos pos;

                        if (mop.typeOfHit == MovingObjectPosition.MovingObjectType.ENTITY)
                        {
                            pos = mop.entityHit.getPosition();
                        }
                        else
                        {
                            pos = mop.getBlockPos();
                            pos = pos.offset(mop.sideHit);
                        }

                        if (player.worldObj.getBlockState(pos).getBlock() == MacroCraftBlocks.light)
                        {
                            TileLight tileLight = (TileLight) player.worldObj.getTileEntity(pos);
                            tileLight.ticks = 0;
                        }
                        else
                        {
                            if (player.worldObj.isAirBlock(pos))
                            {
                                player.worldObj.setBlockState(pos, MacroCraftBlocks.light.getDefaultState());
                            }
                        }
                    }
                }
            }
            else
            {
                playersShining.remove(player);
            }
        }
    }

    public Vec3 getPositionEyes(EntityPlayer player, float partialTick)
    {
        if (partialTick == 1.0F)
        {
            return new Vec3(player.posX, player.posY + (double)player.getEyeHeight(), player.posZ);
        }
        else
        {
            double d0 = player.prevPosX + (player.posX - player.prevPosX) * (double)partialTick;
            double d1 = player.prevPosY + (player.posY - player.prevPosY) * (double)partialTick + (double)player.getEyeHeight();
            double d2 = player.prevPosZ + (player.posZ - player.prevPosZ) * (double)partialTick;
            return new Vec3(d0, d1, d2);
        }
    }

    public MovingObjectPosition rayTrace(EntityPlayer player, double distance, float partialTick)
    {
        Vec3 vec3 = getPositionEyes(player, partialTick);
        Vec3 vec31 = player.getLook(partialTick);
        Vec3 vec32 = vec3.addVector(vec31.xCoord * distance, vec31.yCoord * distance, vec31.zCoord * distance);
        return player.worldObj.rayTraceBlocks(vec3, vec32, false, false, true);
    }

    @SubscribeEvent
    public void onFall(LivingFallEvent event)
    {
        EntityLivingBase entity = event.entityLiving;

        if (entity.dimension == MarsGen.DIMENSION_ID)
        {
            event.distance *= 0.8;
        }
    }
}
