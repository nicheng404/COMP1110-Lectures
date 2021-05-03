package comp1110.lectures.A02;

import comp1110.lectures.A01.List;

public class LinkedList<T> implements List<T> {
    class LLNode {
        T value;
        LLNode next;

        public LLNode(T value, LLNode next) {
            this.value = value;
            this.next = next;
        }

        /**
         * @param index how many nodes after this node to look for the target value
         *              e.g. index == 0 means this node,
         *              index == 1 means the next node, and so on
         * @return the value at the node that is <code>index</code> nodes after this node
         */
        T getRecursive(int index) {
            if (index == 0) {
                return value;
            } else {
                if (this.next == null) {
                    throw new IndexOutOfBoundsException("Tried to traverse past the end of the list");
                }
                return this.next.getRecursive(index - 1);
            }
        }

        /**
         * @param index how many nodes after this node to look for the target node to be removed
         * @return the value at the node that was removed
         */
        T removeRecursive(int index) {
            if (this.next == null) {
                throw new IndexOutOfBoundsException("Tried to remove a node past the end of the list");
            }
            if (index == 1) {
                T value = this.next.value;
                this.next = this.next.next;
                return value;
            }
            return this.next.removeRecursive(index - 1);
        }

        /**
         * @param newNext
         * @return the start of the new list (once reversed)
         */
        LLNode reverseRecursive(LLNode newNext) {
            LLNode oldNext = this.next;
            this.next = newNext;
            if (oldNext == null) {
                // only one node in this list
                return this;
            } else {
                return oldNext.reverseRecursive(this);
            }
        }

        @Override
        public String toString() {
            return value + " " + next.toString();
        }
    }

    private LLNode start;
    private LLNode end;

    LinkedList() {
        start = end = null;
    }

    @Override
    public void add(T value) {
        LLNode newNode = new LLNode(value, null);
        if (start == null) {
            // list is currently empty
            start = newNode;
            end = start;
        } else {
            end.next = newNode;
            end = end.next;
        }
    }

    @Override
    public T get(int index) {
        if (start == null) {
            throw new IndexOutOfBoundsException("Tried to get an element from an empty list");
        }
        return start.getRecursive(index);
    }

    @Override
    public int size() {
        int size = 0;
        LLNode node = start;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }

    @Override
    public T remove(int index) {
        if (start == null) {
            throw new IndexOutOfBoundsException("Tried to remove an element from an empty list");
        }
        if (index == 0) {
            T value = this.start.value;
            this.start = this.start.next;
            return value;
        } else {
            return this.start.removeRecursive(index);
        }
    }

    @Override
    public void reverse() {
        if (start != null) {
            LLNode oldStart = start;
            start = start.reverseRecursive(null);
            end = oldStart;
        }
    }
}
