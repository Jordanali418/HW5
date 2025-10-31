/******************************************************************
 *
 *   Jordan Ali / 002
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     *      Input: [1,50,55,80,90], [55,90]
     *      Output: true
     *      Input: [1,50,55,80,90], [55,90, 99]
     *      Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return      - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {
        /*
        pseudocode
        create empty set S
        for each x in A -> add x to S
        for each y in B -> if y not in S
                return false
        return true
         */
        java.util.HashSet<Integer> seen = new java.util.HashSet<>();
        for (int x : list1) seen.add(x);
        for (int y : list2) if (!seen.contains(y)) return false;


        return true;
    }


    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     *      Input: [1,7,3,10,34,5,8], 4
     *      Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return      - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {
        /*
        pseudocode
        create min heap H size of <= k
        each element in array
            - add to H
            - if H.size > k -> remove smallest

        return top of H
         */
        java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<>();
        for (int x : array) {
            pq.offer(x);
            if (pq.size() > k) pq.poll();
        }
        if (pq.size() < k) throw new IllegalArgumentException("k too large");
        return pq.peek();

    }


    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     *      Input: [4,1,5], [3,2]
     *      Output: 1 2 3 4 5
     *
     * @param array1    - Input array 1
     * @param array2    - Input array 2
     * @return          - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {
    /*
    pseudocode
        create min heap H
        add all elements from both arrays -> H
        create new array result of H.size
        remove each element from H into result
        return result
     */
        java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<>();
        for (int x : array1) pq.offer(x);
        for (int y : array2) pq.offer(y);
        int[] out = new int[pq.size()];
        int i = 0;
        while (!pq.isEmpty()) out[i++] = pq.poll();
        return out;
    }
}
