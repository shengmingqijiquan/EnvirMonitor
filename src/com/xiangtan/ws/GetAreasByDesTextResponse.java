/*    */ package com.xiangtan.ws;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.xml.bind.annotation.XmlAccessType;
/*    */ import javax.xml.bind.annotation.XmlAccessorType;
/*    */ import javax.xml.bind.annotation.XmlElement;
/*    */ import javax.xml.bind.annotation.XmlType;
/*    */ 
/*    */ @XmlAccessorType(XmlAccessType.FIELD)
/*    */ @XmlType(name="getAreasByDesTextResponse", propOrder={"_return"})
/*    */ public class GetAreasByDesTextResponse
/*    */ {
/*    */ 
/*    */   @XmlElement(name="return")
/*    */   protected List<Area> _return;
/*    */ 
/*    */   public List<Area> getReturn()
/*    */   {
/* 63 */     if (this._return == null) {
/* 64 */       this._return = new ArrayList();
/*    */     }
/* 66 */     return this._return;
/*    */   }
/*    */ }

/* Location:           E:\2.中心资料\2.项目资料\1.GIS项目\1.湘潭\JS版本\hm_1\WEB-INF\classes\
 * Qualified Name:     com.xiangtan.ws.GetAreasByDesTextResponse
 * JD-Core Version:    0.6.2
 */