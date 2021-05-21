package comp1110.lectures.A05;

import comp1110.lectures.A04.HashSet;
import comp1110.lectures.A04.Set;

import java.util.ArrayList;
import java.util.List;

public class BSTSet<T extends Object & Comparable<? super T>> implements Set<T> {
    /**
     * This class represents a binary search tree
     * (or equivalently, a node of such a tree).
     */
    class BSTree {
        T value;
        BSTree left, right;

        BSTree(T value) {
            this.value = value;
        }

        /**
         * Add an entire subtree to the tree rooted at this node.
         *
         * @param subtree a binary search tree (or subtree) to add to this tree
         * @return true if the tree was successfully added; false if the value
         * at the root node of 'subtree' was already contained in the tree
         */
        boolean addSubtree(BSTree subtree) {
            if (subtree == null) return false;
            int comparison = subtree.value.compareTo(value);
            if (comparison < 0) {
                if (left != null) {
                    left.addSubtree(subtree);
                } else {
                    left = subtree;
                }
                return true;
            } else if (comparison > 0) {
                if (right != null) {
                    right.addSubtree(subtree);
                } else {
                    right = subtree;
                }
                return true;
            } else {
                return false;
            }
        }

        /**
         * /**
         * Find the given element in the tree, and return the tree that is
         * rooted at the node containing the element.
         * If the element is found and 'remove' is true, remove the node
         * containing the element (and its subtrees) from the tree.
         *
         * @param element the element to find in the tree, may not be null
         * @param remove  whether to remove the node that contains the given element (if found)
         * @return the node that contains the given element, or null if the
         * element is not contained in the tree
         */
        BSTree find(T element, boolean remove) {
            int comparison = element.compareTo(value);
            if (comparison == 0) {
                return this;
            } else if (comparison < 0) {
                if (left != null) {
                    BSTree found = left.find(element, remove);
                    if (found == left && remove) {
                        left = null;
                    }
                    return found;
                } else {
                    return null;
                }
            } else {
                if (right != null) {
                    BSTree found = right.find(element, remove);
                    if (found == right && remove) {
                        right = null;
                    }
                    return found;
                } else {
                    return null;
                }
            }
        }

        /**
         * Add the elements in this tree to the given list of elements,
         * in the order in which they are sorted in the tree.
         *
         * @param elements the list of elements to which the elements in this
         *                 tree are to be added
         */
        void addElements(List<T> elements) {
            if (left != null) {
                left.addElements(elements);
            }
            elements.add(value);
            if (right != null) {
                right.addElements(elements);
            }
        }
    }

    /**
     * The root node of the tree containing all elements of the set.
     */
    private BSTree root;
    private int numElements;

    @Override
    public boolean add(T element) {
        if (element == null) return false;
        BSTree newNode = new BSTree(element);
        if (root == null) {
            root = newNode;
            numElements++;
            return true;
        } else {
            boolean added = root.addSubtree(newNode);
            if (added) numElements++;
            return added;
        }
    }

    @Override
    public boolean remove(T element) {
        if (element != null && root != null) {
            BSTree removedNode = root.find(element, true);
            if (removedNode != null) {
                // we found it!
                if (removedNode == root) {
                    if (removedNode.left != null) {
                        root = removedNode.left;
                        root.addSubtree(removedNode.right);
                    } else if (removedNode.right != null) {
                        root = removedNode.right;
                    } else {
                        root = null;
                    }
                } else {
                    // add the left and right children of the removed node back onto the root
                    root.addSubtree(removedNode.left);
                    root.addSubtree(removedNode.right);
                }
                numElements--;
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean contains(T element) {
        if (element != null && root != null) {
            return root.find(element, false) != null;
        }
        return false;
    }

    @Override
    public int size() {
        return numElements;
    }

    @Override
    public Object[] toArray() {
        List<T> elements = new ArrayList<>();
        if (root != null) {
            root.addElements(elements);
        }
        return elements.toArray();
    }

    @Override
    public Set<T> newInstance() {
        return new BSTSet<>();
    }
}
