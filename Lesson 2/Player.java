public class Player {
    private String name;
    private int number;

    public Player(String name) {
        this.name = name;
        this.number = 0;
    }

    public String getName() {
        return name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
