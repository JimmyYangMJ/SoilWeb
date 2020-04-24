function getJson() {
    var json = {
        "status": 0,
        "msg": "查询成功",
        "data": [
            {
                "node": 1,
                "lng": 121.657843,
                "lat": 31.268527
            },
            {
                "node": 2,
                "lng": 121.657771,
                "lat": 31.267902
            }
        ]
    }
    return json;
}

function removePoint(map, marker) {
    // 删除节点
    var removeMarker = function(e,ee,marker){
        map.removeOverlay(marker);
    }
    //创建右键菜单
    var markerMenu=new BMap.ContextMenu();
    markerMenu.addItem(new BMap.MenuItem('删除此节点',removeMarker.bind(marker)))
    marker.addContextMenu(markerMenu);
    alert("删除成功");
}

// 添加节点
function addPoint(map, lng, lat, massage) {
    alert("添加成功");
    var point = new BMap.Point(lng, lat);
    var marker = new BMap.Marker(point);  // 创建标注
    map.addOverlay(marker);               // 将标注添加到地图中
    // marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
    var label = new BMap.Label(massage, {offset:new BMap.Size(20,-10)});
    marker.setLabel(label);

    // 覆盖物添加*******
    var removeMarker = function(e,ee,marker){
        map.removeOverlay(marker);
    }
    //创建右键菜单
    var markerMenu=new BMap.ContextMenu();
    markerMenu.addItem(new BMap.MenuItem('删除',removeMarker.bind(marker)));
    //
    marker.addContextMenu(markerMenu);
    //***************

}

//右键事件--添加节点
function clickR1(map) {
    //单击获取点击的经纬度
    alert("添加节点:" + rightclickPoint.lng);
    $('#exampleModal').modal('show');

    if (isMarker){
        alert("此处已有节点");
    }else {
        addPoint(map, rightclickPoint.lng, rightclickPoint.lat, massage);
    }

}
//右键事件--删除节点
function clickR2(map) {
    alert("删除节点：" + isMarker);
    //单击获取点击的经纬度
    if (isMarker){
        removePoint(map, isMarker);
    }else {
        alert("此处没有节点不能删除");
    }
}

var massage = "节点 ";
var rightclickPoint;
var isMarker;
// 初始化
// 百度地图API功能
var map = new BMap.Map("allmap");
map.enableAutoResize(); //设置当地图容器发生改变时地图自动适应
var point = new BMap.Point(121.657843,31.268527);
var point2 = new BMap.Point(121.657771,31.267902);
map.centerAndZoom(point, 15);  // 设置中心点 缩放级别为15     //map.setZoom(14);
map.enableScrollWheelZoom(true);

/// 地图添加右键菜单
map.addEventListener("rightclick", function(e){
    rightclickPoint = {lng:e.point.lng,lat:e.point.lat};
    isMarker = e.overlay;
});

var menu = new BMap.ContextMenu();
var txtMenuItem = [
    {
        text:'添加节点',
        callback:function(){clickR1(map);}
    },
    {
        text:'删除节点',
        callback:function(){clickR2(map);}
    }
];
for(var i=0; i < txtMenuItem.length; i++){
    menu.addItem(new BMap.MenuItem(txtMenuItem[i].text,txtMenuItem[i].callback,100));
}
map.addContextMenu(menu);

////
var marker = new BMap.Marker(point);  // 创建标注
map.addOverlay(marker);               // 将标注添加到地图中
//marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
var label = new BMap.Label("结点1",{offset:new BMap.Size(20,-10)});
marker.setLabel(label);

// 覆盖物添加******* 将覆盖物定义为可删除
var removeMarker = function(e,ee,marker){
    map.removeOverlay(marker);
}
//创建右键菜单
var markerMenu=new BMap.ContextMenu();
markerMenu.addItem(new BMap.MenuItem('删除',removeMarker.bind(marker)));
//
marker.addContextMenu(markerMenu);
//***************

//////
var marker2 = new BMap.Marker(point2);
map.addOverlay(marker2);
marker2.setAnimation(BMAP_ANIMATION_BOUNCE);
var label = new BMap.Label("结点2",{offset:new BMap.Size(20,-10)});
marker2.setLabel(label);

