/*     */ package com.xiangtan.ws;
/*     */ 
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="roleLv", propOrder={"desText", "id", "roleName", "type"})
/*     */ public class RoleLv
/*     */ {
/*     */   protected String desText;
/*     */   protected int id;
/*     */   protected String roleName;
/*     */   protected String type;
/*     */ 
/*     */   public String getDesText()
/*     */   {
/*  54 */     return this.desText;
/*     */   }
/*     */ 
/*     */   public void setDesText(String value)
/*     */   {
/*  66 */     this.desText = value;
/*     */   }
/*     */ 
/*     */   public int getId()
/*     */   {
/*  74 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(int value)
/*     */   {
/*  82 */     this.id = value;
/*     */   }
/*     */ 
/*     */   public String getRoleName()
/*     */   {
/*  94 */     return this.roleName;
/*     */   }
/*     */ 
/*     */   public void setRoleName(String value)
/*     */   {
/* 106 */     this.roleName = value;
/*     */   }
/*     */ 
/*     */   public String getType()
/*     */   {
/* 118 */     return this.type;
/*     */   }
/*     */ 
/*     */   public void setType(String value)
/*     */   {
/* 130 */     this.type = value;
/*     */   }
/*     */ }

/* Location:           E:\2.中心资料\2.项目资料\1.GIS项目\1.湘潭\JS版本\hm_1\WEB-INF\classes\
 * Qualified Name:     com.xiangtan.ws.RoleLv
 * JD-Core Version:    0.6.2
 */