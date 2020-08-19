import java.util.*;

public class Playthrough {
    private LinkedList<PageNode> choices = new LinkedList<>();
    private PageTree book;

    public Playthrough(PageTree book) {
        this.book = book;
    }

    public LinkedList<PageNode> getChoices() {
        return choices;
    }

    public void playGame() {
        PageNode node = book.getRoot();
        choices.add(node);
        playGame("1");
        System.out.println(node.getText());
    }


    public void playGame(String option) {
        PageNode node = book.getNode(Integer.parseInt(option));
        while (!node.isEnding()) {
            System.out.println(node.getText());
            System.out.println("Choose an option > " + getOption(node));
            int choice = new Scanner(System.in).nextInt();
            node = book.getNode(choice);
            choices.add(node);
        }
        System.out.println(node.getText());
    }

    public void truncateChoices(int pageNumber) { // If equals to pagenumber, remove everything after it.
        LinkedList<PageNode> current = choices;
        PageNode current2 = current.getLast();
        int index = choices.size() - 1;
        while (current2.getPageNumber() != pageNumber) {
            current.remove(index);
            current2 = current.getLast();
            index--;
        }
        choices = current;
    }

    public String getOption(PageNode input) {
        int bigNum = 0;
        int smallNum = 100;
        for (PageNode everyNode : input.getChildren()) {
            if (everyNode.getPageNumber() > bigNum) {
                bigNum = everyNode.getPageNumber();
            }
            if (everyNode.getPageNumber() < smallNum) {
                smallNum = everyNode.getPageNumber();
            }
        }
        return smallNum + ", " + bigNum;
    }
}