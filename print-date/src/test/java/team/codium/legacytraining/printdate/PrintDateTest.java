package team.codium.legacytraining.printdate;

import org.junit.jupiter.api.Test;
import team.codium.legacytraining.printdate.Calendar;
import team.codium.legacytraining.printdate.PrintDate;
import team.codium.legacytraining.printdate.Printer;

import java.util.Date;
import java.util.GregorianCalendar;

import static java.util.Calendar.FEBRUARY;
import static org.mockito.Mockito.*;


public class PrintDateTest {
	@Test
	public void printDate() throws Exception {
		var ANY_DATE = new GregorianCalendar(2014, FEBRUARY, 1).getTime();
		var calendar = mock(Calendar.class);
		when(calendar.today()).thenReturn(ANY_DATE);
		var printer = mock(Printer.class);
		PrintDate printDate = new PrintDate(calendar, printer);

		printDate.printCurrentDate();

		verify(printer).printLine(ANY_DATE.toString());
	}
}
