package de.vickylaram.colorBalanceCalculator.model.laser;

import de.vickylaram.colorBalanceCalculator.model.dna.DNABase;

/**
 * Interface for a laser used in DNA sequencing.
 *
 * @author Vicky Lara Mielczarek
 * @version 1.0
 */
public interface Laser {

    /**
     * Reads and processes a DNA base.
     *
     * @param base The DNA base to be read. In this case it's one single base represented by
     *             a DNABase object
     * @return {@code true} if the base is successfully processed and laser lights up;
     * {@code false} otherwise.
     */
    boolean readBase(DNABase base);

}
