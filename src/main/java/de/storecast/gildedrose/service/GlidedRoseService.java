package de.storecast.gildedrose.service;

import de.storecast.gildedrose.domain.Item;
import de.storecast.gildedrose.utility.GlideRoseConstants;

/**
 * Service class
 */
public class GlidedRoseService {

    public void updateQuality(Item[] items) {
        for (Item item : items) {
            String itemName = item.name;
            // We dont's need to modify SULFURAS, just check that quality is 80
            if(itemName.equals(GlideRoseConstants.SULFURAS)) {
                if(item.quality != GlideRoseConstants.SULFURAS_QUALITY) {
                    throw new IllegalArgumentException("Sulfuras quality should be 80!");
                }
            } else {
                item.sellIn--;
                if (itemName.equals(GlideRoseConstants.AGED_BRIE)) {
                    incrementQuality(item);
                } else if (itemName.equals(GlideRoseConstants.BACKSTAGE_PASSES_TO_CONCERT)) {
                    processBackstagePassedToConcert(item);
                } else if (itemName.equals(GlideRoseConstants.CONJURED)) {
                    decrementQualityConjured(item);
                } else {
                    decrementQuality(item);
                }
            }
        }
    }

    /**
     * Contains logic for 'Backstage passes to a TAFKAL80ETC concert' processing
     * @param item
     */
    private void processBackstagePassedToConcert(Item item) {
        if (item.sellIn < 0) {
            item.quality = 0;
        } else {
            incrementQuality(item);
            if (item.sellIn < 10) incrementQuality(item);
            if (item.sellIn < 5) incrementQuality(item);
        }
    }

    /**
     * Increments quality if it's possible
     * @param item
     */
    private void incrementQuality(Item item) {
        if (item.quality < GlideRoseConstants.MAX_QUALITY) {
            item.quality++;
            if (item.quality < GlideRoseConstants.MAX_QUALITY && item.sellIn < 0) {
                item.quality++;
            }
        }
    }

    /**
     * Decrements quality if it's possible
     * @param item
     */
    private void decrementQuality(Item item) {
        if(item.quality > 0) {
            item.quality--;
            if (item.quality > 0 && item.sellIn < 0) {
                item.quality--;
            }
        }
    }

    /**
     * Decrements quality for CONJURED
     * @param item
     */
    private void decrementQualityConjured(Item item) {
        if(item.quality > 0) {
            item.quality--;
            if (item.quality > 0) {
                item.quality--;
            }
        }
    }
}
