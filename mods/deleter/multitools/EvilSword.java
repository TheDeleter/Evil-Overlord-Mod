package mods.deleter.multitools;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;

public class EvilSword extends ItemSword{

	public EvilSword(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		// TODO Auto-generated constructor stub
	}
	public void updateIcons(IconRegister iconRegister)
    {
             iconIndex = iconRegister.registerIcon("deleter/multitools:ItemEvilSword");
    }

}
