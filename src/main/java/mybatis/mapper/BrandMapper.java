package mybatis.mapper;

import mybatis.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
  List<Brand> selectAll();
  Brand selectById(int id);
  List<Brand> selectByCondition(Brand brand);
  List<Brand> selectByCondition(Map map);
  List<Brand> selectByCondition(@Param("status")int status, @Param("companyName")String companyName, @Param("brandName")String brandName);
  List<Brand> selectByConditionSingle(Brand brand);
}
