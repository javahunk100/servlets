<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<title>WOW</title>
	<script type="text/javascript">

	/**
	 * This method is used to clear error message from the screen
	 */
	function clearErrorMessage() {
		document.getElementById("nameError").innerHTML = "";
		document.getElementById("emailError").innerHTML = "";
		document.getElementById("mobileError").innerHTML = "";

	}

	function validateForm() {
		var name = document.profileform.name.value;
		if (name.length == 0) {
			document.getElementById("nameError").innerHTML = "Name cannot be empty."
			document.profileform.name.focus();
			return;
		}

		var email = document.profileform.email.value;
		if (email.length == 0) {
			document.getElementById("emailError").innerHTML = "Email cannot be empty."
			document.profileform.email.focus();
			return;
		}

		var mobile = document.profileform.mobile.value;
		if (mobile.length == 0) {
			document.getElementById("mobileError").innerHTML = "Mobile cannot be empty."
			document.profileform.mobile.focus();
			return;
		} else {
			var phoneno = /^\d{10}$/;
			if (!mobile.match(phoneno)) {
				document.getElementById("mobileError").innerHTML = "Mobile is not valid.";
				document.profileform.mobile.focus();
				return;
			}
		}
		
		//submit form throgh JavaScript
		document.profileform.submit();

	} //end of validateForm method
	
	</script>
</head>
<body>
	<header style="height: 45px;background-color: #befff5;">
	  <h2>Learning javaScript</h2> 	
	  	</header>
	  <div class="container">
	  <br/><br/><br/>
	  <table style="width: 100%">
	  <tr>
	  <td style="width:50%">
	     <h3>User Profile Form</h3>
	   <img src="img/math.png" id="himage" style="height: 60px;"/>
	   	<a href="profiles"><img src="img/show-proifles.jpg" style="height: 100px;">Click Here to view profiles</a>
	   <br/>
	   <form name="loginForm" action="auth" method="post">
    <div class="form-group">
      <label for="name">Username:
      <span style="color:red;font-size: 20px;">*</span>
      </label>
      <input type="text" class="form-control"  name="username"/>
         <span style="color:red;font-size: 18px;" id="nameError"></span>
    </div>
    
       <div class="form-group">
      <label for="password">Password:
        <span style="color:red;font-size: 20px;">*</span>
      </label>
      <input type="password" class="form-control"  name="password"/>
       <span style="color:red;font-size: 18px;" id="emailError"></span>
    </div>
    
    <button type="submit" class="btn btn-danger">Login</button>
     <button type="reset" class="btn btn-primary">Clear</button>
    <hr/>
  </form>
	  </td>
		<td style="width: 50%;margin-left: 100px;padding-left: 30px;">
		 	<img src="img/services-students1.png" style=";">
		</td>	
  </tr>
  </table>
	  
</div>
	

</body>
</html>