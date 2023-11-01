package testing.common.testCases;

import java.util.ArrayList;
import java.util.Arrays;

// Класс определяет все используемые при тестировании класса ParameterRestrictions кейсы
// TEST_ERRORS_LEFT и TEST_ERRORS_RIGHT составлены Денисом Титовым
// Границы определены в классе common.LabParameters
public class Cases_ParameterRestrictions {
    public static final ArrayList<ArrayList<Double>> TEST_ERRORS_LEFT = new ArrayList<>(Arrays.asList(
        new ArrayList<>(Arrays.asList( // x1 < l1
            -6d, 4d, -5d, 4d, 0.5d,
            2.5d, 4d, -4d, 0d, -1.73d
        )),
        new ArrayList<>(Arrays.asList( // x2 < l2
            6d, -4d, -5d, 4d, 0.5d,
            2.5d, 4d, 4d, 0d, -1.73d
        )),
        new ArrayList<>(Arrays.asList( // x3 < l3
            6d, 4d, -11d, 4d, 0.5d,
            2.5d, 4d, 4d, 0d, -1.73d
        )),
        new ArrayList<>(Arrays.asList( // x4 < l4
            6d, 4d, -5d, 2d, 0.5d,
            2.5d, 4d, 4d, 0d, -1.73d
        )),
        new ArrayList<>(Arrays.asList( // x5 < l5
            6d, 4d, -5d, 4d, -0.5d,
            2.5d, 4d, 4d, 0d, -1.73d
        )),
        new ArrayList<>(Arrays.asList( // x6 < l6
            6d, 4d, -5d, 4d, 0.5d,
            -7.5d, 4d, 4d, 0d, -1.73d
        )),
        new ArrayList<>(Arrays.asList( // x7 < l7
            6d, 4d, -5d, 4d, 0.5d,
            2.5d, 0d, 4d, 0d, -1.73d
        )),
        new ArrayList<>(Arrays.asList( // x8 < l8
            -6d, 4d, -5d, 4d, 0.5d,
            2.5d, 4d, -4d, 0d, -1.73d
        )),
        new ArrayList<>(Arrays.asList( // x9 < l9
            6d, 4d, -5d, 4d, 0.5d,
            2.5d, 4d, 4d, -3d, -1.73d
        )),
        new ArrayList<>(Arrays.asList( // x10 < l10
            6d, 4d, -5d, 4d, 0.5d,
            2.5d, 4d, 4d, 0d, -4.73d
        ))
    ));
    public static final ArrayList<ArrayList<Double>> TEST_ERRORS_RIGHT = new ArrayList<>(Arrays.asList(
        new ArrayList<>(Arrays.asList( // x1 > r1
                20d, 4d, -5d, 4d, 0.5d,
                2.5d, 4d, 4d, 0d, -1.73d
        )),
        new ArrayList<>(Arrays.asList( // x2 > r2
                6d, 12d, -5d, 4d, 0.5d,
                2.5d, 4d, 4d, 0d, -1.73d
        )),
        new ArrayList<>(Arrays.asList( // x3 > r3
                6d, 4d, 5d, 4d, 0.5d,
                2.5d, 4d, 4d, 0d, -1.73d
        )),
        new ArrayList<>(Arrays.asList( // x4 > r4
                6d, 4d, -5d, 7d, 0.5d,
                2.5d, 4d, 4d, 0d, -1.73d
        )),
        new ArrayList<>(Arrays.asList( // x5 > r5
                6d, 4d, -5d, 4d, 3.5d,
                2.5d, 4d, 4d, 0d, -1.73d
        )),
        new ArrayList<>(Arrays.asList( // x6 > r6
                6d, 4d, -5d, 4d, 0.5d,
                4.5d, 4d, 4d, 0d, -1.73d
        )),
        new ArrayList<>(Arrays.asList( // x7 > r7
                6d, 4d, -5d, 4d, 0.5d,
                2.5d, 5d, 4d, 0d, -1.73d
        )),
        new ArrayList<>(Arrays.asList( // x8 > r8
                6d, 4d, -5d, 4d, 0.5d,
                2.5d, 4d, 8d, 0d, -1.73d
        )),
        new ArrayList<>(Arrays.asList( // x9 > r9
                6d, 4d, -5d, 4d, 0.5d,
                2.5d, 4d, 4d, 3d, -1.73d
        )),
        new ArrayList<>(Arrays.asList( // x10 > r10
                6d, 4d, -5d, 4d, 0.5d,
                2.5d, 4d, 4d, 0d, 4.73d
        ))
    ));
}
