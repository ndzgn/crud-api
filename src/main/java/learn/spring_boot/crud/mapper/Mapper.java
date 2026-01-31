package learn.spring_boot.crud.mapper;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public interface Mapper<E,D> {

    /**
     * Map DTO to his Entity
     * @param dto the DTO
     * @return E entity
     * */
    E toEntity(D dto);

    /**
     * Map Entity to his DTO
     * @param e the Entity
     * @return D dto
     * */
    D toDTO(E e);

    /**
     * Map a list of DTO into a list of Entities
     * @param dtoList the DTO list
     * @return List<E> entities list
     * */
     default List<E> toEntityList(List<D> dtoList){
         return dtoList.stream()
                 .map(this::toEntity)
                 .collect(Collectors.toList());
     }

     /**
      * Map a list of entities into a list of DTO
      * @param entitiesList the entities list
      * @return List<D> dto list
      * */
     default List<D> toDTOList(List<E> entitiesList)
     {
         return entitiesList.stream()
                 .map(this::toDTO)
                 .collect(Collectors.toList());
     }
}
