/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iterativoquicksort;

/**
 *
 * @author Andreu Luna Font
 */
public class IterativoQuicksort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        IterativoQuicksort iq = new IterativoQuicksort();
        int arr[] = {12, 32, 5,3,3,35,22,76,89,123,56,32,876};
        iq.QuickSort(arr, 0, arr.length - 1);
        iq.printArr(arr, arr.length);
    }
    
    void swap(int arr[], int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    /** 
     * método para ordenar las los stacks
    */
    int partition(int arr[], int l, int h) {
        int x = arr[h];
        int i = (l - 1);

        for (int j = l; j <= h - 1; j++) {
            if (arr[j] <= x) {
                i++;
                // swap arr[i] y arr[j]
                swap(arr, i, j);
            }
        }
        // swap arr[i+1] y arr[h]
        swap(arr, i + 1, h);
        return (i + 1);
    }

    
    void QuickSort(int arr[], int l, int h) {
        
        int stack[] = new int[h - l + 1];

        int top = -1;

        stack[++top] = l;
        stack[++top] = h;

        while (top >= 0) {
            // pop h and l
            h = stack[top--];
            l = stack[top--];

            // set pivot element at it's proper position
            int p = partition(arr, l, h);

            // If there are elements on left side of pivot,
            // then push left side to stack
            if (p - 1 > l) {
                stack[++top] = l;
                stack[++top] = p - 1;
            }

            // If there are elements on right side of pivot,
            // then push right side to stack
            if (p + 1 < h) {
                stack[++top] = p + 1;
                stack[++top] = h;
            }
        }
    }

    // A utility function to print contents of arr
    void printArr(int arr[], int n) {
        int i;
        for (i = 0; i < n; ++i) {
            if(i==n-1){
                System.out.println(arr[i]);
            }
            else{
                System.out.print(arr[i] + " < ");
            }
            
        }
    }
}
