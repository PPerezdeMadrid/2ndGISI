package Aplicacion;

public class Hambriento implements State {

    private Tamagotchi tamagotchi;

    @Override
    public void jugar() {
        System.out.println("Tengo mucha habre para jugar");
    }

    @Override
    public void alimentar() {
        System.out.println("Ñom Ñom :)");
        tamagotchi.setState(new Aburrido());
    }

    @Override
    public void dormir() {
        System.out.println("no quiero dormir");
        tamagotchi.setState(new Durmiendo());
    }

    @Override
    public void comoEstas() {
        System.out.println("Tengo mucha hambre, dame comida");
    }

    @Override
    public void setTamagotchi(Tamagotchi tamagotchi) {
        this.tamagotchi = tamagotchi;
    }
}
