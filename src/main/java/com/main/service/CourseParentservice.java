package com.main.service;

import com.main.model.CourseParents;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CourseParentservice {

  Mono<CourseParents> CreateCourseParent(CourseParents courseparents);

  Mono<Void> DeleteById(String id);

  Mono<CourseParents> findById(String id);

  Flux<CourseParents> findByIdparent(String idparent);

  Flux<CourseParents> findByIdparentAndCondition(String idparent, String condition);

  Flux<CourseParents> findByIdparentAndStatus(String idparent, String status);

  Flux<CourseParents> GetAll();

  Mono<CourseParents> ModifyCourseParent(String id, CourseParents courseparents);
}
