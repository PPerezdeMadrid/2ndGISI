package Aplicacion;


public class Tamagotchi {
    private State estado;

    public Tamagotchi(){
        setState(new Aburrido());
    }
    public void setState(State estado){
        this.estado = estado;
        this.estado.setTamagotchi(this);
    }

    public void alimentar() {
        this.estado.alimentar();
    }
    public void dormir(){
        this.estado.dormir();
    }
    public void jugar(){
        this.estado.jugar();
    }
    public void comoEstas(){
        this.estado.comoEstas();
    }
}
