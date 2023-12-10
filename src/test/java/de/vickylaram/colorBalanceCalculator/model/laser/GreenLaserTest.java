package de.vickylaram.colorBalanceCalculator.model.laser;

import de.vickylaram.colorBalanceCalculator.model.dna.DNABase;
import de.vickylaram.colorBalanceCalculator.model.dna.DNASequence;
import de.vickylaram.colorBalanceCalculator.util.FileUtil;
import org.javatuples.Pair;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GreenLaserTest {

    static Laser gl;
    @BeforeAll
    public static void setUp(){
        gl = new GreenLightLaser();
    }

    @Test
    public void readSequencesFromFileTest_readA(){
        assertTrue(gl.readBase(DNABase.A));
    }

    @Test
    public void readSequencesFromFileTest_readT(){
        assertTrue(gl.readBase(DNABase.T));
    }

    @Test
    public void readSequencesFromFileTest_readC(){
        assertFalse(gl.readBase(DNABase.C));
    }

    @Test
    public void readSequencesFromFileTest_readG(){
        assertFalse(gl.readBase(DNABase.G));
    }

}
