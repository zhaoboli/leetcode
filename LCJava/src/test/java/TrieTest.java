import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhaobo on 5/6/17.
 */
public class TrieTest {
    private Trie obj = new Trie();

    public TrieTest() {
        obj.insert("lint");
    }

    @Test
    public void search() throws Exception {
        assertEquals(true, obj.search("lint"));
    }

    @Test
    public void startWithTest() throws Exception {
        assertEquals(true, obj.startsWith("lint"));
    }
}