package com.FJ28.easylearning;

import com.FJ28.easylearning.entity.User;
import com.FJ28.easylearning.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class EasyLearningApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void findAll() {
		List<User> users = userMapper.selectList(null);
		System.out.println(users);
	}

}
