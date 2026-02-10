public class Scania extends Car {
    /**
     *     Uppgift 1: Extensibilitet
     *
     *      Skapa en representation av en Scania-lastbil med modellnamn Scania. Ge den rimliga startvärden för relevanta fält. Lägg den i filen Scania.java i samma mapp.
     *      Scania ska införlivas i er arvs-hierarki från tidigare, men ha ytterligare funktionalitet: den har ett flak som kan höjas (tippas) och sänkas. Införliva detta i er design så att vi kan hålla reda på vilken vinkel flaket har för närvarande, samt funktioner för att höja och sänka det.
     *
     *      Följande förhållanden ska gälla:
     *
     *      Vinkeln på flaket kan inte vara lägre än 0 eller högre än 70.
     *      Det är bara om lastbilen står stilla som flaket får ha en annan vinkel än 0. Flaket ska inte kunna höjas om lastbilen är i rörelse; och lastbilen ska inte kunna köra om flaket är uppfällt.
     *
     *      Lägg allt i Scania.java. Gör minst ett JUnit-test i er testklass.
     */

    public double speedFactor(){
        return 1.0;
    }
    private TruckBed truckBed;
    public Scania(){

    }
}
