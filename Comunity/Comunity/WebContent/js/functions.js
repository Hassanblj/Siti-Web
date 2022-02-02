$(document).ready(function() {
	
	//registrazione
	$('#btnSubmit').click(function(e) {
		e.preventDefault();
		var cognome = $('#cognome').val();
		var nome = $('#nome').val();		
		var indirizzo = $('#indirizzo').val();
		var telefono = $('#telefono').val();
		var email = $('#email').val();
		//debug
		console.log('email=' + email);
		var pwd = $('#pwd').val();
		//debug
		console.log('cognome ' + cognome);
		var pwd2 = $('#pwd2').val();
		if (cognome ==="" || nome ==="" || indirizzo ==="" || telefono ==="" || email ==="" || pwd ==="") {
			alert('campi obbligatori');
		} else if (pwd !== pwd2) {
			alert("I password non sono uguali");
		} else if (pwd === pwd2 && pwd !== '') {
			console.log(cognome + nome + indirizzo + telefono + email + pwd);
			var params = {
				cognome:cognome,
				nome: nome,
				indirizzo: indirizzo,
				telefono: telefono,
				email: email,			
				pwd: pwd
				
			};
			$.post('SignUpServlet', params, function(data) {
				alert(data);
				$('#signUpForm')[0].reset();
				$('#signUpModal').modal('hide');
			});

		} else {
			alert('Devi inserire la password');
		}
	});

	// accesso
	$('#btnLogin').click(function(e) {
		e.preventDefault();
		var emailLog = $('#emailLog').val();
		//debug
		console.log('email=' + emailLog);
		var pwdLog = $('#pwdLog').val();
		//debug
		console.log('pwd=' + pwdLog);
		if (!emailLog) {
			alert("Inserisci la tua email");
		} else if (!pwdLog) {
			alert("Inserisci la password");
		} else if (emailLog !== '' && pwdLog !== '') {
			var params = {
				emailLog: emailLog,
				pwdLog: pwdLog
			};
			$.post('LogInServlet', params, function(data) {
				alert(data);
				$('#logInForm')[0].reset();
				$('#logInModal').modal('hide');
			});
		} else {
			alert('Devi inserire email e password');
		}
	});
});