 
	    var Encry_htmltxt = _TEXT(function () {/*
  <div>
			<a>项目</a>
			<select id="enc_item">
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

			</select> <br />
		</div>
		<div>
			<a>年份 </a>
			<select id="enc_year">
				<option>所有年份…</option>

			</select><br />
		</div>
		<div>
			图层： <input type="radio" name="identity" value="专题图" />专题图
			<input type="radio" name="identity" value="隐藏插值图" />隐藏插值图

			<br />
		</div>

		<div>
			<input id="calcx" type="button" value="错化指数计算" style="width:100px;"  onclick= "cal_ch()" /> 请输入插值阈值： <input id="cxyz" type="text" style="width: 116px;" />
			<br />
		</div>
		<div>
	  <input id="execute_encryption" type="button" value="加密布局" style="width:100px;"/>		 

			请输入加密数量： <input type="text" id="num" style="width: 118px;" />
		</div>
		<div>
			请输入错划阈值：<input type="text" id="chyz" style="width: 30px;" /> 请输入样点距离：
			<input type="text" id="dis" style="width: 60px;" />
		</div>
		<div>
	 <input id="showDataList" type="button" value="显示数据列表"/> 
			<input id="jmcx" type="button" value="加密错划指数计算" onclick="jm_cal()"   />
		</div> 

  */
	    });
	 

	    function _TEXT(wrap) {
	        return wrap.toString().match(/\/\*\s([\s\S]*)\s\*\//)[1];
	    }
	    function cal_ch(){
	        
	   		  if(checkNull1()){
	   		 Dialog.alert("请输入插值阈值");
	   		 }
	   		 else{
	   	 
	   	   Dialog.alert("正在计算，请稍后...");;
	   		setTimeout("Dialog.alert('计算完成.')",3000);
	   		 }
	   		}

	    function jm_cal() {
	     
				if(checkNull2() == 1) {
					Dialog.alert("请输入错划阈值!");
				}
				else if(checkNull2() == 2) {
					Dialog.alert("请输入加密数量!");
				}
				else if(checkNull2() == 3) {
					Dialog.alert("请输入样点距离！");
				}
	   					else
	   					{Dialog.alert("正在计算，请稍后...");
	   					setTimeout("Dialog.alert('计算完成.')", 2500);
	   			}
	   				}
	    function checkNull1(){
	    	 var cxyz=document.getElementById("cxyz");
		   	 if(cxyz.value==""){
		   		 return 1;
		   	 }
		   	 else
		   		{return 0;}
	    }
 function checkNull2(){
	 var m1 = document.getElementById("chyz");
		var m2 = document.getElementById("num");
		var m3 = document.getElementById("dis");
		if(m1.value == "") {
		 
			return 1;
		}
		else if(m2.value == "") {
			 
			return 2;
		}
		else if(m3.value == "") { 
			return 3;
			 
		}
		else
			{return 0;}
	    }