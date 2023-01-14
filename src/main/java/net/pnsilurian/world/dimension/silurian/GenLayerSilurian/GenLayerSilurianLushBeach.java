package net.pnsilurian.world.dimension.silurian.GenLayerSilurian;

//import net.lepidodendron.world.biome.devonian.
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerSilurianLushBeach extends GenLayer
{

    public Biome SILURIAN_OCEAN_SHALLOW = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_sea_shore"));
    public int SILURIAN_OCEAN_SHALLOW_ID =  Biome.getIdForBiome(SILURIAN_OCEAN_SHALLOW);
    public Biome SILURIAN_OCEAN_SHALLOW_HELPER = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_sea_shore_helper"));
    public int SILURIAN_OCEAN_SHALLOW_HELPER_ID =  Biome.getIdForBiome(SILURIAN_OCEAN_SHALLOW_HELPER);
    public Biome SILURIAN_OCEAN_SANDY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_sea_sandy"));
    public int SILURIAN_OCEAN_SANDY_ID =  Biome.getIdForBiome(SILURIAN_OCEAN_SANDY);
    public Biome SILURIAN_OCEAN_ROCKY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_sea"));
    public int SILURIAN_SILURIAN_OCEAN_ROCKY_ID =  Biome.getIdForBiome(SILURIAN_OCEAN_ROCKY);

    public Biome SILURIAN_LAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_land"));
    public int SILURIAN_LAND_ID =  Biome.getIdForBiome(SILURIAN_LAND);

    public Biome SILURIAN_LUSH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:lush_patch"));
    public int SILURIAN_LUSH_ID =  Biome.getIdForBiome(SILURIAN_LUSH);

    private final int LandBiomes[] = new int[] {
            SILURIAN_LAND_ID,
            SILURIAN_LAND_ID,
            SILURIAN_LAND_ID,
            SILURIAN_LAND_ID,
            SILURIAN_LAND_ID,
            SILURIAN_LUSH_ID
    };

    public GenLayerSilurianLushBeach(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight)
    {
        int[] aint = this.parent.getInts(areaX - 1, areaY - 1, areaWidth + 2, areaHeight + 2);
        int[] aint1 = IntCache.getIntCache(areaWidth * areaHeight);

        for (int i = 0; i < areaHeight; ++i)
        {
            for (int j = 0; j < areaWidth; ++j)
            {
                this.initChunkSeed((long)(j + areaX), (long)(i + areaY));
                int k = aint[j + 1 + (i + 1) * (areaWidth + 2)];
                Biome biome = Biome.getBiome(k);

                if (k == SILURIAN_LAND_ID)
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if (!isOcean(l1) && !isOcean(k2) && !isOcean(j3) && !isOcean(i4))
                    {
                        aint1[j + i * areaWidth] = k;
                    }
                    else
                    {
                        aint1[j + i * areaWidth] = LandBiomes[nextInt(LandBiomes.length)];
                    }
                }
                else
                {
                    aint1[j + i * areaWidth] = k;
                }
            }
        }

        return aint1;
    }

    private boolean isOcean(int biomeID) {
        if (biomeID == SILURIAN_OCEAN_SHALLOW_ID || biomeID == SILURIAN_OCEAN_SANDY_ID
                || biomeID == SILURIAN_SILURIAN_OCEAN_ROCKY_ID || biomeID == SILURIAN_OCEAN_SHALLOW_HELPER_ID) {
            return true;
        }
        return false;
    }

}
