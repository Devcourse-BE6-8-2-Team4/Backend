package com.team04.back.domain.clothespost.clothespost.repository;

import com.team04.back.domain.clothespost.clothespost.entity.ClothesPostInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothesPostRepository extends JpaRepository<ClothesPostInfo, Integer> {

}
