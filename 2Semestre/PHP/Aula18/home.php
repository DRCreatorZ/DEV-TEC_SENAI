<?php

    session_start();

    if (isset($_SESSION['username'])) {

        var_dump($_SESSION['username']);

        echo "<br>";

        $_SESSION['username'] = "admin";
        $_SESSION['password'] = "1234";

        echo $_SESSION['username'] . "<br>";
        echo $_SESSION['password'] . "<br>";

        echo session_id() . "<br>";
    }
?>