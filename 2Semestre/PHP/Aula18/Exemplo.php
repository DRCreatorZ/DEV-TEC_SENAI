<?php
    
    //session_set_cookie_params(['lifetime'=> 10]);
    
    session_set_cookie_params(['httpOnly'=> true]);

    session_start();
    var_dump(session_id());
    session_regenerate_id();
    
    $_SESSION['nome'] = "Maria Silva";
   // $_SESSION['nome'] = "João Souza";

    

    echo "<a href='sessao01.php'><button>Teste Sessão 01</button></a>";
?>