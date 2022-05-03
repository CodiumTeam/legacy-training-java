package team.codium.legacytraining.weather;

import java.io.IOException;
import java.util.Date;

import org.junit.jupiter.api.Test;
import team.codium.legacytraining.weather.Forecast;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WeatherKataTest {
    // https://www.metaweather.com/api/location/753692/  // Barcelona

    @Test
    public void xxx() throws IOException {
        new Forecast().predict("Madrid", new Date(), false);
        assertTrue(true);
    }
}
