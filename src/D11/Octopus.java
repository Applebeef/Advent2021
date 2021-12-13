package D11;

public class Octopus {
    private int energy;
    private boolean flashed;

    public Octopus(int energy) {
        this.energy = energy;
        this.flashed = false;
    }

    public void incrementEnergy() {
        energy++;
    }

    public void resetEnergy() {
        if (energy > 9) {
            energy = 0;
        }
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public boolean isFlashed() {
        return flashed;
    }

    public void setFlashed(boolean flashed) {
        this.flashed = flashed;
    }
}
