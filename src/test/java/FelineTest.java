import com.example.Animal;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineTest {

    private final int expectedCountKittens;
    private final int actualCountKittens;

    public FelineTest(int expectedCountKittens, int actualCountKittens) {
        this.expectedCountKittens = expectedCountKittens;
        this.actualCountKittens = actualCountKittens;
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Mock
    Animal animalMock;

    @Test
    public void eatMeatFeline() throws Exception {
        Mockito.when(animalMock.getFood("Хищник"))
                .thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Feline feline = new Feline();
        List<String> actualResult = feline.eatMeat();

        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getFamilyFeline() {
        Feline feline = new Feline();
        String expectedFamily = "Кошачьи";

        String actualFamily = feline.getFamily();

        assertEquals(expectedFamily, actualFamily);
    }

    @Test
    public void getKittensByDefaultCount() {
        Feline feline = new Feline();
        int expectedByDefaultCount = 1;

        int actualByDefaultCount = feline.getKittens();

        assertEquals(expectedByDefaultCount, actualByDefaultCount);
    }

    @Parameterized.Parameters
    public static Object[] getKittensCountParameters() {
        return new Object[][] {
                { 5, 5},
                { 10, 10}, // передали тестовые данные
        };
    }
    @Test
    public void getKittensCount() {
        Feline feline = new Feline();

        int actualCount = feline.getKittens(actualCountKittens);

        assertEquals(expectedCountKittens, actualCount);
    }
}
