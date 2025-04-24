import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;


public class HorseTest {

    @Test
    public void firstArgNullTest() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new Horse(null, 1.2, 1.3));
        assertEquals("Name cannot be null.", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "  ", ""})
    void nonFirstArgTest(String string) {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new Horse(string, 1.4, 1.5));
        assertEquals("Name cannot be blank.", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1, -2, -100})
    void minusSecondArgTest(double v) {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new Horse("first", v, 3));
        assertEquals("Speed cannot be negative.", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(doubles = {-2, -3, -200})
    void minusThirdArgTest(double v) {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new Horse("first", 3.4, v));
        assertEquals("Distance cannot be negative.", exception.getMessage());
    }

    @Test
    void getName() {
        Horse horse = new Horse("F", 4, 5);
        assertEquals("F", horse.getName());

    }

    @Test
    void getSpeedTest() {
        Horse horse = new Horse("F", 4, 5);
        assertEquals(4, horse.getSpeed());
    }

    @Test
    void getDistanceTest() {
        Horse horse = new Horse("F", 4, 5);
        assertEquals(5, horse.getDistance());
    }

    @Disabled
    @Test
    void moveTest(){
        try (MockedStatic<Horse> mockedStatic = mockStatic(Horse.class)){
            new Horse("F", 4,5).move();
            mockedStatic.verify(() -> Horse.getRandomDouble(0.2, 0.9));
        }
    }
}
