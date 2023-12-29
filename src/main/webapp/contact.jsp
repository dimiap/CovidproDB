<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Contact Us</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.10.2/css/all.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <style>
        .div-box {
            border-radius: 20px;
            margin: 20px 0px;
            background-color: #ffffff;
            padding-top: 20px;
            box-shadow: 8px 8px 0px 0px #adadad;
        }
        .User-img {
            width: 100px;
            height: 100px;
            border-radius: 50%;
            overflow: hidden;
            border: 1px solid #ddd;
            margin: 0 auto;
        }
        .User-img img{
            width: 100%;
        }
        .User-name {
            text-align: center;
            font-size: 22px;
            margin: 15px 0px 10px;
        }
        .designation {
            text-align: center;
            font-size: 16px;
        }
        .contact-btn {
            margin: 0 auto;
            display: table;
        }
        .contact-btn .btn {
            width: 95px;
            margin: 15px 5px;
        }
        .profile-details ul{
            padding-left: 10px;
        }
        .profile-details ul li{
            list-style: none;
        }
        .profile-details ul li a {
            color: #607d8b;
            text-decoration: none;
            padding: 12px 15px;
            display: block;
            border-bottom: 1px solid #f1f1f1;
            border-left: 3px solid transparent;
            transition: 0.4s;
        }
        .profile-details ul li:last-child a {
            border-bottom: none;
            border-bottom-right-radius: 20px;
        }
        .profile-details ul li a:hover {
            color: #2196F3;
            background-color: #e6f4ff;
            border-left: 3px solid #2196F3;
        }
        .profile-details ul li a i {
            margin-right: 8px;
        }
        .center {
            margin-left: auto;
            margin-right: auto;
        }
    </style>
</head>
<body class="center">
<div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4">
            <div class="div-box">
                <h3 class="User-name">Δήμητρα Αποστολοπούλου</h3>
                <h4 class="designation">Web Developer</h4>
                <div class="profile-details">
                    <ul>
                        <li><a href="#"><i class="fas fa-home"></i> Σχολή: Πληροφορική Πανεπιστημίου Πειραιά</a></li>
                        <li><a href="#"><i class="fas fa-user"></i> ΑΜ:7113132000009</a></li>
                        <li><a href="#"><i class="fas fa-check"></i> Κατασκευή Back-End και κατασκευή Βάσης Δεδομένων</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="col-sm-6 col-md-4">
            <div class="div-box">
                <h3 class="User-name">Μαριλένα Θεοδοροπούλου</h3>
                <h4 class="designation">Web Designer</h4>
                <div class="profile-details">
                    <ul>
                        <li><a href="#"><i class="fas fa-home"></i> Σχολή: Βιολογία Εθνικού και Καποδιστριακού Πανεπιστημίου Αθηνών</a></li>
                        <li><a href="#"><i class="fas fa-user"></i> ΑΜ:...</a></li>
                        <li><a href="#"><i class="fas fa-check"></i> Κατασκευή Front-End και κατασκευή Βάσης Δεδομένων</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
