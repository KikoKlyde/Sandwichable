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
        addBowlSpread("strawberry_ice_cream", 0xeb6379);
        addBowlSpread("mango_ice_cream", 0xeaae27);
        addBowlSpread("pecan_ice_cream" 0xd4ba8a);
        addBowlSpread("rum_raisin_ice_cream", 0xeaae27);
        addBowlSpread("kiwi_sorbet", 0xbdd363);
        addBowlSpread("whipping_cream" 0xf2f2fc);
        addBowlSpread("crema", 0xf8fcd9);
        addBowlSpread("salsa", 0xa80c14);
        addBowlSpread("nether_wart_stew", 0x7f0229);
        addBowlSpread("beef_stew", 0x7a4633);
        addBowlSpread("baked_beans" 0x4e4036);
        addBowlSpread("refried_beans" 0x623c21);
        addBowlSpread("yoghurt" 0xf0dcdc);
        addBowlSpread("spaghetti_squash", 0xf2f2fc);
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
