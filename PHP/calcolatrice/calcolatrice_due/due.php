<HTML>
	<BODY>
		<?php
        	if(isset($_POST['B1']))
         	{
         	   echo $_POST['T1'] + $_POST['T2'];
         	}
			else
			{
         		if(isset($_POST['B2']))
		    	{
		        	echo $_POST['T1'] - $_POST['T2'];
         		}
				else
				{
         			if(isset($_POST['B3']))
		    		{
		  			    echo $_POST['T1'] * $_POST['T2'];
         			}
					else
					{
         				if(isset($_POST['B4']))
		    			{
		 				    echo $_POST['T1'] / $_POST['T2'];
         				}
         				else
         				{
         					echo "NESSUN DATO";
         				}
         			}
         		}
         	}
         ?>
     </BODY>
</HTML>