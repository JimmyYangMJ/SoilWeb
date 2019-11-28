package com.mvc.controller;

import com.mvc.common.Const;
import com.mvc.common.ServerResponse;
import com.mvc.pojo.SoilNode;
import com.mvc.service.impl.SoilNodeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.spi.ServiceRegistry;
import javax.servlet.http.HttpSession;
import javax.xml.soap.Node;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    /**
     * 1.查询所有结点信息
     * 接口
     * @param session 会话
     * @return json序列
     */
    @RequestMapping(value = "selectSoilNodeSet.do", method = RequestMethod.GET)
    @ResponseBody // 使得序列化为json
    public ServerResponse<List<SoilNode>> selectSoilNodeSet(HttpSession session){

        ServerResponse<List<SoilNode>> response = soilNodeService.selectSoilNodeSet();

        System.out.println(response);
//        if(response.isSuccess()){
//            session.setAttribute(Const.CURRENT_USER,response.getData());
//        }
        return response;
    }


    /**
     * 增加一个结点
     * @param node  结点号
     * @param location 结点位置
     * @param session 会话
     * @return  结果集
     */
    @RequestMapping(value = "addSoilNode.do", method = RequestMethod.POST)
    @ResponseBody // 使得序列化为json
    public ServerResponse<String> addSoilNode(int node, String location, HttpSession session) {
        List<SoilNode> list  = new ArrayList<>();
//        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
//        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");// a为am/pm的标记
        Date date = new Date();// 获取当前时间

        SoilNode soilNode = new SoilNode(node, "00", 0, location, date);

        System.out.println(soilNode); // 存入数据库
        return soilNodeService.insertSoilNode(soilNode);


    }
}
