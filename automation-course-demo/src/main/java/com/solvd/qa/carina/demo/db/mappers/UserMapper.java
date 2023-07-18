package com.solvd.qa.carina.demo.db.mappers;

import com.solvd.qa.carina.demo.db.models.User;

public interface UserMapper {

	void create(User user);

	User findById(long id);

	User findByUserName(String username);

	void update(User user);

	void delete(User user);
}
