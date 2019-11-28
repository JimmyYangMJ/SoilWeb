package com.mvc.dao;

import com.mvc.pojo.SoilNode;
import com.mvc.pojo.SoilWater;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ymj
 * @Date： 2019/11/13 20:24
 */
public interface SoilNodeMapper {

    /**
     * 查询结点的 详细信息
     * @return 结点信息表
     */
    List<SoilNode> selectSoilNodeSet();

    /**
     * 增加一个结点
     * @param soilNode 结点
     * @return
     */
    int insertSoilNode(SoilNode soilNode);


    /**
     * 修改结点 位置信息
     * @param node 结点号
     * @param location 位置信息
     * @return
     */
    int updateSoilNodeLocation(@Param("node") int node, @Param("location") String location);

    /**
     * 删除一个结点
     * @param node
     * @return
     */
    int deleteSoilNode(@Param("node") int node);
}
