public class WolfTest {
    public static void main(String[] args) {
        Wolf wolf = new Wolf();
        wolf.nickname = "Фенрир";
        wolf.gender = "мужской";
        wolf.weight = 4000;
        wolf.age = 10000;
        wolf.color = "Черный";

        System.out.println("Кличка - " + wolf.nickname);
        System.out.println("Пол - " + wolf.gender);
        System.out.println("Вес - " + wolf.weight);
        System.out.println("Возраст - " + wolf.age);
        System.out.println("Окрас - " + wolf.color);

        wolf.walk();
        wolf.sit();
        wolf.run();
        wolf.howl();
        wolf.hunt();
    }
}
