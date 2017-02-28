package com.xiangtan.ws;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(targetNamespace="http://ws.xiangtan.com/", name="Userinfo_lvWS")
@XmlSeeAlso({ObjectFactory.class})
public abstract interface UserinfoLvWS
{
  @WebMethod(operationName="getUserinfo_lvsLikeSth")
  @RequestWrapper(localName="getUserinfo_lvsLikeSth", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.GetUserinfoLvsLikeSth")
  @ResponseWrapper(localName="getUserinfo_lvsLikeSthResponse", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.GetUserinfoLvsLikeSthResponse")
  @WebResult(name="return", targetNamespace="")
  public abstract List<UserinfoLv> getUserinfoLvsLikeSth(@WebParam(name = "arg0", targetNamespace = "") String paramString1, @WebParam(name = "arg1", targetNamespace = "") String paramString2, @WebParam(name = "arg2", targetNamespace = "") String paramString3, @WebParam(name = "arg3", targetNamespace = "") String paramString4);

  @WebMethod
  @RequestWrapper(localName="update", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.Update")
  @ResponseWrapper(localName="updateResponse", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.UpdateResponse")
  @WebResult(name="return", targetNamespace="")
  public abstract UserinfoLv update(@WebParam(name = "arg0", targetNamespace = "") int paramInt, @WebParam(name = "arg1", targetNamespace = "") String paramString1, @WebParam(name = "arg2", targetNamespace = "") String paramString2, @WebParam(name = "arg3", targetNamespace = "") String paramString3, @WebParam(name = "arg4", targetNamespace = "") String paramString4, @WebParam(name = "arg5", targetNamespace = "") String paramString5, @WebParam(name = "arg6", targetNamespace = "") String paramString6, @WebParam(name = "arg7", targetNamespace = "") String paramString7, @WebParam(name = "arg8", targetNamespace = "") String paramString8, @WebParam(name = "arg9", targetNamespace = "") String paramString9);

  @WebMethod(operationName="getUserinfo_lv")
  @RequestWrapper(localName="getUserinfo_lv", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.GetUserinfoLv")
  @ResponseWrapper(localName="getUserinfo_lvResponse", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.GetUserinfoLvResponse")
  @WebResult(name="return", targetNamespace="")
  public abstract UserinfoLv getUserinfoLv(@WebParam(name = "arg0", targetNamespace = "") int paramInt, @WebParam(name = "arg1", targetNamespace = "") String paramString);

  @WebMethod
  @RequestWrapper(localName="getUsersByPager", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.GetUsersByPager")
  @ResponseWrapper(localName="getUsersByPagerResponse", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.GetUsersByPagerResponse")
  @WebResult(name="return", targetNamespace="")
  public abstract List<UserinfoLv> getUsersByPager(@WebParam(name = "arg0", targetNamespace = "") int paramInt1, @WebParam(name = "arg1", targetNamespace = "") int paramInt2, @WebParam(name = "arg2", targetNamespace = "") String paramString);

  @WebMethod
  @RequestWrapper(localName="login", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.Login")
  @ResponseWrapper(localName="loginResponse", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.LoginResponse")
  @WebResult(name="return", targetNamespace="")
  public abstract UserinfoLv login(@WebParam(name = "arg0", targetNamespace = "") String paramString1, @WebParam(name = "arg1", targetNamespace = "") String paramString2);

  @WebMethod
  @RequestWrapper(localName="getAll", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.GetAll")
  @ResponseWrapper(localName="getAllResponse", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.GetAllResponse")
  @WebResult(name="return", targetNamespace="")
  public abstract List<UserinfoLv> getAll(@WebParam(name = "arg0", targetNamespace = "") String paramString);

  @WebMethod(operationName="getUserinfo_lvsByGroupid")
  @RequestWrapper(localName="getUserinfo_lvsByGroupid", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.GetUserinfoLvsByGroupid")
  @ResponseWrapper(localName="getUserinfo_lvsByGroupidResponse", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.GetUserinfoLvsByGroupidResponse")
  @WebResult(name="return", targetNamespace="")
  public abstract List<UserinfoLv> getUserinfoLvsByGroupid(@WebParam(name = "arg0", targetNamespace = "") int paramInt, @WebParam(name = "arg1", targetNamespace = "") String paramString);

  @WebMethod(operationName="getUserinfo_lvByName")
  @RequestWrapper(localName="getUserinfo_lvByName", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.GetUserinfoLvByName")
  @ResponseWrapper(localName="getUserinfo_lvByNameResponse", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.GetUserinfoLvByNameResponse")
  @WebResult(name="return", targetNamespace="")
  public abstract UserinfoLv getUserinfoLvByName(@WebParam(name = "arg0", targetNamespace = "") String paramString1, @WebParam(name = "arg1", targetNamespace = "") String paramString2);

  @WebMethod
  @RequestWrapper(localName="add", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.Add")
  @ResponseWrapper(localName="addResponse", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.AddResponse")
  @WebResult(name="return", targetNamespace="")
  public abstract UserinfoLv add(@WebParam(name = "arg0", targetNamespace = "") String paramString1, @WebParam(name = "arg1", targetNamespace = "") String paramString2, @WebParam(name = "arg2", targetNamespace = "") String paramString3, @WebParam(name = "arg3", targetNamespace = "") String paramString4, @WebParam(name = "arg4", targetNamespace = "") String paramString5, @WebParam(name = "arg5", targetNamespace = "") String paramString6, @WebParam(name = "arg6", targetNamespace = "") String paramString7, @WebParam(name = "arg7", targetNamespace = "") String paramString8, @WebParam(name = "arg8", targetNamespace = "") String paramString9);

  @WebMethod(operationName="deleteUserinfo_lv")
  @RequestWrapper(localName="deleteUserinfo_lv", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.DeleteUserinfoLv")
  @ResponseWrapper(localName="deleteUserinfo_lvResponse", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.DeleteUserinfoLvResponse")
  @WebResult(name="return", targetNamespace="")
  public abstract boolean deleteUserinfoLv(@WebParam(name = "arg0", targetNamespace = "") int paramInt, @WebParam(name = "arg1", targetNamespace = "") String paramString);
}

/* Location:           E:\2.中心资料\2.项目资料\1.GIS项目\1.湘潭\JS版本\hm_1\WEB-INF\classes\
 * Qualified Name:     com.xiangtan.ws.UserinfoLvWS
 * JD-Core Version:    0.6.2
 */