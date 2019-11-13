require.config({
    paths: {
        echarts: 'http://echarts.baidu.com/build/dist'
    }
});
var course;
nodeForm = 1;
dayForm = "2019-09-22";
$.ajax(
    {	//使用JQuery内置的Ajax方法
        type : "post",		//post请求方式
        async : true,		//异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url : "soil/selectSoilSet.do",	//请求发送到ShowInfoIndexServlet处
        data : {node:nodeForm,day:dayForm},		//请求内包含一个key为name，value为A0001的参数；服务器接收到客户端请求时通过request.getParameter方法获取该参数值
        dataType : "json",		//返回数据形式为json
        success : function(result) {


            course = result;
            var status = course.status;

            if(status == 1){  //  没有相应记录
                alert("没有相应记录")
            }
            var node = course.data;
            var nodeTime = new Array();
            var nodeHumidity = new Array();
            for (var i = 0; i < node.length; i++) {
                nodeTime[i] = node[i].times;
                nodeHumidity[i] = node[i].humidity;
            }

// 使用
            require(
                [
                    'echarts',
                    'echarts/chart/line' ,// 使用柱状图就加载bar模块，按需加载
                    'echarts/chart/bar'
                ],
                function (ec) {
                    // 基于准备好的dom，初始化echarts图表
                    var myChart = ec.init(document.getElementById('echart1'));

                    option = {
                        title : {
                            text: '土壤水势',
                            subtext: '虚构'
                        },
                        tooltip : {
                            trigger: 'axis'
                        },
                        legend: {
                            data:['节点一','节点二']
                        },
                        toolbox: {
                            show : true,
                            feature : {
                                mark : {show: true},
                                dataView : {show: true, readOnly: false},
                                magicType : {show: true, type: ['line', 'bar']},
                                restore : {show: true},
                                saveAsImage : {show: true}
                            }
                        },
                        calculable : true,
                        xAxis : [
                            {
                                type : 'category',
                                boundaryGap : false,
                                data: nodeTime
                                // data : ['00：00','1：00','2：00','3：00','4：00','5：00','6：00','7:00','8:00',
                                //     '9：00','10：00','11：00','12：00','13：00','14：00','15：00','16:00','17:00'
                                // ,'18:00', '19：00','20：00','21：00','22：00','23:00']
                            }
                        ],
                        yAxis : [
                            {
                                type : 'value',
                                axisLabel : {
                                    formatter: '{value} pa'
                                }
                            }
                        ],
                        series : [
                            {
                                name:'节点一',
                                type:'line',
                                data:nodeHumidity,
                                // data:[11, 50, 15, 13, 12, 13, 10,9],
                                markPoint : {
                                    data : [
                                        {type : 'max', name: '最大值'},
                                        {type : 'min', name: '最小值'}
                                    ]
                                },
                                markLine : {
                                    data : [
                                        {type : 'average', name: '平均值'}
                                    ]
                                }
                            },
                            {
                                name:'节点二',
                                type:'line',
                                data:[1, -2, 2, 5, 3, 2, 0,4],
                                markPoint : {
                                    data : [
                                        {name : '周最低', value : -2, xAxis: 1, yAxis: -1.5}
                                    ]
                                },
                                markLine : {
                                    data : [
                                        {type : 'average', name : '平均值'}
                                    ]
                                }
                            }
                        ]
                    };

                    // 为echarts对象加载数据
                    myChart.setOption(option);
                }
            );
        },
        error : function(errorMsg) {
            //请求失败时执行该函数
            alert("图表请求数据失败，可能是服务器开小差了");
        }
})