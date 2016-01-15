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
    图片url:<input name="url" id="url"  type="text" value="http://www.faceplusplus.com.cn/wp-content/themes/faceplusplus/assets/img/demo/9.jpg" />
    <input type="submit" value="提交" />
</form>

</body>
</html>
