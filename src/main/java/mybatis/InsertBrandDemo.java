package mybatis;

import mybatis.mapper.BrandMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class InsertBrandDemo {
  public static void main(String[] args) throws IOException {
    Brand brand = new Brand("小米", "小米集团", 100, "为发烧而生", 1);

    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    // 获取sqlSession对象，执行sql
    SqlSession sqlSession = sqlSessionFactory.openSession();

    // 执行sql
    BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
    mapper.insert(brand);
    Integer id = brand.getId();
    System.out.println("id =" + id);
    // 释放资源
    sqlSession.commit();
    sqlSession.close();
  }
}
