/*    */ package com.xiangtan.ws.impl;
/*    */ 
/*    */ import com.xiangtan.ws.UserinfoLvWS;
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
/*    */ @WebServiceClient(name="Userinfo_lvWSImplService", wsdlLocation="http://172.25.11.217:8080/Xiangtan_server/userWS?wsdl", targetNamespace="http://impl.ws.xiangtan.com/")
/*    */ public class UserinfoLvWSImplService extends Service
/*    */ {
/* 36 */   public static final URL WSDL_LOCATION = url;
/*    */ 
/* 25 */   public static final QName SERVICE = new QName("http://impl.ws.xiangtan.com/", "Userinfo_lvWSImplService");
/* 26 */   public static final QName UserinfoLvWSImplPort = new QName("http://impl.ws.xiangtan.com/", "Userinfo_lvWSImplPort");
/*    */ 
/*    */   public UserinfoLvWSImplService(URL wsdlLocation)
/*    */   {
/* 40 */     super(wsdlLocation, SERVICE);
/*    */   }
/*    */ 
/*    */   public UserinfoLvWSImplService(URL wsdlLocation, QName serviceName) {
/* 44 */     super(wsdlLocation, serviceName);
/*    */   }
/*    */ 
/*    */   public UserinfoLvWSImplService() {
/* 48 */     super(WSDL_LOCATION, SERVICE);
/*    */   }
/*    */ 
/*    */   public UserinfoLvWSImplService(WebServiceFeature[] features) {
/* 52 */     super(WSDL_LOCATION, SERVICE, features);
/*    */   }
/*    */ 
/*    */   public UserinfoLvWSImplService(URL wsdlLocation, WebServiceFeature[] features) {
/* 56 */     super(wsdlLocation, SERVICE, features);
/*    */   }
/*    */ 
/*    */   public UserinfoLvWSImplService(URL wsdlLocation, QName serviceName, WebServiceFeature[] features) {
/* 60 */     super(wsdlLocation, serviceName, features);
/*    */   }
/*    */ 
/*    */   @WebEndpoint(name="Userinfo_lvWSImplPort")
/*    */   public UserinfoLvWS getUserinfoLvWSImplPort()
/*    */   {
/* 73 */     return (UserinfoLvWS)super.getPort(UserinfoLvWSImplPort, UserinfoLvWS.class);
/*    */   }
/*    */ 
/*    */   @WebEndpoint(name="Userinfo_lvWSImplPort")
/*    */   public UserinfoLvWS getUserinfoLvWSImplPort(WebServiceFeature[] features)
/*    */   {
/* 85 */     return (UserinfoLvWS)super.getPort(UserinfoLvWSImplPort, UserinfoLvWS.class, features);
/*    */   }
/*    */ 
/*    */   static
/*    */   {
/* 28 */     URL url = null;
/*    */     try {
/* 30 */       url = new URL("http://172.25.11.217:8080/Xiangtan_server/userWS?wsdl");
/*    */     } catch (MalformedURLException e) {
/* 32 */       Logger.getLogger(UserinfoLvWSImplService.class.getName())
/* 33 */         .log(Level.INFO, "Can not initialize the default wsdl from {0}", "http://172.25.11.217:8080/Xiangtan_server/userWS?wsdl");
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\2.中心资料\2.项目资料\1.GIS项目\1.湘潭\JS版本\hm_1\WEB-INF\classes\
 * Qualified Name:     com.xiangtan.ws.impl.UserinfoLvWSImplService
 * JD-Core Version:    0.6.2
 */