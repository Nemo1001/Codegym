<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form action="/Calculate" method="get">
    <table>
        <tr>
            <th colspan="4"><h1>Calculator</h1></th>
        </tr>
        <tr>
            <td></td>
            <td><input type="text" placeholder="0" name="firstOperand"></td>
            <td><input type="text" placeholder="0" name="secondOperand"></td>
            <td></td>
        </tr>
        <tr>
            <td><input type="submit"  value="Addition(+)" name="operator"></td>
            <td><input type="submit"  value="Subtraction(-)" name="operator"></td>
            <td><input type="submit"  value="Multiplication(*)" name="operator"></td>
            <td><input type="submit"  value="Division(/)" name="operator"></td>
        </tr>

    </table>
    <h2><span> <tr>Result: ${result}</h2></span></tr>
</form>
</body>
</html>