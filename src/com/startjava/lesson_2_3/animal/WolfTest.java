package com.startjava.lesson_2_3.animal;

public class WolfTest {
    public static void main(String[] args) {
        Wolf wolf = new Wolf();

        wolf.setNickname("Фенрир");
        wolf.setGender("мужской");
        wolf.setWeight(40);
        wolf.setAge(5);
        wolf.setColor("Черный");

        System.out.println("Кличка - " + wolf.getNickname());
        System.out.println("Пол - " + wolf.getGender());
        System.out.println("Вес - " + wolf.getWeight() + " кг");
        System.out.println("Возраст - " + wolf.getAge() + " лет");
        System.out.println("Окрас - " + wolf.getColor());

        wolf.walk();
        wolf.sit();
        wolf.run();
        wolf.howl();
        wolf.hunt();
    }
}
