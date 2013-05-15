package mods.deleter.multitools;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;


public class evilOre extends BlockOre {
	public evilOre (int id, int texture, Material material) {
		super(id);
		setHardness(4.0F);
		setStepSound(Block.soundStoneFootstep);
        setUnlocalizedName("eviliumOre");
        setCreativeTab(CreativeTabs.tabBlock);
}
	
	@Override
	public void registerIcons(IconRegister iconRegister)
    {
           this.blockIcon = iconRegister.registerIcon("deleter/multitools:eviliumOre");
    }
	
}
