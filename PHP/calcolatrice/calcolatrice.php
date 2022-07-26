<HTML>
	<BODY>
		<?php
			$r=0;
    		if(isset($_POST['B1']))
    	    {
    		    $r = $_POST['T1'] + $_POST['T2'];
    	    }

    	    if(isset($_POST['B2']))
			{
			    $r = $_POST['T1'] - $_POST['T2'];
    	    }

    	    if(isset($_POST['B3']))
			{
			    $r = $_POST['T1'] * $_POST['T2'];
    	    }

    	    if(isset($_POST['B4']))
			{
			    $r = $_POST['T1'] / $_POST['T2'];
    	    }
    	?>
    	<FORM name='F1' method='post'>
		    <INPUT type='text' name='T1' size='6' />
		    <INPUT type='text' name='T2' size='6' /><BR><BR>
		    <INPUT type='submit' name='B1' value=' + ' />
		    <INPUT type='submit' name='B2' value=' - ' />
		    <INPUT type='submit' name='B3' value=' * ' />
		    <INPUT type='submit' name='B4' value=' / ' /><BR><BR>
		    <INPUT type='text' name='T3' size='6' value='<?php  echo $r; ?>'/>
      	</FORM>
	</BODY>
</HTML>