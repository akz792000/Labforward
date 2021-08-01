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
        ResponseEntity<Long> response = this.restTemplate.postForEntity(getUrl() + url + "/persist", httpEntity, Long.class);
        assertThat(response.getBody()).isNotEqualTo(0L);
    }

    public <T> T merge(T dto, String url) {
        HttpEntity<T> httpEntity = new HttpEntity<>(dto);
        ResponseEntity<T> response = (ResponseEntity<T>) this.restTemplate.postForEntity(getUrl() + url + "/merge", httpEntity, dto.getClass());
        return (T) response.getBody();
    }

    public <T> T findByCode(Long code, String url, Class<T> clazz) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(getUrl() + url + "/findByCode")
                .queryParam("code", code);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> httpEntity = new HttpEntity<>(headers);
        HttpEntity<T> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                httpEntity,
                clazz);
        return (T) response.getBody();
    }

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
        persist(dto, "/factory");

        // persist factory 2
        dto = FactoryDTO.builder()
                .code(2L)
                .name("Factory 2")
                .build();
        persist(dto, "/factory");

        // get factories
        FactoryDTO factoryDTO1 = findByCode(1L, "/factory", FactoryDTO.class);
        FactoryDTO factoryDTO2 = findByCode(2L, "/factory", FactoryDTO.class);

        // persist analytical instrument
        AnalyticalInstrumentDTO analyticalInstrumentDTO = AnalyticalInstrumentDTO.builder()
                .powerUsageType(PowerUsageType.E_220)
                .date(new Date())
                .factories(new HashSet<>() {{
                    add(factoryDTO1);
                    add(factoryDTO2);
                }})
                .code(1L)
                .name("AnalyticalInstrument_1")
                .description("Analytical Instrument 1")
                .build();
        persist(analyticalInstrumentDTO, "/analyticalInstrument");

        // persist clinical lab equipment
        ClinicalLabEquipmentDTO clinicalLabEquipmentDTO = ClinicalLabEquipmentDTO.builder()
                .materialType(MaterialType.PLASTIC)
                .date(new Date())
                .factories(new HashSet<>() {{
                    add(factoryDTO1);
                    add(factoryDTO2);
                }})
                .code(2L)
                .name("ClinicalLabEquipment_1")
                .description("Clinical Lab Equipment 1")
                .build();
        persist(clinicalLabEquipmentDTO, "/clinicalLabEquipment");
    }

    @DisplayName("merge")
    @Order(2)
    @Test
    public void merge() {
        // Factory
        String name = "Factory 11";
        FactoryDTO factoryDTO = findByCode(1L, "/factory", FactoryDTO.class);
        factoryDTO.setName(name);
        factoryDTO = merge(factoryDTO, "/factory");
        assertThat(factoryDTO.getName()).isEqualTo(name);

        // AnalyticalInstrument
        PowerUsageType powerUsageType = PowerUsageType.E_110;
        AnalyticalInstrumentDTO analyticalInstrumentDTO = findByCode(1L, "/analyticalInstrument", AnalyticalInstrumentDTO.class);
        analyticalInstrumentDTO.setPowerUsageType(powerUsageType);
        analyticalInstrumentDTO = merge(analyticalInstrumentDTO, "/analyticalInstrument");
        assertThat(analyticalInstrumentDTO.getPowerUsageType()).isEqualTo(powerUsageType);

        // AnalyticalInstrument
        MaterialType materialType = MaterialType.GLASS;
        ClinicalLabEquipmentDTO clinicalLabEquipmentDTO = findByCode(2L, "/clinicalLabEquipment", ClinicalLabEquipmentDTO.class);
        clinicalLabEquipmentDTO.setMaterialType(materialType);
        clinicalLabEquipmentDTO = merge(clinicalLabEquipmentDTO, "/clinicalLabEquipment");
        assertThat(clinicalLabEquipmentDTO.getMaterialType()).isEqualTo(materialType);
    }

}
