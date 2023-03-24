package PedroTejeroS04T02N03.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import PedroTejeroS04T02N03.model.domain.Fruta;

public interface FrutaRepository extends MongoRepository<Fruta, Integer>{

}
