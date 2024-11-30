package br.heittor.mangeracingapi.specifications;

import br.heittor.mangeracingapi.entity.BikeType;
import br.heittor.mangeracingapi.entity.PartsEntity;
import net.kaczmarzyk.spring.data.jpa.domain.*;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

public class PartsSpecification {

    @And({
            //path = atributo do banco
            //params = o parametro q vem do front/insomnia
            //spec = a logica que sera efetuada na busca
            @Spec(path = "type", params = "type", spec = EqualIgnoreCase.class),
            @Spec(path = "title", params = "title", spec = LikeIgnoreCase.class),
            @Spec(path = "createdDate", params = {"after", "before"}, spec = Between.class),
    })
    public interface PartsSpec extends Specification<PartsEntity> {
    }

    public static Specification<PartsEntity> bikeTypeEquals(final BikeType bikeType) {
        return (root, query, builder) -> {
            return builder.equal(root.get("bikeType"), bikeType);
        };
    }
}

