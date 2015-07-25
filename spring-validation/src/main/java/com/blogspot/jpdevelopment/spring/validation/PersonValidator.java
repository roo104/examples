package com.blogspot.jpdevelopment.spring.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by jp on 23-07-2015.
 */
@Component
public class PersonValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "firstname", "firstname.empty");
        ValidationUtils.rejectIfEmpty(errors, "lastname", "lastname.empty");
    }
}
