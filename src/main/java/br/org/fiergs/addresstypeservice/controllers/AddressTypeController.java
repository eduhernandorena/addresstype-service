package br.org.fiergs.addresstypeservice.controllers;

import br.org.fiergs.addresstypeservice.entities.AddressType;
import br.org.fiergs.addresstypeservice.services.AddressTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/addresstype", produces = MediaType.APPLICATION_JSON_VALUE)
public class AddressTypeController {
    @Autowired
    private AddressTypeService addressTypeService;


    @GetMapping
    public List<AddressType> list() {
        return addressTypeService.findAll();
    }

    @GetMapping("/description/{description}")
    public List<AddressType> listByDescription(@PathVariable("description") String description) {
        return addressTypeService.findByDescription(description);
    }

    @GetMapping("/code/{code}")
    public AddressType findByCode(@PathVariable("code") String code) {
        return addressTypeService.findByCode(code);
    }

    @PostMapping
    public AddressType save(@RequestBody @Valid AddressType addressType) {
        return addressTypeService.save(addressType);
    }

    @PutMapping
    public AddressType update(@RequestBody @Valid AddressType addressType) {
        return addressTypeService.update(addressType);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        addressTypeService.delete(id);
    }
}
