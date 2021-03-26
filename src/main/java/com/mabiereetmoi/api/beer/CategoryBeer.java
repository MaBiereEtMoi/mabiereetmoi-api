package com.mabiereetmoi.api.beer;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "category_beer")
public class CategoryBeer {
    @Id
    private Long id_category;

    private String name;
}
