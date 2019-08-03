package com.num6pj.molamola.manager.infra;

import com.num6pj.molamola.manager.domain.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceJpaRepository extends JpaRepository<Resource, Integer> {
}
