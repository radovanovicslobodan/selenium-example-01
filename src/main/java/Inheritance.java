class Parent {

    public int a = 10;

    public void print() {
        System.out.println("abc");
    }
}

class Child extends Parent {
    public void print() {
        System.out.println("def");
    }
}

public class Inheritance {

    public static void main(String[] args) {
        Child child = new Child();

        child.print();
        int a = child.a;
    }
}
