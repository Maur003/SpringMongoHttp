package co.com.bonilla.service.http.repository;

import co.com.bonilla.service.http.model.Film;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends MongoRepository<Film, String>{
}
