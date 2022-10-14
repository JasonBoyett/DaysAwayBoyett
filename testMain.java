/*
* Jason Boyett - jaboye2448
* CIT 4423 01
* October 2, 2022
* mac OS
*/

import static org.junit.Assert.assertEquals;
import java.time.LocalDate;
import org.junit.Test;

public class testMain {
    @Test
    public void testFiveDays() {
        LocalDate currentDate = LocalDate.now();
        LocalDate testDate = currentDate.plusDays(5);

        assertEquals(5, Main.daysTo(testDate), 0);
    }

    @Test
    public void testNextYear() {
        LocalDate currentDate = LocalDate.now();
        LocalDate testDate = currentDate.plusDays(-1);

        assertEquals(364, Main.daysTo(testDate), 0);
    }

    @Test
    public void testLeapYear() {
        LocalDate currentDate = LocalDate.now();
        currentDate = currentDate.withYear(2020);
        LocalDate testDate = currentDate.plusDays(-1);

        assertEquals(364, Main.daysTo(testDate), 0);
    }
}