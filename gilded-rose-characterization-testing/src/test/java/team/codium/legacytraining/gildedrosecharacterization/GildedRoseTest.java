package team.codium.legacytraining.gildedrosecharacterization;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {

    @Test
    public void xxx() {
        Item[] items = new Item[] { new Item("Book", 10, 5) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Book", app.items[0].name);
    }

    @Test
    public void at_the_end_of_the_day_quality_reduces_by_one() {
        var INITIAL_QUALITY = 5;
        var item = new Item("Any item", 1, INITIAL_QUALITY);
        GildedRose app = new GildedRose(new Item[] {item});

        app.updateQuality();

        assertEquals(INITIAL_QUALITY - 1, item.quality);
    }

    @Test
    public void once_sellin_date_has_passed_quality_degrades_twice_as_fast() {
        var INITIAL_QUALITY = 5;
        var item = new Item("Any item", 0, INITIAL_QUALITY);
        GildedRose app = new GildedRose(new Item[] {item});

        app.updateQuality();

        assertEquals(INITIAL_QUALITY - 2, item.quality);
    }

    @Test
    public void the_quality_of_an_item_is_never_negative() {
        var ZERO_QUALITY = 0;
        var item = new Item("Any item", 1, ZERO_QUALITY);
        GildedRose app = new GildedRose(new Item[] {item});

        app.updateQuality();

        assertEquals(ZERO_QUALITY, item.quality);
    }

    @Test
    public void aged_brie_increases_quality_instead_of_decrease() {
        var INITIAL_QUALITY = 5;
        var item = new Item("Aged Brie", 1, INITIAL_QUALITY);
        GildedRose app = new GildedRose(new Item[] {item});

        app.updateQuality();

        assertEquals(INITIAL_QUALITY + 1, item.quality);
    }

    @Test
    public void aged_brie_increases_quality_twice_as_fast_after_sellin_date() {
        var INITIAL_QUALITY = 5;
        var item = new Item("Aged Brie", 0, INITIAL_QUALITY);
        GildedRose app = new GildedRose(new Item[] {item});

        app.updateQuality();

        assertEquals(INITIAL_QUALITY + 2, item.quality);
    }

    @Test
    public void quality_of_an_item_is_never_more_than_50() {
        var MAX_QUALITY = 50;
        var item = new Item("Aged Brie", 0, MAX_QUALITY);
        GildedRose app = new GildedRose(new Item[] {item});

        app.updateQuality();

        assertEquals(MAX_QUALITY, item.quality);
    }

    @Test
    public void sulfuras_does_not_decrese_in_quality() {
        var INITIAL_QUALITY = 50;
        var item = new Item("Sulfuras, Hand of Ragnaros", 0, INITIAL_QUALITY);
        GildedRose app = new GildedRose(new Item[] {item});

        app.updateQuality();

        assertEquals(INITIAL_QUALITY, item.quality);
    }

    @Test
    public void sulfuras_sellin_date_never_changes() {
        var INITIAL_QUALITY = 50;
        var SELLIN_DATE = 0;
        var item = new Item("Sulfuras, Hand of Ragnaros", SELLIN_DATE, INITIAL_QUALITY);
        GildedRose app = new GildedRose(new Item[] {item});

        app.updateQuality();

        assertEquals(SELLIN_DATE, item.sellIn);
    }

    @Test
    public void sellin_dates_decreases_after_each_day() {
        var INITIAL_QUALITY = 50;
        var SELLIN_DATE = 1;
        var item = new Item("Any item", SELLIN_DATE, INITIAL_QUALITY);
        GildedRose app = new GildedRose(new Item[] {item});

        app.updateQuality();

        assertEquals(SELLIN_DATE - 1, item.sellIn);
    }
}
