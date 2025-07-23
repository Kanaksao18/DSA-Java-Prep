class LRUCache {

    class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> cache;
    private final Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();

        // Dummy head and tail nodes
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;

        Node node = cache.get(key);
        remove(node);
        insertToFront(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }

        if (cache.size() == capacity) {
            remove(tail.prev); // Least Recently Used
        }

        Node newNode = new Node(key, value);
        insertToFront(newNode);
    }

    // Remove node from DLL and map
    private void remove(Node node) {
        cache.remove(node.key);

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Insert node after head (most recently used)
    private void insertToFront(Node node) {
        cache.put(node.key, node);

        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }
}
// Time: O(1) for both get() and put()
// Space: O(capacity)
