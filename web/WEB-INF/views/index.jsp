<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2016/12/13
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!--The viewport meta tag is used to improve the presentation and behavior of the samples
on iOS devices-->
    <meta name="viewport" content="initial-scale=1, maximum-scale=1,user-scalable=no" />
    <title>重金属系统</title>
    <style>
        html,
        body ,#main{
            height: 100%;
            width: 100%;
            margin: 0%;
            padding: 0;
        }

        #HomeButton {
            position: absolute;
            top: 195px;
            left: 20px;
            z-index: 50;
        }

        #BasemapToggle {
            position: absolute;
            top: 100px;
            right: 20px;
            z-index: 50;
        }
        .lat
        {
            position: absolute;
            bottom: 0px;
            font-size:smaller;

        }
        .esriLargeSliderVertical {
            height: 100px;
        }

        .esriLargeSliderTR {
            right: 10px;
            top: 100px;
        }

        #BasemapToggle {
            position: absolute;
            top: 90px;
            right: 20px;
            z-index: 50;
        }
        #info {
            width: 14.0625em;

            color: #FF0000;
            position: absolute;
            left: 0;
            bottom: 40px;
            padding-left: 10px;
            padding-top: 10px;
            font-family: Arial, "Helvetica Neue", Helvetica, sans-serif;
            border-top: 2px solid #ffffff;
            border-right: 2px solid #ffffff;
            border-top-right-radius: 20px;
        }
        .esri-feature-table {
            font-family: verdana;
            font-size: 2px;
            height: 20%;
            width: 20%;
        }
    </style>
    <script>
        var dojoConfig = {

            packages: [{
                "name": "mywidget",
                "location": "${pageContext.request.contextPath}/js/mywidget"
            }]
        };

        function createXMLHttpRequest() {//首先要创建一个XMLHttpRequest的对象，可以向后台请求
            //根据浏览器类别,取XMLHttpRequest对象
            if (window.ActiveXObject) {//IE
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
            else if (window.XMLHttpRequest) {//Mozila...
                xmlHttp = new XMLHttpRequest搜索();
            }
        }

        function click() {//你的按钮事件
            alert("ddddddddddddddd");
            //创建ajax对象
            createXMLHttpRequest();
            //设置状态监测
            xmlHttp.onreadystatechange = handleStateChange;
            //设置url
            var url = "test.jsp";//这里写你的后台的Servlet的URL

            xmlHttp.open("GET", url, true);
            xmlHttp.send(null);
        }
        function handleStateChange() {
            if(xmlHttp.readyState == 4) {
                if(xmlHttp.status == 200) {
                    var xmldoc = xmlHttp.responseXML;
                    //这里写提交成功后，获取后台的数据，然后处理
                }if(xmlHttp.status==404){
                    alert("404未找到");
                }
            }
        }
    </script>
    <link rel="stylesheet" href="http://210.42.41.246:50002/arcgis_js_api/library/3.17/3.17/dijit/themes/claro/claro.css" />

    <link rel="stylesheet" type="text/css" href="http://210.42.41.246:50002/arcgis_js_api/library/3.17/3.17/dijit/themes/tundra/tundra.css" />
    <link rel="stylesheet" type="text/css" href="http://210.42.41.246:50002/arcgis_js_api/library/3.17/3.17/esri/css/esri.css" />
    <script type="text/javascript" src="http://210.42.41.246:50002/arcgis_js_api/library/3.17/3.17/init.js"></script>
    <link rel="stylesheet" href="js/mywidget/widgets/themes/darkangel/darkangel.css" />
    <link rel="stylesheet" href="js/mywidget/widgets/themes/darkangel/override.css" />


    <script>
        function getStyle() {

            if(window.top == window.self) {

                document.getElementById("top").style.display = 'block';

            } else {

                document.getElementById("top").style.display = 'none';

            }

        }
    </script>
    <script type="text/javascript" src="script/zDrag.js"></script>
    <script type="text/javascript" src="script/zDialog.js"></script>
    <script type="text/javascript" src="script/innerHTML.js"></script>
    <script type="text/javascript" src="script/Encryption.js"></script>
<script type="text/javascript" src="script/PointPolution.js"></script>
    <script type="text/javascript">
        dojo.require("esri.map");
        dojo.require("esri.tasks.query");
        dojo.require("esri.dijit.BasemapToggle");

        var map, queryTask, query;
        var symbol, infoTemplate;

        function init() {
            map = new esri.Map("mapDiv", {

                spatialReference: 102113,
                center: [112.963, 27.868],
                zoom: 10,
                sliderPosition: "bottom-left",
                sliderStyle: "large"
            });
            //卫星图切换

            //create and add new layer
            var layer = new esri.layers.ArcGISDynamicMapServiceLayer("http://210.42.41.246:6080/arcgis/rest/services/xiangtan_image_wgs84_clip2/MapServer", {
                id: "湘潭影像图"
            });
            map.addLayer(layer);
            var boundary = new esri.layers.ArcGISDynamicMapServiceLayer("http://210.42.41.246:6080/arcgis/rest/services/xiangtan_map_wgs84/MapServer", {
                id: "湘潭行政区划",
                visible: true
            });
            // map.addLayers([basemap,boundary]);
            map.addLayer(boundary);
            //Listen for click event on the map, when the user clicks on the map call executeQueryTask function.
            var point = new esri.layers.ArcGISDynamicMapServiceLayer("http://210.42.41.246:6080/arcgis/rest/services/samples_xt_wgs84/MapServer", {
                id: "采样点"
            });

            //	map.addLayer(point);
            map.on("mouse-move", addPoint);
            var screen_x,screen_y;
            function addPoint(evt) {
                var latitude = evt.mapPoint.getLatitude();
                var longitude = evt.mapPoint.getLongitude();
                // map.infoWindow.setTitle("Coordinates");
                /* map.infoWindow.setContent(
                 "lat/lon : " + latitude.toFixed(2) + ", " + longitude.toFixed(2) +
                 "<br>screen x/y : " + evt.screenPoint.x + ", " + evt.screenPoint.y
                 );*/
                screen_x= evt.screenPoint.x;
                screen_y=evt.screenPoint.y;

                lat.innerHTML = "X,Y=(" + latitude + ", " + longitude + ")";
                //  map.infoWindow.show(evt.mapPoint, map.getInfoWindowAnchor(evt.screenPoint));
            }
            var lat = document.getElementById("latlong");

            //  dojo.connect(map, "onClick", executeQueryTask);
            //    map.on("click", executeQueryTask);

            //build query task
            queryTask = new esri.tasks.QueryTask("http://210.42.41.246:6080/arcgis/rest/services/xiangtan_map_wgs84/MapServer/0");

            //Can listen for onComplete event to process results or can use the callback option in the queryTask.execute method.
            //dojo.connect(queryTask, "onComplete", showResults);

            //build query filter
            query = new esri.tasks.Query();
            query.returnGeometry = true;
            query.outFields = ["FIRST_xingzheng", "FIRST_quhua", "area_code"];

            //create the infoTemplate to be used in the infoWindow.
            //All ${attributeName} will be substituted with the attribute value for current feature.
            infoTemplate = new esri.InfoTemplate("${FIRST_xingzheng}", "名称: ${FIRST_xingzheng}<br />code: ${FIRST_quhua}<br />area_code: ${area_code}");

            symbol = new esri.symbol.SimpleFillSymbol(esri.symbol.SimpleFillSymbol.STYLE_SOLID, new esri.symbol.SimpleLineSymbol(esri.symbol.SimpleLineSymbol.STYLE_DASHDOT, new dojo.Color([255, 0, 0]), 2), new dojo.Color([255, 255, 0, 0.5]));

        }

        function executeQueryTask(evt) {
            //onClick event returns the evt point where the user clicked on the map.
            //This is contains the mapPoint (esri.geometry.point) and the screenPoint (pixel xy where the user clicked).
            //set query geometry = to evt.mapPoint Geometry
            query.geometry = evt.mapPoint;

            //Execute task and call showResults on completion
            queryTask.execute(query, showResults);
        }

        function showResults(featureSet) {
            //remove all graphics on the maps graphics layer
            map.graphics.clear();

            var features = featureSet.features;

            //QueryTask returns a featureSet.  Loop through features in the featureSet and add them to the map.
            dojo.forEach(features, function(feature) {
                var graphic = feature;
                graphic.setSymbol(symbol);

                //Set the infoTemplate.
                graphic.setInfoTemplate(infoTemplate);

                //Add graphic to the map graphics layer.
                map.graphics.add(graphic);

            });

            dojo.connect(map.graphics, "onMouseMove", function(evt) {
                var g = evt.graphic;
                map.infoWindow.setContent(g.getContent());
                map.infoWindow.setTitle(g.getTitle());
                map.infoWindow.show(evt.screenPoint, map.getInfoWindowAnchor(evt.screenPoint));
            });
            dojo.connect(map.graphics, "onMouseOut", function() {
                map.infoWindow.hide();
            });
        }

        dojo.ready(init);

        require([
      "esri/layers/GraphicsLayer",
        "esri/geometry/Circle",
        "esri/geometry/Polyline",
            "esri/renderers/UniqueValueRenderer",
            "esri/renderers/ClassBreaksRenderer", "esri/dijit/Legend",
            "esri/tasks/AreasAndLengthsParameters",
            "esri/tasks/GeometryService",
            "esri/dijit/BasemapToggle",
            "esri/InfoTemplate",
            "esri/config",
            "esri/dijit/HomeButton",
            "dojo/parser",
            "dojo/_base/window", "dojo/dom-style", "dojo/topic",
            "mywidget/widgets/TocWidget", "mywidget/widgets/Menu",
            "mywidget/widgets/_BaseWidget",
            "mywidget/widgets/MoveableWidgetFrame",
            "esri/layers/ArcGISDynamicMapServiceLayer",
            "esri/tasks/FeatureSet",
            "esri/SpatialReference", "esri/tasks/Geoprocessor",
            "esri/IdentityManager",
            "esri/layers/FeatureLayer",
            "esri/dijit/FeatureTable",
            "dojo/dom-construct",
            "dojo/dom",

            "dojo/ready",
            "dojo/on",
            "dojo/_base/lang",
            "dijit/registry",
            "esri/dijit/OverviewMap", "esri/dijit/Scalebar", "esri/tasks/query", "esri/tasks/QueryTask",
            "esri/symbols/SimpleMarkerSymbol", "esri/symbols/SimpleLineSymbol", "esri/symbols/SimpleFillSymbol",
            "esri/geometry/Point", "esri/graphic", "esri/Color", "esri/toolbars/draw",
            "mywidget/widgets/MenuItem",
            "mywidget/widgets/WidgetContainer", "mywidget/widgets/MenuFrame", "dijit/Dialog","dijit/layout/BorderContainer", "dijit/layout/ContentPane",
            "dijit/layout/AccordionContainer",
            "dojo/domReady!"
        ], function(GraphicsLayer,Circle, Polyline,
            UniqueValueRenderer,ClassBreaksRenderer,Legend,AreasAndLengthsParameters,GeometryService,BasemapToggle, InfoTemplate, esriConfig, HomeButton, parser, win, domStyle, topic, TocWidget, Menu, _BaseWidget, MoveableWidgetFrame, ArcGISDynamicMapServiceLayer, FeatureSet, SpatialReference, Geoprocessor,
            IdentityManager, FeatureLayer, FeatureTable,
            domConstruct, dom, ready, on, lang,
            registry, OverviewMap, Scalebar, Query, QueryTask, SimpleMarkerSymbol, SimpleLineSymbol, SimpleFillSymbol,
            Point, Graphic, Color, Draw
        ) {

            var temp_str, toolbar, gp, graphic;


            ready(function() {
                parser.parse();
                //configure map animation to be faster
                esriConfig.defaults.map.panDuration = 1; // time in milliseconds, default panDuration: 350
                esriConfig.defaults.map.panRate = 1; // default panRate: 25
                esriConfig.defaults.map.zoomDuration = 100; // default zoomDuration: 500
                esriConfig.defaults.map.zoomRate = 1; // default zoomRate: 25

                //map.on("load", initGpServer);
                //on(dom.byId("paint"), "click", activateTool);
                //on(dom.byId("clear"), "click", clearGraphics);
                toolbar = new Draw(map);
                toolbar.on("draw-end", addToMap);

                //on(dom.byId("execute"), "click", executeGP);
                var mapserviceurl = "http://210.42.41.246:6080/arcgis/rest/services/idw/MapServer/jobs";
                createWidget();
                createMenu();

                function createWidget() {
                    toc = new TocWidget();
                    toc.setTitle("图层控制器");
                    toc.setMap(map);
                }

                function createMenu() {
                    var menuFrame = registry.byId('menuFrame');
                    var logoUrl = require.toUrl("mywidget/widgets/assets/images/logo.png");
                    menuFrame.setFrameIcon(logoUrl);
                    menuFrame.setTitle("产地安全等级评价与禁产区边界确认分析平台");
                    //确定性插值 地统计插值 区域化分析
                    var params = {
                        label: "",
                        title: "工具",
                        icon: "assets/images/icons/i_tool.png",
                        positionAsPct: 44,
                        visible: true
                    };

                    var toolMenu = new Menu(params);
                    toolMenu.addMenuItem({
                        label: "图层控制器",
                        icon: "assets/images/icons/i_highway.png",
                        visible: true,
                        onMenuItemClick: testMenuItemClick
                    });
                    toolMenu.addMenuItem({
                        label: "测量面积",
                        icon: "assets/images/icons/i_highway.png",
                        visible: true,
                        onMenuItemClick: paintLine
                    });
                    toolMenu.addMenuItem({
                        label: "专题图",
                        icon: "assets/images/icons/i_highway.png",
                        visible: true,
                        onMenuItemClick: drawSpecialPic
                    });
                    toolMenu.addMenuItem({
                        label: "加密布局",
                        icon: "assets/images/icons/i_highway.png",
                        visible: true,
                        onMenuItemClick: createDiaEncry
                    });
	   
                    menuFrame.addChild(toolMenu);
                    toolMenu.startup();

                    //反距离插值 局部多项式插值 全局多项式插值
                    var params1 = {
                        label: "",
                        title: "确定性插值",
                        icon: "assets/images/icons/i_layers1.png",
                        positionAsPct: 50,
                        visible: true
                    };
                    var Deterministic_interpolation = new Menu(params1);
                    Deterministic_interpolation.addMenuItem({
                        label: "反距离插值",
                        icon: "assets/images/icons/i_demographics.png",
                        visible: true,
                        onMenuItemClick: activateTool
                    });
                    Deterministic_interpolation.addMenuItem({
                        label: "局部多项式插值",
                        icon: "assets/images/icons/i_demographics.png",
                        visible: true,
                        onMenuItemClick: activateTool
                    });
                    Deterministic_interpolation.addMenuItem({
                        label: "全局多项式插值",
                        icon: "assets/images/icons/i_demographics.png",
                        visible: true,
                        onMenuItemClick: activateTool
                    });

                    Deterministic_interpolation.addMenuItem({
                        label: "径向基函数插值",
                        icon: "assets/images/icons/i_demographics.png",
                        visible: true,
                        onMenuItemClick: activateTool
                    });

                    Deterministic_interpolation.addMenuItem({
                        label: "自然邻域插值",
                        icon: "assets/images/icons/i_demographics.png",
                        visible: true,
                        onMenuItemClick: activateTool
                    });
                    Deterministic_interpolation.addMenuItem({
                        label: "样条函数插值",
                        icon: "assets/images/icons/i_demographics.png",
                        visible: true,
                        onMenuItemClick: activateTool
                    });
                    menuFrame.addChild(Deterministic_interpolation);
                    Deterministic_interpolation.startup();

                    //
                    var params2 = {
                        label: "",
                        title: "地统计插值",
                        icon: "assets/images/icons/i_layers2.png",
                        positionAsPct: 60,
                        visible: true
                    };
                    var Ground_statistical_interpolation = new Menu(params2);
                    Ground_statistical_interpolation.addMenuItem({
                        label: "普通克里金",
                        icon: "assets/images/icons/i_demographics.png",
                        visible: true,
                        onMenuItemClick: activateTool
                    });
                    menuFrame.addChild(Ground_statistical_interpolation);
                    Ground_statistical_interpolation.startup();

                    //
                    var params3 = {
                        label: "",
                        title: "区域化分析",
                        icon: "assets/images/icons/i_layers3.png",
                        positionAsPct: 70,
                        visible: true
                    };

                    var Regionalization_analysis = new Menu(params3);
                    Regionalization_analysis.addMenuItem({
                        label: "插值到村镇",
                        icon: "assets/images/icons/i_demographics.png",
                        visible: true,
                        onMenuItemClick: activateTool
                    });
                    menuFrame.addChild(Regionalization_analysis);
                    Regionalization_analysis.startup();
	var params4 = {
							label: "",
							title: "污染源分析",
							icon: "assets/images/icons/i_pplay.png",
							positionAsPct: 80,
							visible: true
						};
							var PointPlution_analysis = new Menu(params4);
						 
							PointPlution_analysis.addMenuItem({
									label: "点状污染源分析",
									icon: "assets/images/icons/i_highway.png",
									visible: true,
									onMenuItemClick: executePP
								});
							menuFrame.addChild(PointPlution_analysis);
							PointPlution_analysis.startup();
							
                    //
                    var params5 = {
                        label: "",
                        title: "系统管理",
                        icon: "assets/images/icons/i_GeoprocessingTool.png",
                        positionAsPct: 88,
                        visible: true
                    };

                    var System_administrate = new Menu(params5);
                    System_administrate.addMenuItem({
                        label: "用户管理",
                        icon: "assets/images/icons/i_demographics.png",
                        visible: true,
                        onMenuItemClick: activateUserAdmin
                    });

                    System_administrate.addMenuItem({
                        label: "角色管理",
                        icon: "assets/images/icons/i_demographics.png",
                        visible: true,
                        onMenuItemClick: activateRoleAdmin
                    });
                    menuFrame.addChild(System_administrate);

                    System_administrate.addMenuItem({
                        label: "系统配置",
                        icon: "assets/images/icons/i_demographics.png",
                        visible: true,
                        onMenuItemClick: activateTool
                    });
                    menuFrame.addChild(System_administrate);
                    System_administrate.startup();
                }

                function testMenuItemClick(evt) {
                    topic.publish("showWidget", toc);
                }

                function clearGraphics() {
                    map.graphics.clear();
                }


                // 用户管理
                function activateUserAdmin() {
                    var diag = new Dialog();
                    diag.Width = 1200;
                    diag.Height = 300;
                    diag.Title = "用户管理";
                    //diag.URL = "userAdmin.html";
                    diag.URL = "user/index";
                    diag.show();
                }

                function activateRoleAdmin() {
                    var diag = new Dialog();
                    diag.Width = 1200;
                    diag.Height = 300;
                    diag.Title = "角色管理";
                    //diag.URL = "userAdmin.html";
                    diag.URL = "role/index";
                    diag.show();
                }

                var g_reslutCantainer;

                function activateTool(data) {
                    flayer_Sample.redraw();
                    //   var tool = this.label.toUpperCase().replace(/ /g, "_");
                    //这里要弹出一个框子
                    var diag = new Dialog();
                    diag.Modal = false;
                    diag.Title = data.value;
                    diag.InnerHtml = htmltxt;
                    get_Html = selectMethod(data.value);
                    gp = new Geoprocessor(get_Html["gpurl"]);

                    //点击确定后调用的方法
                    diag.show();
                    changethirdStyle(get_Html["flag"]);
                    document.getElementById("seleimg").onclick = paintRec;
                    document.getElementById("thirdtxt").innerHTML = get_Html["r_html"];
                    document.getElementById("sub").onclick = function() {
                        executeGP(data.value);
                    }
                    document.getElementById("output").onclick = function() {
                        showResultTable();
                    }
                    document.getElementById("cleanLabel").onclick = function() {
                        cleanChoice();
                    }

                }

                function cleanChoice() {
                    map.graphics.clear();
                }

                function showResultTable() {

                    /*	var doc=diag.innerFrame.contentWindow.document;
                     doc.open();
                     doc.write(document.getElementById('resultTable').innerHTML) ;
                     doc.close();
                     */
                    var diag = new Dialog();
                    diag.Modal = false;
                    diag.Height = 600;
                    diag.Width = 700;
                    diag.Title = "交叉验证结果";
                    diag.InnerHtml='<a style="font-size:15px;font-weight:bold;text-align:left;">'+dom.byId("crossInfo").innerHTML+'</a>';
                    diag.InvokeElementId = "resultTable";
                    diag.Top = "50%";
                    diag.Left = "50%";
                    diag.show();

                }

                function paintRec() {
                    //如果点了选择区域进行圈区域的操作
                    toolbar.activate(Draw["RECTANGLE"]);
                    map.hideZoomSlider();
                }
                var tb = new Draw(map);
                function paintLine()
                {
                    //如果点了选择区域进行圈区域的操作

                    tb.on("draw-end", lang.hitch(map, getAreaAndLength));
                    tb.activate(Draw.FREEHAND_POLYGON);
                }

                function addToMap(evt) {
                    var symbol;
                    toolbar.deactivate();
                    map.showZoomSlider();

                    symbol = new SimpleFillSymbol();
                    graphic = new Graphic(evt.geometry, symbol);
                    map.graphics.add(graphic);

                }

                function selectMethod(data) {
                    var r_html, flag = 0;
                    switch(data) {
                        case "反距离插值":
                            gpurl = "http://210.42.41.246:6080/arcgis/rest/services/idw/GPServer/idw";
                            r_html = "距离指数";
                            flag = 1;
                            break;
                        case "局部多项式插值":
                            gpurl = "http://210.42.41.246:6080/arcgis/rest/services/LPI/GPServer/wangchao_LPI";
                            console.log("局部多项式插值" + gpurl);

                            break;
                        case "全局多项式插值":
                            gpurl = "http://210.42.41.246:6080/arcgis/rest/services/GPI/GPServer/wangchao_GPI";
                            console.log("全局多项式插值" + gpurl);

                            break;
                        case "径向基函数插值":
                            gpurl = "http://210.42.41.246:6080/arcgis/rest/services/RBF/GPServer/wangchao_RBF";
                            console.log("径向基函数插值" + gpurl);

                            break;
                        case "自然邻域插值":
                            gpurl = "http://210.42.41.246:6080/arcgis/rest/services/NaturalNeighbor/GPServer/NaturalNeighbor";
                            console.log("自然邻域插值" + gpurl);

                            break;
                        case "样条函数插值":
                            gpurl = "http://210.42.41.246:6080/arcgis/rest/services/Spline/GPServer/Spline";
                            console.log("样条插值法" + gpurl);

                            break;
                        case "普通克里金":
                            gpurl = "http://210.42.41.246:6080/arcgis/rest/services/Kring/GPServer/Kring";
                            console.log("普通克里金" + gpurl);
                            r_html = "变异函数";
                            flag = 2;
                            break;

                        case "插值到村镇":
                            gpurl = "http://210.42.41.246:6080/arcgis/rest/services/zonal_xt_idw/GPServer/zonal_xt_idw";
                            console.log("插值到村镇" + gpurl);
                            r_html = "距离指数";
                            flag = 3;
                            break;
                    }
                    var ret_para = {
                        "gpurl": gpurl,
                        "r_html": r_html,
                        "flag": flag
                    };
                    return ret_para;
                }

                function getGPparamsJson(rec_data) {

                    var features = [];
                    features.push(graphic);
                    var featureSet = new FeatureSet();
                    featureSet.features = features;
                    //获取数据，函数在innerHTML.js中
                    var ireq_para = getData();
                    var obj = ireq_para["obj"];
                    var distance = ireq_para["dis"];
                    var fourthpara = ireq_para["fourth"];
                    console.log("插值对象：" + obj + " 距离参数：" + distance);
                    switch(rec_data) {
                        case "反距离插值":
                            ret_GPparams = {
                                "Z_value_field": obj,
                                "polygon": featureSet,
                                "Power": distance
                            };
                            console.log("反距离插值" + ret_GPparams);
                            break;
                        case "局部多项式插值":
                            ret_GPparams = {
                                "Z_value_field": obj,
                                "polygon": featureSet
                            };
                            console.log("局部多项式插值" + ret_GPparams);
                            break;
                        case "全局多项式插值":
                            ret_GPparams = {
                                "Z_value_field": obj,
                                "polygon": featureSet

                            };
                            console.log("全局多项式插值" + ret_GPparams);
                            break;
                        case "径向基函数插值":
                            ret_GPparams = {
                                "Z_value_field": obj,
                                "polygon": featureSet
                            };
                            console.log("径向基函数插值" + ret_GPparams);
                            r_html = "距离指数";
                            break;
                        case "自然邻域插值":
                            ret_GPparams = {
                                "Z_value_field": obj,
                                "polygon": featureSet
                            };
                            console.log("自然邻域插值" + ret_GPparams);
                            r_html = "距离指数";
                            break;
                        case "样条函数插值":
                            ret_GPparams = {
                                "Z_value_field": obj,
                                "polygon": featureSet
                            };
                            console.log("样条函数插值" + ret_GPparams);
                            r_html = "距离指数";
                            break;

                        case "普通克里金":
                            ret_GPparams = {
                                "Z_value_field": obj,
                                "polygon": featureSet,
                                "Semivariogram_properties": distance
                            };
                            console.log("普通克里金" + ret_GPparams);
                            break;
                        case "插值到村镇":
                            ret_GPparams = {
                                "Z_value_field": obj,
                                "polygon": featureSet,
                                "tablenm": fourthpara
                            };
                            console.log("普通克里金" + ret_GPparams);
                            break;
                    }

                    return ret_GPparams;
                }
                var outlayerName;

                function executeGP(gpmethod) {
                    outlayerName = gpmethod;
                    var features = [];
                    features.push(graphic);
                    console.log("实际执行的GP" + gpurl);
                    var params = getGPparamsJson(gpmethod);
                    gp.setOutSpatialReference({
                        "wkid": 102113
                    });
                    console.log(eval(params));
                    gp.setOutSpatialReference({
                        "wkid": 102113
                    });

                    gp.submitJob(params, completeCallback, statusCallback, cleanResultLayer);
                }

                function statusCallback(jobInfo) {
                    console.log(jobInfo.jobStatus);
                    console.log(jobInfo.jobId);
                }

                function completeCallback(jobInfo) {
                    gp.getResultImageLayer(jobInfo.jobId, null, null, function(layer) {
                        layer.setOpacity(0.7);
                        console.log("输出图层名字"+outlayerName);
                        //layer.id=outlayerName;
                        map.addLayers([layer]);
                    });
                    gp.getResultData(jobInfo.jobId, "output_value", showDataString);

                    var mapurl = mapserviceurl + "/" + jobInfo.jobId;
                    var ClassifiedLayer = new ArcGISDynamicMapServiceLayer(mapurl, {
                        "id": "ClassifiedLayer"
                    });
                    //add the hotspot layer to the map
                    map.addLayer(ClassifiedLayer);
                    var mapurl = mapserviceurl + "/" + jobInfo.jobId+ "/3";
                    console.log(mapurl);
                    var ClassifiedLayer = new FeatureLayer(mapurl, {
                        mode: FeatureLayer.MODE_ONDEMAND,
                        outFields:  ["FID","Measured","Predicted","Error","Included"]
                    });
                    var resultTable = new FeatureTable({
                            "featureLayer": ClassifiedLayer,
                            fieldInfos: [{
                                name: 'Measured',
                                alias: '真实值',
                                editable: false
                            }, {
                                name: 'Predicted',
                                alias: '预测值',
                                editable: false
                            }, {
                                name: 'Error',
                                alias: '误差',
                                editable: false
                            }, {
                                name: 'Included',
                                alias: '是否包含',
                                editable: false
                            }],
                        },
                        "resultTable");
                    resultTable.startup();


                }

                function showDataString(result) {

                    console.log(result);
                    console.log("交叉验证结果:" + result.value);
                    dom.byId("crossInfo").innerHTML="交叉验证结果:"+result.value;
                }
                var closeDiaFlag = 0;

                function cleanResultLayer(jobInfo) {
                    if(closeDiaFlag) {
                        gp.getResultImageLayer(jobInfo.jobId, null, null, function(layer) {
                            layer.setOpacity(0.7);
                            console.log("输出图层名字" + outlayerName);
                            //layer.id=outlayerName;
                            map.removeLayer([layer]);
                        });
                    }

                }

                function changethirdStyle(flag) {
                    if(flag) {
                        document.getElementById("distance").style.display = "block";
                        document.getElementById("thirdtxt").style.display = "block";
                    }
                    if(flag == 2) {
                        document.getElementById("distance").value = "Spherical 225.823841";
                    }
                    if(flag == 3) {

                        document.getElementById("fourthpara").style.display = "block";
                        document.getElementById("Select2").style.display = "block";
                    }
                }

                var toggle = new BasemapToggle({
                    map: map,
                    basemap: "topo"
                }, "BasemapToggle");
                toggle.startup();
                var overviewMapDijit = new OverviewMap({
                    //设置鹰眼控件的地图
                    map: map,
                    attachTo: "bottom-right",
                    //设置是否可见
                    visible: true,
                });
                overviewMapDijit.startup();
                //鹰眼控件放置的位置

                //添加比例尺
                var scalebar = new Scalebar({
                    map: map,
                    //比例尺单位
                    scalebarUnit: "dual",
                    //放置的位置
                    attachTo: "bottom-left"
                });
                //HomeButton
                var home = new HomeButton({
                    map: map
                }, "HomeButton");
                home.startup();

                //采样点的特征图层
                var flayer_Sample = new FeatureLayer("http://210.42.41.246:6080/arcgis/rest/services/samples_xt_wgs84/FeatureServer/0", {
                    mode: FeatureLayer.MODE_ONDEMAND,
                    infoTemplate: new InfoTemplate("重金属含量","\
					    		 <b>编号:</b>\${bh} <br>\
					    		  <b>地区:</b>\${wz} <br> \
					    		 <b>经度:</b>\${jd} <br>\
					    		 <b>纬度:</b>\${wd} <br>\
					    		 <b>土壤Pb:</b>\${tu_pb} <br> \
					    		<b>土壤Cd:</b>\${tu_cd} <br>\
					    		<b>土壤As:</b>\${tu_as}<br>\
					    		<b>土壤Cr:</b>\${tu_cr}<br>\
					    		<b>土壤Hg:</b>\${tu_hg}<br>\
					    		<b>PH:</b>\${ph}<br>\
					    		<b>农产品Pb:</b>\${nong_pb}<br>\
					    		<b>农产品Cd:</b>\${nong_cd}<br>\
					    		<b>农产品As:</b>\${nong_as}<br>\
					    		<b>农产品Cr:</b>\${nong_cr}<br>\
					    		<b>农产品Hg:</b>\${nong_hg}<br>\
					    		<b>是否超标:</b>\${isok}<br>" ),
                    outFields: ["*"],
                    visible: true,
                    id: "flayer"
                });

                map.addLayer(flayer_Sample);




                myTable = new FeatureTable({
                    featureLayer: flayer_Sample,
                    map: map,
                    showAttachments: true,
                    syncSelection: true,
                    gridOptions: {
                        allowSelectAll: true,
                        allowTextSelection: true,
                    },
                    editable: true,
                    zoomToSelection: true,
                    outFields: ["bh", "wz", "jd", "wd", 'tu_pb',
                        "tu_cd", "tu_as", "tu_cr", "tu_hg", "ph", "nong_pb", "nong_cd", "nong_as", "nong_cr", "nong_hg", "isok"
                    ],
                    fieldInfos: [{
                        name: 'bh',
                        alias: '编号',
                        editable: false
                    }, {
                        name: 'wz',
                        alias: '地区',
                        editable: false
                    }, {
                        name: 'jd',
                        alias: '经度',
                        editable: false
                    }, {
                        name: 'wd',
                        alias: '纬度',
                        editable: false
                    }, {
                        name: 'tu_pb',
                        alias: '土壤Pb'
                    }, {
                        name: 'tu_cd',
                        alias: '土壤Cd'
                    }, {
                        name: 'tu_as',
                        alias: '土壤As'
                    }, {
                        name: 'tu_cr',
                        alias: '土壤Cr'
                    }, {
                        name: 'tu_hg',
                        alias: '土壤Hg'
                    }, {
                        name: 'ph',
                        alias: 'PH'
                    }, {
                        name: 'nong_pb',
                        alias: '农产品Pb'
                    }, {
                        name: 'nong_cd',
                        alias: '农产品Cd'
                    }, {
                        name: 'nong_as',
                        alias: '农产品As'
                    }, {
                        name: 'nong_cr',
                        alias: '农产品Cr'
                    }, {
                        name: 'nong_hg',
                        alias: '农产品Hg'
                    }, {
                        name: 'isok',
                        alias: '是否超标'
                    }

                    ]
                }, "myTableNode");
                myTable.on("show-attachments", function(evt) {
                    console.log("show-attachments event - ", evt);
                });
                myTable.startup();

                /*flayer_Sample.on("click", execute);

                 var queryTask1 = new QueryTask("http://210.42.41.246:6080/arcgis/rest/services/samples_xt_wgs84/MapServer/0");
                 //  alert("执行到了这条1");
                 var query1 = new Query();
                 //   alert("执行到了这条2");
                 query1.returnGeometry = false;
                 query1.outFields = ["*"];

                 //on(dom.byId("execute"), "click", execute);

                 //   map.on("click", addPoint);

                 function execute(evt) {
                 //   alert("FL被点击");
                 graphicAttributes = evt.graphic.attributes;
                 // relatedQuery.objectIds = ;
                 var temstr = [graphicAttributes.OBJECTID]
                 // query1.text =temstr.toString() ;
                 query1.where = "OBJECTID=" + temstr.toString();
                 //  alert(query1.where);

                 var pointContent = queryTask1.execute(query1, showResults);
                 // alert("想传回来的point"+temp_str);
                 map.infoWindow.setTitle("属性");
                 map.infoWindow.setContent(temp_str);
                 map.infoWindow.show(evt.mapPoint, map.getInfoWindowAnchor(evt.screenPoint));

                 }

                 function showResults(results) {
                 var resultItems = [];
                 var resultCount = results.features.length;
                 for(var i = 0; i < resultCount; i++) {
                 var featureAttributes = results.features[i].attributes;
                 for(var attr in featureAttributes) {
                 resultItems.push("<b>" + attr + ":</b>  " + featureAttributes[attr] + "<br>");
                 }
                 resultItems.push("<br>");
                 }
                 temp_str = resultItems.join("");

                 //dom.byId("info").innerHTML = resultItems.join("");
                 // alert(dom.byId("info").innerHTML );

                 }
                 */

                function createDiaEncry()
                {
                    var diag = new Dialog();
                    diag.Modal = false;
                    diag.Width = 500;
                    diag.Height = 500;
                    diag.Title = "加密布局";
                    diag.InnerHtml=Encry_htmltxt;

                    diag.show();


                    document.getElementById("execute_encryption").onclick = function() {
                        showEncryption();
                    };
                    document.getElementById("showDataList").onclick = function() {
                        showEncryDataList();
                    };


                }
                function showEncryption()
                {
                    var cxyz=document.getElementById("cxyz");
                    if(cxyz.value==""){
                        Dialog.alert("请先进行错划指数计算!");
                        return 1;
                    }



                    var encryLayer   = new FeatureLayer("http://172.25.11.219:6080/arcgis/rest/services/Encrypted_sample/MapServer/0", {
                        "id": "EncryLayer"
                    });
                    //add the hotspot layer to the map
                    map.addLayer(encryLayer);
                    //启动图例
                    var legend = new Legend({
                        map: map,
                        layerInfos: [
                            {
                                layer: encryLayer,
                                title: "错划指数"
                            }
                        ]
                    },"legend");
                    legend.startup();
                }
                function showEncryDataList()
                {
                    alert("显示数据表");
                    var EncryDataList = new FeatureLayer("http://172.25.11.219:6080/arcgis/rest/services/updateSamples/MapServer/0", {
                        mode: FeatureLayer.MODE_ONDEMAND,

                        outFields:  ["FID","LAT","LON"]
                    });
                    var En_DataTable = new FeatureTable({
                            "featureLayer": EncryDataList,
                            featureCount:50,
                            outFields:  ["DATA","LAT","LON"],
                            fieldInfos: [
                                {
                                    name: 'DATA',
                                    alias: '编号',
                                    editable: false
                                },{
                                    name: 'LON',
                                    alias: '经度',
                                    editable: false
                                }, {
                                    name: 'LAT',
                                    alias: '纬度',
                                    editable: false
                                }]},
                        "En_DataList");
                    En_DataTable.startup();
                    var diag = new Dialog();
                    diag.Modal = false;
                    diag.Height = 600;
                    diag.Width = 700;
                    diag.Title = "数据列表 ";
                    //diag.InnerHtml='<a style="font-size:15px;font-weight:bold;text-align:left;">'+dom.byId("crossInfo").innerHTML+'</a>';
                    diag.InvokeElementId = "En_DataList";
                    diag.Top = "50%";
                    diag.Left = "50%";
                    diag.show();
                }

                var geometryService = new GeometryService("http://210.42.41.246:6080/arcgis/rest/services/Utilities/Geometry/GeometryServer");
                geometryService.on("areas-and-lengths-complete", outputAreaAndLength);

                function getAreaAndLength(evtObj) {
                    var map = this,
                        geometry = evtObj.geometry;
                    map.graphics.clear();

                    var graphic = map.graphics.add(new Graphic(geometry, new SimpleFillSymbol()));

                    //setup the parameters for the areas and lengths operation
                    var areasAndLengthParams = new AreasAndLengthsParameters();
                    areasAndLengthParams.lengthUnit = GeometryService.UNIT_METER;
                    areasAndLengthParams.areaUnit = GeometryService.UNIT_SQUARE_METERS;
                    areasAndLengthParams.calculationType = "geodesic";
                    geometryService.simplify([geometry], function(simplifiedGeometries) {
                        areasAndLengthParams.polygons = simplifiedGeometries;
                        geometryService.areasAndLengths(areasAndLengthParams);
                    });
                }

                function outputAreaAndLength(evtObj) {
                    var result = evtObj.result;

                    Dialog.confirm("长度"+ result.lengths[0].toFixed(3)+"米"+ "</br>"+"面积"+result.areas[0].toFixed(3)+"平方米",
                        null,
                        stopCalLengthAndArea());

                }
                function stopCalLengthAndArea()
                {
                    tb.deactivate();
                    map.graphics.clear();
                }
                function drawSpecialPic()
                {
                    var symbol_ok =  new SimpleMarkerSymbol(SimpleMarkerSymbol.STYLE_X, 10, new SimpleLineSymbol(SimpleLineSymbol.STYLE_SOLID,
                        new Color([255,0,0]), 1),new Color([255,0, 0, 0.5]) );
                    var symbol_Ntok =  new SimpleMarkerSymbol(SimpleMarkerSymbol.STYLE_CIRCLE, 10, new SimpleLineSymbol(SimpleLineSymbol.STYLE_SOLID,
                        new Color([0,255,0]), 1),new Color([0,255,0, 0.5]) );


                    var defaultSymbol = new SimpleMarkerSymbol(SimpleMarkerSymbol.STYLE_CROSS, 10, new SimpleLineSymbol(SimpleLineSymbol.STYLE_SOLID,
                        new Color([255,0,0]), 1),new Color([255,255, 0, 0.5]) ); ;
                    defaultSymbol.outline.setStyle(SimpleLineSymbol.STYLE_NULL);

                    var renderer = new UniqueValueRenderer(defaultSymbol,"isok");
                    renderer.addValue("超标", symbol_ok );
                    renderer.addValue("不超标",symbol_Ntok );
                    flayer_Sample.setRenderer(renderer);
                    flayer_Sample.refresh();
                    //启动图例
                    var legend = new Legend({
                        map: map,
                        layerInfos: [
                            {
                                layer: flayer_Sample,
                                title: "是否超标"
                            }
                        ]
                    },"legend");
                    legend.startup();

                }

  var queryTask = new QueryTask("http://210.42.41.246:6080/arcgis/rest/services/samples_xt_wgs84/MapServer/0");

    var query = new Query();
    query.returnGeometry = true;
    query.outFields = ["*"];

  //  on(dom.byId("execute"), "click", execute);


    var lineSymbol = new SimpleLineSymbol({
        color: [226, 119, 40],  // RGB color values as an array
        width: 1
    });

    var resultItems = [];
    var features = [];
    var currentFeature = null;

    var R = 0.01;

    //获得有向图
    var graph = new Array();   //先声明一维

    function executePP() {
    	var diag = new Dialog();
    	diag.Modal = false;
    	diag.Width = 500;
    	diag.Height = 200;
    	diag.Title = "点状污染源分析";
    	diag.InnerHtml=PointPlu_htmltxt;
     
    	diag.show();
    	document.getElementById("StartAla").onclick = function() {
    		query.text = 0;
            map.graphics.clear();
    	    queryTask.execute(query, showPointPolutionResults);
		}
    	document.getElementById("outputRes").onclick = function() {
    		var diag = new Dialog();
    		diag.Modal = false;
    		diag.Height = 600;
    		diag.Width = 700;
    		diag.Title = "点状污染点数据 ";
    			//diag.InnerHtml='<a style="font-size:15px;font-weight:bold;text-align:left;">'+dom.byId("crossInfo").innerHTML+'</a>';
    		diag.InvokeElementId = "polinfo";
    		diag.Top = "50%";
    		diag.Left = "50%";
    		diag.show();
    		
		}
    	
    	
    
    }

    function showPointPolutionResults(results) {

       	var obj = getData2();
    	 
    	
        features = results.features;
     //   alert(features.length);

        var resultCount = results.features.length;
        var value = "";
        for(var i = 0; i<resultCount; i++)
        {
            var point = features[i].geometry;
            var featureAttributes = features[i].attributes;
            value += features[i].attributes[obj]+" ";
            if(features[i].attributes["OBJECTID"]!=null){
                resultItems.push("I：<b>" + i + "</b>\tX：<b>" + point.x + "</b>\tY：<b>" + point.y + "</b>\ttu_pb：<b>" + featureAttributes[obj] + "</b><br>");
            }
        }
        //alert(value);
        dom.byId("polinfo").innerHTML = resultItems.join("");

        for(var i=0;i<features.length;i++){        //一维长度为i,i为变量，可以根据实际情况改变
            graph[i]=new Array();    //声明二维，每一个一维数组里面的一个元素都是一个数组
            for(var j=0;j<features.length;j++){
                graph[i][j] = 0;
                //alert(graph[i][j]);
            }
        }
        for(var i=0;i<features.length;i++){        //一维长度为i,i为变量，可以根据实际情况改变
            for(var j=0;j<features.length;j++){
                graph[i][j] = 0;
                //alert("ewhr");
            }
        }

        getC(obj);

    }
  	


    //求得污染物含量变异强度系数R
    var c;
    function getC(obj){
        var mean = 0;
        for(var i=0;i<features.length;i++){
            mean += features[i].attributes[obj];
        }
        mean = mean/features.length;
        mean = mean.toFixed(2);
        //alert(mean);

        var sum = 0;
        for(var i=0;i<features.length;i++){
            sum += Math.abs(features[i].attributes[obj]-mean);
        }
        sum = sum/features.length;
        c = sum.toFixed(2);
        //alert(c);

        getGraphic(obj);
        getSource();
    }

    function getGraphic(obj){
        for(var i=0;i<features.length;i++){
            for(var j=0; j<features.length && i!=j; j++){
                if(getDistanceXY(features[i].geometry,features[j].geometry)<=R && (features[i].attributes[obj]-features[j].attributes[obj])>=c){
                    graph[i][j] = 1;
                    AddGraphics(features[i].geometry,features[j].geometry);
                }else if(getDistanceXY(features[i].geometry,features[j].geometry)<=R && (features[i].attributes[obj]-features[j].attributes[obj])<=0 &&
                Math.abs(features[i].attributes[obj]-features[j].attributes[obj])>=c){
                    graph[i][j] = 0;
                    graph[j][i] = 1;
                    AddGraphics(features[j].geometry,features[i].geometry);
                }else if(getDistanceXY(features[i].geometry,features[j].geometry)>R){
                    graph[i][j] = 0;
                }
                /*//alert(graph[i][j]);
                if(graph[i][j]==1){
                    AddGraphics(features[i].geometry,features[j].geometry);
                }*/
            }

        }
    }

    function getDistanceXY(a,b){
        return Math.sqrt((a.x- b.x)*(a.x- b.x)+(a.y- b.y)*(a.y- b.y));
    }

    //在两点间添加边
    function AddGraphics(point1, point2) {

        var polyline = new Polyline();
        polyline.addPath([point1, point2]);

        var polylineGraphic = new Graphic(polyline, lineSymbol);

        map.graphics.add(polylineGraphic);
    }

    //找到污染源
    var s = "";
    function getSource(){
        var str="";
       // alert("graph[151][181]="+graph[151][118]);
        for(var i=0;i<features.length;i++){
            str += graph[151][i]+" ";
        }
       //alert(str);
        for(var i=0;i<features.length;i++){
            var flag = true;
            var hasChild = false;
            for(var j=0;j<features.length ; j++){
                if(i==j)
                    continue;
                if(graph[j][i]===1){
                    flag = false;
                    break;
                }
                if(graph[i][j]===1){
                    if(i==151){
                       // alert("j=="+j);
                    }
                    hasChild = true;
                }
            }
            if(flag==true && hasChild==true) {
               /* if(i==151)
                   alert(i);*/
                AddCircle(features[i].geometry);
            }
        }
    }

    //为污染源添加标识
    var k = 0;
    function AddCircle(point){
        // 绘制圆
        k++;
        var symbol = new SimpleFillSymbol().setColor("blue").outline.setColor("blue");
        var gl = new GraphicsLayer({ id: "circles"+k });
        map.addLayer(gl);
        var radius = 100;
        var circle = new Circle({
            center: point,
            radius: radius
        });
        var graphic = new Graphic(circle, symbol);
            map.graphics.add(graphic);
    }	
    


            });

        });
    </script>
</head>

<body class="tundra"">



<!--		<p style="font-size:18px;color:black;height:40px"> 输入查询编号: <input type="text" id="stateName" value="430321-WG-0203-T" /> -->


<div data-dojo-type="mywidget/widgets/MenuFrame" id='menuFrame' style="top:0px;left: 0px;width:100%"></div>
<div data-dojo-type="mywidget/widgets/WidgetContainer" id="widgetContainer"></div>

<!--
<input id="paint" type="button" value="画图形" />
<input id="execute" type="button" value="提交结果" />
<input id="clear" type="button" value="清除" />
<div id="legendDiv"> </div>
-->

<div data-dojo-type="dijit/layout/BorderContainer" data-dojo-props="design:'headline',gutters:false"  id="main">

    <div data-dojo-type="dijit/layout/ContentPane" data-dojo-props="region:'center'" style="overflow:hidden ">

        <div id="mapDiv" style=" overflow:hidden;height:100%">
            <div id="latlong" class="lat" ></div>
            <div id="bookmarks"> </div>
            <div id="BasemapToggle"></div>

            <div id="HomeButton"></div>
            <div id="info">
                <div id="legend"></div>
            </div>
        </div>

    </div>


    <div data-dojo-type="dijit/layout/ContentPane" data-dojo-props="region:'bottom', splitter:'true'"
         style=" height: 150px;">

        <div id="myTableNode"></div>


    </div>
</div>

<div id="resultTable"></div>
<div id="En_DataList"></div>

<div id="crossInfo" style="font-size:50px;font-weight:bold;display:none">本来的文字</div>

 	    <div id="polinfo"style="width:100%; height:600px; overflow:scroll;display:none "></div>
</body>


</html>