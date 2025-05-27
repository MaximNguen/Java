class LinkedList{
    private Node head;
    private Node tail;

    private static class Node{
        String data;
        Node next;
        Node prev;

        Node(String data){
            this.data = data; // Принимает переменную, переданную в основном файле
        }
    }

    public void MoreImportant(String data){ // Добавляет более важное дело в начало
        Node newNode = new Node(data); // Создается новая узел с ссылкой для хранения переменной
        if (head == null){ // Если список пустой, то первый элемент списка присваивает статус *Начало* и *Конца*
            head = tail = newNode;
        } else{ // Если список будет состоять как минимум 1 элемент до добавления нового, то ниже будут уже махинации для удаления двойного статуса у первого элемента
            newNode.next = head; // Перекидывает старый элемент (Начало) на +1 индекс
            head.prev = newNode; // Возвращается на -1 индекс и присваивает новый элемент
            head = newNode; // Ссылка на начало присваивает новый элемент, чтобы в дальнейшем его перекидывать на +1 индекс, если будут добавляться другие элементы в начало
        }
    }

    public void LessImportant(String data){
        Node newNode = new Node(data); // Аналогично работает с концом
        if (tail == null) {
            head = tail = newNode;
        } else{
            tail.next = newNode; // Новый элемент в конце
            newNode.prev = tail; // Предыдущий берет старый элемент
            tail = newNode; //Ссылка на конец забирает новый элемент для дальнейшей работы
        }

    }
    public void RemoveMoreImportant() { // Удаляет элемент в начале
        if (head == null) return; // Работает, если список пустой
        if (head == tail) { // Если список состоит из 1 элемента, то удаляет его
            head = tail = null;
        } else {
            head = head.next; // Ссылка на начало переходит на +1 индекс
            head.prev = null; // Самая начальный элемент удаляется
        }
    }

    public void RemoveLessImportant() {
        if (tail == null) return; // Аналогично работает и удалением в конце
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    public void printList() { // Вывод списка для проверки
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }
}