package com.blogspot.jpdevelopment.example.tostring;

import org.apache.commons.lang3.builder.ToStringStyle;

public class MyToStringStyle extends ToStringStyle {

    public MyToStringStyle() {
        this.setUseClassName(true);
        this.setUseIdentityHashCode(false);
        this.setUseFieldNames(true);
        this.setContentStart("[start]");
        this.setFieldSeparator(",");
        this.setFieldSeparatorAtStart(false);
        this.setContentEnd("[end]");
    }
}
