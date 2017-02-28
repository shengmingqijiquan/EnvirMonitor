var imgflag = false;
var real_element=new Array("tu_pb","tu_cd", "tu_as", "tu_cr", "tu_hg","nong_pb", "nong_cd", "nong_as", "nong_cr", "nong_hg");

	    var htmltxt = _TEXT(function () {/*
 <div style="display:none"> </div>
 <style>
body { background: #ffffff; color: #444;font-size:12px; }
a { color: #07c; text-decoration: none; border: 0; background-color: transparent; }
body, div, q, iframe, form, h5 { margin: 0; padding: 0; }
img, fieldset { border: none 0; }
body, td, textarea { word-break: break-all; word-wrap: break-word; line-height:1.6; }
body, input, textarea, select, button { margin: 0; font-size: 12px; font-family: Tahoma, SimSun, sans-serif; }
div, p, table, th, td { font-size:1em; font-family:inherit; line-height:inherit; }
h5 { font-size:12px; }
ol li,ul li{ margin-bottom:0.5em;}
pre, code { font-family: "Courier New", Courier, monospace; word-wrap:break-word; line-height:1.4; font-size:12px;}
pre{background:#f6f6f6; border:#eee solid 1px; margin:1em 0.5em; padding:0.5em 1em;}
#content { padding-left:50px; padding-right:50px; }
#content h2 { font-size:20px; color:#069; padding-top:8px; margin-bottom:8px; }
#content h3 { margin:8px 0; font-size:14px; COLOR:#693; }
#content h4 { margin:8px 0; font-size:16px; COLOR:#690; }
#content div.item { margin-top:10px; margin-bottom:10px; border:#eee solid 4px; padding:10px; }
hr { clear:both; margin:7px 0; +margin: 0;
border:0 none; font-size: 1px; line-height:1px; color: #069; background-color:#069; height: 1px; }
.infobar { background:#fff9e3; border:1px solid #fadc80; color:#743e04; }
.buttonStyle{width:64px;height:22px;line-height:22px;color:#369;text-align:center;background:url(images/buticon.gif) no-repeat left top;border:0;font-size:12px;}
.buttonStyle:hover{background:url(images/buticon.gif) no-repeat left -23px;}

</style>
 
<body><div id="forlogin">
      <table width="100%" border="0" align="center" cellpadding="4" cellspacing="4" bordercolor="#666666">
       
        <tr>
          <td width="150" align="right">选择区域<a style="color:red">*</a></td>
          <td style="cursor:pointer">
           <img alt="" src="images/i_draw_rect.png"border="0" title="选择区域" id="seleimg"  />  </td>
        
        </tr>
        <tr>
        <td    align="right" ><a style="color:white">s</a> </td>
        <td><a id="cleanLabel" href="javascript:void(0);" style="color:black;text-decoration:underline">清除</a>  </td>
        <tr/>
        <tr>
          <td width="150" align="right">插值对象<a style="color:red">*</a></td>
           <td>  <select id="Select1">
                <option>土壤铅(Pb)元素含量</option>
                  <option>土壤镉(Cd)元素含量</option>
                    <option>土壤砷(As)元素含量</option>
                      <option>土壤铬(Cr)元素含量</option>
                      <option>土壤汞(Hg)元素含量</option>
                        <option>农产品铅(Pb)元素含量</option>
                          <option>农产品镉(Cd)元素含量</option>
                            <option>农产品砷(As)元素含量</option>
                          <option>农产品铬(Cr)元素含量</option>
                          <option>农产品汞(Hg)元素含量</option>
                        </select> 
            </td>
        </tr>
        <tr>
       
          <td align="right" width="150"  id="thirdtxt" style="display:none">距离指数</td>
          <td><input type="text" id="distance"  value=2  style="display:none"/></td> 
        
        </tr>
          <tr>
       
          <td align="right" width="150"  id="fourthpara" style="display:none" >级别<a style="color:red">*</a></td>
          <td>  <select id="Select2" style="display:none">     
                  <option>村级</option>
                  <option>镇级</option>
                   </select> 
          </td> 
        
        </tr>
        <tr>
          <td colspan="2" align="left" style="padding-left:160px;">
           <input id="sub" type="button"  value="提交" class="buttonStyle" /> 
           <input onClick="tj();" class="buttonStyle" type="button" value="关闭" />
            <input id="output"   type="button" value="输出结果" />
          </td>
        </tr>
      </table>
      <div id="myTableNode"></div>
</div></body>

  */
	    });
	    function getData() {
	        var obj = document.getElementById("Select1"); //定位id
	        var index = obj.selectedIndex; // 选中索引
	        var text = real_element[index]; // 选中文本
	        var obj2 = document.getElementById("Select2"); //定位id
	        var index2 = obj2.selectedIndex; // 选中索引
	        var text2 = obj2.options[index2].text; // 选中文本
            var dis = document.getElementById("distance").value;

	     	     var req_para = { "obj": text, "dis": dis,"fourth":text2 };
	     	     
	  	          return req_para;
	      }


	    function _TEXT(wrap) {
	        return wrap.toString().match(/\/\*\s([\s\S]*)\s\*\//)[1];
	    }

	    function tj() {
	        Dialog.close();
	        closeDiaFlag=1;
	    }

	    function test() {
	        console.log("初始值"+imgflag);
            imgflag = true;
            console.log("执行后值" + imgflag);
	    }
	 