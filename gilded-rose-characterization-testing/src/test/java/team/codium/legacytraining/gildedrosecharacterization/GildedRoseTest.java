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

}
