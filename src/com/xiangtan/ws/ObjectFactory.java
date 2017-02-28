/*     */ package com.xiangtan.ws;
/*     */ 
/*     */ import javax.xml.bind.JAXBElement;
/*     */ import javax.xml.bind.annotation.XmlElementDecl;
/*     */ import javax.xml.bind.annotation.XmlRegistry;
/*     */ import javax.xml.namespace.QName;
/*     */ 
/*     */ @XmlRegistry
/*     */ public class ObjectFactory
/*     */ {
/*  27 */   private static final QName _GetAreaByCode_QNAME = new QName("http://ws.xiangtan.com/", "getAreaByCode");
/*  28 */   private static final QName _GetAreaByCodeResponse_QNAME = new QName("http://ws.xiangtan.com/", "getAreaByCodeResponse");
/*  29 */   private static final QName _GetSubAreasByCode_QNAME = new QName("http://ws.xiangtan.com/", "getSubAreasByCode");
/*  30 */   private static final QName _GetSubAreasByCodeResponse_QNAME = new QName("http://ws.xiangtan.com/", "getSubAreasByCodeResponse");
/*     */ 
/*     */   public GetAreaByCode createGetAreaByCode()
/*     */   {
/*  44 */     return new GetAreaByCode();
/*     */   }
/*     */ 
/*     */   public GetAreaByCodeResponse createGetAreaByCodeResponse()
/*     */   {
/*  52 */     return new GetAreaByCodeResponse();
/*     */   }
/*     */ 
/*     */   public GetSubAreasByCode createGetSubAreasByCode()
/*     */   {
/*  60 */     return new GetSubAreasByCode();
/*     */   }
/*     */ 
/*     */   public GetSubAreasByCodeResponse createGetSubAreasByCodeResponse()
/*     */   {
/*  68 */     return new GetSubAreasByCodeResponse();
/*     */   }
/*     */ 
/*     */   public Area createArea()
/*     */   {
/*  76 */     return new Area();
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="http://ws.xiangtan.com/", name="getAreaByCode")
/*     */   public JAXBElement<GetAreaByCode> createGetAreaByCode(GetAreaByCode value)
/*     */   {
/*  85 */     return new JAXBElement(_GetAreaByCode_QNAME, GetAreaByCode.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="http://ws.xiangtan.com/", name="getAreaByCodeResponse")
/*     */   public JAXBElement<GetAreaByCodeResponse> createGetAreaByCodeResponse(GetAreaByCodeResponse value)
/*     */   {
/*  94 */     return new JAXBElement(_GetAreaByCodeResponse_QNAME, GetAreaByCodeResponse.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="http://ws.xiangtan.com/", name="getSubAreasByCode")
/*     */   public JAXBElement<GetSubAreasByCode> createGetSubAreasByCode(GetSubAreasByCode value)
/*     */   {
/* 103 */     return new JAXBElement(_GetSubAreasByCode_QNAME, GetSubAreasByCode.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="http://ws.xiangtan.com/", name="getSubAreasByCodeResponse")
/*     */   public JAXBElement<GetSubAreasByCodeResponse> createGetSubAreasByCodeResponse(GetSubAreasByCodeResponse value)
/*     */   {
/* 112 */     return new JAXBElement(_GetSubAreasByCodeResponse_QNAME, GetSubAreasByCodeResponse.class, null, value);
/*     */   }
/*     */ }

/* Location:           E:\2.中心资料\2.项目资料\1.GIS项目\1.湘潭\JS版本\hm_1\WEB-INF\classes\
 * Qualified Name:     com.xiangtan.ws.ObjectFactory
 * JD-Core Version:    0.6.2
 */