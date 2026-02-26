package br.edu.ifpb.sr.dac.demo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented

@Constraint(validatedBy = SenhasIguaisValidator.class)

@Target({ElementType.TYPE})

@Retention(RetentionPolicy.RUNTIME)

public @interface SenhasIguais {

    String message() default "As senhas não conferem";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}