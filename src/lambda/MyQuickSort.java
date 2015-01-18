/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda;

public class MyQuickSort<T> {
     
    private T array[];
    private int length;
    private Functional<T> func;
 
    public void sort(T[] inputArr,Functional<T> func, boolean Ascending) {
         
        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        this.array = inputArr;
        this.func = func;
        length = inputArr.length;
        if(Ascending) quickSort(0, length - 1);
        else quickSortDesc(0, length-1);
    }
 
    private void quickSort(int lowerIndex, int higherIndex) {
         
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        Object o =  func.ComparableObject(array[lowerIndex+(higherIndex-lowerIndex)/2]);
        Comparable<Object> pivot = (Comparable)o;
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (Compare(((Comparable)func.ComparableObject(array[i])), pivot) < 0) {
                i++;
            }
            
            while (Compare(((Comparable)func.ComparableObject(array[j])), pivot) > 0 ) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }
    
    private void quickSortDesc(int lowerIndex, int higherIndex) {
         
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        Object o =  func.ComparableObject(array[lowerIndex+(higherIndex-lowerIndex)/2]);
        Comparable<Object> pivot = (Comparable)o;
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (Compare(pivot,((Comparable)func.ComparableObject(array[i]))) <0 ) {
                i++;
            }
            
            while (Compare(pivot,((Comparable)func.ComparableObject(array[j])))>0 ) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSortDesc(lowerIndex, j);
        if (i < higherIndex)
            quickSortDesc(i, higherIndex);
    }
    
    private void exchangeNumbers(int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
     
    private int Compare(Comparable<Object> o1,Comparable<Object> o2)
    {
        if (o1 == null)
        {
            return (o2 == null) ? 0 : -1;
        }
        if (o2 == null) 
        {
            return 1;
        }
        
        return o1.compareTo(o2);
    }
    /*public static void main(String a[]){
         
        MyQuickSort sorter = new MyQuickSort();
        Integer[] input = {24,2,45,20,56,75,2,56,99,53,12};
        sorter.sort(input,o-> o);
        for(int i:input){
            System.out.print(i);
            System.out.print(" ");
        }
    }*/
}
