package Data_Structures;

import java.util.Arrays;

public class _001_Delete_An_Element_From_Array {

    public static int[] delete_Element(int[] arr, int index) {
        int[] temp = new int[arr.length - 1];
        for (int i = 0; i < arr.length; i++) {
            if (i < index) {
                temp[i] = arr[i];
            } else if (i == index) {
                continue;
            } else {
                temp[i - 1] = arr[i];
            }
        }
        return temp;
    }
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50,60};
        int i = 1;
        System.out.println(Arrays.toString(delete_Element(arr,i)));
    }
}
