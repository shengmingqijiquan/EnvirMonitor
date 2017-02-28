/*     */ package com.xiangtan.ws;
/*     */ 
/*     */ import javax.xml.bind.annotation.XmlAccessType;
/*     */ import javax.xml.bind.annotation.XmlAccessorType;
/*     */ import javax.xml.bind.annotation.XmlType;
/*     */ 
/*     */ @XmlAccessorType(XmlAccessType.FIELD)
/*     */ @XmlType(name="userinfoLv", propOrder={"department", "email", "id", "key", "name", "note", "password", "tel", "truename"})
/*     */ public class UserinfoLv
/*     */ {
/*     */   protected String department;
/*     */   protected String email;
/*     */   protected int id;
/*     */   protected String key;
/*     */   protected String name;
/*     */   protected String note;
/*     */   protected String password;
/*     */   protected String tel;
/*     */   protected String truename;
/*     */ 
/*     */   public String getDepartment()
/*     */   {
/*  69 */     return this.department;
/*     */   }
/*     */ 
/*     */   public void setDepartment(String value)
/*     */   {
/*  81 */     this.department = value;
/*     */   }
/*     */ 
/*     */   public String getEmail()
/*     */   {
/*  93 */     return this.email;
/*     */   }
/*     */ 
/*     */   public void setEmail(String value)
/*     */   {
/* 105 */     this.email = value;
/*     */   }
/*     */ 
/*     */   public int getId()
/*     */   {
/* 113 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(int value)
/*     */   {
/* 121 */     this.id = value;
/*     */   }
/*     */ 
/*     */   public String getKey()
/*     */   {
/* 133 */     return this.key;
/*     */   }
/*     */ 
/*     */   public void setKey(String value)
/*     */   {
/* 145 */     this.key = value;
/*     */   }
/*     */ 
/*     */   public String getName()
/*     */   {
/* 157 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String value)
/*     */   {
/* 169 */     this.name = value;
/*     */   }
/*     */ 
/*     */   public String getNote()
/*     */   {
/* 181 */     return this.note;
/*     */   }
/*     */ 
/*     */   public void setNote(String value)
/*     */   {
/* 193 */     this.note = value;
/*     */   }
/*     */ 
/*     */   public String getPassword()
/*     */   {
/* 205 */     return this.password;
/*     */   }
/*     */ 
/*     */   public void setPassword(String value)
/*     */   {
/* 217 */     this.password = value;
/*     */   }
/*     */ 
/*     */   public String getTel()
/*     */   {
/* 229 */     return this.tel;
/*     */   }
/*     */ 
/*     */   public void setTel(String value)
/*     */   {
/* 241 */     this.tel = value;
/*     */   }
/*     */ 
/*     */   public String getTruename()
/*     */   {
/* 253 */     return this.truename;
/*     */   }
/*     */ 
/*     */   public void setTruename(String value)
/*     */   {
/* 265 */     this.truename = value;
/*     */   }
/*     */ }

/* Location:           E:\2.中心资料\2.项目资料\1.GIS项目\1.湘潭\JS版本\hm_1\WEB-INF\classes\
 * Qualified Name:     com.xiangtan.ws.UserinfoLv
 * JD-Core Version:    0.6.2
 */