package buildMaxHeap01;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Heaps {
	public static int[] call(int n) {
		Random rand = new Random(); 
	
		int[] a = new int[n];
		for(int i = 0; i <n;i++) {
			a[i] = rand.nextInt(200)-100;
		}
		return a;
		
	}
	public static void build_MaxHeap(int[]a, int n ){
		for(int i=n;i>=0;i--) {
			max_heapify(a,i,n);
		}
		
	}
	public static void max_heapify(int[]a, int i, int n){
		int max = i;
		int left = 2*i+1;
		int right = 2*i+2;
		if((left<n)&&(a[max]<a[left])) {
			max = left;
		}
		if((right<n)&&(a[max]<a[right])){
			max = right;
		}
		if(max!=i) {
			int temp = a[i];
	        a[i] = a[max];
	        a[max] = temp;
	        max_heapify(a,max,n);
			
		}
	
	}
	public static void heap_sort(int[]a,int n){
		build_MaxHeap(a,n);
		for(int i = n-1;i>0;i--) {
			int temp = a[0];
	        a[0] = a[i];
	        a[i] = temp;
	        max_heapify(a,0,i);
			
			
		}
	}
	public static void selection_sort(int[]a,int n){
		for (int i = 0; i < n-1; i++)
        {
			int min = i;
			 for (int j = i+1; j < n; j++)
	                if (a[j] < a[min])
	                    min = j;
			 
			 int temp = a[min];
	         a[min] = a[i];
	         a[i] = temp;
        }
	}
	
	public static void main(String[] args) {
		System.out.println("partA");
		Scanner userInt = new Scanner(System.in);
		boolean loop = true;
		boolean loop2 = true;

		int x = 0;
		while(loop == true){
			System.out.println("Enter a valid positive integer: ");
			 x = userInt.nextInt();
			if(x<0) {
				System.out.println("Not valid positive integer");
				loop=true;
			}
			else {
				loop =false;
			}
		}
		int[] a; 
		a = call(x);
		int n = a.length;
		System.out.println("unsorted array of size n");
		System.out.println(Arrays.toString(a));
		heap_sort(a, n);
		System.out.println("Heapsorted array");
		System.out.println(Arrays.toString(a));
		System.out.println("Part A Q4");
		a = call(1000);
		n = a.length;
		long start = System.nanoTime();
		for(int i = 0; i<100;i++) {
			heap_sort(a,n);
		}
		long end = System.nanoTime();
        long nano = end - start;
        System.out.println("Heap-sort average runtime: " + nano +" nano seconds");
        a = call(1000);
        n = a.length;
        long start2 = System.nanoTime();
        for(int i = 0; i<100;i++) {
			selection_sort(a,n);
		}
        long end2 = System.nanoTime();
        long nano2 = end2 - start2;
        System.out.println("Selection-sort average runtime: " + nano2 +" nano seconds");
        System.out.println("The time complexity of heap sort is nlogn compared to selection sort which is n^2");
        System.out.println("heapify time complexity is Logn and build heap is n giving a total time complexity of nlogn ");
        System.out.println("two for loops n*n = n^2");

       
        System.out.println("Part B");

        a = call(10);
        n = a.length;
        System.out.println("Unsorted array of size 10");
		System.out.println(Arrays.toString(a));
		heap_sort(a, n);
		System.out.println("Heapsorted array");
		System.out.println(Arrays.toString(a));
	}


}
