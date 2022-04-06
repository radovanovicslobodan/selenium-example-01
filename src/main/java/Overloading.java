class Overload {
    public void overloadedMethod() {
        System.out.println("without arguments");
    }

    public void overloadedMethod(String a) {
        System.out.println("with arguments");
    }
}

public class Overloading {

    public static void main(String[] args) {
        Overload overload = new Overload();

        overload.overloadedMethod();
        overload.overloadedMethod("abc");

        String a = new String("aa");
        int b = 10;
        boolean d = true;
        Integer c = 10;
        a.toUpperCase();
    }
}
