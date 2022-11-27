package Modelo;

public class Dado {

    public int getResultado(){
        return (int) (Math.random() * 6) + 1;
    }
}
