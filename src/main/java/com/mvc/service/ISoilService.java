package com.mvc.service;

import com.mvc.common.ServerResponse;
import com.mvc.pojo.Soil;
import com.mvc.pojo.User;

import java.util.Date;
import java.util.List;

public interface ISoilService {

    /**
     * 查询某结点的水势值和对应的时间
     * @param node  选择的结点
//     * @param day 选择结点的开始时间(天)
     * @return  对应水势数据数组
     */
    ServerResponse<List<Soil>> selectSoilSet(Integer node, String day);
}
