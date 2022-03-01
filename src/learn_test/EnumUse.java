package learn_test;

import javax.swing.plaf.synth.SynthOptionPaneUI;

/**
 * @package: learn_test
 * @Description:
 * @author: jilai_huang
 * @date: 2022/2/25 16:02
 */

public class EnumUse {
    public enum Family{
        FATHER,
        MOTHER,
        SON,
        Daughter
    }

    public static void main(String[] args) {
        for(Family family:Family.values()){
            System.out.println(family + ",ordinal " + family.ordinal());
        }
    }
}
