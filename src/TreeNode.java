import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    private int elem;
    private final List<TreeNode> children = new ArrayList<>();

    public TreeNode() {
    }

    public TreeNode(int elem) {
        this.elem = elem;
    }

    public void addChild(TreeNode childNode) {
        children.add(childNode);
    }

    public TreeNode findNode(int elem) {
        for (TreeNode child : children) {
            if (child.elem == elem) {
                return child;
            }
        }

        return null;
    }

    public int getElement() {
        return elem;
    }

    public List<TreeNode> getChildren() {
        return children;
    }
}
