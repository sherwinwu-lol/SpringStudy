package com.wusd.fourth;
//Use of static import to avoid qualifying constants
import static com.wusd.fourth.PhysicalConstantsA.AVOGADROS_NUMBER;

public class Test {
    double atoms(double mols) {
        return AVOGADROS_NUMBER * mols;
    }
    //Many more uses of PhysicalConstants justify static import
}
