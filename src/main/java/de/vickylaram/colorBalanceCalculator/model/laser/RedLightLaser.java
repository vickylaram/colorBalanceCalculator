package de.vickylaram.colorBalanceCalculator.model.laser;

import de.vickylaram.colorBalanceCalculator.model.dna.DNABase;

/**
 * Implementation of the {@link Laser} interface for a red light laser.
 * @author Vicky Lara Mielczarek
 * @version 1.0
 */
public class RedLightLaser implements Laser {

    /**
     * Reads and interprets a DNA base using the red light laser approach.
     * Overrides the {@code readBase} method from the {@link Laser} interface.
     *
     * @param base The DNA base to be read, expected to be a DNABase type object.
     * @return {@code true} if the base is either 'A' or 'C'; {@code false} if the base is 'G', 'T',
     *         or any other character.
     */
    @Override
    public boolean readBase(DNABase base) {

        switch(base) {
            case A:
            case C:
                return true;
            case G:
            case T:
                return false;
            default:
                break;
        }
        return false;
    }
}
