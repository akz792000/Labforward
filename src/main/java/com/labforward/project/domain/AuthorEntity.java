package com.labforward.project.domain;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity(name = "author")
public class AuthorEntity extends BaseEntity {

    String firstName;

    String lastName;

}
