package tec;

public interface Usager {
    String nom();
    void monterDans(Transport t) throws TecInvalidException;

}