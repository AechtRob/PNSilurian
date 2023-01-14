package net.pnsilurian.world.dimension.silurian.GenLayerSilurian;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerSilurianEstuary2 extends GenLayer
{

    public Biome SILURIAN_OCEAN_ROCKY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_sea"));
    public int SILURIAN_OCEAN_ROCKY_ID =  Biome.getIdForBiome(SILURIAN_OCEAN_ROCKY);
    public Biome SILURIAN_OCEAN_SHORE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_sea_shore"));
    public int SILURIAN_OCEAN_SHORE_ID =  Biome.getIdForBiome(SILURIAN_OCEAN_SHORE);
    public Biome SILURIAN_OCEAN_SHORE_HELPER = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_sea_shore_helper"));
    public int SILURIAN_OCEAN_SHORE_HELPER_ID =  Biome.getIdForBiome(SILURIAN_OCEAN_SHORE_HELPER);
    public Biome SILURIAN_OCEAN_SANDY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_sea_sandy"));
    public int SILURIAN_OCEAN_SANDY_ID =  Biome.getIdForBiome(SILURIAN_OCEAN_SANDY);
    public Biome SILURIAN_OCEAN_GARDEN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_sea_garden"));
    public int SILURIAN_OCEAN_GARDEN_ID =  Biome.getIdForBiome(SILURIAN_OCEAN_GARDEN);
    public Biome SILURIAN_OCEAN_CORAL = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_coral"));
    public int SILURIAN_OCEAN_CORAL_ID =  Biome.getIdForBiome(SILURIAN_OCEAN_CORAL);
    public Biome SILURIAN_REEF = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_reef"));
    public int SILURIAN_REEF_ID =  Biome.getIdForBiome(SILURIAN_REEF);
    
    public Biome SILURIAN_ESTUARY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_lagoon"));
    public int SILURIAN_ESTUARY_ID =  Biome.getIdForBiome(SILURIAN_ESTUARY);
    public Biome SILURIAN_ESTUARY_HELPER = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_lagoon_helper"));
    public int SILURIAN_ESTUARY_HELPER_ID =  Biome.getIdForBiome(SILURIAN_ESTUARY_HELPER);

    public Biome SILURIAN_BEACH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_beach"));
    public int SILURIAN_BEACH_ID =  Biome.getIdForBiome(SILURIAN_BEACH);

    public GenLayerSilurianEstuary2(long seed, GenLayer genLayer)
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

                if (k == SILURIAN_ESTUARY_HELPER_ID)
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if (!isOcean(l1) && !isOcean(k2) && !isOcean(j3) && !isOcean(i4))
                    {
                        aint1[j + i * areaWidth] = SILURIAN_ESTUARY_ID;
                    }
                    else
                    {
                        aint1[j + i * areaWidth] = k;
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
        if (biomeID == SILURIAN_OCEAN_ROCKY_ID || biomeID == SILURIAN_OCEAN_SHORE_ID
                || biomeID == SILURIAN_BEACH_ID || biomeID == SILURIAN_OCEAN_SANDY_ID
                || biomeID == SILURIAN_OCEAN_GARDEN_ID || biomeID == SILURIAN_OCEAN_CORAL_ID
                || biomeID == SILURIAN_REEF_ID || biomeID == SILURIAN_OCEAN_SHORE_HELPER_ID) {
            return true;
        }
        return false;
    }

}
