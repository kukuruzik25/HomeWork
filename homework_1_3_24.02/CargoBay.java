public class CargoBay<T> {

    private T[] items;
    private int size;

    public CargoBay(T[] objects) {
        this.items = objects;
        this.size = 0;
    }

    public void add(T item) {
        this.items[size] = item;
        size++;
    }

    public T get(int index) {
        return this.items[index];
    }

    public T[] getAll() {
        return items;
    }

    public int getSize() {
        return size;
    }

}
