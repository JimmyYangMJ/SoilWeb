package com.mvc.dao;


import com.mvc.pojo.Soil;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SoilMapper {
    // 查询某一结点的 某一天的数据
    List<Soil> selectSoilSet(@Param("node") Integer node, @Param("times") String times);

}
