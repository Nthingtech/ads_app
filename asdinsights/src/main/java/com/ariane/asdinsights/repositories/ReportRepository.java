package com.ariane.asdinsights.repositories;

import com.ariane.asdinsights.models.ReportModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReportRepository extends JpaRepository<ReportModel, UUID> {
}
