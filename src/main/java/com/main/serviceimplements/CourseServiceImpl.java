package com.main.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.model.CourseParents;
import com.main.repository.CourseParentsRepository;
import com.main.service.CourseParentservice;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CourseServiceImpl implements CourseParentservice {

	@Autowired
	private CourseParentsRepository repository;
	
	@Override
	public Flux<CourseParents> findByIdParentAndCondition(String idparent, String condition) {
		// TODO Auto-generated method stub
		return repository.findByIdParentAndCondition(idparent, condition);
	}

	@Override
	public Flux<CourseParents> findByIdParentAndStatus(String idparent, String status) {
		// TODO Auto-generated method stub
		return repository.findByIdParentAndStatus(idparent, status);
	}

	@Override
	public Flux<CourseParents> findByIdParent(String idparent) {
		// TODO Auto-generated method stub
		return repository.findByIdParent(idparent);
	}

	@Override
	public Flux<CourseParents> GetAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Mono<CourseParents> findById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	

	@Override
	public Mono<Void> DeleteById(String id) {
		// TODO Auto-generated method stub
		return repository.deleteById(id);
	}

	@Override
	public Mono<CourseParents> CreateCourseParent(CourseParents courseparents) {
		// TODO Auto-generated method stub
		return repository.save(courseparents);
	}

	@Override
	public Mono<CourseParents> ModifyCourseParent(String id, CourseParents courseparents) {
		// TODO Auto-generated method stub
		courseparents.setId(id);
		return repository.save(courseparents);
	}

}
