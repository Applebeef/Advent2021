package D5;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class D5Test {
    D5 d5 = new D5();

    @Test
    void solve() throws FileNotFoundException {
            assertEquals(20196, d5.Solve());
    }
}