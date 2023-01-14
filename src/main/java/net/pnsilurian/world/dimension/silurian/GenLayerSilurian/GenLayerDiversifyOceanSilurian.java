package net.pnsilurian.world.dimension.silurian.GenLayerSilurian;

import net.lepidodendron.util.EnumBiomeTypeCambrian;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pnsilurian.world.biome.silurian.BiomeSilurianSeaShore;
import net.pnsilurian.world.biome.silurian.BiomeSilurianSeaShoreHelper;

public class GenLayerDiversifyOceanSilurian extends GenLayer {

    public Biome SILURIAN_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_sea_shore"));
    public int SILURIAN_OCEAN_ID =  Biome.getIdForBiome(SILURIAN_OCEAN);
    public Biome SILURIAN_OCEAN_HELPER = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_sea_shore_helper"));
    public int SILURIAN_OCEAN_HELPER_ID =  Biome.getIdForBiome(SILURIAN_OCEAN_HELPER);
    public Biome SILURIAN_REEF = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_reef"));
    public int SILURIAN_REEF_ID =  Biome.getIdForBiome(SILURIAN_REEF);
    public Biome SILURIAN_GARDEN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_sea_garden"));
    public int SILURIAN_GARDEN_ID =  Biome.getIdForBiome(SILURIAN_GARDEN);

    private final int SilurianSeaRockyBiomes[] = new int[] {
            SILURIAN_OCEAN_ID,
            SILURIAN_OCEAN_ID,
            SILURIAN_OCEAN_ID,
            SILURIAN_REEF_ID,
            SILURIAN_GARDEN_ID
    };

    private final int SilurianSeaSandyBiomes[] = new int[] {
            SILURIAN_OCEAN_HELPER_ID,
            SILURIAN_OCEAN_HELPER_ID,
            SILURIAN_OCEAN_HELPER_ID,
            SILURIAN_REEF_ID,
            SILURIAN_GARDEN_ID
    };

    public GenLayerDiversifyOceanSilurian(long seed, GenLayer genlayer) {
        super(seed);
        this.parent = genlayer;
    }

    @Override
    public int[] getInts(int x, int z, int width, int height) {
        return diversify(x, z, width, height);
    }

    private int[] diversify(int x, int z, int width, int height) {
        int input[] = this.parent.getInts(x, z, width, height);
        int output[] = IntCache.getIntCache(width * height);
        EnumBiomeTypeCambrian type;
        for (int zOut = 0; zOut < height; zOut++) {
            for (int xOut = 0; xOut < width; xOut++) {
                int i = xOut + zOut * width;
                int center = input[i];
                initChunkSeed(xOut + x, zOut + z);
                if (nextInt(2) == 0) {
                    if (Biome.getBiome(center) == BiomeSilurianSeaShore.biome) {
                        output[i] = SilurianSeaRockyBiomes[nextInt(SilurianSeaRockyBiomes.length)];
                    }
                    else if (Biome.getBiome(center) == BiomeSilurianSeaShoreHelper.biome) {
                        output[i] = SilurianSeaSandyBiomes[nextInt(SilurianSeaSandyBiomes.length)];
                    }
                    else output[i] = center;
                } else output[i] = center;
            }
        }
        return output;
    }

}