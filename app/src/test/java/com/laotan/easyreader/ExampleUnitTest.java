package com.laotan.easyreader;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit TestBean, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test() throws Exception {
        Monkey[] values = Monkey.values();
        for (Monkey value : values) {
            System.out.println("value  " + value + "  ordinal  " + value.ordinal());
        }
        monney(Monkey.ONE);
        monney(Monkey.TWO);
        monney(Monkey.TEN);
        monney(Monkey.TWENTY);
        monney(Monkey.FIVTY);
    }

    private void monney(Monkey monkey) {
        switch (monkey) {
            case ONE:
                System.out.println("1元");
                break;
            case TWO:
                System.out.println("2元");
                break;
            case FIVE:
                System.out.println("5元");
                break;
            case TEN:
                System.out.println("10元");
                break;
            case TWENTY:
                System.out.println("20元");
                break;

        }
    }

    enum Monkey {
        ONE, TWO, FIVE, TEN, TWENTY, FIVTY
    }
}