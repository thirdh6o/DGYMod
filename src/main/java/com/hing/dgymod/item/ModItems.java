package com.hing.dgymod.item;

import com.hing.dgymod.DGYMod;
import com.hing.dgymod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;


//师从B站UP主 北山_Besson  B站主页https://space.bilibili.com/489671468


public class ModItems {

    public static final Item DGY = registerItem("dgy", new Item(new Item.Settings()));
    public static final Item DGY_INGOT = registerItem("dgy_ingot", new Item(new Item.Settings()));
    public static final Item DGY_COAL = registerItem("dgy_coal", new Item(new Item.Settings()));
    public static final Item DGY_INGOT_PLUS = registerItem("dgy_ingot_plus", new Item(new Item.Settings()));

    //食物写法
    public static final Item DGY_COOKIE = registerItem("dgy_cookie", new Item(new Item.Settings().food(ModFoodComponents.DGY_COOKIE)));









    public static Item register(Identifier id, Item item) {
        return register(RegistryKey.of(Registries.ITEM.getKey(), id), item);
    }

    public static Item register(RegistryKey<Item> key, Item item) {
        if (item instanceof BlockItem) {
            ((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item);
        }
        /* 其实最核心的方法在这里，就是这里的return语句
           Registry是原版的注册表系统，包括静态注册表和动态注册表，这里的Item就是静态注册表，未来我们还会用到动态注册表
           Registry.register方法的作用是将一个物品注册到注册表中，返回值是注册的物品
           Registries类定义了Minecraft中所有的注册表，包括物品、方块、方块实体等等，使用getKey方法可以获取注册表的键
         */
        return Registry.register(Registries.ITEM, key, item);
    }


    public static Item registerItems(String id, Item item) {
        // 整合起来就一句话，当然这里的命名空间得改成你自己的
        return Registry.register(Registries.ITEM, RegistryKey.of(Registries.ITEM.getKey(), new Identifier(DGYMod.MOD_ID, id)), item);
    }


    public static Item registerItem(String id, Item item) {
        /* 这里就要用到Registry.register的另一个方法了
           这个方法接受三个参数，第一个是注册表，第二个是物品的命名空间，第三个是物品本身（其实调用的是上面的那个方法，两者本质上是一样的）
         */
        return Registry.register(Registries.ITEM, new Identifier(DGYMod.MOD_ID, id), item);
    }



    // 两个加入原版物品栏的例子
    private static void addItemToItemGroup1(FabricItemGroupEntries entries) {
        entries.add(ModBlocks.DGY_BLOCK);
    }
    private static void addItemToItemGroup2(FabricItemGroupEntries entries) {
       entries.add(DGY_INGOT);
    }

    private static void addItemToItemGroup3(FabricItemGroupEntries entries) {
        entries.add(DGY_COAL);
    }

    public static void registerModItems() {
        /* 这里其实啥也不用写，就直接在模组主类中调用这个方法即可
           因为在Java中，调用该方法的时候，所在类的所有静态代码块和静态变量都会被初始化
           我们上面写的物品是static final修饰的，所以在这个方法被调用的时候，物品也就被注册了
         */
        // 利用ItemGroupEvents的modifyEntriesEvent方法，将物品加入原版对应的物品栏，并调用上面的方法


        // 这里是加入原版物品栏的两个例子，模组自制物品栏在ModItemGroups中
          ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModItems::addItemToItemGroup1);
          ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemToItemGroup2);
          ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemToItemGroup3);
    }
}