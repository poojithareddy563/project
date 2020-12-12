package com.cg.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.crud.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{

}
