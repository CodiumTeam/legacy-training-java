package team.codium.legacytraining.weather;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WeatherKataTest {
    @Test
    public void xxx() throws IOException {
        new Forecast().predict("Madrid", LocalDate.now(), false);
        assertTrue(true);
    }
}
