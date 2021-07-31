package com.labforward.project;

import com.labforward.project.enums.PowerUsageType;
import com.labforward.project.web.dto.AnalyticalInstrumentDTO;
import com.labforward.project.web.dto.FactoryDTO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Date;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Ali Karimizandi
 * @since 2021
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ProjectApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    public String getUrl() {
        return "http://localhost:" + port;
    }

    public void persistFactory(Long code, String name) {
        FactoryDTO factoryDTO = FactoryDTO.builder()
                .code(code)
                .name(name)
                .build();
        HttpEntity<FactoryDTO> httpEntity = new HttpEntity<>(factoryDTO);
        ResponseEntity<Long> response = this.restTemplate.postForEntity(getUrl() + "/factory/persist", httpEntity, Long.class);
        Long authorId = response.getBody();
        assertThat(authorId).isNotEqualTo(0L);
    }

    public FactoryDTO getFactoryByCode(Long code) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(getUrl() + "/factory/findByCode")
                .queryParam("code", code);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> httpEntity = new HttpEntity<>(headers);
        HttpEntity<FactoryDTO> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                httpEntity,
                FactoryDTO.class);
        return response.getBody();
    }

    //@Disabled
    @DisplayName("persist")
    @Order(1)
    @Test
    public void persist() {
        // persist factories
        persistFactory(1L, "Factory 1");
        persistFactory(2L, "Factory 2");

        // get factory id
        FactoryDTO factoryDTO1 = getFactoryByCode(1L);
        FactoryDTO factoryDTO2 = getFactoryByCode(2L);

        // persist analytical instrument
        AnalyticalInstrumentDTO dto = AnalyticalInstrumentDTO.builder()
                .powerUsageType(PowerUsageType.E_220)
                .date(new Date())
                .factories(new HashSet<FactoryDTO>() {{ add(factoryDTO1); add(factoryDTO2); }})
                .title("AnalyticalInstrument_1")
                .description("Analytical Instrument 1")
                .build();
        HttpEntity<AnalyticalInstrumentDTO> httpEntity = new HttpEntity<>(dto);
        ResponseEntity<String> response = this.restTemplate.postForEntity(getUrl() + "/analyticalInstrument/persist", httpEntity, String.class);
        String authorId = response.getBody();

        System.out.println(authorId);

    }

}
