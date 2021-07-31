package com.labforward.project.web.rest;

import com.labforward.project.domain.CategoryEntity;
import com.labforward.project.service.CategoryService;
import com.labforward.project.web.dto.CategoryDTO;
import com.labforward.project.web.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * @author Ali Karimizandi
 * @since 2021
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final CategoryMapper mapper;

    private final CategoryService service;

    @GetMapping(value = "/findById")
    public CategoryDTO findById(@RequestParam Long id) throws Exception {
        log.info("Find by id");
        Optional<CategoryEntity> optional = service.findById(id);
        if (optional.isPresent()) {
            return mapper.toDTO(optional.get());
        }
        return null;
    }

    @PostMapping(value = "/persist")
    public Long persist(final @RequestBody @Valid CategoryDTO dto) {
        log.info("Persist");
        CategoryEntity entity = mapper.toEntity(dto);
        service.save(entity);
        return entity.getId();
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(final @PathVariable(value = "id") Long id) {
        log.info("Delete by id");
        service.deleteById(id);
    }



    /*
    @GetMapping(value = "/findAll")
    public List<CategoryDTO> findAll(@PathVariable("page") int page, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        log.info("Getting widget details from the database.");
        List<CategoryEntity> result = service.findAll();
        if
        return result.getContent();
    }

    @PostMapping(value = "/persist")
    public WidgetEntity persist(final @RequestBody @Valid WidgetEntity entity) {
        log.info("Saving widget details in the database.");
        return service.persist(entity);
    }

    @PutMapping(value = "/merge")
    public void merge(final @RequestBody @Valid WidgetEntity entity) {
        log.info("Merging widget details in the database.");
        service.merge(entity);
    }




    @DeleteMapping(value = "/removeAll")
    public void removeAll() {
        log.info("Deleting all widget details from the database.");
        service.removeAll();
    }

    @PostMapping(value = "/findInRegion")
    public List<WidgetEntity> findInRegion(@RequestBody @Valid WidgetEntity region) {
        log.info("Getting widget details from the database in the requested region.");
        return service.findInRegion(region);
    }

     */

}
