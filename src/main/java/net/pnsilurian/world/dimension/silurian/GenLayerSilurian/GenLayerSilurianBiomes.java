package net.pnsilurian.world.dimension.silurian.GenLayerSilurian;

//import net.lepidodendron.world.biome.devonian.
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerSilurianBiomes extends GenLayer {

    public Biome SILURIAN_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_sea_shore"));
    public int SILURIAN_OCEAN_ID =  Biome.getIdForBiome(SILURIAN_OCEAN);
    public Biome SILURIAN_OCEAN_HELPER = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_sea_shore_helper"));
    public int SILURIAN_OCEAN_HELPER_ID =  Biome.getIdForBiome(SILURIAN_OCEAN_HELPER);
    public Biome SILURIAN_LAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:silurian_land"));
    public int SILURIAN_LAND_ID =  Biome.getIdForBiome(SILURIAN_LAND);

    private final int SilurianBiomes[] = new int[] {
            SILURIAN_OCEAN_ID,
            SILURIAN_OCEAN_HELPER_ID,
            SILURIAN_LAND_ID
    };

    public GenLayerSilurianBiomes(long seed) {
        super(seed);
    }

    @Override
    public int[] getInts(int x, int z, int width, int height) {
        int dest[] = IntCache.getIntCache(width * height);
        for (int dz = 0; dz < height; dz++) {
            for (int dx = 0; dx < width; dx++) {
                initChunkSeed(dx + x, dz + z);
                dest[dx + dz * width] = SilurianBiomes[nextInt(SilurianBiomes.length)];
            }
        }
        return dest;
    }
}