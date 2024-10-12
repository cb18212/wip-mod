package com.thebeigeoverlord.testingmod.item;

import com.thebeigeoverlord.testingmod.TestingMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TestingMod.MODID);

    public static final RegistryObject<Item> WTF = ITEMS.register("wtf",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> YEAH = ITEMS.register("yeah",
            () -> new Item(new Item.Properties()));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
