package mybatis;

import mybatis.mapper.BrandMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class UpdateBrand {
  public static void main(String[] args) throws IOException {
//    Brand brand = new Brand("oppo", "oppo", 50, "无", 1);
    Brand brand2 = new Brand();
    brand2.setBrandName("vivo");

    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    // 获取sqlSession对象，执行sql
    SqlSession sqlSession = sqlSessionFactory.openSession();

    // 执行sql
    BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
    brand2.setId(5);
    int count = mapper.update(brand2);
    System.out.println("count =" + count);
    // 释放资源
    sqlSession.commit();
    sqlSession.close();
  }
}
