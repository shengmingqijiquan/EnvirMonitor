/*    */ package com.xiangtan.ws.impl;
/*    */ 
/*    */ import com.xiangtan.ws.RoleLvWS;
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
/*    */ @WebServiceClient(name="Role_lvWSImplService", wsdlLocation="http://172.25.11.217:8080/Xiangtan_server/roleWS?wsdl", targetNamespace="http://impl.ws.xiangtan.com/")
/*    */ public class RoleLvWSImplService extends Service
/*    */ {
/* 36 */   public static final URL WSDL_LOCATION = url;
/*    */ 
/* 25 */   public static final QName SERVICE = new QName("http://impl.ws.xiangtan.com/", "Role_lvWSImplService");
/* 26 */   public static final QName RoleLvWSImplPort = new QName("http://impl.ws.xiangtan.com/", "Role_lvWSImplPort");
/*    */ 
/*    */   public RoleLvWSImplService(URL wsdlLocation)
/*    */   {
/* 40 */     super(wsdlLocation, SERVICE);
/*    */   }
/*    */ 
/*    */   public RoleLvWSImplService(URL wsdlLocation, QName serviceName) {
/* 44 */     super(wsdlLocation, serviceName);
/*    */   }
/*    */ 
/*    */   public RoleLvWSImplService() {
/* 48 */     super(WSDL_LOCATION, SERVICE);
/*    */   }
/*    */ 
/*    */   public RoleLvWSImplService(WebServiceFeature[] features) {
/* 52 */     super(WSDL_LOCATION, SERVICE, features);
/*    */   }
/*    */ 
/*    */   public RoleLvWSImplService(URL wsdlLocation, WebServiceFeature[] features) {
/* 56 */     super(wsdlLocation, SERVICE, features);
/*    */   }
/*    */ 
/*    */   public RoleLvWSImplService(URL wsdlLocation, QName serviceName, WebServiceFeature[] features) {
/* 60 */     super(wsdlLocation, serviceName, features);
/*    */   }
/*    */ 
/*    */   @WebEndpoint(name="Role_lvWSImplPort")
/*    */   public RoleLvWS getRoleLvWSImplPort()
/*    */   {
/* 73 */     return (RoleLvWS)super.getPort(RoleLvWSImplPort, RoleLvWS.class);
/*    */   }
/*    */ 
/*    */   @WebEndpoint(name="Role_lvWSImplPort")
/*    */   public RoleLvWS getRoleLvWSImplPort(WebServiceFeature[] features)
/*    */   {
/* 85 */     return (RoleLvWS)super.getPort(RoleLvWSImplPort, RoleLvWS.class, features);
/*    */   }
/*    */ 
/*    */   static
/*    */   {
/* 28 */     URL url = null;
/*    */     try {
/* 30 */       url = new URL("http://172.25.11.217:8080/Xiangtan_server/roleWS?wsdl");
/*    */     } catch (MalformedURLException e) {
/* 32 */       Logger.getLogger(RoleLvWSImplService.class.getName())
/* 33 */         .log(Level.INFO, "Can not initialize the default wsdl from {0}", "http://172.25.11.217:8080/Xiangtan_server/roleWS?wsdl");
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\2.中心资料\2.项目资料\1.GIS项目\1.湘潭\JS版本\hm_1\WEB-INF\classes\
 * Qualified Name:     com.xiangtan.ws.impl.RoleLvWSImplService
 * JD-Core Version:    0.6.2
 */