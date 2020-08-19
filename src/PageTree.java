import java.util.*;

public class PageTree {
    private PageNode root;

    public PageTree(PageNode root) {
        this.root = root;
    }

    public void setRoot(PageNode root) {
        this.root = root;
    }

    public PageNode getNode(int pageNumber) {
        if (root == null) {
            return null;
        } else {
            Queue<PageNode> queue = new LinkedList<>();
            queue.add(root);
            while (queue.size() > 0) {
                PageNode current = queue.remove();
                queue.addAll(current.getChildren());
                if (current.getPageNumber() == pageNumber) {
                    return current;
                }
            }
            return null;
        }
    }

    public PageNode getRoot() {
        return root;
    }

    public List<PageNode> cheat(int desiredEnding) {
        LinkedList<PageNode> path = new LinkedList<>();
        path.add(root);
        List<PageNode> result = new ArrayList<>();
        return helper(path, root, desiredEnding, result);

    }

    public List<PageNode> helper(LinkedList<PageNode> path, PageNode current, int desiredEnding, List<PageNode> result) {
        if (current.getPageNumber() == desiredEnding) {
            return path;
        } else {
            if (current.getChildren().size() > 1) {
                for (PageNode child : current.getChildren()) {
                    path.add(child);
                    result = helper(path, child, desiredEnding, result);
                    if (result != null) {
                        return result;
                    }
                    if (!current.isEnding()) {
                        path.remove(child);
                    }
                }
            } else if (current.getChildren().size() > 1) {
                path.add(current);
                return result;
            }
        }
        return null;
    }
}