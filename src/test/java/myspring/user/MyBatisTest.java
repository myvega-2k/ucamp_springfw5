package myspring.user;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Consumer;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

import myspring.user.dao.UserDao;
import myspring.user.dao.mapper.UserMapper;
import myspring.user.vo.UserVO;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring_beans.xml")
public class MyBatisTest {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	SqlSessionFactory sqlFactory;
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	UserDao userDao;
	
	@Test
	void userDao() {
		UserVO addUser = new UserVO("spring", "스프링", "여", "Seoul");
		userDao.insert(addUser);		
		
		List<UserVO> userList = userDao.readAll();
		//Iterable의 forEach(Consumer) 
		//Consumer 의 추상메서드 void accept(T t)
		userList.forEach(user -> System.out.println(user));
		System.out.println("Method Reference");
		userList.forEach(System.out::println);
		
	}
	
	@Test
	void userMapper() {
		UserVO user = userMapper.selectUserById("gildong");
		System.out.println(user);
		assertEquals("홍길동", user.getName());		
	}
	
	
	@Test @Disabled
	void sqlSession() {
		System.out.println(sqlFactory.getClass().getName());
		//Unique Key로 Select 하기
		UserVO user = sqlSession.selectOne("userNS.selectUserById", "dooly");
		System.out.println(user);
		assertEquals("둘리", user.getName());
		
	}
	
	
	@Test
	void connection() {
		try {
			Connection connection = dataSource.getConnection();
			DatabaseMetaData metaData = connection.getMetaData();
			System.out.println("DB Url = " + metaData.getURL());
			System.out.println("DB Username = " + metaData.getUserName());
			System.out.println("DB ProductName = " + metaData.getDatabaseProductName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
