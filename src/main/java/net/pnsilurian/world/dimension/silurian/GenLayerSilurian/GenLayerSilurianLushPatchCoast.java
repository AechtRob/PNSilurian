package net.pnsilurian.world.dimension.silurian.GenLayerSilurian;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pnsilurian.world.biome.silurian.*;

public class GenLayerSilurianLushPatchCoast extends GenLayer
{

    public Biome SILURIAN_LUSH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_lush_patch"));
    public int SILURIAN_LUSH_ID =  Biome.getIdForBiome(SILURIAN_LUSH);

    public GenLayerSilurianLushPatchCoast(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    @Override
    public int[] getInts(int x, int z, int width, int height) {
        return diversify(x, z, width, height);
    }

    private int[] diversify(int x, int z, int width, int height) {
        int input[] = this.parent.getInts(x, z, width, height);
        int output[] = IntCache.getIntCache(width * height);
        for (int zOut = 0; zOut < height; zOut++) {
            for (int xOut = 0; xOut < width; xOut++) {
                int i = xOut + zOut * width;
                int center = input[i];
                initChunkSeed(xOut + x, zOut + z);
                if (nextInt(12) == 0) {
                    if (Biome.getBiome(center) == BiomeSilurianBeach.biome
                            || Biome.getBiome(center) == BiomeSilurianLagoon.biome) {
                        output[i] = SILURIAN_LUSH_ID;
                    } else {
                        output[i] = center;
                    }
                } else {
                    output[i] = center;
                }
            }
        }
        return output;
    }

}
