<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formularz</title>
</head>
<body>
<h1>Podaj swoje dane:</h1>
<form action="userdata" method="post">
    <fieldset>
        <legend>Wpisz hasło które ma zostac sprawdzone</legend>
        <label for="password">Hasło</label>
        <input type="password" name="pass" id="password"><br>
    </fieldset>
    <input type="submit" value="Sprawdź">
</form>
</body>
</html>