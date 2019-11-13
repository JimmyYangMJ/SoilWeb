package com.mvc.service;

import com.mvc.common.ServerResponse;
import com.mvc.pojo.SoilWater;

import java.util.List;

public interface ISoilService {

    /**
     * 查询某结点对应的时间的水势值
     * @param node  选择的结点
//     * @param day 选择结点的开始时间(天)
     * @return  对应水势数据数组
     */
    ServerResponse<List<SoilWater>> selectSoilSet(Integer node, String day);

    /**
     * 查询有多少结点
     * @return  结点号
     */

    /**
     * 查询哪几天有数据
     * @return  天
     */
}
