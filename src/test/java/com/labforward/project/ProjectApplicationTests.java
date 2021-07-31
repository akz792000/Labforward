package com.labforward.project;

import com.labforward.project.enums.PowerUsageType;
import com.labforward.project.web.dto.AnalyticalInstrumentDTO;
import com.labforward.project.web.dto.FactoryDTO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import java.util.Date;

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

    public void persistFactory(String name) {
        FactoryDTO factoryDTO = FactoryDTO.builder().name(name).build();
        HttpEntity<FactoryDTO> httpEntity = new HttpEntity<>(factoryDTO);
        ResponseEntity<Long> response = this.restTemplate.postForEntity(getUrl() + "/factory/persist", httpEntity, Long.class);
        Long authorId = response.getBody();
        assertThat(authorId).isNotEqualTo(0L);
    }


    //@Disabled
    @DisplayName("persist")
    @Order(1)
    @Test
    public void persist() {
        // persist factories
        persistFactory("Factory 1");
        persistFactory("Factory 2");

        // persist analytical instrument
        AnalyticalInstrumentDTO dto = AnalyticalInstrumentDTO.builder()
                .powerUsageType(PowerUsageType.E_220)
                .date(new Date())
                .title("AnalyticalInstrument_1")
                .description("Analytical Instrument 1")
                .build();
        HttpEntity<AnalyticalInstrumentDTO> httpEntity = new HttpEntity<>(dto);
        ResponseEntity<Long> response = this.restTemplate.postForEntity(getUrl() + "/analyticalInstrument/persist", httpEntity, Long.class);
        Long authorId = response.getBody();

    }

}
