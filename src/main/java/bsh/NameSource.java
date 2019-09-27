package bsh;

public interface NameSource {

    public interface Listener {
        void nameSourceChanged(NameSource nameSource);
    }

    void addNameSourceListener(Listener listener);

    String[] getAllNames();
}
