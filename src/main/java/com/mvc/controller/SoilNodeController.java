package com.mvc.controller;

import com.mvc.common.Const;
import com.mvc.common.ServerResponse;
import com.mvc.pojo.SoilNode;
import com.mvc.service.impl.SoilNodeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author ymj
 * @Date： 2019/11/13 20:35
 */
@Controller("SoilNodeController")
@RequestMapping("/soilNode")
public class SoilNodeController {

    @Autowired
    private SoilNodeServiceImpl soilNodeService;

    @RequestMapping(value = "selectSoilNodeSet.do", method = RequestMethod.GET)
    @ResponseBody // 使得序列化为json
    public ServerResponse<List<SoilNode>> select(HttpSession session){

        ServerResponse<List<SoilNode>> response = soilNodeService.selectSoilNodeSet();

        System.out.println(response);
//        if(response.isSuccess()){
//            session.setAttribute(Const.CURRENT_USER,response.getData());
//        }
        return response;
    }
}
