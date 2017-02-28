/*    */ package com.xiangtan.ws.impl;
/*    */ 
/*    */ import com.xiangtan.ws.PagerWS;
/*    */ import java.net.MalformedURLException;
/*    */ import java.net.URL;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
/*    */ import javax.xml.namespace.QName;
/*    */ import javax.xml.ws.Service;
/*    */ import javax.xml.ws.WebEndpoint;
/*    */ import javax.xml.ws.WebServiceClient;
/*    */ import javax.xml.ws.WebServiceFeature;
/*    */ 
/*    */ @WebServiceClient(name="PagerWSImplService", wsdlLocation="http://172.25.11.217:8080/Xiangtan_server/pagerWS?wsdl", targetNamespace="http://impl.ws.xiangtan.com/")
/*    */ public class PagerWSImplService extends Service
/*    */ {
/* 36 */   public static final URL WSDL_LOCATION = url;
/*    */ 
/* 25 */   public static final QName SERVICE = new QName("http://impl.ws.xiangtan.com/", "PagerWSImplService");
/* 26 */   public static final QName PagerWSImplPort = new QName("http://impl.ws.xiangtan.com/", "PagerWSImplPort");
/*    */ 
/*    */   public PagerWSImplService(URL wsdlLocation)
/*    */   {
/* 40 */     super(wsdlLocation, SERVICE);
/*    */   }
/*    */ 
/*    */   public PagerWSImplService(URL wsdlLocation, QName serviceName) {
/* 44 */     super(wsdlLocation, serviceName);
/*    */   }
/*    */ 
/*    */   public PagerWSImplService() {
/* 48 */     super(WSDL_LOCATION, SERVICE);
/*    */   }
/*    */ 
/*    */   public PagerWSImplService(WebServiceFeature[] features) {
/* 52 */     super(WSDL_LOCATION, SERVICE, features);
/*    */   }
/*    */ 
/*    */   public PagerWSImplService(URL wsdlLocation, WebServiceFeature[] features) {
/* 56 */     super(wsdlLocation, SERVICE, features);
/*    */   }
/*    */ 
/*    */   public PagerWSImplService(URL wsdlLocation, QName serviceName, WebServiceFeature[] features) {
/* 60 */     super(wsdlLocation, serviceName, features);
/*    */   }
/*    */ 
/*    */   @WebEndpoint(name="PagerWSImplPort")
/*    */   public PagerWS getPagerWSImplPort()
/*    */   {
/* 73 */     return (PagerWS)super.getPort(PagerWSImplPort, PagerWS.class);
/*    */   }
/*    */ 
/*    */   @WebEndpoint(name="PagerWSImplPort")
/*    */   public PagerWS getPagerWSImplPort(WebServiceFeature[] features)
/*    */   {
/* 85 */     return (PagerWS)super.getPort(PagerWSImplPort, PagerWS.class, features);
/*    */   }
/*    */ 
/*    */   static
/*    */   {
/* 28 */     URL url = null;
/*    */     try {
/* 30 */       url = new URL("http://172.25.11.217:8080/Xiangtan_server/pagerWS?wsdl");
/*    */     } catch (MalformedURLException e) {
/* 32 */       Logger.getLogger(PagerWSImplService.class.getName())
/* 33 */         .log(Level.INFO, "Can not initialize the default wsdl from {0}", "http://172.25.11.217:8080/Xiangtan_server/pagerWS?wsdl");
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\2.中心资料\2.项目资料\1.GIS项目\1.湘潭\JS版本\hm_1\WEB-INF\classes\
 * Qualified Name:     com.xiangtan.ws.impl.PagerWSImplService
 * JD-Core Version:    0.6.2
 */