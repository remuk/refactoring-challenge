package de.storecast.gildedrose;

import de.storecast.gildedrose.controller.GildedRose;
import de.storecast.gildedrose.domain.Item;
import de.storecast.gildedrose.utility.GlideRoseConstants;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by Unicorn on 30.03.2017.
 */
public class GildedRoseTest {

    @Test
    public void testUpdateQualityBackstage() {
        GildedRose gildedRose = new GildedRose(new Item[]{new Item(GlideRoseConstants.BACKSTAGE_PASSES_TO_CONCERT,7,0)});
        gildedRose.updateQuality();
        Assert.assertEquals(6, gildedRose.getItems()[0].sellIn);
        Assert.assertEquals(2, gildedRose.getItems()[0].quality);
        gildedRose.updateQuality();
        Assert.assertEquals(5, gildedRose.getItems()[0].sellIn);
        Assert.assertEquals(4, gildedRose.getItems()[0].quality);
        gildedRose.updateQuality();
        Assert.assertEquals(4, gildedRose.getItems()[0].sellIn);
        Assert.assertEquals(7, gildedRose.getItems()[0].quality);
        gildedRose.updateQuality();
        Assert.assertEquals(3, gildedRose.getItems()[0].sellIn);
        Assert.assertEquals(10, gildedRose.getItems()[0].quality);
        gildedRose.updateQuality();
        Assert.assertEquals(2, gildedRose.getItems()[0].sellIn);
        Assert.assertEquals(13, gildedRose.getItems()[0].quality);
        gildedRose.updateQuality();
        Assert.assertEquals(1, gildedRose.getItems()[0].sellIn);
        Assert.assertEquals(16, gildedRose.getItems()[0].quality);
        gildedRose.updateQuality();
        Assert.assertEquals(0, gildedRose.getItems()[0].sellIn);
        Assert.assertEquals(19, gildedRose.getItems()[0].quality);
        gildedRose.updateQuality();
        Assert.assertEquals(-1, gildedRose.getItems()[0].sellIn);
        Assert.assertEquals(0, gildedRose.getItems()[0].quality);
        gildedRose.updateQuality();
        Assert.assertEquals(-2, gildedRose.getItems()[0].sellIn);
        Assert.assertEquals(0, gildedRose.getItems()[0].quality);
    }

    @Test
    public void testUpdateQualityAgedBrie() {
        GildedRose gildedRose = new GildedRose(new Item[]{new Item(GlideRoseConstants.AGED_BRIE,6,0)});
        Assert.assertEquals(6, gildedRose.getItems()[0].sellIn);
        Assert.assertEquals(0, gildedRose.getItems()[0].quality);
        gildedRose.updateQuality();
        Assert.assertEquals(5, gildedRose.getItems()[0].sellIn);
        Assert.assertEquals(1, gildedRose.getItems()[0].quality);
        gildedRose.updateQuality();
        Assert.assertEquals(4, gildedRose.getItems()[0].sellIn);
        Assert.assertEquals(2, gildedRose.getItems()[0].quality);
        gildedRose.updateQuality();
        Assert.assertEquals(3, gildedRose.getItems()[0].sellIn);
        Assert.assertEquals(3, gildedRose.getItems()[0].quality);
        gildedRose.updateQuality();
        Assert.assertEquals(2, gildedRose.getItems()[0].sellIn);
        Assert.assertEquals(4, gildedRose.getItems()[0].quality);
        gildedRose.updateQuality();
        Assert.assertEquals(1, gildedRose.getItems()[0].sellIn);
        Assert.assertEquals(5, gildedRose.getItems()[0].quality);
        gildedRose.updateQuality();
        Assert.assertEquals(0, gildedRose.getItems()[0].sellIn);
        Assert.assertEquals(6, gildedRose.getItems()[0].quality);
        gildedRose.updateQuality();
        Assert.assertEquals(-1, gildedRose.getItems()[0].sellIn);
        Assert.assertEquals(8, gildedRose.getItems()[0].quality);
        gildedRose.updateQuality();
        Assert.assertEquals(-2, gildedRose.getItems()[0].sellIn);
        Assert.assertEquals(10, gildedRose.getItems()[0].quality);
    }

    @Test
    public void testUpdateQualitySulfuras() {
        GildedRose gildedRose = new GildedRose(new Item[]{new Item(GlideRoseConstants.SULFURAS,5, GlideRoseConstants.SULFURAS_QUALITY)});
        for(int i = 0; i < 3; i++) {
            gildedRose.updateQuality();
            Assert.assertEquals(5, gildedRose.getItems()[0].sellIn);
            Assert.assertEquals(GlideRoseConstants.SULFURAS_QUALITY, gildedRose.getItems()[0].quality);
        }

    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateQualitySulfurasWrongQuality() {
        GildedRose gildedRose = new GildedRose(new Item[]{new Item(GlideRoseConstants.SULFURAS,0,0)});
        gildedRose.updateQuality();
    }

    @Test
    public void testUpdateQualityCustom() {
        GildedRose gildedRose = new GildedRose(new Item[]{new Item("test",2,7)});
        gildedRose.updateQuality();
        Assert.assertEquals(1, gildedRose.getItems()[0].sellIn);
        Assert.assertEquals(6, gildedRose.getItems()[0].quality);
        gildedRose.updateQuality();
        Assert.assertEquals(0, gildedRose.getItems()[0].sellIn);
        Assert.assertEquals(5, gildedRose.getItems()[0].quality);
        gildedRose.updateQuality();
        Assert.assertEquals(-1, gildedRose.getItems()[0].sellIn);
        Assert.assertEquals(3, gildedRose.getItems()[0].quality);
        gildedRose.updateQuality();
        Assert.assertEquals(-2, gildedRose.getItems()[0].sellIn);
        Assert.assertEquals(1, gildedRose.getItems()[0].quality);
        gildedRose.updateQuality();
        Assert.assertEquals(-3, gildedRose.getItems()[0].sellIn);
        Assert.assertEquals(0, gildedRose.getItems()[0].quality);
    }

    @Test
    public void testUpdateQualityConjured() {
        GildedRose gildedRose = new GildedRose(new Item[]{new Item(GlideRoseConstants.CONJURED,2,4)});
        gildedRose.updateQuality();
        Assert.assertEquals(1, gildedRose.getItems()[0].sellIn);
        Assert.assertEquals(2, gildedRose.getItems()[0].quality);
        gildedRose.updateQuality();
        Assert.assertEquals(0, gildedRose.getItems()[0].sellIn);
        Assert.assertEquals(0, gildedRose.getItems()[0].quality);
        gildedRose.updateQuality();
        Assert.assertEquals(-1, gildedRose.getItems()[0].sellIn);
        Assert.assertEquals(0, gildedRose.getItems()[0].quality);

        gildedRose = new GildedRose(new Item[]{new Item(GlideRoseConstants.CONJURED,2,11)});
        gildedRose.updateQuality();
        Assert.assertEquals(1, gildedRose.getItems()[0].sellIn);
        Assert.assertEquals(9, gildedRose.getItems()[0].quality);
        gildedRose.updateQuality();
        Assert.assertEquals(0, gildedRose.getItems()[0].sellIn);
        Assert.assertEquals(7, gildedRose.getItems()[0].quality);
        gildedRose.updateQuality();
        // modified wrong test expected values
        Assert.assertEquals(-1, gildedRose.getItems()[0].sellIn);
        Assert.assertEquals(5, gildedRose.getItems()[0].quality);
        gildedRose.updateQuality();
        Assert.assertEquals(-2, gildedRose.getItems()[0].sellIn);
        Assert.assertEquals(3, gildedRose.getItems()[0].quality);
        gildedRose.updateQuality();
        Assert.assertEquals(-3, gildedRose.getItems()[0].sellIn);
        Assert.assertEquals(1, gildedRose.getItems()[0].quality);
        gildedRose.updateQuality();
        Assert.assertEquals(-4, gildedRose.getItems()[0].sellIn);
        Assert.assertEquals(0, gildedRose.getItems()[0].quality);
    }
}
