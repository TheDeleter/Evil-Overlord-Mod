package mods.deleter.multitools;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCorruptionStaffs extends Item{

	public ItemCorruptionStaffs(int par1) {
		super(par1);
		this.setCreativeTab(CreativeTabs.tabTools);
		// TODO Auto-generated constructor stub
	}
	public boolean onItemUse(ItemStack tool,
			EntityPlayer player, World world, int x, int y,
			int z, int par7, float xFloat, float yFloat, float zFloat)
	{

		if (!player.canPlayerEdit(x, y, z, par7, tool))//can the player edit this block? if he cant then dont do anything
		{
			return false;
		}
world.setBlockMetadataWithNotify(x, y, z, 0, Multitools.taintedDirt.blockID); // sets the block to diamond block with the meta data 0 (used for setting metadata if the block needs it
		return world.setBlock(x, y, z, Multitools.taintedDirt.blockID);
}
	
	public void updateIcons(IconRegister iconRegister)
    {
             iconIndex = iconRegister.registerIcon("deleter/multitools:ItemInfectionStaff");
    }

}
