package br.edu.ifpb.sr.dac.demo.validation;

import br.edu.ifpb.sr.dac.demo.dto.PostUsuarioDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SenhasIguaisValidator implements ConstraintValidator<SenhasIguais, PostUsuarioDTO> {

    @Override
    public boolean isValid(PostUsuarioDTO dto, ConstraintValidatorContext context) {
        if (dto == null) {
            return true;
        }
        return dto.senha() != null && dto.senha().equals(dto.confirmacaoSenha());
    }
}