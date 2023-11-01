<?php

$senha = "123456";
$cripto = base64_encode($senha);
$descripto = base64_decode($cripto);

echo "Base64 (senha): " .$senha. "<br>";
echo "Base64 (encode): " .$cripto. "<br>";
echo "Base64 (decode): " .$descripto. "<br>";
echo "<br><hr>";

echo "MD5 (senha): " .$senha. "<br>";
echo "MD5 (encode): " .md5($senha). "<br>";
echo "<br><hr>";

echo "SHA1 (senha): " .$senha. "<br>";
echo "SHA1 (encode): " .sha1($senha). "<br>";
echo "<br><hr>";