import java.lang.constant.DynamicCallSiteDesc;
import java.util.*;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;
public class homework6 {

    public static void allFollows(Node x, ArrayList adjList) {
        Stack<Node> nodeStack = new Stack<>();
        Set<String> directNodes = new HashSet<>();
        Set<String> visit = new HashSet<>();

        for (Node a: x.nodeList) {
            visit.add(a.name);
            directNodes.add(a.name);
            nodeStack.add(a);

            for (Node b : nodeStack) {
                for (Node c : b.nodeList) {
                    if (c.nodeList.size() > 0) {
                        for (Node d : c.nodeList) {
                            visit.add(d.name);
                        }
                    }
                }
            }
        }

        System.out.print("The set of people " + x.name + " directly follows is { ");
        for (String e: directNodes) {
            System.out.print(e+ " ");
        }
        System.out.print("}");
        System.out.println();

        System.out.print("The set of people " + x.name + " indirectly follows is { ");
        for (String d: visit) {
            if (directNodes.contains(d) == false) {
                System.out.print(d + " ");
            }
        }
        System.out.print("}");



    }

    public static void main(String[] args) {
        ArrayList<Node> nodes = new ArrayList<>();
        Stack<Node> nodeStack = new Stack<>();

        String userDir = System.getProperty("user.dir");
        String name;
        try {
            File myFile = new File(userDir + "/src/follows_input.txt");
            int i = 0;
            Scanner inputScanner = new Scanner(myFile);
            while (inputScanner.hasNextLine()) {
                String textline = inputScanner.nextLine();
                String info[] = textline.split(", ");
                name = info[0];
                Node node = new Node(name);
                nodes.add(node);
                for (int j=1; j<info.length; j++) {
                    Node follows = new Node(info[j]);
                    node.insertFollows(follows);
                }
                i++;
            }
            inputScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }


        for (Node n: nodes) {
            if (n.nodeList.size() != 0) {
                for (Node e: n.nodeList) {
                    for (Node u: nodes) {
                        if (e.name.equals(u.name)) {
                            e.insertFollows(u);
                        }
                    }
                }
            }
        }


//       allFollows(nodes.get(0), nodes);
//       allFollows(nodes.get(1), nodes);
//       allFollows(nodes.get(2), nodes);
       allFollows(nodes.get(3), nodes);
//       allFollows(nodes.get(4), nodes);
//       allFollows(nodes.get(5), nodes);
//       allFollows(nodes.get(6), nodes);

    }
}
