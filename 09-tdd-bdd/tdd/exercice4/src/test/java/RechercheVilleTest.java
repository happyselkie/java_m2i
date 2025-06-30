import org.example.RechercheVille;
import org.example.exception.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RechercheVilleTest {

    private RechercheVille rechercheVille;
    private List<String> villes;


    @BeforeEach
    public void setup(){
        villes = List.of("Paris", "Budapest", "Skopje", "Rotterdam", "Valence", "Vancouver", "Amsterdam", "Vienne", "Sydney", "New York", "Londres", "Bangkok", "Hong Kong", "Dubaï", "Rome", "Istanbul");
        rechercheVille = new RechercheVille(villes);
    }


    @Test
    public void whenSearchWithV_ThenThrowNotFoundException(){
        String search = "V";

       // rechercheVille.rechercher(search);

        Assertions.assertThrows(NotFoundException.class, () -> {rechercheVille.rechercher(search);});
    }

    @Test
    public void whenSearchWith_Va_ThenNamesStartingWith_Va(){
        String search = "Va";

        List<String> result = rechercheVille.rechercher(search);

        Assertions.assertEquals(List.of("Valence", "Vancouver"), result);
    }

    @Test
    public void whenSearchWithCaseSensitive_VA_ThenNamesStartingWith_Va(){
        String search = "VA";

        List<String> result = rechercheVille.rechercher(search);

        Assertions.assertEquals(List.of("Valence", "Vancouver"), result);
    }

    @Test
    public void whenSearchWith_ape_ThenBudapest(){
        String search = "ape";

        List<String> result = rechercheVille.rechercher(search);

        Assertions.assertEquals(List.of("Budapest"), result);
    }


    @Test
    public void whenSearchWithStar_ThenListOfVilles(){
        String search = "*";

        List<String> result = rechercheVille.rechercher(search);

        Assertions.assertEquals(villes, result);
    }



}
