package mods.deleter.multitools;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="dMultitools", name="Fantasycraft", version="0.0.1")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class Multitools {
	
	@Instance("Multitools")
	public static Multitools instance;
	
	//material creation (broken atm)
	static EnumToolMaterial toolEVIL = EnumHelper.addToolMaterial("EVIL", 2, 500, 5F, 3, 9);
	
	//Items
    public final static Item itemIngotEvil = new ItemEviliumIngot(5002);
    public static Item itemBattleaxe;
    public static Item itemEvilSword;
    public static Item itemEvilPick;
    public static Item itemEvilShovel;
    public static Item itemEvilHoe;
    public static Item itemInfectionStaff; 
        
    //Armor
    public static Item itemEvilHelmet;
    public static Item itemEvilChest;
    public static Item itemEvilLegs;
    public static Item itemEvilBoots;
    
    //Blocks
    public final static Block taintedDirt = new evilBlock(500, 1, Material.ground);
    public final static Block eviliumOre = new evilOre(501, 1, Material.rock);
    
	@SidedProxy(clientSide="mods.deleter.multitools.client.ClientProxy", serverSide="mods.deleter.multitools.CommonProxy")
	public static CommonProxy proxy;
	
    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
            // Stub Method
    }
   
    @Init
    public void load(FMLInitializationEvent event) {
    	
    	//register of worldgen and rendering
		proxy.registerRenderThings();
		GameRegistry.registerWorldGenerator(new WorldGeneratorEvil());
		
    	//Crafting Stacks
         ItemStack stickStack = new ItemStack(Item.stick);
         ItemStack eviliumIngotStack = new ItemStack(itemIngotEvil);
         ItemStack ironIngotStack = new ItemStack(Item.ingotIron);
         ItemStack diamondStack = new ItemStack(Item.diamond);
         
         //Adding Items         
         itemEvilSword = new EvilSword (5007, EnumToolMaterial.EMERALD).setUnlocalizedName("EvilSword");
         itemBattleaxe = new ItemBattleaxe (5008, EnumToolMaterial.EMERALD).setUnlocalizedName("itemBattleaxe");
         itemEvilPick = new EvilPick (5009, EnumToolMaterial.EMERALD).setUnlocalizedName("EvilPick");
         itemEvilShovel = new EvilShovel (5010, EnumToolMaterial.EMERALD).setUnlocalizedName("EvilShovel");
         itemEvilHoe = new EvilHoe (5011, EnumToolMaterial.EMERALD).setUnlocalizedName("EvilHoe");
         
         itemInfectionStaff = new ItemCorruptionStaffs(5099).setUnlocalizedName("infectionStaff");
         
         //Adding names for items and blocks, setting block harvest levels
         LanguageRegistry.addName(itemEvilSword, "Sword of the Tyrant");
    	 LanguageRegistry.addName(itemBattleaxe, "Treebane Axe");
    	 LanguageRegistry.addName(itemEvilPick, "Underworld Pick");
    	 LanguageRegistry.addName(itemEvilShovel, "Gravedigger's Shovel");
    	 LanguageRegistry.addName(itemEvilHoe, "Reaper's Scythe");
    	 
         LanguageRegistry.addName(itemInfectionStaff, "Staff of Infection");
    	 
         LanguageRegistry.addName(itemIngotEvil, "Evilium Ingot");
         
         LanguageRegistry.addName(taintedDirt, "Tainted Dirt");
         MinecraftForge.setBlockHarvestLevel(taintedDirt, "shovel", 1);
         GameRegistry.registerBlock(taintedDirt, "taintedDirt");
         
         LanguageRegistry.addName(eviliumOre, "Evilium Ore");
         MinecraftForge.setBlockHarvestLevel(eviliumOre, "pick", 2);
         GameRegistry.registerBlock(eviliumOre, "eviliumOre");
         
         
         //Adding Armor and registering armor names      
         itemEvilHelmet = new EvilArmor(5003, EnumArmorMaterial.IRON, proxy.addArmor("Overlord"), 0)
         .setUnlocalizedName("OverlordHelm");
         itemEvilChest = new EvilArmor(5004, EnumArmorMaterial.IRON, proxy.addArmor("Overlord"), 1)
         .setUnlocalizedName("OverlordChestplate");
         itemEvilLegs = new EvilArmor(5005, EnumArmorMaterial.IRON, proxy.addArmor("Overlord"), 2)
         .setUnlocalizedName("OverlordLegs");
         itemEvilBoots = new EvilArmor(5006, EnumArmorMaterial.IRON, proxy.addArmor("Overlord"), 3)
         .setUnlocalizedName("OverlordBoots");
         
         LanguageRegistry.addName(itemEvilHelmet, "Helm of the Overlord");
         LanguageRegistry.addName(itemEvilChest, "Chestplate of the Overlord");
         LanguageRegistry.addName(itemEvilLegs, "Greaves of the Overlord");
         LanguageRegistry.addName(itemEvilBoots, "Boots of the Overlord");

                  
         //Crafting Recipes (plus Smelting)
         GameRegistry.addSmelting(501, eviliumIngotStack, 0.8f);
        
         //tool recipes
         GameRegistry.addRecipe(new ItemStack(itemEvilSword), " x ", " x ", " y ",
        		 'x', eviliumIngotStack, 'y', stickStack);
         GameRegistry.addRecipe(new ItemStack(itemBattleaxe), "xx ", "xy ", " y ",
        		 'x', eviliumIngotStack, 'y', stickStack);
         GameRegistry.addRecipe(new ItemStack(itemEvilPick), "xxx", " y ", " y ",
        		 'x', eviliumIngotStack, 'y', stickStack);
         GameRegistry.addRecipe(new ItemStack (itemEvilShovel), " x ", " y ", " y ",
        		 'x', eviliumIngotStack, 'y', stickStack);
         GameRegistry.addRecipe(new ItemStack(itemEvilHoe), "xx ", " y ", " y ",
        		 'x', eviliumIngotStack, 'y', stickStack);
         
         //armor recipes
         GameRegistry.addRecipe(new ItemStack(itemEvilHelmet), "xyx", "x x",
        		 'x', ironIngotStack, 'y', eviliumIngotStack);     
         GameRegistry.addRecipe(new ItemStack(itemEvilChest), "x x", "xyx", "xxx",
        		 'x', ironIngotStack, 'y', eviliumIngotStack);
         GameRegistry.addRecipe(new ItemStack(itemEvilLegs), "xyx", "x x", "x x",
        		 'x', ironIngotStack, 'y', eviliumIngotStack);
         GameRegistry.addRecipe(new ItemStack(itemEvilBoots), "y y", "x x",
        		 'x', ironIngotStack, 'y', eviliumIngotStack);
         GameRegistry.addRecipe(new ItemStack(itemInfectionStaff), "  z", " y ", "x  ",
        		 'x', stickStack, 'y', eviliumIngotStack, 'z', diamondStack);
    }
    
    
	@PostInit
    public void postInit(FMLPostInitializationEvent event) {
            // Stub Method
    }

}
