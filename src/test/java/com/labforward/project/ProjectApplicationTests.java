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

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ProjectApplicationTests {

    private final Logger log = LoggerFactory.getLogger(ProjectApplicationTests.class);

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    public String getUrl() {
        return "http://localhost:" + port + "/widget";
    }

    public CategoryDTO getById(Long id) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(getUrl() + "/getById")
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

    public List<CategoryDTO> getAll(int page, int pageSize) {
        // set uri
        Map<String, Object> uriParam = new HashMap<>();
        uriParam.put("page", page);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(getUrl() + "/getAll/{page}")
                .queryParam("pageSize", pageSize);
        String url = builder.build(uriParam).toString();

        // send request
        HttpEntity<CategoryDTO[]> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                CategoryDTO[].class,
                uriParam);
        return Arrays.asList(response.getBody());
    }

    public List<CategoryDTO> getAll() {
        return getAll(1, 10);
    }

    public CategoryDTO persist(CategoryDTO entity) {
        HttpEntity<CategoryDTO> httpEntity = new HttpEntity<>(entity);
        ResponseEntity<CategoryDTO> response = this.restTemplate.postForEntity(getUrl() + "/persist", httpEntity, CategoryDTO.class);
        return response.getBody();
    }

    public void merge(CategoryDTO entity) {
        this.restTemplate.put(getUrl() + "/merge", entity);
    }

    //@Disabled
    @DisplayName("Base persist")
    @Order(1)
    @Test
    public void persist() {
        // persist
        CategoryDTO entity = persist(CategoryDTO.builder()
                .name("Persist")
                .build());
        assertThat(entity.getId()).isEqualTo(1L);
    }

    //@Disabled
    @DisplayName("Base getById")
    @Order(2)
    @Test
    public void getById() {
        // get by id
        CategoryDTO entity = getById(1L);
        Condition<CategoryDTO> condition = new Condition<>(
                m -> m.getId().equals(1L),
                "not equal"
        );
        assertThat(entity).isNotNull().is(condition);
    }

    //@Disabled
    @DisplayName("Base Merge")
    @Order(3)
    @Test
    public void merge() {
        // get by id
        CategoryDTO entity = getById(1L);

        // merge
        entity.setName("Merge");
        merge(entity);

        // get by id
        entity = getById(1L);
        assertThat(entity.getName()).isEqualTo(200L);
    }

    //@Disabled
    @DisplayName("Base removeById")
    @Order(4)
    @Test
    public void removeById() {
        // remove
        Map<String, Object> param = new HashMap<>();
        param.put("id", 1);
        this.restTemplate.delete(getUrl() + "/removeById/{id}", param);

        // check if it was removed
        CategoryDTO entity = getById(1L);
        assertThat(entity).isNull();
    }

    //@Disabled
    @DisplayName("Base findAll")
    @Order(5)
    @Test
    public void findAll() {
        // save 10 items
        for (int i = 1; i <= 10; i++) {
            CategoryDTO entity = CategoryDTO.builder()
                    .name(String.valueOf(i * 10))
                    .build();
            persist(entity);
        }

        // getAll
        List<CategoryDTO> entities = getAll();
        assertThat(entities).size().isEqualTo(10);
    }

    //@Disabled
    @DisplayName("Remove all")
    @Order(7)
    @Test
    public void removeAll() {
        // remove all
        this.restTemplate.delete(getUrl() + "/removeAll");

        // check if all were removed
        List<CategoryDTO> entities = getAll();
        assertThat(entities).size().isEqualTo(0);
    }

}
