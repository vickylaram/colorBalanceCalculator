package de.vickylaram.colorBalanceCalculator.model.dna;

import de.vickylaram.colorBalanceCalculator.util.FileUtil;
import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DNASequenceTest {

    @Test
    public void getFirstBase_UseCase(){

        List<DNABase> sequence_list = new ArrayList<>(Arrays.asList(DNABase.A, DNABase.C, DNABase.T, DNABase.G));
        DNASequence sequence = new DNASequence(sequence_list);
        assertEquals(DNABase.A, sequence.getFirstBase());
    }

    @Test
    public void getFirstBase_EmptySequenceList(){
        DNASequence sequence = new DNASequence(new ArrayList<>());
        Throwable exception = assertThrows(IndexOutOfBoundsException.class, sequence::getFirstBase);
        assertEquals("Index 0 out of bounds for length 0", exception.getMessage());
    }

    @Test
    public void nextBase_UseCase(){
        List<DNABase> sequence_list = new ArrayList<>(Arrays.asList(DNABase.A, DNABase.C, DNABase.T, DNABase.G));
        DNASequence sequence = new DNASequence(sequence_list);
        assertEquals(DNABase.A, sequence.getFirstBase());
        sequence.nextBase();
        assertEquals(DNABase.C, sequence.getFirstBase());
    }

    @Test
    public void nextBase_EdgeCase(){
        List<DNABase> sequence_list = new ArrayList<>(Arrays.asList(DNABase.A, DNABase.C, DNABase.T, DNABase.G));
        DNASequence sequence = new DNASequence(sequence_list);
        assertEquals(DNABase.A, sequence.getFirstBase());
        sequence.nextBase();
        assertEquals(DNABase.C, sequence.getFirstBase());
        sequence.nextBase();
        assertEquals(DNABase.T, sequence.getFirstBase());
        sequence.nextBase();
        assertEquals(DNABase.G, sequence.getFirstBase());
    }

    @Test
    public void nextBase_EmptySequenceList(){
        List<DNABase> sequence_list = new ArrayList<>();
        DNASequence sequence = new DNASequence(sequence_list);
        Throwable exception = assertThrows(IndexOutOfBoundsException.class, sequence::nextBase);
        assertEquals("Index 0 out of bounds for length 0", exception.getMessage());

    }

}
