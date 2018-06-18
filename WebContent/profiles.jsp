<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="com.servlet.model.Profile"%>
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
	     <h3>User Profile List</h3>
	   <img src="img/summary.png" id="himage" style="height: 60px;"/>
  </tr>
  </table>
  <hr/>
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>SNo</th>
        <th>Name</th>
        <th>Email</th>
        <th>Mobile</th>
           <th>Gender</th>
                  <th>Address</th>
                         <th>Image</th>
      </tr>
    </thead>
    <tbody>
    
    <%
    List<Profile>  profilesList=(List<Profile>)request.getAttribute("profilesList");
    int count=1;
    for(Profile profile:profilesList){
    %>
      <tr>
        <td><%=count %></td>
        <td><%=profile.getName() %></td>
             <td><%=profile.getEmail() %></td>
        <td><%=profile.getMobile()%></td>
        <td><%=profile.getGender()%></td>
        <td><%=profile.getAddress()%></td>
        <td><img src="<%=profile.getImage() %>" style="height: 80px;"></td>
      </tr>
      <%
      count++;
      }
    %>
      
    </tbody>
  </table>
	  
</div>
	

</body>
</html>