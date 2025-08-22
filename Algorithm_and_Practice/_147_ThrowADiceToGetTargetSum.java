package Algorithm_and_Practice;

import java.util.ArrayList;

public class _147_ThrowADiceToGetTargetSum {
    public static void main(String[] args) {
        dice("",4);
        System.out.println(diceToGetTargetSum("",4));
        System.out.println(diceWithMultipleFaces(8,8,""));
    }
    static ArrayList<String> diceWithMultipleFaces(int target, int face, String process){
        if (target == 0){
            ArrayList<String> list = new ArrayList<>();
            list.add(process);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= face && i <= target; i++) {
            list.addAll(diceWithMultipleFaces(target-i,face,process+i));
        }
        return list;
    }


    static ArrayList<String> diceToGetTargetSum(String p,int up){
        if (up == 0){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list=  new ArrayList<>();
        for (int i = 1; i <= 6 && i <= up; i++) {
            list.addAll(diceToGetTargetSum(p+i,up-i));
        }
        return list;
    }
    static void dice(String p,int up){
        if (up == 0){
            System.out.println(p);
            return;
        }
        ArrayList<Integer> list=  new ArrayList<>();
        for (int i = 1; i <= 6 && i <= up; i++) {
            dice(p+i,up-i);
        }
    }
}
