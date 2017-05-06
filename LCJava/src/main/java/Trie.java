public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        root.insertNode(root, word);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word == null || word.length() ==0) {
            return false;
        }
        TrieNode res = root.searchNode(root, word);
        if (res != null && res.hasWord) {
            return true;
        }
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() ==0) {
            return false;
        }
        TrieNode res = root.searchNode(root, prefix);
        return res != null;
    }
}
