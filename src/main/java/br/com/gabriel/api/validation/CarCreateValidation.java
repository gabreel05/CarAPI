/*
package br.com.gabriel.api.validation;

import br.com.gabriel.api.controller.dto.CarTDO;
import br.com.gabriel.api.exception.FieldMessage;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class CarCreateValidation implements ConstraintValidator<CarCreate, CarTDO> {
    @Override
    public void initialize(CarCreate constraintAnnotation) {
    }

    @Override
    public boolean isValid(CarTDO value, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        Cliente clienteExistente = clienteRepository.findByEmail(objDto.getEmail());

        if(clienteExistente != null) {
            list.add(new FieldMessage("email", "E-mail já existente"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}
*/
