package com.TDD;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;

import static junit.framework.Assert.assertEquals;

/**
 * Created by dexter on 3/14/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class RomaArabicTest {

    private MockMvc mockMvc;
    @Test
    public void testConvert(){
        Roman r = new Roman(1);
        int arabic = r.toArabic();
        assertEquals(arabic, 1);
    }


    @Test
    public void testConvert1(){
        Roman r = new Roman(1);
        int arabic = r.toArabic();
        assertEquals(arabic, 3);
    }

    @Test
    public void testConvert2(){
        Roman r = new Roman(1);
        int arabic = r.toArabic();
        assertEquals(arabic, 2);
        Assert.assertEquals(arabic, 2);
    }


}
