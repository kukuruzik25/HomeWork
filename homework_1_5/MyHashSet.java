import java.util.ArrayList;

public class MyHashSet<T> {
    private static final int DEFAULT_CAPACITY = 16;

    private ArrayList<T>[] buckets;
    private int size;

    @SuppressWarnings("unchecked")
    public MyHashSet() {
        buckets = new ArrayList[DEFAULT_CAPACITY];
        size = 0;
    }

    private int getBucketIndex(T item) {
        int hashCode = item.hashCode();
        return Math.abs(hashCode) % buckets.length;
    }

    public boolean add(T item) {
        int index = getBucketIndex(item);
        if (buckets[index] == null) {
            buckets[index] = new ArrayList<>();
        }

        ArrayList<T> bucket = buckets[index];
        if (bucket.contains(item)) {
            return false;
        }

        bucket.add(item);
        size++;
        return true;
    }

    public boolean contains(T item) {
        int index = getBucketIndex(item);
        if (buckets[index] == null) {
            return false;
        }
        return buckets[index].contains(item);
    }

    public int size() {
        return size;
    }
}