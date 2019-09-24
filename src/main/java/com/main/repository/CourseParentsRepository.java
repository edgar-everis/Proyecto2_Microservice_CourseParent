package com.main.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.main.model.CourseParents;


import reactor.core.publisher.Flux;

public interface CourseParentsRepository extends ReactiveMongoRepository<CourseParents, String> {

	Flux<CourseParents> findByIdParentAndCondition(String idparent, String condition);

    Flux<CourseParents> findByIdParentAndStatus(String idparent, String status);

    Flux<CourseParents> findByIdParent(String idparent);
}
