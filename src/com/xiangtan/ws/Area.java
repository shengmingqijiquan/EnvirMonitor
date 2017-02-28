/*     */ package com.xiangtan.ws;
/*     */ 
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="area", propOrder={"areaCode", "areaLevel", "areaName", "completeAddress", "subAreaNum"})
/*     */ public class Area
/*     */ {
/*     */   protected String areaCode;
/*     */   protected int areaLevel;
/*     */   protected String areaName;
/*     */   protected String completeAddress;
/*     */   protected int subAreaNum;
/*     */ 
/*     */   public String getAreaCode()
/*     */   {
/*  57 */     return this.areaCode;
/*     */   }
/*     */ 
/*     */   public void setAreaCode(String value)
/*     */   {
/*  69 */     this.areaCode = value;
/*     */   }
/*     */ 
/*     */   public int getAreaLevel()
/*     */   {
/*  77 */     return this.areaLevel;
/*     */   }
/*     */ 
/*     */   public void setAreaLevel(int value)
/*     */   {
/*  85 */     this.areaLevel = value;
/*     */   }
/*     */ 
/*     */   public String getAreaName()
/*     */   {
/*  97 */     return this.areaName;
/*     */   }
/*     */ 
/*     */   public void setAreaName(String value)
/*     */   {
/* 109 */     this.areaName = value;
/*     */   }
/*     */ 
/*     */   public String getCompleteAddress()
/*     */   {
/* 121 */     return this.completeAddress;
/*     */   }
/*     */ 
/*     */   public void setCompleteAddress(String value)
/*     */   {
/* 133 */     this.completeAddress = value;
/*     */   }
/*     */ 
/*     */   public int getSubAreaNum()
/*     */   {
/* 141 */     return this.subAreaNum;
/*     */   }
/*     */ 
/*     */   public void setSubAreaNum(int value)
/*     */   {
/* 149 */     this.subAreaNum = value;
/*     */   }
/*     */ }

/* Location:           E:\2.中心资料\2.项目资料\1.GIS项目\1.湘潭\JS版本\hm_1\WEB-INF\classes\
 * Qualified Name:     com.xiangtan.ws.Area
 * JD-Core Version:    0.6.2
 */