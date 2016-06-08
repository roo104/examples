package com.blogspot.jpdevelopment.tostring.builder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ToStringBuilderTest {

    @Test
    public void testToString() throws Exception {
        String result = new ToStringBuilder(new OuterClass()).toReflectString();

        assertEquals("OuterClass[i=1,inte=2,s=s,InnerClass[t=11]]", result);
    }

    private class OuterClass {
        private int i = 1;
        private Integer inte = new Integer(2);
        private String s = "s";
        private InnerClass innerClass = new InnerClass();
    }

    private class InnerClass {
        private int t = 11;
        private SecondInnerClass secondInnerClass;

        private class SecondInnerClass {
            private String string = "string";
        }
    }
}