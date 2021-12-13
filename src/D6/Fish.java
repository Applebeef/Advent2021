package D6;

public class Fish {
    private int age;

    public Fish() {
        this.age = 8;
    }

    public Fish(int age) {
        this.age = age;
    }

    public Fish reduceAge() {
        Fish fish = null;
        if (age == 0) {
            fish = new Fish();
            setAge(7);
        }
        age--;
        return fish;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
