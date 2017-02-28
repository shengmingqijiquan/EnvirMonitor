 
	    var PointPlu_htmltxt = _TEXT(function () {/*
  <div>
			<a>项目：</a>
			   <select id="Select1">
				<option>土壤铅(Pb)元素含量</option>
				<option>土壤镉(Cd)元素含量</option>
				<option>土壤砷(As)元素含量</option>
				<option>土壤铬(Cr)元素含量</option>
				<option>土壤汞(Hg)元素含量</option>
			 

			</select> 
		 
		</div>
	 
	 <br />
		 
	  	<div>
			  <input id="StartAla" type="button" value="污染源分析"/> 
			  	  <input id="outputRes" type="button" value="输出结果"/> 
			  	</div>
  */
	    });
	 
function getData2() {
	        var obj = document.getElementById("Select1"); //定位id
	        var index = obj.selectedIndex; // 选中索引
	        var text = real_element[index]; // 选中文本
	       

	      
	     	     
	  	          return text;
	      }
	    function _TEXT(wrap) {
	        return wrap.toString().match(/\/\*\s([\s\S]*)\s\*\//)[1];
	    }
	   