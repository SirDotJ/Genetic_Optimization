package testing.common;

import common.LabFormula;
import common.LabParameters;

import java.util.ArrayList;
import java.util.Arrays;

public class Test_LabFormula {
    private static final ArrayList<Double> VALID_TEST_VALUES_ARRAYLIST = new ArrayList<>(Arrays.asList(
            4d, 4d, 4d, 4d, 4d,
            4d, 4d, 4d, 4d, 4d
    ));
    public static void main(String[] args) {
        LabFormula validFormula1 = new LabFormula();
        try {
            System.out.println("validFormula1.get(): " + validFormula1.get(new LabParameters(VALID_TEST_VALUES_ARRAYLIST)));
        } catch (Exception e) {
            System.out.println("Exception caught: " + e);
        }
    }
}
