<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="../css/authorization.css">
  <link rel="stylesheet" href="../css/commonAutReg.css">
  <title>Authorization page</title>
</head>

<body>
  <header>
    <div id="logo">
      <a href="../index.jsp" target="_self">
        <img src="../images/logoindex.png"/>
      </a> 
    </div> 
    <div id="welcom">
      <h1>AUTHORIZATION</h1>
    </div>
    <div id="regAuth">
      <a href="registration.jsp">Registration</a>
    </div>
  </header>  

  <nav>
    <a href="../index.jsp" target="_self">Home page</a>
  </nav>
  
  <section>
    <form class="form-3" method="post" action="Controller">
      <p class="clearfix">
        <label for="username">Username</label>
        <input type="text" name="username" id="login" placeholder="Username">
      </p>
      <p class="clearfix">
        <label for="password">Password</label>
        <input type="password" name="password" id="password" placeholder="Password">
      </p>
      <p class="clearfix">
        <input type="checkbox" name="remember" id="remember">
        <label for="remember">Remember me</label>
      </p>
      <p class="clearfix">
        <input type="submit" name="submit" value="Enter">
      </p>      
    </form>
  </section>  
  
  <footer>
     <p id="rights">&copy; 2016-2017 VitSoft. All rights are reserved.</p>
  </footer>  
</body>
</html>