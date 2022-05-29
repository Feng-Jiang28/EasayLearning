package com.FJ28.easylearning;

import com.FJ28.easylearning.entity.User;
import com.FJ28.easylearning.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
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

	//insert test
	@Test
	public void add(){
		User user = new User();
		// id is created by pm using snowflake algorithm;
		// There are three ways to generate a id
		// auto increment;
		// uuid and snowflake;
		user.setName("Lee");
		user.setAge(18);
		int result = userMapper.insert(user);
		System.out.println("Row affected: " +  result);
	}

	// update test
	@Test
	public void update(){
		User user = new User();
		user.setId(1L);
		user.setName("Bob");
		int result = userMapper.updateById(user);
		System.out.println("Row affected: " +  result);
	}

	@Test
	public void testOptimisticLocker(){
		User user = userMapper.selectById(1530863919298510850L);
		user.setName("Helen Yao");
		user.setEmail("123@qq.com");
		// version will be updated to old version + 1;

		userMapper.updateById(user);
	}

	@Test //this one should fail
	public void testOptimiticLocker2(){
		User user = userMapper.selectById(1530863919298510850L);
		user.setName("Helen Yao");
		user.setEmail("123@qq.com");

		// failed because of a wrong version
		user.setVersion(user.getVersion() - 1);

		int result = userMapper.updateById(user);
		System.out.println("update fail or not:" + result);
	}

	// multiple ids search
	@Test
	public void testSelectDemo1(){
		List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
		users.forEach(System.out::println);
	}


	@Test
	public void testPage() {
		// 1. create page object
		// two arguments currentPage and records in each page.
		Page<User> page = new Page<>(1, 3);
		// page data will go into page object
		userMapper.selectPage(page, null);

		// get the data thru page object
		System.out.println(page.getCurrent()); // current page
		System.out.println(page.getRecords()); // list of the page
		System.out.println(page.getSize());
		System.out.println(page.getPages()); // total pages
		System.out.println(page.hasNext());
		System.out.println(page.hasPrevious());
	}

}
