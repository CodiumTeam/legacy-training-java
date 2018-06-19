package team.codium.legacytraining.gildedrose;

import team.codium.legacytraining.gildedrose.GildedRose;
import team.codium.legacytraining.gildedrose.Item;

public class SampleExecution {
    public static void main(String[] args) {
        Item[] items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Aged Brie", 2, 0),
                new Item("Aged Brie", 0, 49),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
        };

        GildedRose app = new GildedRose(items);

        int days = 20;

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }
}