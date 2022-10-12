package com.sillycom.pizzer.repository;

import com.sillycom.pizzer.model.RecentlyEated;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecentlyEatedRepository extends JpaRepository<RecentlyEated, String> {
}
