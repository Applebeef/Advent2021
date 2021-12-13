package D11;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class OctopusMap {
    private List<List<Octopus>> map;
    private int flashes;
    private int syncStep;

    public OctopusMap(List<String> input) {
        flashes = 0;
        syncStep = 0;
        map = new ArrayList<>();
        for (String s : input) {
            map.add(s.chars().mapToObj(integer -> integer - '0').map(Octopus::new).collect(Collectors.toList()));
        }
    }

    public void runSimulation(int steps) {
        for (int i = 0; i < steps; i++) {
            for (int j = 0; j < map.size(); j++) {
                for (int k = 0; k < map.get(j).size(); k++) {
                    flash(j, k);
                }
            }

            for (List<Octopus> line : map) {
                line.forEach(Octopus::resetEnergy);
                line.forEach(octopus -> octopus.setFlashed(false));
            }
        }
    }

    public int runSimulation2() {
        int step = 0;
        while (syncStep == 0) {
            for (int j = 0; j < map.size(); j++) {
                for (int k = 0; k < map.get(j).size(); k++) {
                    flash(j, k);
                }
            }

            for (List<Octopus> line : map) {
                line.forEach(Octopus::resetEnergy);
                line.forEach(octopus -> octopus.setFlashed(false));
            }

            if (syncStep == 0) {
                boolean res = true;
                for (List<Octopus> line : map) {
                    res = res && line.stream().allMatch(octopus -> octopus.getEnergy() == 0);
                }
                if (res) {
                    syncStep = step + 1;
                }
                step++;
            }
        }
        return step;
    }

    public void flash(int i, int j) {
        if (!validateIndexes(i, j)) {
            return;
        }
        Octopus curr = map.get(i).get(j);
        curr.incrementEnergy();
        if (curr.getEnergy() > 9 && !curr.isFlashed()) {
            curr.setFlashed(true);
            flashes++;
            for (int k = i - 1; k <= i + 1; k++) {
                for (int l = j - 1; l <= j + 1; l++) {
                    flash(k, l);
                }
            }
        }
    }

    boolean validateIndexes(int i, int j) {
        return i >= 0 && i < map.size() && j >= 0 && j < map.get(i).size();
    }

    public int getFlashes() {
        return flashes;
    }

    public int getSyncStep() {
        return syncStep;
    }
}
