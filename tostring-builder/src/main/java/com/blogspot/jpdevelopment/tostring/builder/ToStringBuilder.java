package com.blogspot.jpdevelopment.tostring.builder;

import java.lang.reflect.Field;

public class ToStringBuilder {

    private final Object object;

    public ToStringBuilder(Object object) {
        this.object = object;
    }

    public String toReflectString() throws IllegalAccessException {
        StringBuilder sb = new StringBuilder();
        sb.append(toReflect(object));
        return sb.toString();
    }

    private String toReflect(Object obj) throws IllegalAccessException {
        StringBuilder sb = new StringBuilder();
        if (obj != null && obj != this) {
            boolean firstRun = true;
            Class<?> objClass = obj.getClass();
            sb.append(objClass.getSimpleName());
            sb.append("[");
            Field[] declaredFields = objClass.getDeclaredFields();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                Object fieldValue = field.get(obj);
                String fieldName = field.getName();

                if (shouldPrint(obj, field)) {
                    if (!firstRun) {
                        sb.append(",");
                    } else {
                        firstRun = false;
                    }
                    sb.append(fieldName);
                    sb.append("=");
                    sb.append(fieldValue);
                } else if (!fieldName.equals("this$0")) {
                    sb.append(",");
                    sb.append(toReflect(fieldValue));
                }
            }
            sb.append("]");
        }
        return sb.toString();
    }

    private boolean shouldPrint(Object obj, Field field) throws IllegalAccessException {
        boolean shouldPrint = false;
        if (field.getType().isPrimitive()) {
            shouldPrint = true;
        } else if (field.get(obj) instanceof Integer) {
            shouldPrint = true;
        } else if (field.get(obj) instanceof String) {
            shouldPrint = true;
        }

        return shouldPrint;
    }
}
