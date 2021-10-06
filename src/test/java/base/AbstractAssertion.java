package base;

public class AbstractAssertion<T extends FunctionalLibrary> {
    protected T functionalLibrary;

    public T endAssertion() {
        return functionalLibrary;
    }

    public void setPage(T functionalLibrary) {
        this.functionalLibrary = functionalLibrary;
    }
}
