package com.hing.dgymod.datagen;


import com.hing.dgymod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.ArmorItem;

public class ModModelsProvider extends FabricModelProvider {
    public ModModelsProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        // 这个方法下写我们的方块，它会将我们的方块模型文件、方块状态文件，以及方块对应的方块物品模型文件一起生成

        // 我们之前写的方块是cube all的，那么这里我们就可以采用registerSimpleCubeAll方法来生成我们的方块模型文件
//        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ICE_ETHER_BLOCK);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        // 这个方法下写我们的物品，它生成我们的物品模型文件

        // 利用register方法注册我们的物品，并指定它的模型类

        // 盔甲物品的模型与其他物品不同，有单独的方法
        itemModelGenerator.registerArmor((ArmorItem) ModItems.DGY_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.DGY_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.DGY_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.DGY_BOOTS);
    }
}
