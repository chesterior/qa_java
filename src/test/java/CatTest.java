import com.example.Cat;
import com.example.Feline;
import com.example.Predator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CatTest {

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Mock
    Predator predatorMock;
    @Mock
    Feline felineMock;

    @Test
    public void catTest() {
    }

    @Test
    public void testCatConstructor() {
        Cat cat = new Cat(felineMock);
        assertEquals(felineMock, cat.predator);
    }

    @Test
    public void getSoundCat() {
        Cat cat = new Cat(new Feline());
        String expectedGetSoundCat = "Мяу";

        String actualGetSoundCat = cat.getSound();

        assertEquals(expectedGetSoundCat, actualGetSoundCat);
    }

    @Test
    public void getFoodCat() throws Exception {
        Cat cat = new Cat(new Feline());
        Mockito.when(predatorMock.eatMeat()).
                thenReturn(List.of("Животные", "Птицы", "Рыба"));

        List<String> expectedGetFoodCat = List.of("Животные", "Птицы", "Рыба");

        List<String> actualGetFoodCat = cat.getFood();

        assertEquals(expectedGetFoodCat, actualGetFoodCat);
    }

}
