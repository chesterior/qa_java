import com.example.Cat;
import com.example.Feline;
import com.example.Predator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Test
    public void getSoundCat() {
        Cat cat = new Cat(new Feline());
        String expectedGetSoundCat = "Мяу";

        String actualGetSoundCat = cat.getSound();

        assertEquals(expectedGetSoundCat, actualGetSoundCat);
    }

    @Mock
    Predator predator;

    @Test
    public void getFoodCat() throws Exception {
        Cat cat = new Cat(new Feline());
        Mockito.when(predator.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        List<String> expectedGetFoodCat = List.of("Животные", "Птицы", "Рыба");

        List<String> actualGetFoodCat = cat.getFood();

        assertEquals(expectedGetFoodCat, actualGetFoodCat);
    }

}
