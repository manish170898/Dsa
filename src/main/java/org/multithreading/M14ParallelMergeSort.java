package org.multithreading;

public class M14ParallelMergeSort {
    static int[] arr;
    public void parallelMergeSort(int low, int high, int numberOfThreads){
        if(numberOfThreads <= 1){
            mergeSort(low,high);
            return;
        }

        int middle = (low + high)/2;
        Thread leftSorted = createThread(low,middle, numberOfThreads);
        Thread rightSorted = createThread(middle+1,high, numberOfThreads);

        leftSorted.start();
        rightSorted.start();

        try {
            leftSorted.join();
            rightSorted.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        mergeBoth(low, middle, high);
    }
    private Thread createThread(int low, int high, int numberOfThreads){
        return new Thread(() -> parallelMergeSort(low, high, numberOfThreads/2));
    }

    public static void main(String[] args) {
        arr = new int[1000000];
        for(int i=0; i<arr.length; i++){
            arr[i] = (int)(Math.random() * 1000 + Math.random()*100 + Math.random() * 10 + Math.random());
        }

        M14ParallelMergeSort sort = new M14ParallelMergeSort();
        long startTime = System.currentTimeMillis();
        sort.parallelMergeSort(0, arr.length-1, 6);
        long endTime = System.currentTimeMillis();

//        long startTime = System.currentTimeMillis();
//        sort.mergeSort(0, arr.length-1);
//        long endTime = System.currentTimeMillis();

        System.out.println("Time take :" + (endTime-startTime));
    }

    public void mergeSort(int low, int high){
        if(low >= high){
            return;
        }
        int mid = (low+high)/2;
        mergeSort(low, mid);
        mergeSort(mid+1, high);
        mergeBoth(low, mid, high);
    }

    private void mergeBoth(int low, int mid, int high) {
        int[] temp = new int[high+1];
        int left = low;
        int right= mid +1;
        int i=0;
        while (left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp[i] = arr[left];
                left++;
                i++;
            }
            else{
                temp[i] = arr[right];
                right++;
                i++;
            }
        }
        while (left<=mid){
            temp[i] = arr[left];
            left++;
            i++;
        }
        while (right<=high){
            temp[i] = arr[right];
            right++;
            i++;
        }
        for (int j= low; j<=high; j++){
            arr[j] = temp[j-low];
        }
    }
}
