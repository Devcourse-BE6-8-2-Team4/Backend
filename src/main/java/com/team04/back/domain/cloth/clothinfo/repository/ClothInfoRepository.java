package com.team04.back.domain.cloth.clothinfo.repository;

import com.team04.back.domain.cloth.clothinfo.entity.ClothInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothInfoRepository extends JpaRepository<ClothInfo, Integer> {
}
