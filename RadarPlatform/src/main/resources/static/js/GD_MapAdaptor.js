/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var map = new AMap.Map('container', {
    pitch:75, // 地图俯仰角度，有效范围 0 度- 83 度
    viewMode:'3D' // 地图模式
});
//行车路线规划
//高德地图组件初始化
map.plugin('AMap.DragRoute', function () {
	  // path 是驾车导航的起、途径和终点，最多支持16个途经点
	  var path = []

	  path.push([116.303843, 39.983412])
	  path.push([116.321354, 39.896436])
	  path.push([116.407012, 39.992093])

	  var route = new AMap.DragRoute(map, path, AMap.DrivingPolicy.LEAST_FEE)
	  // 查询导航路径并开启拖拽导航
	  route.search()
	//事件处理--记录路线	
	    AMap.event.addDomListener(document.getElementById('record'), 'click', function() {
	    	console.log(route);	    	
	    	console.log(route.getStart().getPosition());
	    	console.log(route.getStart().getLabel());
	    	console.log(route.getEnd());
	    	console.log(route.getWays());
	    }, false); 
	});

	AMap.plugin([
	    'AMap.ToolBar',
	    'AMap.Scale',
	    'AMap.OverView',
	    'AMap.MapType',
	    'AMap.Geolocation',
	], function(){	    // 在图面添加工具条控件，工具条控件集成了缩放、平移、定位等功能按钮在内的组合控件
	    map.addControl(new AMap.ToolBar());

	    // 在图面添加比例尺控件，展示地图在当前层级和纬度下的比例尺
	    map.addControl(new AMap.Scale());

	    // 在图面添加鹰眼控件，在地图右下角显示地图的缩略图
	    map.addControl(new AMap.OverView({isOpen:true}));
	   
	    // 在图面添加类别切换控件，实现默认图层与卫星图、实施交通图层之间切换的控制
	    map.addControl(new AMap.MapType());
	   
	    // 在图面添加定位控件，用来获取和展示用户主机所在的经纬度位置
	    map.addControl(new AMap.Geolocation());
	});

//行驶轨迹回放功能demo
	/* var postData = {};
	 postData['rsearch'] = rsearch;
	 postData['uid'] = uid;
	 postData['stime'] = stime;
	 postData['etime'] = etime;
	 postData['ajax'] = 1;
	 var url = 'index.php?mod={$mod}&act={$act}&opt={$opt}'; //接口地址

	 $.post(url,postData,function(res){
	     if(res.status == 1){

	         console.log(res);
	         $("#container").show();
	         var lnglatArr = new Array();
	         var i = 0;

	         $.grep(res.data,function(re){
	             lnglatArr[i] = new AMap.LngLat(re.longitude,re.latitude);
	             i = i+1; 
	         })

	         AMap.convertFrom(lnglatArr, 'gps',function(status,result){
	             console.log(result); 

	             var marker, lineArr = [];
	 
	             var map = new AMap.Map("container", {
	                 resizeEnable: true,
	                 center: [result.locations[0].lng, result.locations[0].lat],
	                 zoom: 13
	             });

	             marker = new AMap.Marker({
	                 map: map,
	                 position:[result.locations[0].lng, result.locations[0].lat],
	                 icon: "http://webapi.amap.com/images/car.png",
	                 offset: new AMap.Pixel(-26, -13),
	                 autoRotation: true
	             });
	 
	             $.grep(result.locations,function(r){
	                 console.log(r);
	                 lineArr.push([r.lng, r.lat]);
	             })

	             // 绘制轨迹
	             var polyline = new AMap.Polyline({
	                 map: map,
	                 path: lineArr,
	                 strokeColor: "#00A", //线颜色
	                 //strokeOpacity: 1, //线透明度
	                 strokeWeight: 3, //线宽
	                 //strokeStyle: "solid" //线样式
	             });
	             var passedPolyline = new AMap.Polyline({
	                 map: map,
	                 //path: lineArr,
	                 strokeColor: "#F00", //线颜色
	                 //strokeOpacity: 1, //线透明度
	                 strokeWeight: 3, //线宽
	                 //strokeStyle: "solid" //线样式
	             });
	             $("#move").show();
	             $("#pause").show();
	             $("#resume").show();
	             $("#stop").show();

	             AMapUI.loadUI(['overlay/SimpleInfoWindow'], function(SimpleInfoWindow) {
	                 infoWindow = new SimpleInfoWindow({
	                     infoTitle: '<strong>标题</strong>',
	                     infoBody: '点击开始动画可进行播放',
	                     //基点指向marker的头部位置
	                     offset: new AMap.Pixel(0, -31)
	                 });
	                 infoWindow.open(map, marker.getPosition());
	             })

	             marker.on('click',function(e){
	                 infoWindow.open(map, marker.getPosition());
	             });

	             marker.on('moving',function(e){
	                 var len = e.passedPath.length;
	                 var rate = res.data[len-1].rate;
	                 var location = e.passedPath[len-1];
	                 var lll = new AMap.LngLat(location.lng,location.lat);

	                 infoWindow.setInfoBody('<div>经度：'+location.lng+'<br>纬度：'+location.lat+'<br>速度：'+rate+' km/h</div>');
	                 infoWindow.setPosition(lll);
	                 passedPolyline.setPath(e.passedPath);
	             })
	             map.setFitView();

	             AMap.event.addDomListener(document.getElementById('move'), 'click', function() {
	                 marker.moveAlong(lineArr, 500,function(k){
	                     return k;
	                 });
	             }, false);

	             AMap.event.addDomListener(document.getElementById('pause'), 'click', function() {
	                 marker.pauseMove();
	             }, false);
	             AMap.event.addDomListener(document.getElementById('resume'), 'click', function() {
	                 marker.resumeMove();
	             }, false);
	             AMap.event.addDomListener(document.getElementById('stop'), 'click', function() {
	                 marker.stopMove();
	             }, false); 
	         });
	     }else{
	         $("#container").hide();
	         $("#move").hide();
	         $("#pause").hide();
	         $("#resume").hide();
	         $("#stop").hide();
	         layui.use(['layer'], function(){
	         var layer = layui.layer;
	         layer.msg(res.msg, {icon: 2});});
	     }},'json')*/