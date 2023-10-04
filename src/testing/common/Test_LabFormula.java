package testing.common;

import common.LabFormula;

import java.util.ArrayList;
import java.util.Arrays;

public class Test_LabFormula {
    private static final ArrayList<Double> VALID_TEST_VALUES_ARRAYLIST = new ArrayList<>(Arrays.asList(
            4d, 4d, 4d, 4d, 4d,
            4d, 4d, 4d, 4d, 4d
    ));
    private static final ArrayList<Double> INVALID_TEST_VALUES_ARRAYLIST = new ArrayList<>(Arrays.asList(
            4d, 4d, 4d, 4d, 4d,
            4d, 4d, 4d, 4d
    ));
    public static void main(String[] args) {
        LabFormula validFormula1 = new LabFormula(VALID_TEST_VALUES_ARRAYLIST);
        System.out.println("validFormula1.get(): " + validFormula1.get());
        LabFormula emptyFormula1 = new LabFormula();
        try {
            System.out.println(emptyFormula1.get());
        } catch (Exception e) {
            System.out.println("emptyFormula1: correctly caught exception for get method: " + e.toString());
        }
        LabFormula invalidFormula1;
        try {
            invalidFormula1 = new LabFormula(INVALID_TEST_VALUES_ARRAYLIST);
            System.out.println("Error: exception not caught for invalidFormula1 constructor");
        } catch (Exception e) {
            System.out.println("invalidFormula1: correctly caught exception for constructor: " + e.toString());
        }
    }
}
