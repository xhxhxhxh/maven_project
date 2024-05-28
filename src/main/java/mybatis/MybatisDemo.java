package mybatis;

import mybatis.mapper.StuMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisDemo {
  public static void main(String[] args) throws IOException {
    // 加载核心配置文件
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    // 获取sqlSession对象，执行sql
    SqlSession sqlSession = sqlSessionFactory.openSession();

    // 执行sql
    // List<Student> students = sqlSession.selectList("test.selectAll");
    StuMapper mapper = sqlSession.getMapper(StuMapper.class);
    List<Student> students = mapper.selectAll();
    System.out.println(students);
    // 释放资源
    sqlSession.close();
  }
}
