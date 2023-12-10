package de.vickylaram.colorBalanceCalculator.util;

import de.vickylaram.colorBalanceCalculator.exception.IllegalBaseException;
import de.vickylaram.colorBalanceCalculator.model.dna.DNABase;
import de.vickylaram.colorBalanceCalculator.model.dna.DNASequence;
import org.javatuples.Pair;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for file-related operations such as checking if file exists or reading file.
 *
 * @author Vicky Lara Mielczarek
 * @version 1.0
 */
public class FileUtil {


    /**
     * Reads DNA sequences from a file at {@code filePath} and returns them along with the maximum length of the sequences.
     *
     * @param filePath  The path of the file containing the DNA sequences/indexes.
     * @param delimiter The delimiter used to separate bases in a sequence line.
     * @return A {@link Pair} object containing a list of {@link DNASequence} objects and an integer
     * representing the maximum length of the sequences.
     */
    public static Pair<List<DNASequence>, Integer> readSequencesFromFile(String filePath, String delimiter) {

        List<DNASequence> sequences = new ArrayList<>();
        int max_index_length = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                List<DNABase> temp_sequence = parseLine(line, delimiter);
                sequences.add(new DNASequence(temp_sequence));

                // Find the longest sequence -> needed for later iteration, but also for a possible extension where indexes can be of variable lengths
                if (temp_sequence.size() > max_index_length) {
                    max_index_length = temp_sequence.size();
                }

            }
        } catch (FileNotFoundException fe) {
            throw new IllegalArgumentException("File " + filePath + " not found.");
        } catch (IndexOutOfBoundsException | IOException ie) {
            throw new IllegalArgumentException("File " + filePath + " seems to be empty...");
        } catch (IllegalBaseException be) {
            throw new IllegalArgumentException("Wrong bases, only A, C, G, T allowed.");
        }

        return new Pair<>(sequences, max_index_length);

    }


    /**
     * Parses a given line of text and parses characters to DNABase objects based on a specified delimiter.
     *
     * @param line      The line of text to be parsed.
     * @param delimiter The delimiter used to split the line.
     * @return A list of bases extracted from the line. If the line does not contain
     * the delimiter or is empty after splitting, an empty list is returned.
     * If the first character after splitting is a digit, it is not included in the list.
     */
    private static List<DNABase> parseLine(String line, String delimiter) throws IllegalBaseException {
        List<DNABase> sequence = new ArrayList<>();

        if (line.contains(delimiter)) {
            String[] parts = line.split(delimiter);
            for (String part : parts) {
                if (!part.isEmpty()) {
                    char character = part.charAt(0);
                    // If an input file has numbers in the beginning of the line, remove it
                    if (Character.isDigit(character)) {
                        continue;
                    }

                    sequence.add(parseDNABase(character));
                }
            }
        } else {
            throw new IllegalArgumentException("Wrong file format, provided delimiter doesn't match actual delimiter");
        }
        return sequence;
    }

    /**
     * Parses a raw character from a line in a file to a DNABase object
     * @param rawCharacter The character to be parsed. Should be 'A', 'C', 'G', or 'T' (see {@link DNABase} enum)
     * @return DNABase enum corresponding to the input character.
     * @throws IllegalBaseException If a character that is not a valid nucleotide is provided.
     */
    private static DNABase parseDNABase(char rawCharacter) throws IllegalBaseException {
        switch (rawCharacter) {

            case 'A':
                return DNABase.A;
            case 'C':
                return DNABase.C;
            case 'G':
                return DNABase.G;
            case 'T':
                return DNABase.T;
            default:
                throw new IllegalBaseException("Wrong base, only A, C, G, T are valid bases.");
        }
    }

}
