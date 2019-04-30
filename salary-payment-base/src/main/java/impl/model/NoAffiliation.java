package impl.model;

public class NoAffiliation implements Affiliation {
    @Override
    public double calculateDeductions(PayCheck pc) {
        return 0;
    }
}
