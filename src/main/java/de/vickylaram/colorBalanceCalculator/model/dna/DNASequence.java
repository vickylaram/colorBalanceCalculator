package de.vickylaram.colorBalanceCalculator.model.dna;

import java.util.List;

/**
 * Model class for a DNA sequence
 * @author Vicky Lara Mielczarek
 * @version 1.0
 */
public class DNASequence {

    private List<DNABase> sequence;

    /**
     * Constructor
     * @param sequence any type of list containing sequence bases as DNABase objects
     */
    public DNASequence(List<DNABase> sequence) {
        this.sequence = sequence;
    }

    /**
     * Retrieves (current) first element of sequence.
     * @return first base of sequence as a DNABase object
     */
    public DNABase getFirstBase() throws IndexOutOfBoundsException {
        return sequence.get(0);
    }

    /**
     * Removes the first base from the DNA sequence.
     * @throws IndexOutOfBoundsException if the sequence is empty
     */
    public void nextBase() throws IndexOutOfBoundsException {
        sequence.remove(0);
    }

    /**
     * Returns a string representation of the {@code DNASequence} object.
     * @return A string representation of the {@code DNASequence} object,
     *         which includes the class name and the 'sequence' field value.
     */
    @Override
    public String toString() {
        return "DNASequence{" +
                "sequence=" + sequence +
                '}';
    }

}
