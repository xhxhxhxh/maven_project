package mybatis;

import mybatis.mapper.BrandMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class BrandDemo {
  public static void main(String[] args) throws IOException {
    // 加载核心配置文件
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    // 获取sqlSession对象，执行sql
    SqlSession sqlSession = sqlSessionFactory.openSession();

    // 执行sql
    BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
    List<Brand> brands = mapper.selectAll();
    System.out.println(brands);
    Brand brand = mapper.selectById(1);
    System.out.println(brand);

    List<Brand> brandList = mapper.selectByCondition(1, "%华为%", "%华为%");
    System.out.println("--------");
    System.out.println(brandList);


    Brand brand1 = new Brand();
    brand1.setId(1);
    brand1.setCompanyName("%华为%");
    brand1.setBrandName("%华为%");
    List<Brand> brandList2 = mapper.selectByConditionSingle(brand1);
    System.out.println("--------");
    System.out.println(brandList2);
    // 释放资源
    sqlSession.close();
  }
}
