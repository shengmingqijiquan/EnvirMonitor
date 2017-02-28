package com.xiangtan.ws;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(targetNamespace="http://ws.xiangtan.com/", name="Role_lvWS")
@XmlSeeAlso({ObjectFactory.class})
public abstract interface RoleLvWS
{
  @WebMethod
  @RequestWrapper(localName="getAreasByDesText", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.GetAreasByDesText")
  @ResponseWrapper(localName="getAreasByDesTextResponse", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.GetAreasByDesTextResponse")
  @WebResult(name="return", targetNamespace="")
  public abstract List<Area> getAreasByDesText(@WebParam(name = "arg0", targetNamespace = "") String paramString1, @WebParam(name = "arg1", targetNamespace = "") String paramString2);

  @WebMethod(operationName="updateRole_lv")
  @RequestWrapper(localName="updateRole_lv", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.UpdateRoleLv")
  @ResponseWrapper(localName="updateRole_lvResponse", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.UpdateRoleLvResponse")
  @WebResult(name="return", targetNamespace="")
  public abstract RoleLv updateRoleLv(@WebParam(name = "arg0", targetNamespace = "") int paramInt, @WebParam(name = "arg1", targetNamespace = "") String paramString1, @WebParam(name = "arg2", targetNamespace = "") String paramString2, @WebParam(name = "arg3", targetNamespace = "") String paramString3, @WebParam(name = "arg4", targetNamespace = "") String paramString4);

  @WebMethod(operationName="addRole_lv")
  @RequestWrapper(localName="addRole_lv", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.AddRoleLv")
  @ResponseWrapper(localName="addRole_lvResponse", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.AddRoleLvResponse")
  @WebResult(name="return", targetNamespace="")
  public abstract RoleLv addRoleLv(@WebParam(name = "arg0", targetNamespace = "") String paramString1, @WebParam(name = "arg1", targetNamespace = "") String paramString2, @WebParam(name = "arg2", targetNamespace = "") String paramString3, @WebParam(name = "arg3", targetNamespace = "") String paramString4);

  @WebMethod(operationName="getRole_lv")
  @RequestWrapper(localName="getRole_lv", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.GetRoleLv")
  @ResponseWrapper(localName="getRole_lvResponse", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.GetRoleLvResponse")
  @WebResult(name="return", targetNamespace="")
  public abstract RoleLv getRoleLv(@WebParam(name = "arg0", targetNamespace = "") int paramInt, @WebParam(name = "arg1", targetNamespace = "") String paramString);

  @WebMethod(operationName="getAll")
  @RequestWrapper(localName="getAll", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.GetAll")
  @ResponseWrapper(localName="GetAllResponse", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.GetAllResponse")
  @WebResult(name="return", targetNamespace="")
  public abstract List<RoleLv> getAll(@WebParam(name = "arg0", targetNamespace = "") String paramString);

  @WebMethod(operationName="getAllRoles")
  @RequestWrapper(localName="getAllRoles", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.GetAllRoles")
  @ResponseWrapper(localName="getAllRolesResponse", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.GetAllRolesResponse")
  @WebResult(name="return", targetNamespace="")
  public abstract List<RoleLv> getAllRoles(@WebParam(name = "arg0", targetNamespace = "") String paramString);

  @WebMethod(operationName="getRole_lvsByUserid")
  @RequestWrapper(localName="getRole_lvsByUserid", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.GetRoleLvsByUserid")
  @ResponseWrapper(localName="getRole_lvsByUseridResponse", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.GetRoleLvsByUseridResponse")
  @WebResult(name="return", targetNamespace="")
  public abstract List<RoleLv> getRoleLvsByUserid(@WebParam(name = "arg0", targetNamespace = "") int paramInt, @WebParam(name = "arg1", targetNamespace = "") String paramString);

  @WebMethod
  @RequestWrapper(localName="deleteByRoleName", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.DeleteByRoleName")
  @ResponseWrapper(localName="deleteByRoleNameResponse", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.DeleteByRoleNameResponse")
  @WebResult(name="return", targetNamespace="")
  public abstract boolean deleteByRoleName(@WebParam(name = "arg0", targetNamespace = "") String paramString1, @WebParam(name = "arg1", targetNamespace = "") String paramString2);

  @WebMethod
  @RequestWrapper(localName="deleteByRoleId", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.DeleteByRoleId")
  @ResponseWrapper(localName="deleteByRoleIdResponse", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.DeleteByRoleIdResponse")
  @WebResult(name="return", targetNamespace="")
  public abstract boolean deleteByRoleId(@WebParam(name = "arg0", targetNamespace = "") int paramInt, @WebParam(name = "arg1", targetNamespace = "") String paramString);

  @WebMethod
  @RequestWrapper(localName="getRolesByPager", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.GetRolesByPager")
  @ResponseWrapper(localName="getRolesByPagerResponse", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.GetRolesByPagerResponse")
  @WebResult(name="return", targetNamespace="")
  public abstract List<RoleLv> getRolesByPager(@WebParam(name = "arg0", targetNamespace = "") int paramInt1, @WebParam(name = "arg1", targetNamespace = "") int paramInt2, @WebParam(name = "arg2", targetNamespace = "") String paramString);

  @WebMethod
  @RequestWrapper(localName="getByRoleName", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.GetByRoleName")
  @ResponseWrapper(localName="getByRoleNameResponse", targetNamespace="http://ws.xiangtan.com/", className="com.xiangtan.GetByRoleNameResponse")
  @WebResult(name="return", targetNamespace="")
  public abstract RoleLv getByRoleName(@WebParam(name = "arg0", targetNamespace = "") String paramString1, @WebParam(name = "arg1", targetNamespace = "") String paramString2);
}

/* Location:           E:\2.中心资料\2.项目资料\1.GIS项目\1.湘潭\JS版本\hm_1\WEB-INF\classes\
 * Qualified Name:     com.xiangtan.ws.RoleLvWS
 * JD-Core Version:    0.6.2
 */