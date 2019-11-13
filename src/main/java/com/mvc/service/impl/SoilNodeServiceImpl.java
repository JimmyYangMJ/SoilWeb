package com.mvc.service.impl;

import com.mvc.common.ServerResponse;
import com.mvc.dao.SoilNodeMapper;
import com.mvc.pojo.SoilNode;
import com.mvc.service.ISoilNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ymj
 * @Date： 2019/11/13 20:21
 */
@Service("iSoilNodeService")
public class SoilNodeServiceImpl implements ISoilNodeService {

    @Autowired
    private SoilNodeMapper soilNodeMapper;

    @Override
    public ServerResponse<List<SoilNode>> selectSoilNodeSet() {

        List<SoilNode> resultCount = soilNodeMapper.selectSoilNodeSet();

        if(resultCount.size() == 0 ){
            return ServerResponse.createByErrorMessage("没有相应记录");
        }
        return ServerResponse.createBySuccess("查询成功", resultCount);
    }
}
