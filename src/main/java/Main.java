import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

interface Animal {
    public void makeNoise();
}

class Dog implements Animal {

    @Override
    public void makeNoise() {
        System.out.println("avav");
    }
}

class Cat implements Animal {

    @Override
    public void makeNoise() {
        System.out.println("mjau");
    }
}

public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();

        Animal dog1 = new Dog();
        Animal cat1 = new Cat();

        Animal animal = new Dog();

        animal.makeNoise();

        animal = cat;

        animal.makeNoise();

        dog.makeNoise();
        cat.makeNoise();

        dog1.makeNoise();
        cat1.makeNoise();

        WebDriver driver = new ChromeDriver();
        ChromeDriver driver1 = new ChromeDriver();
        driver = new FirefoxDriver();
//        driver1 = new FirefoxDriver();
    }
}
