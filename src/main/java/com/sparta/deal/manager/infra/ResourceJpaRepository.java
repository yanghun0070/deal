package com.sparta.deal.manager.infra;

import com.sparta.deal.manager.domain.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceJpaRepository extends JpaRepository<Resource, Integer> {
}
