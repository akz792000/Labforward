package com.labforward.project.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author Ali Karimizandi
 * @since 2021
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AuthorDTO {

    private Long id;

    private String firstName;

    private String lastName;

}
