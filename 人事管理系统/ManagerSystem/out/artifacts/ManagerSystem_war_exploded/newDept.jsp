<%--
  Created by IntelliJ IDEA.
  User: 38198
  Date: 2020/9/1
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div>
    <form action="JobServlet" method="post">
        <table>
            <tr><td>部门编号:</td><td><input type="text" name="dept"/></td></tr>
            <tr><td>部门名称:</td><td><input type="text" name="dname"/></td></tr>
            <tr>
                <td>部门类型:</td>
                <td>
                    <select name="dtype">
                        <option value="1">公司</option>
                        <option value="2" selected="selected">部门</option>
                    </select>
                </td>
            </tr>
            <tr><td>部门电话:</td><td><input type="text" name="dtel"/></td></tr>
            <tr><td>部门传真:</td><td><input type="text" name="demail"/></td></tr>
            <tr><td>部门描述:</td><td><input type="text" name="dmiaoshu"/></td></tr>
            <tr><td>上级部门:</td><td><input type="text" name="ddescribe"/></td></tr>
            <tr><td>成立日期:</td><td><input type="date" name="ddate"/></td></tr>
        </table>
        <input type="submit" value="提交">
    </form>

</div>
</body>
</html>
