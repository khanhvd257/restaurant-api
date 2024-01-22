package retaurant.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import retaurant.dto.CategoryDTO;
import retaurant.entity.Category;
import retaurant.repository.CategoryRepository;
import retaurant.service.CategoryService;

@Service
@RequiredArgsConstructor
public class ICategoryService implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;


    @Override
    @Transactional
    public Category saveCategory(CategoryDTO dto) {
        Category category = modelMapper.map(dto, Category.class);
        return categoryRepository.save(category);
    }
}
