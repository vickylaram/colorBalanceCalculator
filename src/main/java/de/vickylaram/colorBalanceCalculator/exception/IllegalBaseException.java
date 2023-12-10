package de.vickylaram.colorBalanceCalculator.exception;


/**
 * This class represents an exception that is thrown when an illegal nucleotide/base is read.
 * @author Vicky Lara Mielczarek
 * @version 1.0
 */
public class IllegalBaseException extends Exception {

    /**
     * Constructs a new {@code IllegalBaseException} with the specified detail message.
     * @param errorMessage the detail message to by printed
     */
    public IllegalBaseException(String errorMessage) {
        super(errorMessage);
    }
}
