package net.gegy1000.macrocraft.client.render;

import net.gegy1000.macrocraft.common.entity.EntitySpaceship;
import net.gegy1000.macrocraft.common.entity.SpaceshipBlockContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Map;

@SideOnly(Side.CLIENT)
public class RenderSpaceship extends Render
{
    public RenderSpaceship()
    {
        super(Minecraft.getMinecraft().getRenderManager());
        this.shadowSize = 0.0F;
    }

    public void doRender(EntitySpaceship spaceship, double posX, double posY, double posZ, float yaw, float partialTicks)
    {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)posX - 0.5, (float)posY, (float)posZ - 0.5);
        GlStateManager.disableLighting();
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();

        World world = spaceship.worldObj;

        bindEntityTexture(spaceship);

        for (Map.Entry<BlockPos, SpaceshipBlockContainer> entry : spaceship.getBlocks().entrySet())
        {
            worldrenderer.begin(7, DefaultVertexFormats.BLOCK);

            BlockPos blockpos = entry.getKey();
            IBlockState iblockstate = entry.getValue().getState();

            int i = blockpos.getX();
            int j = blockpos.getY();
            int k = blockpos.getZ();

            GlStateManager.translate(i, j, k);
            BlockRendererDispatcher blockrendererdispatcher = Minecraft.getMinecraft().getBlockRendererDispatcher();
            IBakedModel ibakedmodel = blockrendererdispatcher.getModelFromBlockState(iblockstate, world, null);
            blockrendererdispatcher.getBlockModelRenderer().renderModel(world, ibakedmodel, iblockstate, blockpos, worldrenderer, false);
            GlStateManager.translate(-i, -j, -k);
            tessellator.draw();
        }

        GlStateManager.enableLighting();
        GlStateManager.popMatrix();
        super.doRender(spaceship, posX, posY, posZ, yaw, partialTicks);
    }

    protected ResourceLocation getEntityTexture(EntitySpaceship spaceship)
    {
        return TextureMap.locationBlocksTexture;
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return this.getEntityTexture((EntitySpaceship)entity);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity>) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doe
     */
    public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTicks)
    {
        this.doRender((EntitySpaceship)entity, x, y, z, yaw, partialTicks);
    }
}