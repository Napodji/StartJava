package com.startjava.lesson_2_3.robot;

public class JaegerTest {
    public static void main(String[] args) {
        Jaeger chernoAlpha = new Jaeger();

        chernoAlpha.setName("Cherno Alpha");
        chernoAlpha.setMark(3);
        chernoAlpha.setHeight(85.34f);
        chernoAlpha.setWeight(2412.0f);
        chernoAlpha.setSpeed(3);
        chernoAlpha.setStrength(10);
        chernoAlpha.setArmor(10);
        chernoAlpha.setKaijuKillCounter(6);

        Jaeger strikeEureka = new Jaeger(
                "Striker Eureka",
                5,
                76.2f,
                1850.0f,
                10,
                10,
                9,
                11
        );

        System.out.print(chernoAlpha);
        chernoAlpha.drift();
        chernoAlpha.scanKaiju();
        chernoAlpha.attackKaiju();
        System.out.println();
        System.out.print(strikeEureka);
        strikeEureka.drift();
        strikeEureka.scanKaiju();
        strikeEureka.attackKaiju();
    }
}
