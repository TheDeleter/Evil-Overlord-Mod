package mods.deleter.multitools;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemEviliumIngot extends Item {

    public ItemEviliumIngot(int id) {
            super(id);
           
            // Constructor Configuration
            maxStackSize = 64;
            setCreativeTab(CreativeTabs.tabMaterials);
            setUnlocalizedName("EviliumIngot");
            
    }
    public void updateIcons(IconRegister iconRegister)
    {
             iconIndex = iconRegister.registerIcon("deleter/multitools:ItemEviliumIngot");
    }
}
