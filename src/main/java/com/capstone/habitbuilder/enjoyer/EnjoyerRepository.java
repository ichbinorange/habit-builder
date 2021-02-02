package com.capstone.habitbuilder.enjoyer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnjoyerRepository extends CrudRepository<Enjoyer, Long> {
    Optional<Enjoyer> findEnjoyerByEmail(String email);
    Boolean existsByEmail(String email);
}
