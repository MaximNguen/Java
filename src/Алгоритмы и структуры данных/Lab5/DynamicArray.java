
public class DynamicArray {
    private int[] array;
    private int size;

    public DynamicArray() {
        array = new int[2];
        size = 0;
    }

    public void add(int value) {
        if (size == array.length) resize();
        array[size++] = value;
    }

    private void resize() {
        int[] newArray = new int[array.length * 2];
        for (int i = 0; i < array.length; i++) newArray[i] = array[i];
        array = newArray;
    }

    public int get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return array[index];
    }

    public int size() {
        return size;
    }

    public void remove(int index) {
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }
    public boolean contains(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }
}