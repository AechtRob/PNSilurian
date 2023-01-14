package net.pnsilurian.world.dimension.silurian.GenLayerSilurian;

import net.lepidodendron.LepidodendronConfig;
import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.*;

public class GenLayerSilurian {

    protected GenLayer parent;

    public static GenLayer[] initializeAllBiomeGenerators(long seed, WorldType worldType, String options) {

        GenLayer biomes = new GenLayerSilurianBiomes(1L);
        biomes = new GenLayerFuzzyZoom(2000L, biomes);
        //if (!LepidodendronConfig.doShrinkBiomes) {
        //    biomes = new GenLayerZoom(2001L, biomes);
        //}
        biomes = new GenLayerDiversifySilurian1(700L, biomes);
        biomes = new GenLayerZoom(1000L, biomes);
        biomes = new GenLayerDiversifySilurian2(700L, biomes);
        biomes = new GenLayerFuzzyZoom(2900L, biomes);
        
        biomes = new GenLayerSilurianLushSwampLand(666L, biomes);
        biomes = new GenLayerSilurianEstuary1(1000L, biomes);
        biomes = new GenLayerDiversifyOceanSilurian(3005L, biomes);

        biomes = new GenLayerZoom(1001L, biomes);
        biomes = new GenLayerSilurianDeepOcean(1109L, biomes);
        biomes = new GenLayerSilurianShallowOcean(1400L, biomes);

        biomes = new GenLayerSilurianEstuary2(1000L, biomes);
        biomes = new GenLayerSilurianHilly(777L, biomes);

        biomes = new GenLayerZoom(1001L, biomes);

        //biomes = new GenLayerSilurianCoral(1124L, biomes);

        biomes = new GenLayerSilurianEstuary2(1000L, biomes);

        biomes = new GenLayerSmooth(700L, biomes);
        biomes = new GenLayerSilurianHilly(220L, biomes);

        biomes = new GenLayerZoom(1005L, biomes);

        biomes = new GenLayerSilurianBeach(1050L, biomes);
        biomes = new GenLayerSilurianCoral(1124L, biomes);
        //This next one nees t gen the patches not the silty swamps:
        biomes = new GenLayerSilurianLushPatchLand(662L, biomes);

        biomes = new GenLayerSilurianEstuary2(1000L, biomes);
        biomes = new GenLayerSilurianCraggy(778L, biomes);

        biomes = new GenLayerZoom(1005L, biomes);
        biomes = new GenLayerSilurianBeachExtra(2869L, biomes);
        biomes = new GenLayerSilurianLushPatchCoast(1169L, biomes);
        biomes = new GenLayerSilurianSeaFix(999L, biomes);

        biomes = new GenLayerSmooth(703L, biomes);
        biomes = new GenLayerFuzzyZoom(1000L, biomes);

        biomes = new GenLayerSmooth(705L, biomes);
        biomes = new GenLayerFuzzyZoom(1001L, biomes);
        biomes = new GenLayerZoom(1006L, biomes);


        //Build and superimpose creeks:
        GenLayer genlayercreek = new GenLayerRiverInit(100L, biomes);
        GenLayer genlayercreek2 = GenLayerZoom.magnify(1000L, genlayercreek, 1);
        GenLayer genlayercreek3 = GenLayerZoom.magnify(1000L, genlayercreek2, 2);
        GenLayer genlayercreek4 = GenLayerZoom.magnify(1000L, genlayercreek3, 2);
        GenLayer genlayercreek5 = GenLayerZoom.magnify(1000L, genlayercreek4, 2);
        GenLayer genlayercreek6 = new GenLayerRiver(1L, genlayercreek5);
        GenLayer genlayercreek7 = new GenLayerSmooth(1000L, genlayercreek6);
        GenLayer genlayercreekfinal = new GenLayerSilurianRiverMix(100L, biomes, genlayercreek7);

        GenLayer genlayervoronoizoom = new GenLayerVoronoiZoom(10L, genlayercreekfinal);

        genlayercreekfinal.initWorldGenSeed(seed);
        genlayervoronoizoom.initWorldGenSeed(seed);
        biomes.initWorldGenSeed(seed);

        genlayervoronoizoom.initWorldGenSeed(seed);
        return (new GenLayer[] { genlayercreekfinal, genlayervoronoizoom, genlayercreekfinal });
    }

}