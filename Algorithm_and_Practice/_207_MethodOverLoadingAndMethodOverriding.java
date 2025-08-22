package Algorithm_and_Practice;

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
// `Algorithm_and_Practice.C` extends `Algorithm_and_Practice.B`
class C extends B {}
// `Algorithm_and_Practice.D` extends `Algorithm_and_Practice.A`
class D extends A {}
// Abstract class `Algorithm_and_Practice.E`
abstract class E {
    abstract int add2(int a, int b);
}
// Interface `Algorithm_and_Practice.F`
interface F {
    int add3(int a, int b);
}
// `Algorithm_and_Practice.G` extends `Algorithm_and_Practice.B` and implements `Algorithm_and_Practice.F`
class G extends B implements F {
    @Override
    public int add3(int a, int b) {
        return a % b;
    }
}
public class _207_MethodOverLoadingAndMethodOverriding {
    public static void main(String[] args) {
        // Testing `Algorithm_and_Practice.C` which extends `Algorithm_and_Practice.B`
        C c = new C();
        System.out.println("Algorithm_and_Practice.C.add(2,3): " + c.add(2, 3));
        // Testing `Algorithm_and_Practice.D` which extends `Algorithm_and_Practice.A`
        D d = new D();
        System.out.println("Algorithm_and_Practice.D.add1(2,4): " + d.add1(2, 4));
        // Testing `Algorithm_and_Practice.G` which extends `Algorithm_and_Practice.B` and implements `Algorithm_and_Practice.F`
        G g = new G();
        System.out.println("Algorithm_and_Practice.G.add3(5,7): " + g.add3(5, 7));
    }
}
