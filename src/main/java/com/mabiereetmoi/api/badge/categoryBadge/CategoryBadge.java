package com.mabiereetmoi.api.badge.categoryBadge;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "category_badge")
public class CategoryBadge {
    @Id
    private String name;
}
