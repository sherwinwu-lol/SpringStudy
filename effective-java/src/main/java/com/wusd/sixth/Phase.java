package com.wusd.sixth;

import java.util.EnumMap;
import java.util.Map;

//Using a nested EnumMap to associate data with enum pairs
public enum Phase {
    SOLID, LIQUID, GAS;

    public enum Transition {
        MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
        SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID);
        private final Phase src;
        private final Phase dst;
        Transition(Phase src, Phase dst) {
            this.src = src;
            this.dst = dst;
        }
        //Initialize the phase transition map
        private static final Map<Phase, Map<Phase, Transition>> m = new EnumMap<>(Phase.class);
        static {
            for (Phase p : Phase.values())
                m.put(p, new EnumMap<>(Phase.class));
            for (Transition trans : Transition.values())
                m.get(trans.src).put(trans.dst, trans);
        }
        public static Transition from(Phase src, Phase dst) {
            return m.get(src).get(dst);
        }
    }
//    SOLID, LIQUID, GAS;
//    public enum Transition {
//        MELT, FREEZE, BOIL, CONDENSE, SUBLIME, DEPOSIT;
//        //Rows indexed by src-ordinal, cols by dst-ordinal
//        private static final Transition[][] TRANSITIONS = {
//            {null, MELT, SUBLIME},
//            {FREEZE, null, BOIL},
//            {DEPOSIT, CONDENSE, null}
//        };
//        //Returns the phase transition from one phase to another
//        public static Transition from(Phase src, Phase dst) {
//            return TRANSITIONS[src.ordinal()][dst.ordinal()];
//        }
//    }
}
