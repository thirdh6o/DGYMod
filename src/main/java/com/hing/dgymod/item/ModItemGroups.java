package com.hing.dgymod.item;

import com.hing.dgymod.DGYMod;
import com.hing.dgymod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    // 注册物品栏的注册键
    public static final RegistryKey<ItemGroup> TUTORIAL_GROUP = register("dgy_group");

    // 原版的注册方法，当然我们要改命名空间（再回到上面注册物品栏的注册键）
    private static RegistryKey<ItemGroup> register(String id) {
        return RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(DGYMod.MOD_ID, id));
    }



    public static void registerModItemGroups() {
        // 这里本来是不用写什么的，我们可以将注册语句写在这里
        // 在原始注册语句中，我们可以看到一个Registry<ItemGroup>类型的registry，这个其实就是注册表类型，可直接调用原版注册表的东西
        // 注册参数分别是注册表项、注册键、物品栏（其中物品栏创建参数可再分为物品栏位置、展示名字、图标文件、物品栏内容等，不要忘了最后的build）
        Registry.register(
                Registries.ITEM_GROUP,
                TUTORIAL_GROUP,
                ItemGroup.create(ItemGroup.Row.TOP, 7)
                        .displayName(Text.translatable("itemGroup.dgy_group"))
                        .icon(() -> new ItemStack(ModItems.DGY))
                        .entries((displayContext, entries) -> {
                            entries.add(ModItems.DGY);
                            entries.add(ModBlocks.DGY_BLOCK);
                            entries.add(ModItems.DGY_COOKIE);
                            entries.add(ModItems.DGY_INGOT);
                            entries.add(ModItems.DGY_COAL);
                            entries.add(ModBlocks.DGY_ORE);
                            entries.add(ModItems.DGY_INGOT_PLUS);
                            entries.add(ModItems.DGY_AXE);
                            entries.add(ModItems.DGY_PICKAXE);
                            entries.add(ModItems.DGY_SHOVEL);
                            entries.add(ModItems.DGY_SWORD);
                            entries.add(ModItems.DGY_HOE);
                        }).build());
    }
}
