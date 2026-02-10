package lab;

import java.awt.*;

public class carTransport extends Car {

    public carTransport(){
        super(2, new Color(1,2,3), 50, "carTransport");
    }

    public double speedFactor(){
        return getEnginePower() * 0.01;
    }
}

/**
 * en biltransport är en lastbil
 * en biltransport kompositeras av en bil och ett flak.
 * Ett flak har en vinkel men hur man höjer och sänker flaket eller huruvida man kan höja
 * och sänka är olika för olika flak.
 * olika flak kan innehålla olika saker.
 *
 */
