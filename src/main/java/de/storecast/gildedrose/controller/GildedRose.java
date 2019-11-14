package de.storecast.gildedrose.controller;

import de.storecast.gildedrose.domain.Item;
import de.storecast.gildedrose.service.GlidedRoseService;

/**
 * Controller class
 */
public class GildedRose {

    private Item[] items;
    private GlidedRoseService glidedRoseService;

    {
        glidedRoseService = new GlidedRoseService();
    }

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public GildedRose() {
    }

    public Item[] getItems() {
        return items;
    }

    public void updateQuality() {
        glidedRoseService.updateQuality(items);
    }

}