function completeCallback(jobInfo) {
	gp.getResultImageLayer(jobInfo.jobId, null, null, function(layer) {
		layer.setOpacity(0.7);
        console.log("输出图层名字"+outlayerName);
        //layer.id=outlayerName;
		map.addLayers([layer]);
	});
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
	"featureLayer": ClassifiedLayer
	}, 'resultTable');
	resultTable.startup(); 
  
}