package com.mvc.service;

import com.mvc.common.ServerResponse;
import com.mvc.pojo.SoilNode;

import java.util.List;

/**
 * 查询结点信息
 * @author ymj
 * @Date： 2019/11/13 20:18
 */
public interface ISoilNodeService {

    /**
     * 查询结点相关的所有信息
     * @return 结点相关信息 List
     */
    ServerResponse<List<SoilNode>> selectSoilNodeSet();


    /**
     * 增加一个结点
     * @param soilNode 结点
     * @return
     */
    ServerResponse<String> insertSoilNode(SoilNode soilNode);

    // Todo 修改结点位置信息

    // Todo 删除一个结点（结点号）

}
