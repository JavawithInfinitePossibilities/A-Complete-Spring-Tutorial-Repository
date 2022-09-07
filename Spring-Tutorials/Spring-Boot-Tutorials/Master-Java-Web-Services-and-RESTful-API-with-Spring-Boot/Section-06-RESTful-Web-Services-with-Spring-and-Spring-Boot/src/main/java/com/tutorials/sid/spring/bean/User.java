package com.tutorials.sid.spring.bean;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@Component
@ApiModel(description = "All details about the user.")
public class User extends RepresentationModel<User> {

	private Integer id;
	@Size(min = 2, message = "Name should have atleast 2 characters")
	@ApiModelProperty(notes = "Name should have atleast 2 characters")
	private String name;
	@Past
	@ApiModelProperty(notes = "Birth date should be in the past")
	private Date birthDate;

	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, birthDate=%s]", id, name, birthDate);
	}
}