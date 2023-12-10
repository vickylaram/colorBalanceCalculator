package de.vickylaram.colorBalanceCalculator.util;

import de.vickylaram.colorBalanceCalculator.model.dna.DNASequence;
import de.vickylaram.colorBalanceCalculator.util.FileUtil;
import org.javatuples.Pair;
import org.junit.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class FileUtilTest {

    String testResourcesPath = "src/test/resources/";

    @Test
    public void readSequencesFromFileTest_fileHasSpaceDelimiter(){
        String filePath = testResourcesPath + "test_file1.txt";
        String delimiter = " ";
        Pair<List<DNASequence>, Integer> result = FileUtil.readSequencesFromFile(filePath, delimiter);
        assertEquals(3, result.getValue0().size());
        assertEquals(15, result.getValue1());
    }

    @Test
    public void readSequencesFromFileTest_fileHasCommaDelimiter(){
        String filePath = testResourcesPath + "test_file2.txt";
        String delimiter = ",";
        Pair<List<DNASequence>, Integer> result = FileUtil.readSequencesFromFile(filePath, delimiter);
        assertEquals(3, result.getValue0().size());
        assertEquals(15, result.getValue1());
    }

    @Test
    public void readSequencesFromFileTest_fileHasSemicolonDelimiter(){
        String filePath = testResourcesPath + "test_file3.txt";
        String delimiter = ";";
        Pair<List<DNASequence>, Integer> result = FileUtil.readSequencesFromFile(filePath, delimiter);
        assertEquals(3, result.getValue0().size());
        assertEquals(15, result.getValue1());
    }
/**
    @Test
    public void readSequencesFromFileTest_fileHasWrongDelimiter(){
        String filePath = testResourcesPath + "test_file3.txt";
        String delimiter = ",";
        Throwable exception = assertThrows(IllegalArgumentException.class, FileUtil.readSequencesFromFile(filePath, delimiter));
        assertEquals("Wrong file format, provided delimiter doesn't match actual delimiter", exception.getMessage());

    } **/


    @Test
    public void readSequencesFromFileTest_fileHasNoNumbers(){
        String filePath = testResourcesPath + "test_file4.txt";
        String delimiter = " ";
        Pair<List<DNASequence>, Integer> result = FileUtil.readSequencesFromFile(filePath, delimiter);
        assertEquals(3, result.getValue0().size());
        assertEquals(15, result.getValue1());
    }

    @Test
    public void readSequencesFromFileTest_fileIsEmpty(){
        String filePath = testResourcesPath + "test_file5.txt";
        String delimiter = " ";
        Pair<List<DNASequence>, Integer> result = FileUtil.readSequencesFromFile(filePath, delimiter);
        assertEquals(0, result.getValue0().size());
        assertEquals(0, result.getValue1());
    }

}
