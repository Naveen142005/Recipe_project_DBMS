package com.example.getdata.userdatas;

import com.example.getdata.models.recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userdataRepository extends JpaRepository<recipe,Integer> {

}
