
var dom = document.getElementById("container");
var myChart = echarts.init(dom);
var app = {};
option = null;
function randomData() {
    now = new Date(+now + oneDay);

    value = value + Math.random() * 21 - 10;
    return {
        name: now.toString(),
        value: [
            [now.getFullYear(), now.getMonth() + 1, now.getDate()].join('/'),
            Math.round(value)
        ]
    }
}

var data = [];
var now = +new Date(1997, 9, 3);
var oneDay = 24 * 3600 * 1000;
var value = Math.random() * 1000;
for (var i = 0; i < 50; i++) {
    data.push(randomData());
}

option = {
    title: {
        text: '土壤水势 动态数据',
        subtext: 'sspu'
    },
    tooltip: {
        trigger: 'axis',
        formatter: function (params) {
            params = params[0];
            var date = new Date(params.name);
            return date.getDate() + '/' + (date.getMonth() + 1) + '/' + date.getFullYear() + ' : ' + params.value[1];
        },
        axisPointer: {
            animation: false
        }
    },
    toolbox: { // 工具栏
        show: true,
        feature: {
            dataZoom: {
                yAxisIndex: 'none'
            },
            dataView: {readOnly: false},
            magicType: {type: ['line', 'bar']},
            restore: {},
            saveAsImage: {}
        }
    },
    legend: {
        data:['结点 1','结点 2']
    },
    dataZoom: [
        {
            show: false,
            start: 0,
            end: 100,
            type: 'inside'
        },
        {
            id: 'dataZoomX',
            type: 'slider',
            xAxisIndex: [0],
            filterMode: 'filter'
        },
        {
            id: 'dataZoomY',
            type: 'slider',
            yAxisIndex: [0],
            filterMode: 'empty'
        }
    ],
    xAxis: {
        type: 'time',
        boundaryGap: true,

    },
    yAxis: {
        type: 'value',
        //boundaryGap: [0, '100%'],
        boundaryGap: [0.2, 0.2],
        scale: true,
        name: '水势',
        //min: 0,
        axisLabel: {
            formatter: '{value} 巴'
        }

    },
    series: [{
        name: '结点 1',
        type: 'line',
        showSymbol: true, // 是否显示 symbol
        hoverAnimation: false,
        symbolSize: 6,   //折线点的大小
        markPoint: {
            data: [
                {type: 'max', name: '最大值'},
                {type: 'min', name: '最小值'}
            ]
        },
        markLine: {
            data: [
                {type: 'average', name: '平均值'}
            ]
        },
        data: data
    }]
};

setInterval(function () {

    data.push(randomData());

    myChart.setOption({
        series: [{
            data: data
        }]
    }, window.onresize = myChart.resize);
}, 2100);;
if (option && typeof option === "object") {
    myChart.setOption(option, true);
}