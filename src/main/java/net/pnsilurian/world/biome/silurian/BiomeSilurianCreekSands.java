
package net.pnsilurian.world.biome.silurian;

import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.block.BlockCoarseSandyDirt;
import net.lepidodendron.block.BlockNematophyta;
import net.lepidodendron.block.BlockStoneScoria;
import net.lepidodendron.util.EnumBiomeTypeSilurian;
import net.lepidodendron.world.biome.silurian.BiomeSilurian;
import net.lepidodendron.world.gen.WorldGenBlackSandyDirt;
import net.lepidodendron.world.gen.WorldGenRedSandyDirt;
import net.lepidodendron.world.gen.WorldGenRockPiles;
import net.lepidodendron.world.gen.WorldGenSinglePlantOptionalWater;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;

@ElementsLepidodendronMod.ModElement.Tag
public class BiomeSilurianCreekSands extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:silurian_creek_sands")
	public static final BiomeGenCustom biome = null;
	public BiomeSilurianCreekSands(ElementsLepidodendronMod instance) {
		super(instance, 1591);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new BiomeGenCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.WASTELAND);
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.DEAD);
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.SANDY);
	}

	static class BiomeGenCustom extends BiomeSilurian {
		public BiomeGenCustom() {
			super(new BiomeProperties("Silurian Sands Creek").setRainfall(0.5F).setBaseHeight(0.0F).setHeightVariation(0.0F).setTemperature(2.25F));
			setRegistryName("lepidodendron:silurian_creek_sands");
			topBlock = BlockCoarseSandyDirt.block.getDefaultState();
			fillerBlock = BlockStoneScoria.block.getDefaultState();
			decorator.treesPerChunk = -999;
			decorator.flowersPerChunk = 0;
			decorator.grassPerChunk = 0;
			decorator.mushroomsPerChunk = 0;
			decorator.bigMushroomsPerChunk = 0;
			decorator.reedsPerChunk = 0;
			decorator.cactiPerChunk = 0;
			decorator.sandPatchesPerChunk = 0;
			decorator.gravelPatchesPerChunk = 0;
			this.spawnableMonsterList.clear();
			this.spawnableCreatureList.clear();
			this.spawnableWaterCreatureList.clear();
			this.spawnableCaveCreatureList.clear();
		}

		protected static final WorldGenRockPiles ROCK_PILES_GENERATOR = new WorldGenRockPiles();
		//protected static final WorldGenNematophyta NEMATOPHYTA_GENERATOR = new WorldGenNematophyta();
		protected static final WorldGenSinglePlantOptionalWater PLANT_GENERATOR = new WorldGenSinglePlantOptionalWater();
		protected static final WorldGenRedSandyDirt RED_GENERATOR = new WorldGenRedSandyDirt();
		protected static final WorldGenBlackSandyDirt BLACK_GENERATOR = new WorldGenBlackSandyDirt();

		public WorldGenAbstractTree getRandomTreeFeature(Random rand)
	    {
	        return null;
	    }

		@Override
	    public void decorate(World worldIn, Random rand, BlockPos pos)
	    {

	        if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.ROCK))
	        {
	        	int i = rand.nextInt(2);
	            for (int j = 0; j < i; ++j)
	            {
	                int k = rand.nextInt(16) + 8;
	                int l = rand.nextInt(16) + 8;
	                BlockPos blockpos = worldIn.getHeight(pos.add(k, 0, l));
	                ROCK_PILES_GENERATOR.generate(worldIn, rand, blockpos);
	            }
	        }

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.ROCK))
			{
				int i = rand.nextInt(8);
				for (int j = 0; j < i; ++j)
				{
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(16) + 8;
					BlockPos blockpos = worldIn.getHeight(pos.add(k, 0, l));
					RED_GENERATOR.generate(worldIn, rand, blockpos);
				}
			}

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.ROCK))
			{
				int i = rand.nextInt(2);
				for (int j = 0; j < i; ++j)
				{
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(16) + 8;
					BlockPos blockpos = worldIn.getHeight(pos.add(k, 0, l));
					BLACK_GENERATOR.generate(worldIn, rand, blockpos);
				}
			}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 20; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					PLANT_GENERATOR.generate(BlockNematophyta.block.getDefaultState().withProperty(BlockNematophyta.BlockCustom.FACING, EnumFacing.UP), worldIn, rand, pos.add(j, l, k));
				}

	        super.decorate(worldIn, rand, pos);
		}

		@Override
		public EnumBiomeTypeSilurian getBiomeType() {
			return EnumBiomeTypeSilurian.Sands;
		}
	}

}
