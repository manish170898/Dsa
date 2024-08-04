package org.dsa;

public class Main {
        public static void main(String[] args) {
            int[] arr = {0, 1, 2, 3, 4, 5, 6, 7}; // Example array
            rearrangeArray(arr);

            // Print the rearranged array
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        public static void rearrangeArray(int[] arr) {
            int n = arr.length;
            int mid = n / 2;

            // Perform the rearrangement in place
            for (int i = 0; i <= mid; i++) {
                int temp = arr[mid + i];
                // Shift elements to make space for the new arrangement
                for (int j = mid + i; j > i + i; j--) {
                    arr[j] = arr[j - 1];
                }
                // Place the mid element at its new position
                arr[i + i] = temp;
            }
        }
}
