package com.labforward.project;

import com.labforward.project.enums.MaterialType;
import com.labforward.project.enums.PowerUsageType;
import com.labforward.project.web.dto.AnalyticalInstrumentDTO;
import com.labforward.project.web.dto.ClinicalLabEquipmentDTO;
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

    public <T> void persist(T dto, String url) {
        HttpEntity<T> httpEntity = new HttpEntity<>(dto);
        ResponseEntity<Long> response = this.restTemplate.postForEntity(getUrl() + url, httpEntity, Long.class);
        assertThat(response.getBody()).isNotEqualTo(0L);
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
        FactoryDTO dto;
        // persist factory 1
        dto = FactoryDTO.builder()
                .code(1L)
                .name("Factory 1")
                .build();
        persist(dto, "/factory/persist");

        // persist factory 2
        dto = FactoryDTO.builder()
                .code(2L)
                .name("Factory 2")
                .build();
        persist(dto, "/factory/persist");

        // get factories
        FactoryDTO factoryDTO1 = getFactoryByCode(1L);
        FactoryDTO factoryDTO2 = getFactoryByCode(2L);

        // persist analytical instrument
        AnalyticalInstrumentDTO analyticalInstrumentDTO = AnalyticalInstrumentDTO.builder()
                .powerUsageType(PowerUsageType.E_220)
                .date(new Date())
                .factories(new HashSet<>() {{
                    add(factoryDTO1);
                    add(factoryDTO2);
                }})
                .name("AnalyticalInstrument_1")
                .description("Analytical Instrument 1")
                .build();
        persist(analyticalInstrumentDTO, "/analyticalInstrument/persist");

        // persist clinical lab equipment
        ClinicalLabEquipmentDTO clinicalLabEquipmentDTO = ClinicalLabEquipmentDTO.builder()
                .materialType(MaterialType.PLASTIC)
                .date(new Date())
                .factories(new HashSet<>() {{
                    add(factoryDTO1);
                    add(factoryDTO2);
                }})
                .name("ClinicalLabEquipment_1")
                .description("Clinical Lab Equipment 1")
                .build();
        persist(clinicalLabEquipmentDTO, "/clinicalLabEquipment/persist");

        System.out.println("End");

    }

}
