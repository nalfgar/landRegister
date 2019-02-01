import org.junit.Test;
import pl.strojecki.LandRegister;

import static org.junit.Assert.*;

public class MainLandRegiserTest {

    @org.junit.Test
    public void kI1RTrue() {
        assertTrue(new LandRegister("KI1R", "0", 2).isValid());
        assertTrue(new LandRegister("KI1R", "1", 9).isValid());
        assertTrue(new LandRegister("KI1R", "2", 6).isValid());
        assertTrue(new LandRegister("KI1R", "3", 3).isValid());
        assertTrue(new LandRegister("KI1R", "4", 0).isValid());
        assertTrue(new LandRegister("KI1R", "5", 7).isValid());
        assertTrue(new LandRegister("KI1R", "6", 4).isValid());
        assertTrue(new LandRegister("KI1R", "7", 1).isValid());
        assertTrue(new LandRegister("KI1R", "8", 8).isValid());
        assertTrue(new LandRegister("KI1R", "9", 5).isValid());
    }
    
    @org.junit.Test
    public void kI1WTrue() {
        assertTrue(new LandRegister("KI1W", "0", 6).isValid());
        assertTrue(new LandRegister("KI1W", "1", 3).isValid());
        assertTrue(new LandRegister("KI1W", "2", 0).isValid());
        assertTrue(new LandRegister("KI1W", "3", 7).isValid());
        assertTrue(new LandRegister("KI1W", "4", 4).isValid());
        assertTrue(new LandRegister("KI1W", "5", 1).isValid());
        assertTrue(new LandRegister("KI1W", "6", 8).isValid());
        assertTrue(new LandRegister("KI1W", "7", 5).isValid());
        assertTrue(new LandRegister("KI1W", "8", 2).isValid());
        assertTrue(new LandRegister("KI1W", "9", 9).isValid());
    }

    @org.junit.Test
    public void kI1RFalse() {
        assertFalse(new LandRegister("KI1R", "0", 20).isValid());
        assertFalse(new LandRegister("KI1R", "1", 90).isValid());
        assertFalse(new LandRegister("KI1R", "2", 60).isValid());
        assertFalse(new LandRegister("KI1R", "3", 30).isValid());
        assertFalse(new LandRegister("KI1R", "4", 10).isValid());
        assertFalse(new LandRegister("KI1R", "5", 70).isValid());
        assertFalse(new LandRegister("KI1R", "6", 40).isValid());
        assertFalse(new LandRegister("KI1R", "7", 10).isValid());
        assertFalse(new LandRegister("KI1R", "8", 80).isValid());
        assertFalse(new LandRegister("KI1R", "9", 50).isValid());
    }

    @org.junit.Test
    public void kI1WFalse() {
        assertFalse(new LandRegister("KI1W", "0", 60).isValid());
        assertFalse(new LandRegister("KI1W", "1", 30).isValid());
        assertFalse(new LandRegister("KI1W", "2", 10).isValid());
        assertFalse(new LandRegister("KI1W", "3", 70).isValid());
        assertFalse(new LandRegister("KI1W", "4", 40).isValid());
        assertFalse(new LandRegister("KI1W", "5", 10).isValid());
        assertFalse(new LandRegister("KI1W", "6", 80).isValid());
        assertFalse(new LandRegister("KI1W", "7", 50).isValid());
        assertFalse(new LandRegister("KI1W", "8", 20).isValid());
        assertFalse(new LandRegister("KI1W", "9", 90).isValid());
    }

    @org.junit.Test
    public void kI1BtoString(){
        assertEquals("KI1B/00046215/1", new LandRegister("KI1B", "46215").toString());
        assertEquals("KI1B/00010737/5", new LandRegister("KI1B", "10737").toString());
        assertEquals("KI1B/00064738/5", new LandRegister("KI1B", "64738").toString());
    }

    @org.junit.Test
    public void kI1WFromString(){
        assertTrue(new LandRegister("KI1B/64738/5").isValid());
        assertFalse(new LandRegister("KI1B/64738/6").isValid());
        assertEquals("KI1B/00064738/5", new LandRegister("KI1B/64738/5").validate().toString());
    }
}