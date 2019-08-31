package com.sea.tianmao.dao;

import com.sea.tianmao.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer> {
}
