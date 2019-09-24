package com.main.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Document
public class CourseParents {

	    @Id
	    private String id;

	    @NotEmpty
	    private String idparent;

	    @NotEmpty
	    private String idcourse;

	    @NotEmpty // Status = Iniciado o no iniciado
	    private String status;

	    @NotEmpty // condition = activo o finalizado
	    private String condition;
}
