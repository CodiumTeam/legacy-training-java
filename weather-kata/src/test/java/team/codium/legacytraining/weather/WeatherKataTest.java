package team.codium.legacytraining.weather;

import java.io.IOException;
import java.util.Date;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherKataTest {
    // https://www.metaweather.com/api/location/753692/  // Barcelona

    public void xxx() throws IOException {
        var prediction = new Forecast().predict("Barcelona", new Date(), false);

        assertEquals(prediction, "Heavy Rain");
    }

    @Test
    public void a_city_with_predictions() throws IOException {
        Forecast testeableForecast = new Forecast() {
            @Override
            protected String getCityId(String city) {
                return "[{\"woeid\":766273}]";
            }

            @Override
            protected String getPredictionJsonById(String woeid) {
                return "{\"consolidated_weather\": []}";
            }
        };

        var prediction = testeableForecast.predict("City without prediction", new Date(), false);

        assertEquals(prediction, "");
    }


    @Test
    public void a_city_without_predictions() throws IOException {
        Forecast testeableForecast = new Forecast() {
            @Override
            protected String getCityId(String city) {
                return "[{\"woeid\":766273}]";
            }

            @Override
            protected String getPredictionJsonById(String woeid) {
                return "{\"consolidated_weather\": []}";
            }
        };

        var prediction = testeableForecast.predict("City without prediction", new Date(), false);

        assertEquals(prediction, "");
    }

    @Test
    public void only_predicts_up_to_6_days_from_current_date() throws IOException {
        Forecast testeableForecast = new Forecast() {
            @Override
            protected Date getToday() {
                return new Date(new Date().getTime() - (1000 * 60 * 60 * 24 * 6));
            }
        };

        var prediction = testeableForecast.predict("Any City", null, false);

        assertEquals(prediction, "");
    }

    @Test
    public void get_prediction_with_wind_info() throws IOException {
        Forecast testeableForecast = new Forecast() {
            @Override
            protected Date getToday() {
                return new Date(new Date().getTime() - (1000 * 60 * 60 * 24 * 6));
            }
        };

        var prediction = testeableForecast.predict("Any City", null, false);

        assertEquals(prediction, "");
    }
}
