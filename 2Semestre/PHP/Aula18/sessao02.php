<?php

    session_start();

        $_SESSION['username'] = "admin";
        $_SESSION['password'] = "1234";

        echo $_SESSION['username'] . "<br>";
        echo $_SESSION['password'] . "<br>";

        echo session_id() . "<br>";
?>