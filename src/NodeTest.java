import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class NodeTest {
    Node test = new Node(1,4);

    @org.junit.jupiter.api.Test
    void makenode() {
        assertEquals(4, test.colorReadyToChoice.size());
    }
    @org.junit.jupiter.api.Test
    void makenode2() {
        Node test = new Node(1,5);
        assertEquals(5, test.colorReadyToChoice.size());
    }
    @org.junit.jupiter.api.Test
    void addne() {
        Node node = new Node(10,4);
        test.addne(node);
        assertEquals(node, test.neb[test.necounter-1]);
    }
    @org.junit.jupiter.api.Test
    void addne2() {
        Node node = new Node(10,4);
        test.addne(node);
        assertEquals(10, test.neb[test.necounter-1].name);
    }
    @org.junit.jupiter.api.Test
    void addne3() {
        Node node = new Node(10,4);
        test.addne(node);
        assertEquals(4, test.neb[test.necounter-1].colorReadyToChoice.size());
    }

}