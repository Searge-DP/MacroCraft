package net.gegy1000.macrocraft.client.proxy;

import net.gegy1000.macrocraft.MacroCraft;
import net.gegy1000.macrocraft.client.event.ClientEventHandler;
import net.gegy1000.macrocraft.client.event.GuiOverlay;
import net.gegy1000.macrocraft.client.render.RenderSpaceship;
import net.gegy1000.macrocraft.common.block.MacroCraftBlocks;
import net.gegy1000.macrocraft.common.entity.EntitySpaceship;
import net.gegy1000.macrocraft.common.item.MacroCraftItems;
import net.gegy1000.macrocraft.common.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class ClientProxy extends CommonProxy
{
    @Override
    public void preInit()
    {
        super.preInit();

        ClientEventHandler eventHandler = new ClientEventHandler();
        MinecraftForge.EVENT_BUS.register(eventHandler);
        FMLCommonHandler.instance().bus().register(eventHandler);

        MinecraftForge.EVENT_BUS.register(new GuiOverlay());
    }

    @Override
    public void init()
    {
        super.init();

        ItemModelMesher modelMesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();

        registerItemRenderer(modelMesher, MacroCraftItems.space_helmet, "space_helmet", "inventory");

        registerBlockRenderer(modelMesher, MacroCraftBlocks.martian_soil, "martian_soil", "inventory");
        registerBlockRenderer(modelMesher, MacroCraftBlocks.martian_rock, "martian_rock", "inventory");

        RenderingRegistry.registerEntityRenderingHandler(EntitySpaceship.class, new RenderSpaceship());
    }

    @Override
    public void postInit()
    {
        super.postInit();
    }

    /**
     * Registers an item renderer
     */
    public void registerItemRenderer(ItemModelMesher itemModelMesher, Item item, final String path, final String type)
    {
        itemModelMesher.register(item, new ItemMeshDefinition()
        {
            @Override
            public ModelResourceLocation getModelLocation(ItemStack stack)
            {
                return new ModelResourceLocation(MacroCraft.modid + ":" + path, type);
            }
        });
    }

    /**
     * Registers an item renderer with metadata
     */
    public void registerItemRenderer(ItemModelMesher itemModelMesher, Item item, int meta, String path, String type)
    {
        itemModelMesher.register(item, meta, new ModelResourceLocation(MacroCraft.modid + ":" + path, type));
    }

    /**
     * Registers an block renderer with metadata
     */
    public void registerBlockRenderer(ItemModelMesher itemModelMesher, Block block, int meta, String path, String type)
    {
        itemModelMesher.register(Item.getItemFromBlock(block), meta, new ModelResourceLocation(MacroCraft.modid + ":" + path, type));
    }

    /**
     * Registers a block renderer
     */
    public void registerBlockRenderer(ItemModelMesher itemModelMesher, Block block, final String path, final String type)
    {
        itemModelMesher.register(Item.getItemFromBlock(block), new ItemMeshDefinition()
        {
            @Override
            public ModelResourceLocation getModelLocation(ItemStack stack)
            {
                return new ModelResourceLocation(MacroCraft.modid + ":" + path, type);
            }
        });
    }
}
