public interface PriorityQueue<E extends Comparable<E>> {
    void add(E value);

    E remove();

    boolean isEmpty();
}