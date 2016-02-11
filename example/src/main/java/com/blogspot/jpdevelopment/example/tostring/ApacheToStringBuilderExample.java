package com.blogspot.jpdevelopment.example.tostring;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ApacheToStringBuilderExample {

    public static void main(String[] args) {
        ToString toString = new ToString("attributeOne", "attributeAnother");

        // com.blogspot.jpdevelopment.example.tostring.ToString@31befd9f[attributeOne=attributeOne,attributeAnother=attributeAnother]
        System.out.println("Default toString: " + ToStringBuilder.reflectionToString(toString));

        // attributeOne,attributeAnother
        System.out.println("Simple toString: " + ToStringBuilder.reflectionToString(toString, ToStringStyle.SIMPLE_STYLE));

        // com.blogspot.jpdevelopment.example.tostring.ToString@31befd9f[
        //        attributeOne=attributeOne
        // attributeAnother=attributeAnother
        // ]
        System.out.println("Multi line toString: " + ToStringBuilder.reflectionToString(toString, ToStringStyle.MULTI_LINE_STYLE));

        // ToString[attributeOne=attributeOne,attributeAnother=attributeAnother]
        System.out.println("Short prefix toString: " + ToStringBuilder.reflectionToString(toString, ToStringStyle.SHORT_PREFIX_STYLE));

        // com.blogspot.jpdevelopment.example.tostring.ToString@31befd9f[attributeOne,attributeAnother]
        System.out.println("No field names toString: " + ToStringBuilder.reflectionToString(toString, ToStringStyle.NO_FIELD_NAMES_STYLE));

    }
}
