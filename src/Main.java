import D1.D1;
import D10.D10;
import D11.D11;
import D12.D12;
import D13.D13;
import D2.*;
import D3.D3;
import D4.D4;
import D5.D5;
import D6.D6;
import D7.D7;
import D8.D8;
import D9.D9;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        D1 d1 = new D1();
        D2 d2 = new D2();
        Submarine submarine = new Submarine();
        Submarine2 submarine2 = new Submarine2();
        D3 d3 = new D3();
        D4 d4 = new D4();
        D5 d5 = new D5();
        D6 d6 = new D6();
        D7 d7 = new D7();
        D8 d8 = new D8();
        D9 d9 = new D9();
        D10 d10 = new D10();
        D11 d11 = new D11();
        D12 d12 = new D12();
        D13 d13 = new D13();
        try {
            System.out.println(d13.Solve2());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
//