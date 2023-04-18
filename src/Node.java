import java.util.ArrayList;
import java.util.Arrays;

public class Node {
    public String name;

    public Boolean visited;
    public ArrayList<Node> nodeList = new ArrayList<>();

    //constructor
    public Node (String name) {
        this.name = name;
        this.visited = false;
    }


    public void insertFollows(Node node) {
        this.nodeList.add(node);
    }

    public ArrayList<Node> getNodeList () {
        return this.nodeList;
    }


    public void printNodeList() {
        for (Node n: nodeList) {
            System.out.print(n.name + " ");
        }
    }


    public boolean setVisited(Boolean x) {
        this.visited = x;
        return x;
    }

    public void print() {
        System.out.print(name + " follows: ");
        printNodeList();
        System.out.println();
    }

}
