package com.mvc.dao;


import com.mvc.pojo.SoilWater;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @author dell
 */
public interface SoilMapper {


    /**
     *  查询某一结点的 某一天的数据
     * @param node 结点编号
     * @param times 查询时间（天）： 2019-09-22%
     * @return json数据
     */
    List<SoilWater> selectSoilSet(@Param("node") Integer node, @Param("times") String times);

}
