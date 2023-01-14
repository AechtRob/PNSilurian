package net.pnsilurian.world.dimension.silurian.GenLayerSilurian;

import net.lepidodendron.util.EnumBiomeTypeDevonian;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pnsilurian.world.biome.silurian.BiomeSilurianBeach;
import net.pnsilurian.world.biome.silurian.BiomeSilurianLagoon;
import net.pnsilurian.world.biome.silurian.BiomeSilurianLand;

public class GenLayerLushPatchSilurian extends GenLayer {

    public Biome SILURIAN_LAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_land"));
    public int SILURIAN_LAND_ID =  Biome.getIdForBiome(SILURIAN_LAND);
    public Biome SILURIAN_LUSH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_lush_patch"));
    public int SILURIAN_LUSH_ID =  Biome.getIdForBiome(SILURIAN_LUSH);
    public Biome SILURIAN_BEACH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_beach"));
    public int SILURIAN_BEACH_ID =  Biome.getIdForBiome(SILURIAN_BEACH);
    public Biome SILURIAN_LAGOON = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_lagoon"));
    public int SILURIAN_LAGOON_ID =  Biome.getIdForBiome(SILURIAN_LAGOON);

    private final int LandBiomes[] = new int[] {
            SILURIAN_LAND_ID,
            SILURIAN_LAND_ID,
            SILURIAN_LAND_ID,
            SILURIAN_LUSH_ID
    };

    private final int LagoonBiomes[] = new int[] {
            SILURIAN_LAGOON_ID,
            SILURIAN_LAGOON_ID,
            SILURIAN_LAGOON_ID,
            SILURIAN_LUSH_ID
    };

    private final int BeachBiomes[] = new int[] {
            SILURIAN_BEACH_ID,
            SILURIAN_BEACH_ID,
            SILURIAN_BEACH_ID,
            SILURIAN_LUSH_ID
    };

    public GenLayerLushPatchSilurian(long seed, GenLayer genlayer) {
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
        EnumBiomeTypeDevonian type;
        for (int zOut = 0; zOut < height; zOut++) {
            for (int xOut = 0; xOut < width; xOut++) {
                int i = xOut + zOut * width;
                int center = input[i];
                initChunkSeed(xOut + x, zOut + z);
                if (nextInt(2) == 0) {
                    if (Biome.getBiome(center) == BiomeSilurianLand.biome) {
                        output[i] = LandBiomes[nextInt(LandBiomes.length)];
                    }
                    if (Biome.getBiome(center) == BiomeSilurianLagoon.biome) {
                        output[i] = LagoonBiomes[nextInt(LagoonBiomes.length)];
                    }
                    if (Biome.getBiome(center) == BiomeSilurianBeach.biome) {
                        output[i] = BeachBiomes[nextInt(BeachBiomes.length)];
                    }
                    else output[i] = center;
                } else output[i] = center;
            }
        }
        return output;
    }

}