/**
 * Created by Apache CXF WadlToJava code generator
**/
package cn.zhangpeng.springcxf.client;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/user")
public interface UserResource {

    @GET
    @Produces("application/json")
    @Path("/getUser/{id}")
    Response getGetUserid(@PathParam("id") int id);

    @GET
    @Produces("application/xml")
    @Path("/getUserList/{name}")
    Response getGetUserListname(@PathParam("name") String name);

}