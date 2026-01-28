public class Universe {

;
    static void main() {
        Saab95 sab;
        sab = new Saab95();
        for (int i = 0; i < 120; i++){
            sab.gas(1);
        }

        sab.turnLeft(10);
        System.out.println(sab.get_direction().x() + " " + sab.get_direction().y());
        System.out.println(sab.velocity().x() + " " + sab.velocity().y());
        sab.tick();
        sab.tick();
        System.out.println(sab.position().x() + " " + sab.position().y());


    }
}
