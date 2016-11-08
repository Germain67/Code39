package com.code.barres;
import junit.framework.*;

import static com.code.barres.Code39.encode;
import static com.code.barres.Code39.encodeWithModulo;

/**
 * Created by germain on 03/11/16.
 */
public class TestCode39 extends TestCase {

    public static void testSimpleEncode() throws Exception {
        assertEquals("*TEST*", encode("test"));
        assertEquals("*CECI EST UNE CHAINE A ENCODER*", encode("Ceci est une chaine a encoder"));
    }

    public static void testSpecialCharsEncode() throws Exception {
        assertEquals("**", encode(""));
        assertEquals("*$*", encode("$"));
        assertEquals("**", encode("è"));
    }

    public static void testComplexStringEncode() throws Exception {
        assertEquals("*YEL$LO KOALA*", encode("yel$lO koala"));
        assertEquals("*ZAB*", encode("èµéùèèzAèèèèbèèèè"));
        assertEquals("*AAAB$BB*", encode("aaèa\nb$bb"));
        assertEquals("*TEST$ 0123*", encode("TEST$_éè 0123"));
    }

    public static void testModuloSimpleEncode() throws Exception {
        assertEquals("*TESTE*", encodeWithModulo("test"));
    }

    public static void testModuloSpecialCharsEncode() throws Exception {
        assertEquals("*0*", encodeWithModulo(""));
        assertEquals("*$$*", encodeWithModulo("$"));
        assertEquals("*0*", encodeWithModulo("è"));
    }

    public static void testModuloComplexStringEncode() throws Exception {
        assertEquals("*ZABD*", encodeWithModulo("èµéùèèzAèèèèbèèèè"));
    }
}
