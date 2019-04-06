package com.danske.test;


import java.util.List;

/**
 * Hello world!
 *
 * @since
 */
public class App {
    public static void main(String[] args) {
        //files are presnt on /resources folder under main folder
        //numbers must be space separated
        String fileName = "input2.txt";//"input1.txt"
        FileUtilities fileOp = new FileUtilities();
        List<List<Integer>> inputList = fileOp.readFile(fileName);
        System.out.println("Output:");
        List<Node> listOfNodes = OtherUtilities.findNodes(inputList);
        Node node = OtherUtilities.findMaxNode(listOfNodes);
        printResult(node);
    }

    private static void printResult(Node node) {
        if (node != null) {
            System.out.println("Maximum Sum: " + node.getSum());
            System.out.println("Path: " + node.getRoute());
        } else {
            System.out.println("Bottom of the pyramid un-reachable");
        }
    }
}
