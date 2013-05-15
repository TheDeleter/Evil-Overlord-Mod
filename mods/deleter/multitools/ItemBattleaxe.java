package mods.deleter.multitools;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;

public class ItemBattleaxe extends ItemAxe{

	public ItemBattleaxe(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		// TODO Auto-generated constructor stub
	}
	 public void updateIcons(IconRegister iconRegister)
     {
              iconIndex = iconRegister.registerIcon("deleter/multitools:ItemEvilAxe");
     }
   }
       
