package com.mvc.controller;

import com.mvc.common.Const;
import com.mvc.common.ServerResponse;
import com.mvc.pojo.SoilNode;
import com.mvc.pojo.SoilTimeList;
import com.mvc.pojo.SoilWater;
import com.mvc.service.ISoilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller("SoilController")
@RequestMapping("/soil")
public class SoilController {

    @Autowired
    private ISoilService iSoilService;

    /**
     * 查询某天的某节点水势信息
     * @param node 结点
     * @param day 日期
     * @param session 会话
     * @return json文件
     */
    @RequestMapping(value = "selectSoilSet.do", method = RequestMethod.GET)
    @ResponseBody // 使得序列化为json
    public ServerResponse<List<SoilWater> > selectSoilSet(Integer node, String day, HttpSession session){
        day = day + "%";
        System.out.println(day);
        ServerResponse<List<SoilWater>> response = iSoilService.selectSoilSet(node, day);

        System.out.println(response);

        if(response.isSuccess()){
            session.setAttribute(Const.CURRENT_USER,response.getData());
        }
        return response;
    }

    @RequestMapping(value = "selectSoilWhichTime.do", method = RequestMethod.GET)
    @ResponseBody // 使得序列化为json
    public ServerResponse<List<SoilTimeList>> selectSoilWhichTime(HttpSession session){

        ServerResponse<List<SoilTimeList>> response = iSoilService.selectSoilWhichTime();

        System.out.println(response);
//        if(response.isSuccess()){
//            session.setAttribute(Const.CURRENT_USER,response.getData());
//        }
        return response;
    }

    @RequestMapping("test.do")
    public String echartsJSP(){
        System.out.println("调用了echartsJSP界面");
        return "test";
    }
}
