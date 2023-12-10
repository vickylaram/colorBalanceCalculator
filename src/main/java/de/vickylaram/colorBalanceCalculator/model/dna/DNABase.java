package de.vickylaram.colorBalanceCalculator.model.dna;

/**
 * Model class for a DNA base (Adenine, Cytosine, Guanine, Thymine)
 * @author Vicky Lara Mielczarek
 * @version 1.0
 */
public enum DNABase {

    A('A'),
    C('C'),
    T('T'),
    G('G');

    public final Character label;

    DNABase(Character label) {
        this.label = label;
    }
}
