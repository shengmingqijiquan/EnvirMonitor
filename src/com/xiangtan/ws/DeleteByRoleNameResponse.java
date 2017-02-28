/*    */ package com.xiangtan.ws;
/*    */ 
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="deleteByRoleNameResponse", propOrder={"_return"})
/*    */ public class DeleteByRoleNameResponse
/*    */ {
/*    */ 
/*    */   @XmlElement(name="return")
/*    */   protected boolean _return;
/*    */ 
/*    */   public boolean isReturn()
/*    */   {
/* 43 */     return this._return;
/*    */   }
/*    */ 
/*    */   public void setReturn(boolean value)
/*    */   {
/* 51 */     this._return = value;
/*    */   }
/*    */ }

/* Location:           E:\2.中心资料\2.项目资料\1.GIS项目\1.湘潭\JS版本\hm_1\WEB-INF\classes\
 * Qualified Name:     com.xiangtan.ws.DeleteByRoleNameResponse
 * JD-Core Version:    0.6.2
 */