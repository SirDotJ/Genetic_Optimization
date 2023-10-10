package testing.common;

import common.LabFormula;
import common.LabParameters;
import common.ParameterRestrictions;

import java.util.ArrayList;
import java.util.Arrays;

public class Test_LabFormula {
    private static final ArrayList<Double> VALID_TEST_VALUES = new ArrayList<>(Arrays.asList(
            6d, 4d, -5d, 4d, 0.5d,
            2.5d, 4d, 4d, 0d, -1.73d
    ));
    public static void main(String[] args) {
        LabFormula validFormula1 = new LabFormula();
        LabParameters parameters;
        try {
            parameters = new LabParameters(VALID_TEST_VALUES);
            System.out.println("validFormula1.get(): " + validFormula1.get(parameters));
        } catch (Exception e) {
            System.out.println("Exception caught: " + e);
            // Вывод неправильных параметров
            ParameterRestrictions setRestrictions = new ParameterRestrictions(LabParameters.LAB_PARAMETER_RANGES);
            System.out.println("Misfits: " + setRestrictions.findMisfits(VALID_TEST_VALUES));
        }
    }
}
