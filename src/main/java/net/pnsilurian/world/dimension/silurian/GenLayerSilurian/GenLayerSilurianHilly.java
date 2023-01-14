package net.pnsilurian.world.dimension.silurian.GenLayerSilurian;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerSilurianHilly extends GenLayer
{

    public Biome SILURIAN_HILLS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_hills"));
    public int SILURIAN_HILLS_ID =  Biome.getIdForBiome(SILURIAN_HILLS);
    public Biome SILURIAN_LAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_land"));
    public int SILURIAN_LAND_ID =  Biome.getIdForBiome(SILURIAN_LAND);

    private final int HillsBiomes[] = new int[] {
            SILURIAN_LAND_ID,
            SILURIAN_LAND_ID,
            SILURIAN_LAND_ID,
            SILURIAN_HILLS_ID
    };

    public GenLayerSilurianHilly(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight)
    {int[] aint = this.parent.getInts(areaX - 1, areaY - 1, areaWidth + 2, areaHeight + 2);
        int[] aint1 = IntCache.getIntCache(areaWidth * areaHeight);

        for (int i = 0; i < areaHeight; ++i)
        {
            for (int j = 0; j < areaWidth; ++j)
            {
                this.initChunkSeed((long)(j + areaX), (long)(i + areaY));
                int k = aint[j + 1 + (i + 1) * (areaWidth + 2)];

                if (k == SILURIAN_LAND_ID)
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];
                    boolean flag = (
                        (l1 == SILURIAN_LAND_ID)
                        && (k2 == SILURIAN_LAND_ID)
                        && (j3 == SILURIAN_LAND_ID)
                        && (i4 == SILURIAN_LAND_ID)
                    );
                    if (flag)
                    {
                        aint1[j + i * areaWidth] = HillsBiomes[nextInt(HillsBiomes.length)];
                    }
                    else {
                        aint1[j + i * areaWidth] = k;
                    }
                }
                else {
                    aint1[j + i * areaWidth] = k;
                }
            }
        }

        return aint1;
    }
    
}
