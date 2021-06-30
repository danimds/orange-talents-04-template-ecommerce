package br.com.zupacademy.dani.mercadolivre.utils;



import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {
    private String targetAttribute;
    private Class<?> klass;

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(UniqueValue params) {
        targetAttribute = params.fieldName();
        klass = params.targetClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        Query query = manager.createQuery("select k from "+klass.getName()+ " k where "+ targetAttribute+"=:pValue");
        query.setParameter("pValue", value);
        List<?> list = query.getResultList();
        Assert.state(list.size() <=1, "Foi encontrado mais de um "+klass+" com o atributo "+targetAttribute+" = "+value);

        return list.isEmpty();
    }
}
