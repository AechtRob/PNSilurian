
package net.pnsilurian.world.biome.silurian;

import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.block.BlockAlgalReef;
import net.lepidodendron.block.BlockStromatoporoideaReef;
import net.lepidodendron.util.EnumBiomeTypeSilurian;
import net.lepidodendron.world.biome.silurian.BiomeSilurian;
import net.lepidodendron.world.gen.WorldGenReef;
import net.lepidodendron.world.gen.WorldGenStromatoliteReefCambrian;
import net.lepidodendron.world.gen.WorldGenThrombolite;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;

@ElementsLepidodendronMod.ModElement.Tag
public class BiomeSilurianReef extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:silurian_reef")
	public static final BiomeGenCustom biome = null;
	public BiomeSilurianReef(ElementsLepidodendronMod instance) {
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
	}

	static class BiomeGenCustom extends BiomeSilurian {
		public BiomeGenCustom() {
			super(new BiomeProperties("Silurian Stromatoporoidea Reef").setRainfall(0.9F).setBaseHeight(-0.85F).setHeightVariation(0.15F).setTemperature(2.25F));
			setRegistryName("lepidodendron:silurian_reef");
			topBlock = Blocks.GRAVEL.getDefaultState();
			fillerBlock = Blocks.STONE.getStateFromMeta(0);
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

		protected static final WorldGenStromatoliteReefCambrian REEF_GENERATOR_STROMATOLITE = new WorldGenStromatoliteReefCambrian();
		protected static final WorldGenReef REEF_GENERATOR = new WorldGenReef();

		public WorldGenAbstractTree getRandomTreeFeature(Random rand)
	    {
	        return null;
	    }

		@Override
	    public void decorate(World worldIn, Random rand, BlockPos pos)
	    {

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.CLAY)) {
				for (int i = 0; i < 4; ++i) {
					int radius = 6;
					int j;
					int k;
					if (radius < 14) {
						j = 16 + rand.nextInt(16 - radius - 2) - rand.nextInt(16 - radius - 2);
						k = 16 + rand.nextInt(16 - radius - 2) - rand.nextInt(16 - radius - 2);
					}
					else {
						radius = 14;
						j = 16;
						k = 16;
					}
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					BlockPos pos1 = pos.add(j, l, k);
					if (
							(pos1.getY() < worldIn.getSeaLevel())
					) {
						REEF_GENERATOR_STROMATOLITE.generate(worldIn, rand, pos1, radius);
					}
				}
			}

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.ROCK))
			for (int i = 0; i < 8; ++i)
			{
				int radius = 10;
				int j;
				int k;
				if (radius < 14) {
					j = 16 + rand.nextInt(16 - radius - 2) - rand.nextInt(16 - radius - 2);
					k = 16 + rand.nextInt(16 - radius - 2) - rand.nextInt(16 - radius - 2);
				}
				else {
					radius = 14;
					j = 16;
					k = 16;
				}
				int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
				BlockPos pos1 = pos.add(j, l, k);
				if (
						(pos1.getY() < worldIn.getSeaLevel())
				) {
					REEF_GENERATOR.generate(worldIn, rand, pos1, radius, BlockStromatoporoideaReef.block.getDefaultState());
				}
			}


			super.decorate(worldIn, rand, pos);
	    }

		@Override
		public EnumBiomeTypeSilurian getBiomeType() {
			return EnumBiomeTypeSilurian.Reef;
		}

	}
}
