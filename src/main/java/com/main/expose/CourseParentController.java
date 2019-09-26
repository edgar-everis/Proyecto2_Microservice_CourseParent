package com.main.expose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.main.model.CourseParents;
import com.main.service.CourseParentservice;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/API/CourseParent")
public class CourseParentController {

  @Autowired private CourseParentservice service;

  @PostMapping("/create")
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<CourseParents> CreateCourseParent(@RequestBody CourseParents courseparents) {
    return service.CreateCourseParent(courseparents);
  }

  @DeleteMapping("/delete/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public Mono<Void> deleteCourseParent(@PathVariable String id) {
    return service.DeleteById(id);
  }

  @GetMapping("/coursestatus/{idparent}")
  public Flux<CourseParents> FindbyIdparent(@PathVariable String idparent) {
    return service.findByIdparent(idparent);
  }

  @GetMapping("/coursecondition/{idparent}/{condition}")
  public Flux<CourseParents> FindbyIdparentAndCondition(
      @PathVariable String idparent, @PathVariable String condition) {
    return service.findByIdparentAndCondition(idparent, condition);
  }

  @GetMapping("/coursestatus/{idparent}/{status}")
  public Flux<CourseParents> FindbyIdparentAndStatus(
      @PathVariable String idparent, @PathVariable String status) {
    return service.findByIdparentAndStatus(idparent, status);
  }

  @GetMapping
  public Flux<CourseParents> Getall() {
    return service.GetAll();
  }

  @PutMapping("/update/{id}")
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<CourseParents> updateCourseParent(
      @PathVariable String id, @RequestBody CourseParents courseparents) {
    return service.ModifyCourseParent(id, courseparents);
  }
}
