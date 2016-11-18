<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="../css/registration.css">
  <link rel="stylesheet" href="../css/commonAutReg.css">
  <title>Registration page</title>
</head>

<body>
  <header>
    <div id="logo">
      <a href="../index.jsp" target="_self">
        <img src="../images/logoindex.png"/>
      </a> 
    </div> 
    <div id="welcom">
      <h1>REGISTRATION</h1>
    </div>
    <div id="regAuth">
      <a href="authorization.jsp">Authorization</a>
    </div>
  </header>  

  <nav>
    <a href="../index.jsp" target="_self">Home page</a>
  </nav>
  
  <section>
  <table id="registerForm">
  <tr>
  <td>
    <form class="contact_form" action="#" method="post" name="contact_form">
      <ul>
        <li>
          <span class="required_notification">* Denotes Required Field</span>
          <label for="firstname">First Name:</label>
          <input type="text"  placeholder="Ivan Ivanov" required />
        </li>
        <li>
          <label for="secondname"> Second Name:</label>
	  <input type="text"  placeholder="Ivan Ivanov" required />
        </li>
        <li>
          <label for="email">Email:</label>
          <input type="email" name="email" placeholder="ivan_ivanov@gmail.com" required />
          <span class="form_hint">Proper format "name@xxx.com"</span>
        </li>
        <li>
          <label for="website">Website:</label>
          <input type="url" name="website" placeholder="http://ivanov.com" required pattern="(http|https)://.+"/>
          <span class="form_hint">Proper format "http://xxx.com"</span>
        </li>
        <li>
          <label for="message">Message:</label>
          <textarea name="message" cols="40" rows="6" required ></textarea>
        </li>
        <li>
          <button class="submit" type="submit">Sign up</button>
        </li>
      </ul>
    </form>
    </td>
    </tr>
    </table>
  </section>  
  
  <footer>
     <p id="rights">&copy; 2016-2017 VitSoft. All rights are reserved.</p>
  </footer>  
</body>
</html>