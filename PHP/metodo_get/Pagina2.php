<html>
<head>
<title>Pagina 2</title>
</head>

<body>
	Questa è la seconda pagina del nostro esempio<br/>
   <?php
		print_r($_GET);// stampo il parametro passato che diventa un array
               	$str = $_GET["prova"]; // assegno il parametro ad una variabile
		echo "<br/>" . $str; // stampo la variabile
	?>
</body>
</html>
