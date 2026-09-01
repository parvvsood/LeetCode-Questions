class LFUCache {

    class Node {
        int key, val, freq;
        Node prev, next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            freq = 1;
        }
    }

    class DLL {
        Node head = new Node(0, 0);
        Node tail = new Node(0, 0);
        int size = 0;

        DLL() {
            head.next = tail;
            tail.prev = head;
        }

        void add(Node n) {
            n.next = head.next;
            n.prev = head;
            head.next.prev = n;
            head.next = n;
            size++;
        }

        void remove(Node n) {
            n.prev.next = n.next;
            n.next.prev = n.prev;
            size--;
        }

        Node removeLast() {
            if (size == 0) return null;
            Node n = tail.prev;
            remove(n);
            return n;
        }
    }

    int capacity;
    int minFreq = 0;

    HashMap<Integer, Node> map = new HashMap<>();
    HashMap<Integer, DLL> freqMap = new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;

        Node n = map.get(key);
        increaseFreq(n);

        return n.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (map.containsKey(key)) {
            Node n = map.get(key);
            n.val = value;
            increaseFreq(n);
            return;
        }

        if (map.size() == capacity) {
            DLL list = freqMap.get(minFreq);
            Node removed = list.removeLast();
            map.remove(removed.key);
        }

        Node n = new Node(key, value);
        map.put(key, n);

        freqMap.putIfAbsent(1, new DLL());
        freqMap.get(1).add(n);

        minFreq = 1;
    }

    void increaseFreq(Node n) {
        int f = n.freq;

        DLL oldList = freqMap.get(f);
        oldList.remove(n);

        if (f == minFreq && oldList.size == 0)
            minFreq++;

        n.freq++;

        freqMap.putIfAbsent(n.freq, new DLL());
        freqMap.get(n.freq).add(n);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */