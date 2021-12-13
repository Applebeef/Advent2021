package D2;

public class Submarine2 extends Submarine {
    int aim;

    public Submarine2() {
        aim = 0;
    }

    @Override
    public void forward(int x) {
        super.forward(x);
        super.down(getAim() * x);
    }

    @Override
    public void up(int x) {
        aim -= x;
    }

    @Override
    public void down(int x) {
        aim += x;
    }

    public int getAim() {
        return aim;
    }

    public void setAim(int aim) {
        this.aim = aim;
    }
}
