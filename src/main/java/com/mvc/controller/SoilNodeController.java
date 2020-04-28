package com.mvc.controller;

import com.mvc.common.Const;
import com.mvc.common.ServerResponse;
import com.mvc.pojo.SoilNode;
import com.mvc.pojo.SoilNodeLocation;
import com.mvc.service.cloudNio.NioServerWrite;
import com.mvc.service.impl.SoilNodeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

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
     * 向下位机发送消息
     * 接口
     * @param session 会话
     * @return json序列
     */
    @RequestMapping(value = "sendmessage.do", method = RequestMethod.GET)
    @ResponseBody // 使得序列化为json
    public ServerResponse<String> sendmassage(int id, String message,HttpSession session){

        System.out.println("客户机 " + id + " 发送: " + message);

        NioServerWrite.setSendId(id);
        NioServerWrite.setSendMessage(message);
        // todo 发送状态
        return ServerResponse.createBySuccessMessage("发送成功");
    }

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
     * @param lng 经度
     * @param lat 纬度
     * @param session 会话
     * @return  结果集
     */
    @RequestMapping(value = "addSoilNode.do", method = RequestMethod.POST)
    @ResponseBody // 使得序列化为json
    public ServerResponse<String> addSoilNode(int node, double lng, double lat, HttpSession session) {
//        List<SoilNode> list  = new ArrayList<>();
//        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
//        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");// a为am/pm的标记
        Date date = new Date();// 获取当前时间

        SoilNode soilNode = new SoilNode(node, "00", 0, lng, lat, date);

        System.out.println(soilNode); // 存入数据库
        return soilNodeService.insertSoilNode(soilNode);
    }

    /**
     * 更新一个结点的位置信息
     * @param node 结点号
     * @param lng 经度
     * @param lat 纬度
     * @param session
     * @return
     */
    @RequestMapping(value = "updateSoilNodeLocation.do" , method = RequestMethod.GET)
//  Todo  @PutMapping(value = "updateSoilNodeLocation.do")
    @ResponseBody // 使得序列化为json
    public ServerResponse<String> updateSoilNodeLocation(int node, @RequestParam(required = false) Double lng, @RequestParam(required = false)  Double lat, HttpSession session) {

        if(lng == null){
            System.out.println("移除此节点");
        }
        System.out.println(node + ": " + lng + ": " + lat); // update数据库
        return soilNodeService.updateSoilNodeLocation(node, lng, lat);
    }



    /**
     * 删除指定结点
     * @param node 结点号
     * @param session
     * @return
     */
    @RequestMapping(value = "deleteSoilNode.do", method = RequestMethod.DELETE)
    @ResponseBody // 使得序列化为json
    public ServerResponse<String> deleteSoilNode(int node, HttpSession session) {
        System.out.println("要删除的结点： " + node); // update数据库
        return soilNodeService.deleterSoilNode(node);
    }


    /**
     * 1.查询所有结点 位置
     * 接口
     * @param session 会话
     * @return json序列
     */
    @RequestMapping(value = "SoilNodeLocation.do", method = RequestMethod.GET)
    @ResponseBody // 使得序列化为json
    public ServerResponse<List<SoilNodeLocation>> selectSoilNodeLocation(HttpSession session){

        // todo 管理员验证

        ServerResponse<List<SoilNodeLocation>> response = soilNodeService.selectSoilNodeLocationSet();

        System.out.println(response);

        return response;
    }



}
