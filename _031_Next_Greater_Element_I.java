import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class _031_Next_Greater_Element_I {

//    Brute Force Approach.
    public static Integer[] nextGreaterElement(int[] nums1) {
        List<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < nums1.length;i++) {
            arr.add(findmax(nums1, nums1[i], i));
        }
        return arr.toArray(new Integer[0]);
    }
    private static int findmax(int[] nums1, int current_element, int i) {
        for (int j = i+1; j < nums1.length; j++){
            if (nums1[j] > current_element){
                return nums1[j];
            }
        }
        return -1;
    }
// Time Saving Algo.
    public static int[] findnextgreater(int[] nums){
        int[] arr = new int[nums.length];
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = nums.length - 1; i >= 0; i--) {
            int element = nums[i];
            if (stack.isEmpty()){
                stack.push(element);
                arr[i] = -1;
                continue;
            }
            if (stack.peek() > element){
                arr[i] = stack.peek();
                stack.push(element);
                continue;
            }
            while (!stack.isEmpty() && stack.peek() <= element){
                stack.pop();
            }
            if (stack.isEmpty()) {
                arr[i] = -1;
            }else {
                arr[i] = stack.peek();
            }
            stack.push(element);
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] nums = {4,12,5,3,1,2,5,3,1,2,4,6};
        int[] nums1 = {4,1,2};
        int[] nums2 = { 1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElement(nums)));
        System.out.println(Arrays.toString(findnextgreater(nums)));

    }
}
// result arr will be = [ -1, 3, -1]
//                         nums1 = [4, 1, 2] , nums2 = [ 1, 3, 4, 2]
// you pov is from here  | for : 4                             4 there is no greater element on the right hand side of 4. so -1
// means you are seeing  | for : 1                             1 there is 3 the next greater element than. so 3
// the array from this   | for : 2                             2 there is no greater element on the right hand side of 2. so -1
// side                  |

// result arr will be  = [ 3, -1 ]
// ->                    nums1 = [2, 4] , nums2 = [ 1, 2, 3, 4]
// you pov is from here  | for : 2                             2 there is  the next greater element than. so 3.
// means you are seeing  | for : 4                             4 there is no greater element on the right hand side of 4. so -1.
// the array from this   |
// side                  |

// result = [ 12 , -1, 6, 5, 2, 5, 6, 4, 2, 4, 6, -1 ]
//-> pov                   nums = [4, 12, 5, 3, 1, 2, 5, 3, 1, 2, 4, 6]
//   for every ele. start | for 1st element i.e. 4 next greater element on right hand side is 12.
//   searching the next   | for 2nd element i.e. 12 no greater element on right hand side. so -1
//   greater element in   | for 3rd element i.e. 5 next greater in right hand side element is 6.
//   right hand side.     | for 4th element i.e. 3 next greater element on right hand side is 5.
//                        | for 5th element i.e. 1 next greater element on right hand side is 2.
//                        | for 6th element i.e. 2 next greater element on right hand side is 5.
//                        | for 7th element i.e. 5 next greater element on right hand side is 6.
//                        | for 8th element i.e. 3 next greater element on right hand side is 4.
//                        | for 9th element i.e. 1 next greater element on right hand side is 2.
//                        | for 10th element i.e. 2 next greater element on right hand side is 4.
//                        | for 11th element i.e. 4 next greater element on right hand side is 6.
//                        | for 12th element i.e. 6 no greater element on right hand side. so -1.
