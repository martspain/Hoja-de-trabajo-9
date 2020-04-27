import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TranslationTest {

	@Test
    public void testAddHashing(){
        Hashing<String,String> hashing = new Hashing<>();
        Association<String,String> association = new Association<>("traduccion","translation");
        assertNotNull(hashing.put(association));
    }

    @Test
    public void testSearchHashing(){
        Hashing<String,String> hashing = new Hashing<>();
        Association<String,String> association = new Association<>("traduccion","translation");
        hashing.put(association);
        String busqueda = hashing.get("traduccion");
        assertEquals(busqueda, "translation");
    }

    @Test
    public void testAddSplay(){
        SplayTreeMapping<String,String> splayTree = new SplayTreeMapping<>();
        Association<String,String> association = new Association<>("traduccion","translation");
        assertNotNull(splayTree.put(association));
    }

    @Test
    public void testSearchSplay(){
    	SplayTreeMapping<String,String> splayTree = new SplayTreeMapping<>();
        Association<String,String> association = new Association<>("traduccion","translation");
        splayTree.put(association);
        String busqueda = splayTree.get("traduccion");
        assertEquals(busqueda, "translation");
    }
    
}
