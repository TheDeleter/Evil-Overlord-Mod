package mods.deleter.multitools;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class EvilArmor extends ItemArmor implements IArmorTextureProvider{

	public EvilArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial,
			int par3, int par4) {
		super(par1, par2EnumArmorMaterial, par3, par4);
	}

	@Override
	public String getArmorTextureFile(ItemStack itemstack) {
		if(itemstack.itemID == Multitools.itemEvilHelmet.itemID || itemstack.itemID == Multitools.itemEvilChest.itemID  || itemstack.itemID == Multitools.itemEvilBoots.itemID){
		return "/mods/deleter/multitools/textures/armor/evil_1.png";
		}
		if (itemstack.itemID == Multitools.itemEvilLegs.itemID){
			return "/mods/deleter/multitools/textures/armor/evil_2.png";
		}
		else return null;
	}

	 public void updateIcons(IconRegister iconRegister)
	    {
		 if(this == Multitools.itemEvilHelmet)
	             iconIndex = iconRegister.registerIcon("deleter/multitools:ItemEvilHelm");
		 
		 if(this == Multitools.itemEvilChest)
             iconIndex = iconRegister.registerIcon("deleter/multitools:ItemEvilChest");
		 
		 if(this == Multitools.itemEvilLegs)
             iconIndex = iconRegister.registerIcon("deleter/multitools:ItemEvilLegs");
		 
		 if(this == Multitools.itemEvilBoots)
             iconIndex = iconRegister.registerIcon("deleter/multitools:ItemEvilBoots");
	    }
	
}
