package com.mabiereetmoi.api.badge;

import com.mabiereetmoi.api.badge.categoryBadge.CategoryBadge;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Badge {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    private CategoryBadge category;

    private String description;

    private String image;

    private String imageGrey;

}
