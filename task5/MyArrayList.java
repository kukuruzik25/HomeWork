public class MyArrayList<T> implements MyList<T> {

    private static final int capacity = 10;

    private T[] arr;
    private int size;

    public MyArrayList() {
        arr =(T[]) new Object[capacity];
        size = 0;
    }

    public void resize() {
        int new_capacity = (int) (arr.length * 1.5);
        T[] new_arr = (T[]) new Object[new_capacity];
        for (int i = 0; i < size; i++) {
            new_arr[i] = arr[i];
        }
        arr = new_arr;
    }

    @Override
    public void add(T item) {
        if (size == arr.length) {
            resize();
        }
        arr[size] = item;
        size++;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("АААААА");
        }
        if (size == arr.length) {
            resize();
        }
        for (int i = size; i > index; i--) {
            arr[i] = arr[i-1];
        }
        arr[index] = item;
        size++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("АААААА");
        }
        return arr[index];
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("АААААА");
        }
        T removee = arr[index];
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i+1];
        }
        arr[size-1] = null;
        size--;
        return removee;
    }

    @Override
    public boolean remove(T item) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(item)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            arr[i] = null;
        }
        size = 0;
    }

    @Override
    public boolean contains(T item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(T item) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }
}
