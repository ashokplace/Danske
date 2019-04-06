package com.danske.test;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private int sum;
    private List<Integer> path;
    private int parentIndex = -1;

    public Node() {
        sum = 0;
        path = new ArrayList<Integer>();
    }

    public void addPoint(int point) {
        path.add(point);
        sum += point;
    }

    public int getSum() {
        return sum;
    }

    public String getRoute() {
        String route = "";
        for (int point : path) {
            route = route + point + ", ";
        }

        return route.substring(0, route.length()-2);
    }

    public int getParentIndex() {
        return parentIndex;
    }

    public void setParentIndex(int parentIndex) {
        this.parentIndex = parentIndex;
    }

    public boolean isLastPointEven() {
        return isEven(path.get(path.size() - 1));
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public Node clone() {
        Node node = new Node();
        node.setParentIndex(parentIndex);
        for (int point : path) {
            node.addPoint(point);
        }

        return node;
    }

}