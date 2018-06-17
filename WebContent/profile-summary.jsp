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

</head>

<body style="background-image: url('img/backgrounds.jpg');">
	<header style="height: 45px;background-color: #befff5;">
	  <h2>Learning javaScript</h2> 	
	  	</header>
	  <div class="container">
	  <br/><br/><br/>
	  <table style="width: 100%">
	  <tr>
	  <td style="width:50%">
	     <h3>User Profile Summary</h3>
	   <img src="img/summary.png" id="himage" style="height: 60px;"/>
	   <br/>
	   <form name="profileform" action="add-profile" method="post">
    <div class="form-group">
      <label for="name">Name:
      <span style="color:red;font-size: 20px;">*</span>
      </label>
      <input type="text" class="form-control"  name="name" readonly="readonly" value="${pname}"/>
         <span style="color:red;font-size: 18px;" id="nameError"></span>
    </div>
    
       <div class="form-group">
      <label for="email">Email:
        <span style="color:red;font-size: 20px;">*</span>
      </label>
      <input type="text" class="form-control"  name="email" readonly="readonly" value="${pemail}"/>
       <span style="color:red;font-size: 18px;" id="emailError"></span>
    </div>
    
    
       <div class="form-group">
      <label for="mobile">Mobile:</label>
      <input type="text" class="form-control"  name="mobile" readonly="readonly" value="${pmobile}"/>
         <span style="color:red;font-size: 18px;" id="mobileError"></span>
    </div>
    
    
       <div class="form-group">
      <label for="gender">Gender:</label>
      <select  class="form-control"  name="gender" readonly="readonly">
      	<option ${pgender=='Male'? "selected":""}>Male</option>
      		<option ${pgender=='Female'? "selected":""}>Female</option>
      </select>
    </div>
    
       <div class="form-group">
      <label for="address">Address:</label>
      <textarea  class="form-control"  name="address" cols="20" rows="2" readonly="readonly">${paddress}</textarea>
    </div>
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