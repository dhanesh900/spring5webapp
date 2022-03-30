package guru.springframework.spring5webapp.Repository;

import guru.springframework.spring5webapp.model.publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends CrudRepository<publisher, Long> {
}
