public class Person {
    String gender = "male";
    String name = "Aleks";
    float height = 1.81f;
    float weight = 82.7f;
    int age = 37;

    public void walk() {
        System.out.println(name + " идет.");
    }

    public void sit() {
        System.out.println(name + " сидит.");
    }

    public void run() {
        System.out.println(name + " бежит.");
    }

    public void speak() {
        System.out.println(name + " говорит.");
    }

    public void learnJava() {
        System.out.println(name + " учит Java.");
    }
}
