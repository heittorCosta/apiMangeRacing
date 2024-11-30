package br.heittor.mangeracingapi.converter;

import br.heittor.mangeracingapi.entity.BikeType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BikeTypeConverter implements Converter<String, BikeType> {

    @Override
    public BikeType convert(String source) {
        return BikeType.valueOf(source.toUpperCase());
    }
}