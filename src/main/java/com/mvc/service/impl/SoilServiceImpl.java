package com.mvc.service.impl;

import com.mvc.common.ServerResponse;
import com.mvc.dao.SoilMapper;
import com.mvc.pojo.Soil;
import com.mvc.pojo.User;
import com.mvc.service.ISoilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("iSoilService")
public class SoilServiceImpl implements ISoilService {

    @Autowired
    private SoilMapper soilMapper;

    @Override
    public ServerResponse<List<Soil>> selectSoilSet(Integer node, String day) {
        System.out.println("node: " + node );

        List<Soil> resultCount = soilMapper.selectSoilSet(node, day);

        System.out.println( resultCount.size());

        if(resultCount.size() == 0 ){
            return ServerResponse.createByErrorMessage("没有相应记录");
        }

        return ServerResponse.createBySuccess("查询成功", resultCount);
    }
}
