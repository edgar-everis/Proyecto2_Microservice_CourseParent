package com.main.service;



import com.main.model.CourseParents;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CourseParentservice  {


		Flux<CourseParents> findByIdParentAndCondition(String idparent, String condition);

		Flux<CourseParents> findByIdParentAndStatus(String idparent, String status);

		Flux<CourseParents> findByIdParent(String idparent);

	    Flux<CourseParents> GetAll();

	    Mono<CourseParents> findById(String id);

	    Mono<CourseParents> CreateCourseParent(CourseParents courseparents);

	    Mono<CourseParents> ModifyCourseParent(String id, CourseParents courseparents);

	    Mono<Void> DeleteById(String id);
}
