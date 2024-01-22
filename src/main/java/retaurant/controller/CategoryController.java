package retaurant.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import retaurant.config.ResultMessage;
import retaurant.dto.CategoryDTO;
import retaurant.service.CategoryService;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor

public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/add")
    public ResultMessage<Object> saveCategory(@RequestBody @Valid CategoryDTO dto) {
        return ResultMessage.success(categoryService.saveCategory(dto),
                "Lưu danh mục thành công");
    }
}
