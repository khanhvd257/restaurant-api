package retaurant.service;

import retaurant.dto.CategoryDTO;
import retaurant.entity.Category;

public interface CategoryService {
    Category saveCategory(CategoryDTO categoryDTO);
}
