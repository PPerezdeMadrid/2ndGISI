package Aplicacion;

public class Cansado implements State {

    private Tamagotchi tamagotchi;

    @Override
    public void jugar() {
        System.out.println("Estoy muy cansado para jugar");
    }

    @Override
    public void alimentar() {
        System.out.println("no quiero comer");
    }

    @Override
    public void dormir() {
        System.out.println("Buenas noches uwu");
        tamagotchi.setState(new Durmiendo());
    }

    @Override
    public void comoEstas() {
        System.out.println("Tengo sueño");
    }

    @Override
    public void setTamagotchi(Tamagotchi tamagotchi) {
        this.tamagotchi = tamagotchi;
    }
}
