public class Jaeger {
    private String name;
    private int mark;
    private float height;
    private float weight;
    private int speed;
    private int strength;
    private int armor;
    private int kaijuKillCounter;

    public Jaeger() {}

    public Jaeger(String name, int mark, float height, float weight,
                  int speed, int strength, int armor, int kaijuKillCounter) {
        this.name = name;
        this.mark = mark;
        this.height = height;
        this.weight = weight;
        this.speed = speed;
        this.strength = strength;
        this.armor = armor;
        this.kaijuKillCounter = kaijuKillCounter;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public void setKaijuKillCounter(int kaijuKillCounter) {
        this.kaijuKillCounter = kaijuKillCounter;
    }

    public void drift() {
        System.out.println("Пилоты егеря " + name + " вошли в дрифт");
    }

    public void scanKaiju() {
        System.out.println("Jaeger " + name + " сканирует местность в поисках кайдзю!");
    }

    public void attackKaiju() {
        System.out.println("Jaeger " + name + " атакует кайдзю!");
    }

    public String toString() {
        return """
            Данные робота:
            Имя: %s
            Поколение: %d
            Высота: %.1f метров
            Масса: %.1f тонн
            Скорость: %d
            Сила: %d
            Броня: %d
            Уничтожено кайдзю: %d
            """.formatted(name, mark, height, weight, speed, strength, armor, kaijuKillCounter);
    }
}
