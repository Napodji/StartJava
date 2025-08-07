public class WolfTest {
    public static void main(String[] args) {
        Wolf wolf = new Wolf();

        wolf.setNickname("Фенрир");
        wolf.setGender("мужской");
        wolf.setWeight(4000);
        wolf.setAge(10000);
        wolf.setColor("Черный");

        System.out.println("Кличка - " + wolf.getNickname());
        System.out.println("Пол - " + wolf.getGender());
        System.out.println("Вес - " + wolf.getWeight() + " кг");
        if ("Фенрир".equals(wolf.getNickname())) {
            System.out.println("Возраст - " + wolf.getAge() + " лет" + ", Фенрир очень древний!");
        } else {
            System.out.println("Возраст - " + wolf.getAge() + " лет");
        }
        System.out.println("Окрас - " + wolf.getColor());

        wolf.walk();
        wolf.sit();
        wolf.run();
        wolf.howl();
        wolf.hunt();
    }
}
