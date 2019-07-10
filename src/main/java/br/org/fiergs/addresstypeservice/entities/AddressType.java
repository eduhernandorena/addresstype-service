package br.org.fiergs.addresstypeservice.entities;

import lombok.*;

import javax.persistence.*;

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

    private String code;

    private String description;
}
