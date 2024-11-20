class A {
    int add1(int a, int b) {
        return a * b;
    }
}
class B {
    int add(int a, int b) {
        return a / b;
    }
}
// `C` extends `B`
class C extends B {}
// `D` extends `A`
class D extends A {}
// Abstract class `E`
abstract class E {
    abstract int add2(int a, int b);
}
// Interface `F`
interface F {
    int add3(int a, int b);
}
// `G` extends `B` and implements `F`
class G extends B implements F {
    @Override
    public int add3(int a, int b) {
        return a % b;
    }
}
public class _207_MethodOverLoadingAndMethodOverriding {
    public static void main(String[] args) {
        // Testing `C` which extends `B`
        C c = new C();
        System.out.println("C.add(2,3): " + c.add(2, 3));
        // Testing `D` which extends `A`
        D d = new D();
        System.out.println("D.add1(2,4): " + d.add1(2, 4));
        // Testing `G` which extends `B` and implements `F`
        G g = new G();
        System.out.println("G.add3(5,7): " + g.add3(5, 7));
    }
}
