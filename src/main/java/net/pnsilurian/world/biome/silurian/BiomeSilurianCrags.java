
package net.pnsilurian.world.biome.silurian;

import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.util.EnumBiomeTypeSilurian;
import net.lepidodendron.world.biome.silurian.BiomeSilurian;
import net.lepidodendron.world.gen.WorldGenIceOnSea;
import net.lepidodendron.world.gen.WorldGenSnow;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;

@ElementsLepidodendronMod.ModElement.Tag
public class BiomeSilurianCrags extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:silurian_crags")
	public static final BiomeGenCustom biome = null;
	public BiomeSilurianCrags(ElementsLepidodendronMod instance) {
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
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.MOUNTAIN);
	}

	static class BiomeGenCustom extends BiomeSilurian {
		public BiomeGenCustom() {
			super(new BiomeProperties("Silurian Hilly Wastes").setRainfall(0.4F).setBaseHeight(2.75F).setHeightVariation(0.4F).setTemperature(2.25F));
			setRegistryName("lepidodendron:silurian_crags");
			topBlock = Blocks.STONE.getStateFromMeta(0);//Handled in chunk provider
			fillerBlock = Blocks.STONE.getStateFromMeta(0);//Handled in chunk provider
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

		public WorldGenAbstractTree getRandomTreeFeature(Random rand)
	    {
	        return null;
	    }


		@Override
	    public void decorate(World worldIn, Random rand, BlockPos pos)
	    {


			super.decorate(worldIn, rand, pos);
	    }

		@Override
		public EnumBiomeTypeSilurian getBiomeType() {
			return EnumBiomeTypeSilurian.BarrenLand;
		}

	}
}
