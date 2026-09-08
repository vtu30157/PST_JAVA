class MyHashSet {

    private static final int BUCKET_SIZE = 1000;
    private Bucket[] buckets;

    public MyHashSet() {
        buckets = new Bucket[BUCKET_SIZE];
        for (int i = 0; i < BUCKET_SIZE; i++) {
            buckets[i] = new Bucket();
        }
    }

    public void add(int key) {
        int bucketIndex = hash(key);
        buckets[bucketIndex].add(key);
    }

    public void remove(int key) {
        int bucketIndex = hash(key);
        buckets[bucketIndex].remove(key);
    }

    public boolean contains(int key) {
        int bucketIndex = hash(key);
        return buckets[bucketIndex].contains(key);
    }

    private int hash(int key) {
        return key % BUCKET_SIZE;
    }

    // Bucket implemented as a simple linked list
    private static class Bucket {
        private LinkedNode head;

        public Bucket() {
            head = new LinkedNode(-1); // dummy head node
        }

        public void add(int key) {
            if (contains(key)) {
                return; // already exists, do nothing
            }
            LinkedNode newNode = new LinkedNode(key);
            newNode.next = head.next;
            head.next = newNode;
        }

        public void remove(int key) {
            LinkedNode prev = head;
            LinkedNode curr = head.next;
            while (curr != null) {
                if (curr.val == key) {
                    prev.next = curr.next;
                    return;
                }
                prev = curr;
                curr = curr.next;
            }
        }

        public boolean contains(int key) {
            LinkedNode curr = head.next;
            while (curr != null) {
                if (curr.val == key) {
                    return true;
                }
                curr = curr.next;
            }
            return false;
        }
    }

    private static class LinkedNode {
        int val;
        LinkedNode next;

        LinkedNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
}

