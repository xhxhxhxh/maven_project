package mybatis.mapper;

import mybatis.Student;

import java.util.List;

public interface StuMapper {
  List<Student> selectAll();
}
