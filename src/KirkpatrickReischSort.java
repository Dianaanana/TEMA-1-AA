import java.util.Comparator;
import java.util.List;

public class KirkpatrickReischSort extends HybridSortAlgorithm {
    private static int vectorIndex = 0;

    public KirkpatrickReischSort(int[] arr, int size) {
        super(arr, size);
    }

    public static void sortData(int[] a, int n)
    {
        int bitsChunk = (int) Math.round(Math.log(n));
        TreeNode root = new TreeNode();
        for (int i = 0; i < n; i++) {
            TreeNode node = root;
            int chunks = (int) Math.ceil(32.0 / bitsChunk);
            for (int j = 0; j < chunks; j++) {
                int bits = getBits(a[i], bitsChunk, j);
                node = addChild(node, bits);
            }
        }

        sortChildren(root);

        addTreeToArray(a, root, 0);
    }

    private static int getBits(int a, int bitsCount, int chunkNo) {
        int result = 0;
        int startingBit = chunkNo * bitsCount;
        int mask = (1 << (31 - startingBit));
        for (int i = 0; i < bitsCount; i++) {
            result = result | (a & mask);
            mask >>= 1;
        }

        return result;
    }

    private static TreeNode addChild(TreeNode node, int elem) {
        TreeNode childNode = node.findNode(elem);
        if (childNode != null) {
            return childNode;
        }

        childNode = new TreeNode(elem);
        node.addChild(childNode);
        return childNode;
    }

    private static void sortChildren(TreeNode node) {
        node.getChildren().sort(Comparator.comparingInt(TreeNode::getElement));
        for (TreeNode child : node.getChildren()) {
            sortChildren(child);
        }
    }

    private static void addTreeToArray(int[] a, TreeNode node, int acumulator) {
        acumulator |= node.getElement();
        List<TreeNode> children = node.getChildren();
        if (children.isEmpty()) {
            a[vectorIndex] = acumulator;
            vectorIndex++;
        } else {
            for (TreeNode child : children) {
                addTreeToArray(a, child, acumulator);
            }
        }
    }

    @Override
    public void run(int algorithmType) {
        KirkpatrickReischSort.vectorIndex = 0;
        long maxMemory = 0;
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        maxMemory = Math.max(maxMemory, totalMemory);
        KirkpatrickReischSort.sortData(arr, size);

        System.out.println("maxMemory is  = " + maxMemory + " bits");
    }
}
