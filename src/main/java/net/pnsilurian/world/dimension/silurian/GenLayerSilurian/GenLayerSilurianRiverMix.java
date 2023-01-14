package net.pnsilurian.world.dimension.silurian.GenLayerSilurian;

import net.lepidodendron.util.EnumBiomeTypeSilurian;
import net.lepidodendron.world.biome.silurian.BiomeSilurian;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerSilurianRiverMix extends GenLayer
{
    private final GenLayer biomePatternGeneratorChain;
    private final GenLayer riverPatternGeneratorChain;

    //Creeks to use:
    public Biome SILURIAN_CREEK_COAST = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_creek_coastal"));
    public int SILURIAN_CREEK_COAST_ID = Biome.getIdForBiome(SILURIAN_CREEK_COAST);
    public Biome SILURIAN_CREEK_LAGOON = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_lagoon"));
    public int SILURIAN_CREEK_LAGOON_ID =  Biome.getIdForBiome(SILURIAN_CREEK_LAGOON);
    public Biome SILURIAN_CREEK = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_creek"));
    public int SILURIAN_CREEK_ID =  Biome.getIdForBiome(SILURIAN_CREEK);
    public Biome SILURIAN_CREEK_COOKSONIA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_creek_cooksonia"));
    public int SILURIAN_CREEK_COOKSONIA_ID =  Biome.getIdForBiome(SILURIAN_CREEK_COOKSONIA);
    public Biome SILURIAN_CREEK_SWAMP = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_creek_silty_swamp"));
    public int SILURIAN_CREEK_SWAMP_ID =  Biome.getIdForBiome(SILURIAN_CREEK_SWAMP);
    public Biome SILURIAN_CREEK_SANDS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_creek_sands"));
    public int SILURIAN_CREEK_SANDS_ID =  Biome.getIdForBiome(SILURIAN_CREEK_SANDS);

    //Biomes to exclude for rivers:
    public Biome SILURIAN_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_sea"));
    public int SILURIAN_OCEAN_ID =  Biome.getIdForBiome(SILURIAN_OCEAN);
    public Biome SILURIAN_OCEAN_SAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_sea_sandy"));
    public int SILURIAN_OCEAN_SAND_ID =  Biome.getIdForBiome(SILURIAN_OCEAN_SAND);
    public Biome SILURIAN_OCEAN_SHORE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_sea_shore"));
    public int SILURIAN_OCEAN_SHORE_ID =  Biome.getIdForBiome(SILURIAN_OCEAN_SHORE);
    public Biome SILURIAN_OCEAN_SHORE_HELPER = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_sea_shore_helper"));
    public int SILURIAN_OCEAN_SHORE_HELPER_ID =  Biome.getIdForBiome(SILURIAN_OCEAN_SHORE_HELPER);
    public Biome SILURIAN_CORAL = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_coral"));
    public int SILURIAN_CORAL_ID =  Biome.getIdForBiome(SILURIAN_CORAL);
    public Biome SILURIAN_REEF = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_reef"));
    public int SILURIAN_REEF_ID =  Biome.getIdForBiome(SILURIAN_REEF);
    public Biome SILURIAN_CRINOID = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_sea_garden"));
    public int SILURIAN_CRINOID_ID =  Biome.getIdForBiome(SILURIAN_CRINOID);
    public Biome SILURIAN_LUSH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_lush_patch"));
    public int SILURIAN_LUSH_ID =  Biome.getIdForBiome(SILURIAN_LUSH);

    public GenLayerSilurianRiverMix(long p_i2129_1_, GenLayer p_i2129_3_, GenLayer p_i2129_4_)
    {
        super(p_i2129_1_);
        this.biomePatternGeneratorChain = p_i2129_3_;
        this.riverPatternGeneratorChain = p_i2129_4_;
    }

    public void initWorldGenSeed(long seed)
    {
        this.biomePatternGeneratorChain.initWorldGenSeed(seed);
        this.riverPatternGeneratorChain.initWorldGenSeed(seed);
        super.initWorldGenSeed(seed);
    }

    public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight)
    {
        int[] aint = this.biomePatternGeneratorChain.getInts(areaX, areaY, areaWidth, areaHeight);
        int[] aint1 = this.riverPatternGeneratorChain.getInts(areaX, areaY, areaWidth, areaHeight);
        int[] aint2 = IntCache.getIntCache(areaWidth * areaHeight);

        for (int i = 0; i < areaWidth * areaHeight; ++i)
        {
            if (aint1[i] == Biome.getIdForBiome(Biomes.RIVER))
            {
                //Exclude rivers here:
                if (aint[i] == SILURIAN_OCEAN_ID
                        || aint[i] == SILURIAN_OCEAN_SAND_ID
                        || aint[i] == SILURIAN_OCEAN_SHORE_ID
                        || aint[i] == SILURIAN_OCEAN_SHORE_HELPER_ID
                        || aint[i] == SILURIAN_CORAL_ID
                        || aint[i] == SILURIAN_REEF_ID
                        || aint[i] == SILURIAN_CRINOID_ID
                        || aint[i] == SILURIAN_LUSH_ID
                )
                {
                    aint2[i] = aint[i];
                }
                else {
                    //Add the rivers we want:
                    Biome biome = Biome.getBiome(aint[i]);
                    if (biome instanceof BiomeSilurian) {
                        BiomeSilurian biomeSilurian = (BiomeSilurian) biome;
                        if (biomeSilurian.getBiomeType() == EnumBiomeTypeSilurian.BarrenLand) {
                            aint2[i] = SILURIAN_CREEK_ID;
                        }
                        else if (biomeSilurian.getBiomeType() == EnumBiomeTypeSilurian.Ocean) {
                            aint2[i] = SILURIAN_CREEK_COAST_ID;
                        }
                        else if (biomeSilurian.getBiomeType() == EnumBiomeTypeSilurian.Sands) {
                            aint2[i] = SILURIAN_CREEK_SANDS_ID;
                        }
                        else if (biomeSilurian.getBiomeType() == EnumBiomeTypeSilurian.Cooksonia) {
                            aint2[i] = SILURIAN_CREEK_COOKSONIA_ID;
                        }
                        else if (biomeSilurian.getBiomeType() == EnumBiomeTypeSilurian.Swamp) {
                            aint2[i] = SILURIAN_CREEK_SWAMP_ID;
                        }
                        else if (biomeSilurian.getBiomeType() == EnumBiomeTypeSilurian.Lagoon) {
                            aint2[i] = SILURIAN_CREEK_LAGOON_ID;
                        }
                        else {
                            aint2[i] = aint[i];
                        }
                    }
                    else {
                        aint2[i] = aint[i];
                    }
                }
            }
            else
            {
                aint2[i] = aint[i];
            }

        }

        return aint2;
    }
}
