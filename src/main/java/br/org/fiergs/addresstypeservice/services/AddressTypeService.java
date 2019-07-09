package br.org.fiergs.addresstypeservice.services;

import br.org.fiergs.addresstypeservice.entities.AddressType;
import br.org.fiergs.addresstypeservice.repositories.AddressTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressTypeService {

    @Autowired
    private AddressTypeRepository addressTypeRepository;

    public List<AddressType> findAll() {
        return addressTypeRepository.findAll();
    }

    public List<AddressType> findByDescription(String description) {
        Optional<List<AddressType>> optAddressType = addressTypeRepository.findByDescriptionContainingIgnoreCase(description);
        return optAddressType.orElse(new ArrayList<>());
    }

    public AddressType findByCode(String code) {
        Optional<AddressType> optAddressType = addressTypeRepository.findByCode(code);
        return optAddressType.orElse(null);
    }

    public AddressType save(AddressType addressType) {
        Optional<AddressType> optAddressType = addressTypeRepository.findByDescriptionOrCode(addressType.getDescription(), addressType.getCode());
        if (optAddressType.isEmpty()) {
            return addressTypeRepository.save(addressType);
        } else {
            throw new RuntimeException("Tipo de endereço já cadastrado!");
        }
    }

    public AddressType update(AddressType addressType) {
        Optional<AddressType> optAddressType = addressTypeRepository.findOneByDescriptionIgnoreCaseOrCodeAndIdNot(addressType.getDescription(), addressType.getCode(), addressType.getId());
        if (optAddressType.isEmpty()) {
            return addressTypeRepository.save(addressType);
        } else {
            throw new RuntimeException("Tipo de endereço já cadastrado!");
        }
    }

    public void delete(Long id) {
        addressTypeRepository.deleteById(id);
    }
}
