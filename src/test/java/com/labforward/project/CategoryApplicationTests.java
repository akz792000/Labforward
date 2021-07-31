package com.labforward.project;

import com.labforward.project.web.dto.CategoryDTO;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class CategoryApplicationTests {

    private final Logger log = LoggerFactory.getLogger(CategoryApplicationTests.class);

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    public String getUrl() {
        return "http://localhost:" + port + "/category";
    }

    public CategoryDTO findById(Long id) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(getUrl() + "/findById")
                .queryParam("id", 1L);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> httpEntity = new HttpEntity<>(headers);
        HttpEntity<CategoryDTO> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                httpEntity,
                CategoryDTO.class);
        return response.getBody();
    }

    //@Disabled
    @DisplayName("persist")
    @Order(1)
    @Test
    public void persist() {
        // persist
        CategoryDTO dto = CategoryDTO.builder()
                .name("persist")
                .build();
        HttpEntity<CategoryDTO> httpEntity = new HttpEntity<>(dto);
        ResponseEntity<Long> response = this.restTemplate.postForEntity(getUrl() + "/persist", httpEntity, Long.class);
        assertThat(response.getBody()).isEqualTo(1L);
    }

    //@Disabled
    @DisplayName("findById")
    @Order(2)
    @Test
    public void findById() {
        // get by id
        CategoryDTO dto = findById(1L);
        Condition<CategoryDTO> condition = new Condition<>(
                m -> m.getId().equals(1L),
                "not equal"
        );
        assertThat(dto).isNotNull().is(condition);
    }

    //@Disabled
    @DisplayName("deleteById")
    @Order(4)
    @Test
    public void deleteById() {
        // remove
        Map<String, Object> param = new HashMap<>();
        param.put("id", 1);
        this.restTemplate.delete(getUrl() + "/deleteById/{id}", param);

        // check if it was removed
        CategoryDTO entity = findById(1L);
        assertThat(entity).isNull();
    }

}
