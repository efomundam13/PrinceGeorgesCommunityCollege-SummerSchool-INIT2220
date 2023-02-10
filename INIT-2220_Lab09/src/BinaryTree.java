public class BinaryTree<T> implements BinaryTreeInterface<T> {
    private BinaryNode<T> root;

    public BinaryTree() {
        root = null;
    } // end of default constructor

    public BinaryTree(T rootData) {
        root = new BinaryNode<>(rootData);
    } // end of type constructor #1

    public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
        initializeTree(rootData, leftTree, rightTree);
    } // end of type constructor #2

    public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
        initializeTree(rootData, (BinaryTree<T>)leftTree, (BinaryTree<T>)rightTree);
    } // end of setTree

    public void setRootData(T rootData) {
        root.setData(rootData);
    } // end of setRootData

    public T getRootData() {
        if(isEmpty()) {
            throw new EmptyTreeException("The tree is empty...");
        }
        else {
            return root.getData();
        }
    } // end of getRootData

    public boolean isEmpty() {
        return root == null;
    } // end of isEmpty

    public void clear() {
        root = null;
    } // end of clear

    protected void setRootNode(BinaryNode<T> rootNode) {
        root = rootNode;
    } // end of setRootNode

    protected BinaryNode<T> getRootNode() {
        return root;
    } // end of getRootNode

    private void initializeTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
        // create a new BinaryNode containing the given data "rootData".
        root = new BinaryNode<>(rootData);

        // check to see if the left subtree exists and is not empty.
        if((leftTree != null) && !leftTree.isEmpty()) {
            // if so, attach the left subtree's root node to
            // the new BinaryNode as a left child.
            root.setLeftChild(leftTree.root);
        }

        // check to see if the right subtree exists and is not empty.
        if((rightTree != null) && !rightTree.isEmpty()) {
            // also, check to see if the right subtree is distinct
            // from the left subtree.
            if(rightTree != leftTree) {
                // if so, attach the right subtree's root node
                // to the new BinaryNode as a right child.
                root.setRightChild(rightTree.root);
            }
            else {
                // otherwise, attach a copy of the right subtree
                // to the new BinaryNode instead.
                root.setRightChild(rightTree.root.copy());
            }
        } // end if

        // check to see if the left subtree exists and differs from
        // the tree object used to call initializeTree method.
        if((leftTree != null) && (leftTree != this)) {
            // if so, set the left subtree's data field
            // "root" to null by calling the clear method.
            leftTree.clear();
        }

        // check to see if the right subtree exists and differs from
        // the tree object used to call initializeTree method.
        if((rightTree != null) && (rightTree != this)) {
            // if so, set the right subtree's data field
            // "root" to null by calling the clear method.
            rightTree.clear();
        }
    } // end of initializeTree

    /** calls postorderTraverse(BinaryNode<T> node)
     * prints (using post-order traversal) all nodes in the "whole" tree */
    public void postorderTraverse() {
        // perform post-order traversal of the whole tree.
        postorderTraverse(root);
    } // end of postorderTraverse

    /** A Recursive Method in the BinaryTree Class
     * prints (using post-order traversal) all nodes in the subtree rooted at this node.*/
    private void postorderTraverse(BinaryNode<T> node) {
        if(null != node) {
            postorderTraverse(node.getLeftChild());
            postorderTraverse(node.getRightChild());
            System.out.println(node.getData());
        }
    } // end of postorderTraverse

    /** The following calls postorderTraverse_binaryNodeMethod(), which is a recursive binaryNode class method
     * prints (using post-order traversal) all nodes in the "whole" tree */
    public void postorderTraverse_callBinaryNodeMethod() {
        if (isEmpty()) {
            throw new EmptyTreeException("The tree is empty...");
        }
        else {
            getRootNode().postorderTraverse_binaryNodeMethod();
        }
    }

    /** calls getHeight(BinaryNode<T> node)
     @return  The height of the "whole" tree */
    public int getHeight() {
        return getHeight(root);
    } // end of getHeight

    /** A Recursive Method in the BinaryTree Class
     * Computes the height of the subtree rooted at this node.
     @return  The height of the subtree rooted at this node. */
    private int getHeight(BinaryNode<T> node) {
        int height = 0;

        if(node != null) {
            height = 1 + Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()));
        }
        return height;
    } // end of getHeight

    /** The following calls getHeight_binaryNodeMethod() which is a recursive binaryNode class method
     * Computes the height of the "whole" tree.
     @return  The height of the "whole" tree. */
    public int getHeight_callBinaryNodeMethod() {
        if(isEmpty()) {
            throw new EmptyTreeException("The tree is empty...");
        }
        else {
            return getRootNode().getHeight_binaryNodeMethod();
        }
    } // end of getHeight_callBinaryNodeMethod

    /** calls getNumberOfNodes(BinaryNode<T> node)
     @return  The number of nodes in the "whole" tree */
    public int getNumberOfNodes() {
        return getNumberOfNodes(getRootNode());
    } // end of getNumberOfNodes

    /** A Recursive Method in the BinaryTree Class
     * Counts the nodes in the subtree rooted at this node.
     @return  The number of nodes in the subtree rooted at this node. */
    private int getNumberOfNodes(BinaryNode<T> node) {
        int leftNumber = 0;
        int rightNumber = 0;

        // check to see if node is not equal to null
        // in order to avoid dereferencing a null pointer.
        if (null != node) {
            // if so, return the number of nodes in the subtree
            // rooted at this node, including this one.
            leftNumber = getNumberOfNodes(node.getLeftChild());
            rightNumber = getNumberOfNodes(node.getRightChild());
            return 1 + leftNumber + rightNumber;
        }
        // otherwise, return 0;
        return 0;
    } // end of getNumberOfNodes

    /** The following calls getNumberOfNodes_binaryNodeMethod() which is a recursive binaryNode class method
     * Counts the nodes in the "whole" tree
     @return  The number of nodes in the "whole" tree. */
    public int getNumberOfNodes_callBinaryNodeMethod() {
        int numberOfNodes = 0;

        if(root != null) {
            numberOfNodes = root.getNumberOfNodes_binaryNodeMethod();
        }
        return numberOfNodes;
    } // end of getNumberOfNodes_callBinaryNodeMethod
} // end of "BinaryTree" class