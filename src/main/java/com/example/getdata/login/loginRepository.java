package com.example.getdata.login;

import com.example.getdata.models.login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface loginRepository extends JpaRepository<login,Integer>{

}
