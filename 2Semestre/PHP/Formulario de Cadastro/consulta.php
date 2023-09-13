<?PHP

//$host = 'localhost';
//$usuario = 'root';
//$senha = '';
//$banco = 'aluno';

$conexao = mysqli_connect('localhost', 'root', '');
$banco = mysqli_select_db($conexao, 'aluno');
mysqli_set_charset($conexao, 'utf8');
$sql = mysqli_query($conexao, "select * from aluno") or die ("Erro");
while ($dados=mysqli_fecth_assoc($sql)) {
	echo $dados['id'] . ' ';
	echo $dados['nome'] . '<br>;'
}
?>