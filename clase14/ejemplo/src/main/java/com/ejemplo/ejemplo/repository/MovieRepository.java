package com.ejemplo.ejemplo.repository;

import com.ejemplo.ejemplo.entity.MovieEntity;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import reactor.core.publisher.Mono;

public interface MovieRepository extends ReactiveNeo4jRepository<MovieEntity,
        String> {
    Mono<MovieEntity> findOneByTitle(String title);
}