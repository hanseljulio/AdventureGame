import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ParseFile {
    public static PageTree parseFile(String filePath) throws FileNotFoundException {
        Scanner in = new Scanner(new File(filePath));
        PageTree tree = new PageTree(null); // Initialize new tree
        int pageNumber = 1; // Start from page 1
        Set<Integer> nodeSet = new HashSet<>();

        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] data = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
            PageNode eachNode;
            if (!nodeSet.contains(pageNumber)) { // set up root of the tree
                eachNode = new PageNode(pageNumber, data[data.length - 1]);
                tree.setRoot(eachNode);
            } else {
                eachNode = tree.getNode(pageNumber);
            }

            // Handles ending case. Ending is "ENDING", the text is data[data.length - 1].
            nodeSet.add(pageNumber);
            eachNode.setEnding(line.startsWith("ENDING"));
            eachNode.setText(data[data.length - 1]);

            if (!eachNode.isEnding()) {
                Set<PageNode> childrenSet = new HashSet<>();
                for (int i = 0; i < data.length - 1; i++) {
                    if (!nodeSet.contains(Integer.parseInt(data[i]))) {
                        PageNode child = new PageNode(Integer.parseInt(data[i]));
                        nodeSet.add(Integer.parseInt(data[i]));
                        childrenSet.add(child);
                    } else if (nodeSet.contains(Integer.parseInt(data[i])) && tree.getNode(Integer.valueOf(data[i])).getText() == null) {
                        childrenSet.add(tree.getNode(Integer.parseInt(data[i])));
                    }
                }
                eachNode.setChildren(childrenSet);
            }
            pageNumber++; // move on to the next page
        }
        return tree;
    }
}

