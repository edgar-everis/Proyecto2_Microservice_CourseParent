package com.main.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.main.model.CourseParents;

import reactor.core.publisher.Flux;

@Repository
public interface CourseParentsRepository extends ReactiveMongoRepository<CourseParents, String> {

  Flux<CourseParents> findByIdparent(String idparent);

  Flux<CourseParents> findByIdparentAndCondition(String idparent, String condition);

  Flux<CourseParents> findByIdparentAndStatus(String idparent, String status);
}
