package springboot_13.demo;

import org.springframework.data.repository.CrudRepository;

public interface ActorRepository extends CrudRepository<Actor, Long> {
}
