import com.example.Animal;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

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

    @Test
    public void getKittensCount() {
        Feline feline = new Feline();
        int expectedCount = 5;

        int actualCount = feline.getKittens(5);

        assertEquals(expectedCount, actualCount);
    }
}
