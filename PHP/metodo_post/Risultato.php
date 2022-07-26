<html>
<head>
<title>Metodo post</title>
</head>

<body>
	<?php
		print_r($_POST); //stampo l'array
		echo "<br/>";
		$username = $_POST['username']; // assegno ad una variabile l'elemento username
		$password = $_POST['password']; // assegno ad una variabile l'elemento password
		
		echo $username . " " . $password;// stampo l'elemento username e password
	?>
</body>
</html>
