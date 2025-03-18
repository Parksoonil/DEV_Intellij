<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>회원 가입</title>
</head>
<body>
    <h2>회원 정보 입력</h2>
    <form action="another/step3" method="post">
    <p>
    <p>
        <label>이메일:<br>
        <input type="text" name="email" />
        </label>
    </p>
    <p>
        <label>이름:<br>
        <input type="text" name="name" />
        </label>
    </p>
    <p>
        <label>비밀번호:<br>
        <input type="password" name="password" />
        </label>
    </p>
    <p>
        <label>비밀번호 확인:<br>
        <input type="password" name="confirmPassword" />
        </label>
    </p>
    <input type="submit" value="가입완료">
    </form>
</body>
</html>
