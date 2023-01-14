package net.pnsilurian.world.dimension.silurian.GenLayerSilurian;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerSilurianDeepOcean extends GenLayer
{

    public Biome SILURIAN_OCEAN_ROCKY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_sea"));
    public int SILURIAN_OCEAN_ROCKY_ID =  Biome.getIdForBiome(SILURIAN_OCEAN_ROCKY);
    public Biome SILURIAN_OCEAN_SHORE_FOR_ROCKY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_sea_shore"));
    public int SILURIAN_OCEAN_SHORE_FOR_ROCKY_ID =  Biome.getIdForBiome(SILURIAN_OCEAN_SHORE_FOR_ROCKY);
    public Biome SILURIAN_OCEAN_SHORE_FOR_SANDY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_sea_shore_helper"));
    public int SILURIAN_OCEAN_SHORE_FOR_SANDY_ID =  Biome.getIdForBiome(SILURIAN_OCEAN_SHORE_FOR_SANDY);
    public Biome SILURIAN_OCEAN_SANDY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_sea_sandy"));
    public int SILURIAN_OCEAN_SANDY_ID =  Biome.getIdForBiome(SILURIAN_OCEAN_SANDY);
    public Biome SILURIAN_OCEAN_GARDEN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_sea_garden"));
    public int SILURIAN_OCEAN_GARDEN_ID =  Biome.getIdForBiome(SILURIAN_OCEAN_GARDEN);
    public Biome SILURIAN_OCEAN_CORAL = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_coral"));
    public int SILURIAN_OCEAN_CORAL_ID =  Biome.getIdForBiome(SILURIAN_OCEAN_CORAL);
    public Biome SILURIAN_REEF = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_reef"));
    public int SILURIAN_REEF_ID =  Biome.getIdForBiome(SILURIAN_REEF);

    public GenLayerSilurianDeepOcean(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight)
    {
        return this.getIntsOcean(areaX, areaY, areaWidth, areaHeight);
    }

    private int[] getIntsOcean(int p_151626_1_, int p_151626_2_, int p_151626_3_, int p_151626_4_)
    {
        int i = p_151626_1_ - 1;
        int j = p_151626_2_ - 1;
        int k = 1 + p_151626_3_ + 1;
        int l = 1 + p_151626_4_ + 1;
        int[] aint = this.parent.getInts(i, j, k, l);
        int[] aint1 = IntCache.getIntCache(p_151626_3_ * p_151626_4_);

        for (int i1 = 0; i1 < p_151626_4_; ++i1)
        {
            for (int j1 = 0; j1 < p_151626_3_; ++j1)
            {
                this.initChunkSeed((long)(j1 + p_151626_1_), (long)(i1 + p_151626_2_));
                int k1 = aint[j1 + 1 + (i1 + 1) * k];

                if (k1 == SILURIAN_OCEAN_SHORE_FOR_ROCKY_ID)
                {
                    int l1 = aint[j1 + 1 + (i1 + 1 - 1) * k];
                    int i2 = aint[j1 + 1 + 1 + (i1 + 1) * k];
                    int j2 = aint[j1 + 1 - 1 + (i1 + 1) * k];
                    int k2 = aint[j1 + 1 + (i1 + 1 + 1) * k];
                    boolean flag = (
                        (l1 == SILURIAN_OCEAN_ROCKY_ID || l1 == SILURIAN_OCEAN_SANDY_ID || l1 == SILURIAN_OCEAN_SHORE_FOR_SANDY_ID || l1 == SILURIAN_OCEAN_SHORE_FOR_ROCKY_ID || l1 == SILURIAN_REEF_ID || l1 == SILURIAN_OCEAN_GARDEN_ID)
                        && (i2 == SILURIAN_OCEAN_ROCKY_ID || i2 == SILURIAN_OCEAN_SANDY_ID || i2 == SILURIAN_OCEAN_SHORE_FOR_SANDY_ID || i2 == SILURIAN_OCEAN_SHORE_FOR_ROCKY_ID || i2 == SILURIAN_REEF_ID || i2 == SILURIAN_OCEAN_GARDEN_ID)
                        && (j2 == SILURIAN_OCEAN_ROCKY_ID || j2 == SILURIAN_OCEAN_SANDY_ID || j2 == SILURIAN_OCEAN_SHORE_FOR_SANDY_ID || j2 == SILURIAN_OCEAN_SHORE_FOR_ROCKY_ID || j2 == SILURIAN_REEF_ID || j2 == SILURIAN_OCEAN_GARDEN_ID)
                        && (k2 == SILURIAN_OCEAN_ROCKY_ID || k2 == SILURIAN_OCEAN_SANDY_ID || k2 == SILURIAN_OCEAN_SHORE_FOR_SANDY_ID|| k2 == SILURIAN_OCEAN_SHORE_FOR_ROCKY_ID || k2 == SILURIAN_REEF_ID || k2 == SILURIAN_OCEAN_GARDEN_ID)
                    );
                    if (flag)
                    {
                        k1 = SILURIAN_OCEAN_ROCKY_ID;
                    }
                }
                else if (k1 == SILURIAN_OCEAN_SHORE_FOR_SANDY_ID)
                {
                    int l1 = aint[j1 + 1 + (i1 + 1 - 1) * k];
                    int i2 = aint[j1 + 1 + 1 + (i1 + 1) * k];
                    int j2 = aint[j1 + 1 - 1 + (i1 + 1) * k];
                    int k2 = aint[j1 + 1 + (i1 + 1 + 1) * k];
                    boolean flag = (
                            (l1 == SILURIAN_OCEAN_ROCKY_ID || l1 == SILURIAN_OCEAN_SANDY_ID || l1 == SILURIAN_OCEAN_SHORE_FOR_SANDY_ID || l1 == SILURIAN_OCEAN_SHORE_FOR_ROCKY_ID || l1 == SILURIAN_REEF_ID || l1 == SILURIAN_OCEAN_GARDEN_ID || l1 == SILURIAN_OCEAN_CORAL_ID)
                                    && (i2 == SILURIAN_OCEAN_ROCKY_ID || l1 == SILURIAN_OCEAN_SANDY_ID || i2 == SILURIAN_OCEAN_SHORE_FOR_SANDY_ID || i2 == SILURIAN_OCEAN_SHORE_FOR_ROCKY_ID || i2 == SILURIAN_REEF_ID || i2 == SILURIAN_OCEAN_GARDEN_ID || i2 == SILURIAN_OCEAN_CORAL_ID)
                                    && (j2 == SILURIAN_OCEAN_ROCKY_ID || j2 == SILURIAN_OCEAN_SANDY_ID || j2 == SILURIAN_OCEAN_SHORE_FOR_SANDY_ID || j2 == SILURIAN_OCEAN_SHORE_FOR_ROCKY_ID || j2 == SILURIAN_REEF_ID || j2 == SILURIAN_OCEAN_GARDEN_ID || j2 == SILURIAN_OCEAN_CORAL_ID)
                                    && (k2 == SILURIAN_OCEAN_ROCKY_ID || k2 == SILURIAN_OCEAN_SANDY_ID || k2 == SILURIAN_OCEAN_SHORE_FOR_SANDY_ID|| k2 == SILURIAN_OCEAN_SHORE_FOR_ROCKY_ID || k2 == SILURIAN_REEF_ID || k2 == SILURIAN_OCEAN_GARDEN_ID || k2 == SILURIAN_OCEAN_CORAL_ID)
                    );
                    if (flag)
                    {
                        k1 = SILURIAN_OCEAN_SANDY_ID;
                    }
                }

                aint1[j1 + i1 * p_151626_3_] = k1;
            }
        }

        return aint1;
    }
    
}
