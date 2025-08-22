package Algorithm_and_Practice;

class Animal{
    String name;
    int age;
    void show(){
        System.out.println(name+" "+age);
    }
    Animal(String n ,int a){
        System.out.println("Hello Animals");
        name = n;
        age = a;
    }
    Animal(){
        System.out.println("Hi Animals");
        name = "Ram";
        age = 10;
    }
    {
        System.out.println("Person");
    }
}
public class Test{
    public static void main(String[] args) {
        Animal a1 = new Animal("Eages",5);
        Animal a = new Animal();
        Animal aa = new Animal("Eages",6);
        a1.show();
        a.show();
        aa.show();
    }


}
