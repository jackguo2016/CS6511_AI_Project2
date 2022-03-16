import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void isContainKey() {
        int[] test = {1,2,3,4,5,6,7,8,9};
        Main.isContainKey(test,1);
        assertEquals(true, Main.isContainKey(test,1));
    }
    @Test
    void isContainKey2() {
        int[] test = {1,2,3,4,5,6,7,8,9};
        Main.isContainKey(test,2);
        assertEquals(true, Main.isContainKey(test,2));
    }
    @Test
    void isContainKey3() {
        int[] test = {1,2,3,4,5,6,7,8,9};
        Main.isContainKey(test,6);
        assertEquals(true, Main.isContainKey(test,6));
    }
    @Test
    void isContainKey4() {
        int[] test = {1,2,3,4,5,6,7,8,9};
        Main.isContainKey(test,12);
        assertEquals(false, Main.isContainKey(test,12));
    }
    @Test
    void isContainKey5() {
        int[] test = {1,2,3,4,5,6,7,8,9};
        Main.isContainKey(test,0);
        assertEquals(false, Main.isContainKey(test,0));
    }

    @Test
    void findIndex() {
        int[] test = {1,2,3,4,5,6,7,8,9};
        assertEquals(0, Main.findIndex(test,1));
    }
    @Test
    void findIndex2() {
        int[] test = {1,2,3,4,5,6,7,8,9};
        assertEquals(-1, Main.findIndex(test,12));
    }
    @Test
    void findIndex3() {
        int[] test = {1,2,3,4,5,6,7,8,9};
        assertEquals(4, Main.findIndex(test,5));
    }
    @Test
    void findIndex4() {
        int[] test = {1,2,3,4,5,6,7,8,9};
        assertEquals(8, Main.findIndex(test,9));
    }
    @Test
    void findIndex5() {
        int[] test = {1,2,3,4,5,6,7,8,9};
        assertEquals(6, Main.findIndex(test,7));
    }
    @Test
    void findIndex6() {
        int[] test = {1,2,3,4,5,6,7,8,9};
        assertEquals(1, Main.findIndex(test,2));
    }
    @Test
    void findIndex7() {
        int[] test = {1,2,3,4,5,6,7,8,9};
        assertEquals(-1, Main.findIndex(test,100));
    }
}