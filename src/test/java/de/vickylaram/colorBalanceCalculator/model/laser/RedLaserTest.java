package de.vickylaram.colorBalanceCalculator.model.laser;

import de.vickylaram.colorBalanceCalculator.model.dna.DNABase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RedLaserTest {


    static Laser gl;
    @BeforeAll
    public static void setUp(){
        gl = new RedLightLaser();
    }

    @Test
    public void readSequencesFromFileTest_readA(){
        assertTrue(gl.readBase(DNABase.A));
    }

    @Test
    public void readSequencesFromFileTest_readC(){
        assertTrue(gl.readBase(DNABase.C));
    }

    @Test
    public void readSequencesFromFileTest_readT(){
        assertFalse(gl.readBase(DNABase.T));
    }

    @Test
    public void readSequencesFromFileTest_readG(){
        assertFalse(gl.readBase(DNABase.G));
    }

}
