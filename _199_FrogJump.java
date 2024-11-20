/*
Distance to Cover: The frog needs to cover a distance = 𝑌 − 𝑋
Number of Jumps: Each jump covers
D units. The minimal number of jumps required can be
calculated as the ceiling of (distance / 𝐷)
 .
 */
class FrogJump{
    int frogJump(int x, int y, int d){
        return (int) Math.ceil((double) (y-x) / d);
    }
}
public class _199_FrogJump {
    public static void main(String[] args) {
        FrogJump sol = new FrogJump();

        System.out.println(sol.frogJump(10,85,30));
    }
}
