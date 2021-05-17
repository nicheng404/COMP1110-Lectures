package comp1110.lectures.A06;

import comp1110.lectures.A04.HashSet;
import comp1110.lectures.A04.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {
    class KVPair {
        // BSTMap$KVPair.class
        K key;
        V value;

        public KVPair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * This class represents a binary search tree
     * (or equivalently, a node of such a tree).
     */
    class BSTree {
        KVPair kv;
        BSTree left, right;

        BSTree(KVPair kv) {
            this.kv = kv;
        }

        /**
         * Add an entire subtree to the tree rooted at this node.
         *
         * @param subtree a binary search tree (or subtree) to add to this tree
         * @return true if the tree was successfully added; false if the value
         * at the root node of 'subtree' was already contained in the tree
         */
        V addSubtree(BSTree subtree) {
            if (subtree == null) return null;
            int comparison = subtree.kv.key.compareTo(kv.key);
            if (comparison < 0) {
                V previousValue = null;
                if (left != null) {
                    previousValue = left.addSubtree(subtree);
                } else {
                    left = subtree;
                }
                return previousValue;
            } else if (comparison > 0) {
                V previousValue = null;
                if (right != null) {
                    previousValue = right.addSubtree(subtree);
                } else {
                    right = subtree;
                }
                return previousValue;
            } else {
                // update the value that's currently stored for this key
                V temp = kv.value;
                kv.value = subtree.kv.value;
                return temp;
            }
        }

        /**
         * /**
         * Find the given element in the tree, and return the tree that is
         * rooted at the node containing the element.
         * If the element is found and 'remove' is true, remove the node
         * containing the element (and its subtrees) from the tree.
         *
         * @param key    the key to find in the tree, may not be null
         * @param remove whether to remove the node that contains the given element (if found)
         * @return the node that contains the given element, or null if the
         * element is not contained in the tree
         */
        BSTree find(K key, boolean remove) {
            int comparison = key.compareTo(kv.key);
            if (comparison == 0) {
                return this;
            } else if (comparison < 0) {
                if (left != null) {
                    BSTree found = left.find(key, remove);
                    if (found == left && remove) {
                        left = null;
                    }
                    return found;
                } else {
                    return null;
                }
            } else {
                if (right != null) {
                    BSTree found = right.find(key, remove);
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
         * @param keys the list of keys to which the keys in this
         *             tree are to be added
         */
        void addKeys(Set<K> keys) {
            if (left != null) {
                left.addKeys(keys);
            }
            keys.add(kv.key);
            if (right != null) {
                right.addKeys(keys);
            }
        }
    }

    /**
     * The root node of the tree containing all elements of the set.
     */
    private BSTree root;
    private int numElements;

    @Override
    public V put(K key, V value) {
        if (key == null) throw new IllegalArgumentException("key is null");
        if (value == null) throw new IllegalArgumentException("value is null");
        BSTree newNode = new BSTree(new KVPair(key, value));
        if (root == null) {
            root = newNode;
            numElements++;
            return null;
        } else {
            V added = root.addSubtree(newNode);
            if (added == null) numElements++;
            return added;
        }
    }

    @Override
    public V get(K key) {
        if (key == null) throw new IllegalArgumentException("key is null");
        if (root != null) {
            BSTree node = root.find(key, false);
            if (node != null) return node.kv.value;
        }
        return null;
    }

    @Override
    public boolean remove(K key) {
        if (key == null) throw new IllegalArgumentException("key is null");
        if (root != null) {
            BSTree removedNode = root.find(key, true);
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
    public int size() {
        return numElements;
    }

    @Override
    public Set<K> getKeys() {
        Set<K> keys = new HashSet<>();
        if (root != null) {
            root.addKeys(keys);
        }
        return keys;
    }
}
