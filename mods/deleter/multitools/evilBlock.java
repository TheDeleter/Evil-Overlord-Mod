package mods.deleter.multitools;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;

public class evilBlock extends BlockDirt{
	
	public evilBlock (int id, int texture, Material material) {
        super(id);
        setHardness(0.5F);
        setStepSound(Block.soundGravelFootstep);
        setUnlocalizedName("taintedDirt");
        setCreativeTab(CreativeTabs.tabBlock);
}
	@Override
	public void registerIcons(IconRegister iconRegister)
    {
           this.blockIcon = iconRegister.registerIcon("deleter/multitools:taintedDirt");
    }

}
