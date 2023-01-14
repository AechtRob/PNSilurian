
package net.pnsilurian.world.biome.silurian;

import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.block.*;
import net.lepidodendron.util.EnumBiomeTypeSilurian;
import net.lepidodendron.world.biome.silurian.BiomeSilurian;
import net.lepidodendron.world.gen.*;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;

@ElementsLepidodendronMod.ModElement.Tag
public class BiomeSilurianCoral extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:silurian_coral")
	public static final BiomeGenCustom biome = null;
	public BiomeSilurianCoral(ElementsLepidodendronMod instance) {
		super(instance, 1591);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new BiomeGenCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.OCEAN);
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.WATER);
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.LUSH);
	}

	static class BiomeGenCustom extends BiomeSilurian {
		public BiomeGenCustom() {
			super(new BiomeProperties("Silurian Coral Cleft").setRainfall(0.5F).setBaseHeight(-1.899F).setHeightVariation(0.25F).setTemperature(2.25F));
			setRegistryName("lepidodendron:silurian_coral");
			topBlock = Blocks.SAND.getStateFromMeta(0);
			fillerBlock = Blocks.GRAVEL.getDefaultState();
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

    	protected static final WorldGenReef REEF_GENERATOR_CORAL = new WorldGenReef();
		protected static final WorldGenReef REEF_GENERATOR_BRYOZOAN = new WorldGenReef();
		protected static final WorldGenReef REEF_GENERATOR_TABULATA_1 = new WorldGenReef();
		protected static final WorldGenReef REEF_GENERATOR_TABULATA_2 = new WorldGenReef();
		protected static final WorldGenReef REEF_GENERATOR_TABULATA_3 = new WorldGenReef();

		public WorldGenAbstractTree getRandomTreeFeature(Random rand)
	    {
	        return null;
	    }

		@Override
	    public void decorate(World worldIn, Random rand, BlockPos pos) {

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.ROCK))
				for (int i = 0; i < 12; ++i) {
					int radius = 4;
					int j;
					int k;
					if (radius < 14) {
						j = 16 + rand.nextInt(16 - radius - 2) - rand.nextInt(16 - radius - 2);
						k = 16 + rand.nextInt(16 - radius - 2) - rand.nextInt(16 - radius - 2);
					} else {
						radius = 14;
						j = 16;
						k = 16;
					}
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					BlockPos pos1 = pos.add(j, l, k);
					if (
							(pos1.getY() < worldIn.getSeaLevel())
					) {
						REEF_GENERATOR_CORAL.generate(worldIn, rand, pos1, radius, BlockCoral.block.getDefaultState());
					}
				}

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.ROCK))
				for (int i = 0; i < 12; ++i) {
					int radius = 2;
					int j;
					int k;
					if (radius < 14) {
						j = 16 + rand.nextInt(16 - radius - 2) - rand.nextInt(16 - radius - 2);
						k = 16 + rand.nextInt(16 - radius - 2) - rand.nextInt(16 - radius - 2);
					} else {
						radius = 14;
						j = 16;
						k = 16;
					}
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					BlockPos pos1 = pos.add(j, l, k);
					if (
							(pos1.getY() < worldIn.getSeaLevel())
					) {
						REEF_GENERATOR_BRYOZOAN.generate(worldIn, rand, pos1, radius, BlockBryozoanReef.block.getDefaultState());
					}
				}

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.ROCK))
				for (int i = 0; i < 6; ++i) {
					int radius = 10;
					int j;
					int k;
					if (radius < 14) {
						j = 16 + rand.nextInt(16 - radius - 2) - rand.nextInt(16 - radius - 2);
						k = 16 + rand.nextInt(16 - radius - 2) - rand.nextInt(16 - radius - 2);
					} else {
						radius = 14;
						j = 16;
						k = 16;
					}
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					BlockPos pos1 = pos.add(j, l, k);
					if (
							(pos1.getY() < worldIn.getSeaLevel())
					) {
						REEF_GENERATOR_TABULATA_1.generate(worldIn, rand, pos1, radius, BlockTabulata_Block1.block.getDefaultState());
					}
				}

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.ROCK))
				for (int i = 0; i < 6; ++i) {
					int radius = 10;
					int j;
					int k;
					if (radius < 14) {
						j = 16 + rand.nextInt(16 - radius - 2) - rand.nextInt(16 - radius - 2);
						k = 16 + rand.nextInt(16 - radius - 2) - rand.nextInt(16 - radius - 2);
					} else {
						radius = 14;
						j = 16;
						k = 16;
					}
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					BlockPos pos1 = pos.add(j, l, k);
					if (
							(pos1.getY() < worldIn.getSeaLevel())
					) {
						REEF_GENERATOR_TABULATA_2.generate(worldIn, rand, pos1, radius, BlockTabulata_Block2.block.getDefaultState());
					}
				}

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.ROCK))
				for (int i = 0; i < 6; ++i) {
					int radius = 10;
					int j;
					int k;
					if (radius < 14) {
						j = 16 + rand.nextInt(16 - radius - 2) - rand.nextInt(16 - radius - 2);
						k = 16 + rand.nextInt(16 - radius - 2) - rand.nextInt(16 - radius - 2);
					} else {
						radius = 14;
						j = 16;
						k = 16;
					}
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					BlockPos pos1 = pos.add(j, l, k);
					if (
							(pos1.getY() < worldIn.getSeaLevel())
					) {
						REEF_GENERATOR_TABULATA_3.generate(worldIn, rand, pos1, radius, BlockTabulata_Block3.block.getDefaultState());
					}
				}

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.ROCK))
				for (int i = 0; i < 10; ++i) {
					int radius = 2;
					int j;
					int k;
					if (radius < 14) {
						j = 16 + rand.nextInt(16 - radius - 2) - rand.nextInt(16 - radius - 2);
						k = 16 + rand.nextInt(16 - radius - 2) - rand.nextInt(16 - radius - 2);
					} else {
						radius = 14;
						j = 16;
						k = 16;
					}
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					BlockPos pos1 = pos.add(j, l, k);
					if (
							(pos1.getY() < worldIn.getSeaLevel())
					) {
						REEF_GENERATOR_TABULATA_1.generate(worldIn, rand, pos1, radius, BlockTabulata_Block1.block.getDefaultState());
					}
				}

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.ROCK))
				for (int i = 0; i < 10; ++i) {
					int radius = 2;
					int j;
					int k;
					if (radius < 14) {
						j = 16 + rand.nextInt(16 - radius - 2) - rand.nextInt(16 - radius - 2);
						k = 16 + rand.nextInt(16 - radius - 2) - rand.nextInt(16 - radius - 2);
					} else {
						radius = 14;
						j = 16;
						k = 16;
					}
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					BlockPos pos1 = pos.add(j, l, k);
					if (
							(pos1.getY() < worldIn.getSeaLevel())
					) {
						REEF_GENERATOR_TABULATA_2.generate(worldIn, rand, pos1, radius, BlockTabulata_Block2.block.getDefaultState());
					}
				}

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.ROCK))
				for (int i = 0; i < 10; ++i) {
					int radius = 2;
					int j;
					int k;
					if (radius < 14) {
						j = 16 + rand.nextInt(16 - radius - 2) - rand.nextInt(16 - radius - 2);
						k = 16 + rand.nextInt(16 - radius - 2) - rand.nextInt(16 - radius - 2);
					} else {
						radius = 14;
						j = 16;
						k = 16;
					}
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					BlockPos pos1 = pos.add(j, l, k);
					if (
							(pos1.getY() < worldIn.getSeaLevel())
					) {
						REEF_GENERATOR_TABULATA_3.generate(worldIn, rand, pos1, radius, BlockTabulata_Block3.block.getDefaultState());
					}
				}

		super.decorate(worldIn, rand, pos);

		}

		@Override
		public EnumBiomeTypeSilurian getBiomeType() {
			return EnumBiomeTypeSilurian.Coral;
		}
	}

}
