import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinTreeGenTest {

    private BinNodeGen f,g,h,i,j,k,l,m;
    private BinTreeGen abb1;
    private BinTreeGen abb2;

    @BeforeEach
    void setup(){
        f = new BinNodeGen(1);
        g = new BinNodeGen(3);
        h = new BinNodeGen(2, f, g);
        i = new BinNodeGen(5);
        j = new BinNodeGen(4, h, i);
        k = new BinNodeGen(8);
        l = new BinNodeGen(9, k, null);
        m = new BinNodeGen(7, j, l);
        abb1 = new BinTreeGen(m);

        abb2 = new BinTreeGen<>();
    }


    @Test
    void countNodes() {
        // act
        int test = abb1.countNodes();
        // assert
        assertEquals(8,test);
    }

    @Test
    void insertNode() {
        // act
        abb1.insertNode(10);
        //
        abb1.toString();

    }
    @Test
    void insertNodeEmptyTree(){
        // act & assert
        assertThrows(IllegalStateException.class, ()->abb2.toString());
    }

    @Test
    void findElementNotIncluded() {
        // act
       BinNodeGen test =  abb1.find(6);
       // assert
        assertNull(test);
    }
    @Test
    void findElementIncluded(){
        // act
        BinNodeGen test = abb1.find(4);
        //assert
        assertEquals( 4,test.data);
    }
    @Test
    void findNullElement(){
        // act & assert
        assertThrows(NullPointerException.class, ()-> abb1.find(null));
    }
}