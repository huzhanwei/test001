<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>书籍数据</title>
</head>
<body>
    <h1>Please input disaster data!</h1>
    <form action="BookSevice" name="form">
        <p>
        <table border="1">
            <tr>
                <td>书籍Id</td>
                <td>书籍名称</td>
                <td>书籍作者</td>
                <td>书籍价格</td>
            </tr>
            <tr>
                <td><input name="bookId" type="text" /></td>
                <td><input name="bookName" type="text" /></td>
                <td><input name="bookAuthor" type="text" /></td>
                <td><input name="bookPice" type="text" /></td>
            </tr>
        </table>
        </p>
        <tr>
            <td><input type="submit" value="确定" size="50" /></td>
            <td><input type="reset" value="取消" size="50" /></td>
        </tr>
    </form>
</body>
</html>