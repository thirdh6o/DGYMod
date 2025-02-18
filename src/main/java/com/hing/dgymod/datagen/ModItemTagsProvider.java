package com.hing.dgymod.datagen;

import com.hing.dgymod.item.ModItems;
import com.hing.dgymod.tag.ModItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends FabricTagProvider.ItemTagProvider {

    // 注意在创建super函数的时候，选择带有两个参数的构造函数，三个参数的那个其中一个是BlockTags的
    public ModItemTagsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModItemTags.COMBAT_KIT)
                .add(ModItems.DGY_HELMET)
                .add(ModItems.DGY_CHESTPLATE)
                .add(ModItems.DGY_LEGGINGS)
                .add(ModItems.DGY_BOOTS);
    }
}
