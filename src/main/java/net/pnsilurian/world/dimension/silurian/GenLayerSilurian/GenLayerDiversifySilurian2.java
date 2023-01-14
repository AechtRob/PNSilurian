package net.pnsilurian.world.dimension.silurian.GenLayerSilurian;

import net.lepidodendron.util.EnumBiomeTypeSilurian;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pnsilurian.world.biome.silurian.BiomeSilurianLand;

public class GenLayerDiversifySilurian2 extends GenLayer {

    public Biome SILURIAN_SAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_sands"));
    public int SILURIAN_SAND_ID = Biome.getIdForBiome(SILURIAN_SAND);
    public Biome SILURIAN_BARREN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_land"));
    public int SILURIAN_BARREN_ID = Biome.getIdForBiome(SILURIAN_BARREN);
    public Biome SILURIAN_COOKSONIA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_cooksonia"));
    public int SILURIAN_COOKSONIA_ID = Biome.getIdForBiome(SILURIAN_COOKSONIA);


    private final int SilurianLandBiomes[] = new int[] {
            SILURIAN_BARREN_ID,
            SILURIAN_BARREN_ID,
            SILURIAN_SAND_ID,
            SILURIAN_COOKSONIA_ID
    };

    public GenLayerDiversifySilurian2(long seed, GenLayer genlayer) {
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
        EnumBiomeTypeSilurian type;
        for (int zOut = 0; zOut < height; zOut++) {
            for (int xOut = 0; xOut < width; xOut++) {
                int i = xOut + zOut * width;
                int center = input[i];
                initChunkSeed(xOut + x, zOut + z);
                if (nextInt(2) == 0) {
                    if (Biome.getBiome(center) == BiomeSilurianLand.biome)
                        output[i] = SilurianLandBiomes[nextInt(SilurianLandBiomes.length)];
                    else output[i] = center;
                } else output[i] = center;
            }
        }
        return output;
    }

}