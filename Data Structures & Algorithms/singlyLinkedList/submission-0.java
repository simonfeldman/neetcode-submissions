
class Node {
    int val;
    Node next;
    Node(int val) {
        this.val = val;
        this.next = null;
    }
}
class LinkedList {
    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int get(int index) {
        Node current = head;
        int currentIndex = 0;

        if (head == null || index < 0) {
            return -1;
        }
        while(current != null) {
            if (currentIndex == index) {
                return current.val;
            }
            current = current.next;
            currentIndex++;
        }
        return -1;
    }

    public void insertHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void insertTail(int val) {
        Node newNode = new Node(val);
        
        if (head == null) {
            head = newNode;
            size++;
            return;
        }
        Node current = head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        size++;
    }

    public boolean remove(int index) {
        if (index < 0 || index >= size || head == null) {
            return false;
        }
        if (index == 0) {
            head = head.next;
            size--;
            return true;
        }
        Node current = head;
        for (int i = 0; i < index-1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        size--;
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer>list = new ArrayList<>();
        Node current = head;
        while(current != null) {
            list.add(current.val);
            current = current.next;
        }
        return list;
    }
}
