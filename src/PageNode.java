import java.util.HashSet;
import java.util.Set;

public class PageNode {
    private int pageNumber;
    private String text;
    private boolean isEnding;
    private Set<PageNode> children = new HashSet<>();

    public PageNode(int pageNumber, String text) {
        this.pageNumber = pageNumber;
        this.text = text;
    }

    public PageNode(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageNumber() {
        return this.pageNumber;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isEnding() {
        return this.isEnding;
    }

    public void setEnding(boolean ending) {
        isEnding = ending;
    }

    public Set<PageNode> getChildren() {
        return children;
    }

    public void setChildren(Set<PageNode> children) {
        this.children = children;
    }

    public String toString() {
        return String.valueOf(pageNumber);
    }

}
