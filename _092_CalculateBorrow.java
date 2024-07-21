import java.util.Scanner;

public class _092_CalculateBorrow {
    public String calculateBorrow(int num1,int num2){
        int count = 0;
        if (num2 > num1){
            return "Not Possible";
        }else{
            boolean flag = false;
            while (num1 != 0 && num2 !=0){
                int temp1 = 0;
                int temp2 = num2 % 10;
                if (flag){
                    temp1 = num1 % 10 - 1;
                }
                else {
                    temp1 = num1 % 10;
                }
                if (temp1 < temp2){
                    count++;
                    flag = true;
                }else {
                    flag = false;
                }
                num1 = num1 / 10;
                num2 = num2 / 10;
            }
        }
        return String.valueOf(count);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter First number");
        int num1 = sc.nextInt();
        System.out.println("Enter Second number");
        int num2 = sc.nextInt();
        _092_CalculateBorrow j = new _092_CalculateBorrow();
        System.out.println(j.calculateBorrow(num1,num2));
    }
}
