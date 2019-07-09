package br.org.fiergs.addresstypeservice.repositories;

import br.org.fiergs.addresstypeservice.entities.AddressType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AddressTypeRepository extends JpaRepository<AddressType, Long> {

    Optional<List<AddressType>> findByDescriptionContainingIgnoreCase(String description);

    Optional<AddressType> findByCode(String code);

    Optional<AddressType> findByDescriptionOrCode(String description, String code);

    @Query("select o from AddressType o where (upper(description) = upper(?1) or code = ?2) and id <> ?3")
    Optional<AddressType> findOneByDescriptionIgnoreCaseOrCodeAndIdNot(String description, String code, Long id);

    void deleteById(Long id);
}
