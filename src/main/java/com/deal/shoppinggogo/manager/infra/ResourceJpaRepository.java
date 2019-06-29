package com.deal.shoppinggogo.manager.infra;

import com.deal.shoppinggogo.manager.domain.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceJpaRepository extends JpaRepository<Resource, Integer> {
}
