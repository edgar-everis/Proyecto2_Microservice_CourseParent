package com.main.serviceimplements;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.reactivestreams.Publisher;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.main.model.CourseParents;

import com.main.repository.CourseParentsRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class CourseServiceImplTest {

  @Mock private CourseParentsRepository repo;

  @InjectMocks private CourseServiceImpl service;

  @Test
  public void testCreateCourseParent() {
    CourseParents list = new CourseParents();
    list.setId("1");
    list.setIdcourse("C01");
    list.setIdparent("P01");
    list.setCondition("Activo");
    list.setStatus("Iniciado");

    when(repo.save(list)).thenReturn(Mono.just(list));
    Mono<CourseParents> actual = service.CreateCourseParent(list);
    assertResults(actual, list);
  }

  @Test
  public void testDeleteById() {
    CourseParents course = new CourseParents();
    course.setId("1");
    course.setIdcourse("C01");
    course.setIdparent("P01");
    course.setCondition("Activo");
    course.setStatus("Inciado");
    when(repo.delete(course)).thenReturn(Mono.empty());
  }

  @Test
  public void testFindById() {
    CourseParents list = new CourseParents();
    list.setId("1");
    list.setIdcourse("C01");
    list.setIdparent("P01");
    list.setCondition("Activo");
    list.setStatus("Iniciado");

    when(repo.findById("2")).thenReturn(Mono.just(list));
    Mono<CourseParents> actual = service.findById("2");
    assertResults(actual, list);
    System.out.println(actual);
  }

  @Test
  public void testFindByIdparent() {
    CourseParents list = new CourseParents();
    list.setId("1");
    list.setIdcourse("C01");
    list.setIdparent("P01");
    list.setCondition("Activo");
    list.setStatus("Iniciado");

    when(repo.findByIdparent("P01")).thenReturn(Flux.just(list));
    Flux<CourseParents> actual = service.findByIdparent("P01");
    assertResults(actual, list);
    System.out.println(actual);
  }

  @Test
  public void testFindByIdparentAndCondition() {
    CourseParents list = new CourseParents();
    list.setId("1");
    list.setIdcourse("C01");
    list.setIdparent("P01");
    list.setCondition("Activo");
    list.setStatus("Iniciado");

    when(repo.findByIdparentAndCondition("P01", "Activo")).thenReturn(Flux.just(list));
    Flux<CourseParents> actual = service.findByIdparentAndCondition("P01", "Activo");
    assertResults(actual, list);
    System.out.println(actual);
  }

  @Test
  public void testFindByIdparentAndStatus() {
    CourseParents list = new CourseParents();
    list.setId("1");
    list.setIdcourse("C01");
    list.setIdparent("P01");
    list.setCondition("Activo");
    list.setStatus("Iniciado");

    when(repo.findByIdparentAndStatus("P01", "Iniciado")).thenReturn(Flux.just(list));
    Flux<CourseParents> actual = service.findByIdparentAndStatus("P01", "Iniciado");
    assertResults(actual, list);
    System.out.println(actual);
  }

  @Test
  public void testGetAll() {
    CourseParents list = new CourseParents();
    list.setId("1");
    list.setIdcourse("C01");
    list.setIdparent("P01");
    list.setCondition("Activo");
    list.setStatus("Iniciado");
    when(service.GetAll()).thenReturn(Flux.just(list));
    Flux<CourseParents> actual = service.GetAll();
    assertResults(actual, list);
  }

  private void assertResults(
      Publisher<CourseParents> publisher, CourseParents... expectedProducts) {
    StepVerifier.create(publisher).expectNext(expectedProducts).verifyComplete();
  }
}
