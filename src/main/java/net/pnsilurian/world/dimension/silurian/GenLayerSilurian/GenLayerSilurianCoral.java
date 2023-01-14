package net.pnsilurian.world.dimension.silurian.GenLayerSilurian;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pnsilurian.world.biome.silurian.BiomeSilurianSeaRocky;
import net.pnsilurian.world.biome.silurian.BiomeSilurianSeaSandy;

public class GenLayerSilurianCoral extends GenLayer
{

    public Biome SILURIAN_CORAL = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_coral"));
    public int SILURIAN_CORAL_ID =  Biome.getIdForBiome(SILURIAN_CORAL);

    public GenLayerSilurianCoral(long seed, GenLayer genLayer)
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
                if (nextInt(10) == 0) {
                    if (Biome.getBiome(center) == BiomeSilurianSeaRocky.biome || Biome.getBiome(center) == BiomeSilurianSeaSandy.biome) {
                        output[i] = SILURIAN_CORAL_ID;
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
