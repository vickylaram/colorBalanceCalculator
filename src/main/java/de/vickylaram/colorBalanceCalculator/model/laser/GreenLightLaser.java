package de.vickylaram.colorBalanceCalculator.model.laser;

import de.vickylaram.colorBalanceCalculator.model.dna.DNABase;

/**
 * Implementation of the {@link Laser} interface for a green light laser.
 *
 * @author Vicky Lara Mielczarek
 * @version 1.0
 */
public class GreenLightLaser implements Laser {
    /**
     * Reads and interprets a DNA base as a green light laser.
     * Overrides the {@code readBase} method from the {@link Laser} interface.
     *
     * @param base The DNA base to be read, expected to be a DNABase type object.
     * @return {@code true} if the base is either 'A' or 'T'; {@code false} if the base is 'C', 'G',
     * or any other character.
     */
    @Override
    public boolean readBase(DNABase base) {
        switch (base) {
            case A:
            case T:
                return true;
            case C:
            case G:
                return false;
            default:
                break;
        }
        return false;
    }
}
