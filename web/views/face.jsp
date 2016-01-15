<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/1/8 0008
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>人脸识别</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/face/upload.do" method="post" enctype="multipart/form-data">
    <input name="file" id="imgFile" type="file" />
    <input type="submit" value="上传" />
</form>

<form action="${pageContext.request.contextPath}/face/allface.do" method="post" >
    百度logo:https://www.baidu.com/img/bd_logo1.png<br>
    双人头像:http://img4.cache.netease.com/ent/2016/1/13/2016011321071571817.jpg<br>
    单人侧面头像:http://e.hiphotos.baidu.com/baike/w%3D480/sign=c6677012be12c8fcb4f3f7c5cc0292b4/83025aafa40f4bfb4f019c66044f78f0f736182a.jpg<br>
    单人正脸头像:http://upload.cbg.cn/2015/1120/1447990413976.jpg<br>
    图片url:<input name="url" id="url" style="width: 1000px;"  type="text" value="http://www.faceplusplus.com.cn/wp-content/themes/faceplusplus/assets/img/demo/9.jpg" />
    <input type="submit" value="提交" />
</form>

</body>
</html>
