package com.mabiereetmoi.api.badge;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BadgeRepository extends CrudRepository<Badge,Long> {
    Badge findByNameEquals(String name);
    List<Badge> findAll();
}
