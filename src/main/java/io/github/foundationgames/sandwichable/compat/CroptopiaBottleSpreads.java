package io.github.foundationgames.sandwichable.compat;

import io.github.foundationgames.sandwichable.items.spread.SpreadType;
import io.github.foundationgames.sandwichable.util.SpreadRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class CroptopiaCompat {
    public static void init() {
        addBottleSpread("grape_jam", 0x4d3dff);
        addBottleSpread("strawberry_jam", 0xc21d39);
        addBottleSpread("peach_jam", 0xff801f);
        addBottleSpread("apricot_jam", 0xff9b21);
        addBottleSpread("blackberry_jam", 0x1a0e29);
        addBottleSpread("blueberry_jam", 0x17287a);
        addBottleSpread("cherry_jam", 0x8f0018);
        addBottleSpread("elderberry_jam", 0x071124);
        addBottleSpread("raspberry_jam", 0x8a0e2b);
        addBottleSpread("yam_jam", 0xa27d79);
        addBottleSpread("peanut_butter", 0xbc9256);
    }

    private static void addBottleSpread(String itemId, int color) {
        Optional<Item> oitem = Registries.ITEM.getOrEmpty(new Identifier("croptopia", itemId));
        if(oitem.isPresent()) {
            Item item = oitem.get();
            int h = 0;
            float s = 0;
            if(item.isFood()) {
                h = item.getFoodComponent().getHunger();
                s = item.getFoodComponent().getSaturationModifier();
            }
            SpreadRegistry.INSTANCE.register(itemId, new SpreadType(h, s, color, item, Items.GLASS_BOTTLE));
        }
    }
}
