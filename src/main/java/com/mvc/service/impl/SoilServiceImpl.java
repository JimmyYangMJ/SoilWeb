package com.mvc.service.impl;

import com.mvc.common.ServerResponse;
import com.mvc.dao.SoilMapper;
import com.mvc.pojo.SoilTimeList;
import com.mvc.pojo.SoilWater;
import com.mvc.service.ISoilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iSoilService")
public class SoilServiceImpl implements ISoilService {

    @Autowired
    private SoilMapper soilMapper;

    @Override
    public ServerResponse<List<SoilWater>> selectSoilSet(Integer node, String day) {
        System.out.println("node: " + node );

        List<SoilWater> resultCount = soilMapper.selectSoilSet(node, day);

        System.out.println( resultCount.size());

        if(resultCount.size() == 0 ){
            return ServerResponse.createByErrorMessage("没有相应记录");
        }

        return ServerResponse.createBySuccess("查询成功", resultCount);
    }

    @Override
    public ServerResponse<List<SoilTimeList>> selectSoilWhichTime() {

        List<SoilTimeList> resultCount = soilMapper.selectSoilWhichTime();

        if(resultCount.size() == 0 ){
            return ServerResponse.createByErrorMessage("没有相应记录");
        }

        return ServerResponse.createBySuccess("查询成功", resultCount);
    }
}
