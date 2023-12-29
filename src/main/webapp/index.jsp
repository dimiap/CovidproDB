<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <title>COVIDproDB</title>
</head>

<body>
<header class="bg-light">
    <div class="home-header">
        <div class="header-logo">
            <a class="navbar-brand" href="index.jsp">
                <img src="logo.png" width="60" height="60">
            </a>
        </div>
        <div class="nav-links">
            <a class="headerlink4" href="contact.jsp">Contact us</a>
        </div>
        <a class="dashboard" href="loginAdmin.jsp"><div class="header-login"> Dashboard  </div></a>
    </div>
</header>
<div class="home-sct1-wrapper">
    <div class="home-sct1">
        <h1> COVIDproDB </h1>
        <h2> Information about the structural classification the subcellular location, length, gene names, annotation, description and information about the entry in Uniprot.</h2>
        <div class="home-services">
            <a class="servicelink1" href="ShowAllServlet">Show All Proteins</a>
        </div>
    </div>
</div>
<div class="home-sct2-wrapper">
    <div class="home-sct2">
        <div class="home-sct2-clm1">
        </div>
        <div class="home-sct2-clm2">
        </div>
        <!--<form action="AdvancedSearchServlet" method = "GET">

        </form> -->
        <form action="AdvancedSearchServlet" method ="GET">
            <div class="input-group">
                <input type="text" name="searchTerm" id ="searchTerm" class="form-control rounded" placeholder="Search" aria-label="searchTerm" aria-describedby="search-addon" />
                <button type="submit" class="btn btn-outline-primary"> Search </button>
            </div>
            <a data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample" class="advanced">
                Advanced Search with Filters  <i class="fa fa-angle-down"></i>
            </a>
            <div class="collapse" id="collapseExample">
                <div class="card card-body">
                    <div class="row">
                        <div class="col-md-4">
                            <select name="logicGates1" class = "form-select" aria-label="Logic Gates 1">
                                <option selected>Select Logic Gate For Entry Name</option>
                                <option value="AND">AND</option>
                                <option value="OR">OR</option>
                            </select>
                            <div class="input-group">
                                <select name="notOrNo1" class = "form-select" aria-label="Not">
                                    <option selected> </option>
                                    <option value="NOT"> NOT</option>
                                </select>
                                <input type="text" name = "entry_name" placeholder="Entry Name" class="form-control">
                            </div>
                        </div>
                        <div class="col-md-4">
                            <select name="logicGates2" class = "form-select" aria-label="Logic Gates 2">
                                <option selected>Select Logic Gate For Organism</option>
                                <option value="AND">AND</option>
                                <option value="OR">OR</option>
                            </select>
                            <div class="input-group">
                                <select name="notOrNo2" class = "form-select" aria-label="Not">
                                    <option selected> </option>
                                    <option value="NOT"> NOT</option>
                                </select>
                                <input type="text" class="form-control" name ="organism" placeholder="Organism">
                            </div>
                        </div>
                        <div class="col-md-4">
                            <select name="logicGates3" class = "form-select" aria-label="Logic Gates 3">
                                <option selected>Select Logic Gate For 3D Structure</option>
                                <option value="AND">AND</option>
                                <option value="OR">OR</option>
                            </select>
                            <div class="input-group">
                                <select name="notOrNo3" class = "form-select" aria-label="Not">
                                    <option selected> </option>
                                    <option value="NOT"> NOT</option>
                                </select>
                            <input type="text" class="form-control" name = "structure_3d" placeholder="3D Structure">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
<footer>
    <div class="home-footer">
        <div class="footer-sct1">
            <div class="footer-sct1-clm1">
                <div class="footer-logo">
                </div>
                <p></p>
            </div>
            <div class="footer-sct1-clm2">
                <a class="footerlink2" href="contact.jsp">Contact Us</a>
            </div>
        </div>
        <div class="footer-sct2">
            <p class="copyright-notice">
                Copyright © 2022 COVIDproDB | All Rights Reserved.
            </p>
        </div>
    </div>
</footer>
</body>
<style>
    .advanced{

        text-decoration: none;
        font-size: 15px;
        font-weight: 500;
    }
    .advanced{

        color: #31a9f0 !important;
    }
    .collapse.in {
        display: block;
    }

    body{
        margin:0;
        padding:0;
    }

    a{
        text-decoration:none;
        color: black;
    }

    a:hover{
        color:#2a6fb5;
    }


    header{
        padding: 0 25px 0 25px;
        box-shadow: #00000040 0 0 20px 0;
        position: sticky;
        top:0;
        background: white;
    }

    .home-header{
        display:flex;
        justify-content:space-between;
        align-items: center;
    }

    .header-logo img{
        width:70px;
    }

    .headerlink1, .headerlink2, .headerlink3, .headerlink4{
        margin-right:18px;
        font-size: 20px;
    }

    .headerlink1:hover, .headerlink2:hover, .headerlink3:hover, .headerlink4:hover{
        color: #2a6fb5;
    }

    .header-login{
        font-size:20px;
        border-radius: 100px;
        color:white;
        background: #31a9f0;
        padding: 8px 17px 8px 17px;
    }

    .home-sct1-wrapper{
        background-image: url("https://diabetes.org/sites/default/files/styles/crop_large/public/2020-03/Coronavirus_Blog%20Post-min.jpg");
        background-size: cover;
    }

    .home-sct1{
        max-width: 1600px;
        margin: auto;
        padding: 100px 100px 120px 100px;
        background:#0000006e;
        color: white;
    }

    .home-sct1 h2{
        font-weight:normal;
        color: #dadada;
    }

    .home-services{
        display: flex;
        justify-content: space-evenly;
        font-size: 20.5px;
        background: #f0f0f0;
        margin-bottom: -150px;
        margin-top: 90px;
        border-radius: 100px;
        text-align: center;
    }

    .servicelink1, .servicelink2, .servicelink3{
        padding: 30px 0 30px 0;
    }

    .home-sct2-wrapper{
        padding: 70px 100px 250px 100px;
    }

    footer{
        background:black;
    }

    .home-footer{
        max-width:1600px;
        margin:auto;
        color: white;
        padding: 50px 100px 50px 100px;
    }

    .footerlink1, .footerlink2, .footerlink3, .footerlink4{
        margin-right:18px;
        font-size: 20px;
        color: #e4e4e4;
    }

    .footerlink1:hover, .footerlink2:hover, .footerlink3:hover, .footerlink4:hover{
        color: white;
    }

</style>
</html>