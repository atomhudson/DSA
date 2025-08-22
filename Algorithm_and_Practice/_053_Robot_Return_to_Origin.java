package Algorithm_and_Practice;

public class _053_Robot_Return_to_Origin {
    public boolean judgeCircle(String moves) {
        int x = 0 , y = 0;
        for (char c : moves.toCharArray()){
            if (c == 'U') y++;
            else if (c == 'D')y--;
            else if (c == 'R') x++;
            else x--;
        }
        return x==0 && y==0;
    }
    public static void main(String[] args) {
        _053_Robot_Return_to_Origin returnToOrigin = new _053_Robot_Return_to_Origin();
        System.out.println(returnToOrigin.judgeCircle("LL"));

    }
}
