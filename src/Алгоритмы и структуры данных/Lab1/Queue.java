class Queue {
    private Node head;
    private Node tail;

    private static class Node{
        int data;
        Node next;
        Node prev;

        Node(int data){
            this.data = data;
        }
    }

    public void In(int data){
        Node newNode = new Node(data); // Аналогично работает как MoreImportant, просто взят из двусвязного списка
        if (head == null){
            head = tail = newNode;
        } else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void Out() {
        if (tail == null) return; // Работает аналогично как RemoveLessImportant, удаление в конце
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
