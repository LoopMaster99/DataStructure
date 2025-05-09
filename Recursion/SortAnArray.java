package Recursion;

import java.util.*;;

public class SortAnArray {
    private void insertElement(List<Integer> list, int temp, int n){
        /* Base Condition (when list is empty, its ok to insert the element
           but in case of not, if last element is smaller than inserted element
           than no need to smaller the input just add the element the last) */ 

        if(n == 0 || list.get(n - 1) <= temp){          
            list.add(temp);                         // adding element at last
            return;
        }    
        
        int val = list.get(n - 1);
        list.remove(n - 1);                 // store and remove the last element

        insertElement(list, temp, list.size());     // Recursive call of Smaller Input

        list.add(val);          // adding back the removed element 

        return;
    }

    private void sort(List<Integer> list, int n){
        if(n == 1){         // Base Condition (automatically sorted when 1 element is left)
            return;
        }    

        int temp = list.get(n - 1);
        list.remove(n - 1);                     // Store and Remove the last element

        sort(list, list.size());            // Recursive call of Smaller Input

        insertElement(list, temp, list.size());

        return; 
    }

    public void sortArr(int[] arr){
        List<Integer> list = new ArrayList<>();

        for(int val : arr) list.add(val);

        sort(list, list.size());

        int i = 0;
        for(Integer val : list) arr[i++] = val;

        return;
    }
}
