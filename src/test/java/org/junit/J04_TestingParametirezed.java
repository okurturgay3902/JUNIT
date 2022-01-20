package org.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class J04_TestingParametirezed {

    @Test
        //CISSSS asla tavsiye edilmez --> failed olan testten sonra kalan testler run olamaycagi icin defect bulunamaz
    void uzunlukSifirdanbyk() {
        assertTrue("yıldız".length() > 0);
        assertTrue("suleyman".length() > 2);
        assertTrue("omer".length() > 3);
        assertTrue("kursat".length() > 4);
    }
    //TEKIL SART...
    /*
    lenght() methodu ile asagıdaki sartlar için 0'dan buyuk deger return ettigini test ediniz.
    Sartlar : "yıldız" , "suleyman" , "omer" , "kursat"  --> bu datalar testi nasıl geçer
     */
    @ParameterizedTest
    // @ValueSource(strings = {"yıldız", "suleyman", "omer", "kursat"})//passed
    @ValueSource(strings = {"yıldız", "suleyman", "omer","x", "kursat"})//failed
    void uzunlukSifirdanBykPrmtrl(String str){//@ValueSource(strings = {"yıldız", "suleyman", "omer", "kursat"}) parametre
        // elemanları methoda parametre olarak göngüye girerek run edilir
        assertTrue(str.length()>2);
    }

    //COKLU SART --> Her parametre elemanı KEY VALUE ikili ile test method'unda run edilir.
    @ParameterizedTest
    //CSV : comma-separated values --> virgülle ayrılmış degerler
    @CsvSource(value= {"yıldız,YILDIZ","suleyman,SULEYMAN","omer,OMER","kursat,KURSAT"})
    void testBykHrfCvr(String beklenenBYKhrf, String isim){
        assertEquals(beklenenBYKhrf.toUpperCase(),isim);
    }
}
