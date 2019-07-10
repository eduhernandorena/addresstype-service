package br.org.fiergs.addresstypeservice.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "CAD_ADDRESSTYPE")
@SequenceGenerator(name = "seqCad_AddressType", sequenceName = "SEQCAD_ADDRESSTYPE", allocationSize = 1)
public class AddressType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqCad_AddressType")
    private Long id;

    @NotEmpty(message = "Código é obrigatório!")
    private String code;

    @NotEmpty(message = "Descrição é obrigatória!")
    private String description;
}
