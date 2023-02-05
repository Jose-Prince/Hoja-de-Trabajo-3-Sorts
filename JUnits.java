import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class JUnits {
    
    Sorts listas = new Sorts<>();
    @Test
    public void mergeTest() {
        int actual[] = {5,1,6,2,3,4};
        int expected[] = {1,2,3,4,5,6};
        Sorts.mergeSort(actual, actual.length);
        assertArrayEquals(expected, actual);
    }
}
