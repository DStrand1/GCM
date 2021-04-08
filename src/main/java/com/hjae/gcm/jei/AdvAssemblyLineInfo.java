package com.hjae.gcm.jei;

import com.hjae.gcm.tileentities.GCMTileEntities;
import gregicadditions.item.GAMetaBlocks;
import gregicadditions.item.GAMultiblockCasing;
import gregicadditions.item.GATransparentCasing;
import gregicadditions.jei.AssemblyLineInfo;
import gregicadditions.jei.GAMultiblockShapeInfo;
import gregicadditions.machines.GATileEntities;
import gregtech.api.metatileentity.multiblock.MultiblockControllerBase;
import gregtech.api.unification.material.Materials;
import gregtech.common.blocks.BlockMultiblockCasing;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.integration.jei.multiblock.MultiblockShapeInfo;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;

import java.util.ArrayList;
import java.util.List;

public class AdvAssemblyLineInfo extends AssemblyLineInfo {

    @Override
    public MultiblockControllerBase getController() {
        return GCMTileEntities.ADV_ASSEMBLY_LINE;
    }

    @Override
    public List<MultiblockShapeInfo> getMatchingShapes() {
        List<MultiblockShapeInfo> shapes = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            GAMultiblockShapeInfo.Builder builder = GAMultiblockShapeInfo.builder();
            builder.aisle("COC", "RTR", "GAG", "#Y#");
            for (int num = 0; num < 3 + i; num++) {
                if (num == 4 || num == 9) builder.aisle("FCf", "RTR", "GAG", "#Y#");
                else builder.aisle("CCC", "RTR", "GAG", "#Y#");
            }
            builder.aisle("CIC", "RTR", "GSG", "#Y#")
                    .where('S', GCMTileEntities.ADV_ASSEMBLY_LINE, EnumFacing.SOUTH)
                    .where('C', GAMetaBlocks.getMetalCasingBlockState(Materials.Steel))
                    .where('F', MetaTileEntities.FLUID_IMPORT_HATCH[4], EnumFacing.WEST)
                    .where('f', MetaTileEntities.FLUID_IMPORT_HATCH[4], EnumFacing.EAST)
                    .where('O', MetaTileEntities.ITEM_EXPORT_BUS[4], EnumFacing.DOWN)
                    .where('Y', MetaTileEntities.ENERGY_INPUT_HATCH[4], EnumFacing.UP)
                    .where('I', MetaTileEntities.ITEM_IMPORT_BUS[3], EnumFacing.DOWN)
                    .where('G', MetaBlocks.MUTLIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.GRATE_CASING))
                    .where('A', MetaBlocks.MUTLIBLOCK_CASING.getState(BlockMultiblockCasing.MultiblockCasingType.ASSEMBLER_CASING))
                    .where('R', GAMetaBlocks.TRANSPARENT_CASING.getState(GATransparentCasing.CasingType.IRIDIUM_GLASS))
                    .where('T', GAMetaBlocks.MUTLIBLOCK_CASING.getState(GAMultiblockCasing.CasingType.TUNGSTENSTEEL_GEARBOX_CASING))
                    .where('#', Blocks.AIR.getDefaultState());
            shapes.add(builder.build());
        }
        return shapes;
    }

}
