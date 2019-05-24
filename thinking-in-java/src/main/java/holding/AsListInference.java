package holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Snow {}
class Power extends Snow {}
class Light extends Power {}
class Heavy extends Power {}
class Crusty extends Snow {}
class Slush extends Snow {}
public class AsListInference {
    public static void main(String[] args) {
        List<Snow> snow1 = Arrays.asList(
                new Crusty(), new Slush(), new Power());

        //Won't compile:
        List<Snow> snow2 = Arrays.asList(
                new Light(), new Heavy());
        //Compiler says:
        //found : java.util.List<Power>
        //required : java.util.List<Snow>
        //Collections.addAll() doesn't get confused:
        List<Snow> snow3 = new ArrayList<>();
        Collections.addAll(snow3, new Light(), new Heavy());

        //Give a hint using an
        //explicit type argument specification:
        List<Snow> snow4 = Arrays.asList(new Light(), new Heavy());
    }
}
