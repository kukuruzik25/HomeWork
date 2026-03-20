public class MyHashSet<T> {

    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private MyArrayList<T>[] buckets;
    private int size;

    @SuppressWarnings("unchecked")
    public MyHashSet() {
        buckets = new MyArrayList[DEFAULT_CAPACITY];
        size = 0;
    }

    private int getBucketIndex(T item) {
        int hashCode = item.hashCode();
        return Math.abs(hashCode) % buckets.length;
    }

    public boolean add(T item) {
        int index = getBucketIndex(item);
        if (buckets[index] == null) {
            buckets[index] = new MyArrayList<>();
        }

        MyArrayList<T> bucket = buckets[index];
        if (bucket.contains(item)) {
            return false;
        }

        bucket.add(item);
        size++;

        if ((double) size / buckets.length >= LOAD_FACTOR) {
            resize();
        }
        return true;
    }

    public boolean contains(T item) {
        int index = getBucketIndex(item);
        if (buckets[index] == null) {
            return false;
        }
        return buckets[index].contains(item);
    }

    public boolean remove(T item) {
        int index = getBucketIndex(item);
        if (buckets[index] == null) {
            return false;
        }
        boolean removed = buckets[index].remove(item);
        if (removed) {
            size--;
        }
        return removed;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                buckets[i].clear();
            }
        }
        size = 0;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        MyArrayList<T>[] oldBuckets = buckets;
        buckets = new MyArrayList[oldBuckets.length * 2];
        size = 0;

        for (MyArrayList<T> bucket : oldBuckets) {
            if (bucket != null) {
                for (int i = 0; i < bucket.size(); i++) {
                    add(bucket.get(i));
                }
            }
        }
    }
}