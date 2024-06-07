package mybatis;

import mybatis.mapper.BrandMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class DeleteBrandDemo {
  public static void main(String[] args) throws IOException {

    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    // 获取sqlSession对象，执行sql
    SqlSession sqlSession = sqlSessionFactory.openSession();

    // 执行sql
    BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
//    mapper.delete(6);
    int[] ids = {3, 5};
    mapper.deleteByIds(ids);
    // 释放资源
    sqlSession.commit();
    sqlSession.close();
  }
}
