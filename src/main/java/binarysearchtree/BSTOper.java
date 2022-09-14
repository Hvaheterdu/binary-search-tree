package binarysearchtree;

import java.util.ArrayList;

public interface BSTOper<T> {

    void add(T value);

    boolean remove(T value);

    int size();

    boolean existsInTree(T value);

    T findNearestSmallerThan(T value);

    void addAll(ArrayList<T> objects);

    ArrayList<T> sortedArray();

    ArrayList<T> findInRange(T low, T high);
}
