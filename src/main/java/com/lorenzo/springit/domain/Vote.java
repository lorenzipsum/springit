package com.lorenzo.springit.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Vote extends Auditable {
    @Id
    @GeneratedValue
    private Long id;
    private int vote;
}
