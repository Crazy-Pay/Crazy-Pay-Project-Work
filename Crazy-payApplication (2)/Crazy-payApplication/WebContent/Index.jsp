<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
<title>Insert title here</title>
    <style>
      
        a.nav-link:hover{
    background-color: #56baed;
    
  }
  
  body {
    font-family: "Poppins", sans-serif;
    height: 100vh;
    
    background: #00c6ff; /* fallback for old browsers */
    background: -webkit-linear-gradient(to right, #00c6ff, #0072ff); /* Chrome 10-25, Safari 5.1-6 */
    background: linear-gradient(to right, #00c6ff, #0072ff); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
  
  }
  
  a {
    color: #92badd;
    display:inline-block;
    text-decoration: none;
    font-weight: 400;
  }
  
  h1{
    text-align: center;
    font-size: 300px;
    font-weight: 900;
    text-transform: uppercase;
    display:inline-block;
    margin: 40px 8px 10px 8px; 
    color: white;
  }
  
  
  
  input[type=button], input[type=submit], input[type=reset]  {
    font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
    font-size:larger;
    background-color: white;
    border: none;
    color: grey;
    padding: 15px 80px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    text-transform: uppercase;
    font-size: 13px;
    -webkit-box-shadow: 0 10px 30px 0 rgba(95,186,233,0.4);
    box-shadow: 0 10px 30px 0 rgba(95,186,233,0.4);
    -webkit-border-radius: 5px 5px 5px 5px;
    border-radius: 5px 5px 5px 5px;
    margin: 5px 20px 40px 20px;
  }
  
  nav-link:hover{
  background-color:#56baed ;
  
  }
      </style>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
</head>
<body>
    <header>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
          <div class="container-fluid">
            <img src="photo/crazzy.png" width="150" height="75">
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
              <ul class="navbar-nav">
                
                <li class="nav-item">
                  <a class="nav-link" href="login.jsp" style="font-size:large;color: black;">Login</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="Features.html" style="font-size:large;color: black;">Features</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Do's&dont.html" style="font-size:large;color: black;">Do's & Don't</a>
                  
                  <li class="nav-item">
                    <a class="nav-link" href="FAQ.html" style="font-size:large;color: black;">FAQ</a>
                  </li>
              </header>
<center>
<br><br><h1>Click on the Above Button to Link your Bank Account</h1><br/><br/>
<b><a href="BankList"><input type="button" value="Link your Bank Account"></a></b>
</center>
           
<script  src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>
</body>
</html>