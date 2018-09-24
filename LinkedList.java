
import java.util.NoSuchElementException;
import java.util.Iterator;


    /**
     A linked list is a sequence of nodes with efficient
     element insertion and removal. This class
     contains a subset of the methods of the standard
     java.util.LinkedList class.
     Complete the reverse method by reversing the links in a
     the list. Implement this method by directly rerouting the
     links, not by using an iterator.
     */
    public class LinkedList implements Iterable {
        private Node first;

        /**
         * Constructs an empty linked list.
         */
        public LinkedList() {
            first = null;
        }

        /**
         * Reverses all elements in a linked list.
         */
        public void reverse() {
            // Complete this method
            //you should discuss this with your partner and perhaps draw a picture
            if(first == null)  {return;}
            Node previous = first;
            Node currentNode = first.next;
            first.next = null;

            while(currentNode !=null)   {
                Node holder = new Node();
                holder = currentNode.next;
                currentNode.next = previous;

                previous = currentNode;
                currentNode = holder;
                //LADIES AND GENTLEMEN, WE GOT HIM.
            }
            first = previous;


        }

        /**
         * Adds an element to the front of the linked list.
         *
         * @param element the element to add
         */
        public void addFirst(Object element) {
            //complete this method as we did in class
            Node newFirst = new Node();
            newFirst.data = element;
            newFirst.next = first;
            first = newFirst;



        }

        /**
         * Returns an iterator for iterating through this list.
         *
         * @return an iterator for iterating through this list
         */
        public Iterator iterator() {
            return new LIterator();
        }

        private class Node {
            public Object data;
            public Node next;
        }

        private class LIterator implements Iterator {
            Node position; // keeps track of the current position;
            Node previous;
            Boolean isAfterNext;



            /**
             * Moves the iterator past the next element.
             *
             * @return the traversed element
             */
            public Object next() {
                //complete this method similar to class
                if(!hasNext())  {
                    throw new NoSuchElementException();
                }
                previous = position;
                isAfterNext = true;

                if (position == null)
                {
                    position = first;
                }
                else
                {
                    position = position.next;
                }



                //solution here

                return position.data;
            }

            /**
             * Tests if there is an element after the iterator
             * position.
             *
             * @return true if there is an element after the iterator
             * position
             */
            public boolean hasNext() {
                //this method given to you
                if (position == null)
                    return first != null;
                else
                    return position.next != null;
            }
        }

        public static void main(String[] args) {
            runTests();
        }

        /***
         * Execute the testing methods
         *
         */

        public static void runTests() {
            System.out.print("Test 0: ");
            System.out.println((test0() ? "passed" : "failed"));


            System.out.print("Test 1: ");
            System.out.println((test1() ? "passed" : "failed"));

            System.out.print("Test 2: ");
            System.out.println((test2() ? "passed" : "failed"));

        }


        /*** Below here some tests to ensure everything is working ***/


        public static boolean test0() {
            LinkedList b = new LinkedList();
            b.reverse();

            //nothing to reverse
            return true;

        }

        public static boolean test1() {
            LinkedList a = new LinkedList();

            a.addFirst("A");
            Iterator<String> it = a.iterator();

            if (it.hasNext() != true)
                return false;

            if (!it.next().equals("A"))
                return false;
            if (it.hasNext())
                return false;

            return true;
        }

        public static boolean test2() {
            LinkedList b = new LinkedList();
            b.addFirst("A");
            b.addFirst("B");
            b.addFirst("C");


            Iterator<String> it = b.iterator();

            if (!it.next().equals("C")) {
                return false;
            }
            if (!it.next().equals("B")) {
                return false;
            }

            b.reverse();
            it = b.iterator();
            if (!it.next().equals("A")) {
                return false;
            }

            b.addFirst("D");

            it = b.iterator();
            if (!it.next().equals("D"))
                return false;


            return true;
        }

    }