package Aplicacion;

import java.util.Timer;
import java.util.TimerTask;

public class Durmiendo implements State {
    private Tamagotchi tamagotchi;

    @Override
    public void jugar() {
        System.out.println("zzzz");
    }

    @Override
    public void alimentar() {
        System.out.println("zzzz");
    }

    @Override
    public void dormir() {
        System.out.println("zzzz");
    }

    @Override
    public void comoEstas() {
        System.out.println("(Esta durmiendo, no lo molestes)");
    }

    @Override
    public void setTamagotchi(Tamagotchi tamagotchi) {
        this.tamagotchi = tamagotchi;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run(){
                System.out.println("Se ha despertado");
                Durmiendo.this.tamagotchi.setState(new Hambriento());     //Ponemos un Durmiendo.this , por que esta dentro de una "mini clase"
            }
        }, 7000);
    }
}
