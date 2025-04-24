import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class HippodromeTest {

    @Test
    void constructorTest() {
        Throwable throwable = assertThrows(IllegalArgumentException.class,
                () -> new Hippodrome(null));
        assertEquals("Horses cannot be null.", throwable.getMessage());
    }

    @Test
    void constructorNonArgTest() {
        List<Horse> list = new ArrayList<>();
        Throwable throwable = assertThrows(IllegalArgumentException.class,
                () -> new Hippodrome(list));
        assertEquals("Horses cannot be empty.", throwable.getMessage());
    }

    @Test
    void getHorsesTets() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            horses.add(new Horse("Horse " + i + 1, i + 1.2, i + 3));
        }


        assertEquals(horses, new Hippodrome(horses).getHorses());
    }

    @Test
    void moveTest() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            horses.add(mock(Horse.class));
        }

        new Hippodrome(horses).move();

        for (Horse horse : horses) {
            verify(horse).move();
        }
    }

    @Test
    void getWinnerTest() {

        Horse winHorse = new Horse("Winner", 120.4, 100);

        Horse horseFirst = new Horse("First", 100.4, 85);
        Horse horseSecond = new Horse("Second", 120.3, 99.9);

        List<Horse> list = new ArrayList<>();
        list.add(winHorse);
        list.add(horseFirst);
        list.add(horseSecond);

        Hippodrome hippodrome = new Hippodrome(list);

        assertEquals(winHorse, hippodrome.getWinner());
    }

}
