package com.danske.test;

import java.util.ArrayList;
import java.util.List;

/**
 * OtherUtilities class does all the operation to find the nodes
 */
public class OtherUtilities {

    public static List<Node> findNodes(List<List<Integer>> inputList) {
        List<Node> nodes = new ArrayList<Node>();
        // find all result combination
        for (int i = 0; i < inputList.size(); i++) {
            if (i == 0) {
                generateFirstNodes(inputList.get(i), nodes);
            } else {
                List<Node> newNodes = new ArrayList<Node>();
                for (Node node : nodes) {
                    List<Node> tempNodes = findNextNumbersNodes(inputList.get(i), node);
                    if (tempNodes != null) {
                        newNodes.addAll(tempNodes);
                    }
                }
                nodes.clear();
                nodes.addAll(newNodes);
            }
        }
        return nodes;
    }

    private static void generateFirstNodes(List<Integer> inputList, List<Node> nodes) {
        for (int i = 0; i < inputList.size(); i++) {
            Node node = new Node();
            node.setParentIndex(i);
            node.addPoint(inputList.get(i));
            nodes.add(node);
        }
    }

    private static List<Node> findNextNumbersNodes(List<Integer> inputList, Node node) {
        List<Node> nodes = new ArrayList<Node>();
        addToNode(inputList, node.getParentIndex(), node, nodes);
        addToNode(inputList, node.getParentIndex() + 1, node, nodes);
        if (nodes.size() == 0) {
            return null;
        }
        return nodes;
    }

    private static void addToNode(List<Integer> inputList, int index, Node node, List<Node> nodes) {
        if (isIndexAvailable(index, inputList.size())) {
            if (isEvenNumber(inputList.get(index)) != node.isLastPointEven()) {
                Node newNode = node.clone();
                newNode.setParentIndex(index);
                newNode.addPoint(inputList.get(index));
                nodes.add(newNode);
            }
        }
    }

    public static boolean isIndexAvailable(int index, int inputArraySize) {
        if (index >= inputArraySize) {
            return false;
        }
        return true;
    }

    public static boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }

    public static Node findMaxNode(List<Node> nodes) {
        int max = 0;
        int maxIndex = -1;
        for (int i = 0; i < nodes.size(); i++) {
            if (maxIndex == -1 || max < nodes.get(i).getSum()) {
                max = nodes.get(i).getSum();
                maxIndex = i;
            }
        }

        if (maxIndex != -1) {
            return nodes.get(maxIndex);
        }
        return null;
    }
}
