package Aplicacion;

public class main {
    public static void main(String[] args) {
        Tamagotchi miTamagotchi = new Tamagotchi();

        new Menu(miTamagotchi).display();
    }
}
