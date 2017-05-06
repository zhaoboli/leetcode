class TrieNode {
    // Initialize your data structure here.
    char nodeChar;
    boolean hasWord;
    TrieNode[] childNodes;

    public TrieNode(char nodeChar) {
        this.nodeChar = nodeChar;
        childNodes = new TrieNode[26];
    }

    public TrieNode() {
        childNodes = new TrieNode[26];
    }

    public void insertNode(TrieNode root, String word) {
        if (word == null || word.length() == 0) {
            root.hasWord = true;
            return;
        }
        char c = word.charAt(0);
        if (root.childNodes[c - 'a'] == null) {
            TrieNode node = new TrieNode(c);
            root.childNodes[c - 'a'] = node;
        }
        insertNode(root.childNodes[c - 'a'], word.substring(1));
    }

    public TrieNode searchNode(TrieNode root, String word) {
        if (word == null || word.length() == 0) {
            return root;
        }
        char c = word.charAt(0);
        if (root.childNodes[c - 'a'] != null) {
            return root.searchNode(root.childNodes[c - 'a'], word.substring(1));
        } else {
            return null;
        }
    }
}
