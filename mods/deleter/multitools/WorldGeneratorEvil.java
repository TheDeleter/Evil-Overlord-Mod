package mods.deleter.multitools;

import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGeneratorEvil implements IWorldGenerator{

	//this sets up the world generation with the generate function
	// -1 is the Nether/Hell, 0 is the Overworld, 1 is The End dimension
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		switch(world.provider.dimensionId){
		case -1:
			generateNether(world, random, chunkX * 16, chunkZ * 16);
			break;
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
			break;
		case 1:
			generateEnd(world, random, chunkX * 16, chunkZ * 16);
			break;
		}
		// TODO Auto-generated method stub
		
	}
	//each generate function here dictates where and how the ore spawns. WorldGenMinable then defines the ore to spawn.
	//I think a new WorldGenMinable can be added for each new ore, but a new private void generation would have to be made if
	//the ore had different spawning rules.
	private void generateEnd(World world, Random random, int i, int j) {}
		// TODO Auto-generated method stub

	private void generateSurface(World world, Random random, int i, int j) {
		for(int k = 0; k < 5; k++){
		int eviloreXCoord = i + random.nextInt(16);
		int eviloreYCoord = random.nextInt(64);
		int eviloreZCoord = j + random.nextInt(16);
		
		(new WorldGenMinable(Multitools.eviliumOre.blockID, 4)).generate(world, random, eviloreXCoord, eviloreYCoord, eviloreZCoord);
		}
	}

	private void generateNether(World world, Random random, int i, int j) {}
		// TODO Auto-generated method stub

}
