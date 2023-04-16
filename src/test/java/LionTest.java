import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.*;


public class LionTest {

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    Feline felineMock;

    @Test
    public void lionTest() throws Exception {
        Lion lion = new Lion("Самец");
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testConstructorWithValidFemaleSex() throws Exception {
        Lion lion = new Lion("Самка");
        assertFalse(lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void testConstructorWithInvalidSex() throws Exception {
        Lion lion = new Lion("InvalidSex");
    }

    @Test
    public void getKittensLion() throws Exception {
        Lion lion = new Lion("Самец");
        lion.feline = felineMock;
        Mockito.when(felineMock.getKittens()).thenReturn(1);

        int actualCountKittensLion = lion.getKittens();

        int expectedCountKittensLion = 1;
        assertEquals(expectedCountKittensLion, actualCountKittensLion);
    }

    @Test
    public void doesHaveManeLion() throws Exception {
        Lion lion = new Lion("Самец");
        boolean expectedMane = true;

        boolean actualMane = lion.doesHaveMane();

        assertEquals(expectedMane, actualMane);
    }

    @Test
    public void getFoodLion() throws Exception {
        Lion lion = new Lion("Самец");
        lion.feline = felineMock;
        Mockito.when(felineMock.getFood("Хищник"))
                .thenReturn(List.of("Животные", "Птицы", "Рыба"));

        List<String> actualResult = lion.getFood();

        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedResult, actualResult);
    }

}
