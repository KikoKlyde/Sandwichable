package io.github.foundationgames.sandwichable.compat;

import io.github.foundationgames.sandwichable.items.spread.SpreadType;
import io.github.foundationgames.sandwichable.util.SpreadRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class CroptopiaBowlSpreads {
    public static void init() {
        addBowlSpread("vanilla_ice_cream", 0xe8d7bd);
        addBowlSpread("chocolate_ice_cream", 0x975f31);
        addBowlSpread("strawberry_ice_cream" 0xeb6379);
    }

    private static void addBowlSpread(String itemId, int color) {
        Optional<Item> oitem = Registries.ITEM.getOrEmpty(new Identifier("croptopia", itemId));
        if(oitem.isPresent()) {
            Item item = oitem.get();
            int h = 0;
            float s = 0;
            if(item.isFood()) {
                h = item.getFoodComponent().getHunger();
                s = item.getFoodComponent().getSaturationModifier();
            }
            SpreadRegistry.INSTANCE.register(itemId, new SpreadType(h, s, color, item, Items.BOWL));
        }
    }
}
