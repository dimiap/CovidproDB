<%@ page import="java.util.List" %>
<%@ page import="com.example.covidprodb.models.Proteins" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <title>All Proteins</title>
    <style>
        a:link
        {
            color:#FFFFFF;
        }

        a:visited
        {
            color:#FFFFFF;
        }

        a:hover
        {
            color:#FFFFFF;
        }

        h4{
            text-align: center;
            font-family: "Brush Script MT";
        }
        .btn-insert {
            padding: 10px 20px;
            font-size: 20px;
            border-radius: 10px;
            width:59%;
        }
        .center {
            margin-left: auto;
            margin-right: auto;
        }
        table.minimalTable thead th{
            text-align: center;
            font-size: 20px;
        }
        .advanced{

            text-decoration: none;
            font-weight: 500;
        }
        .advanced{

            color: #31a9f0 !important;
        }
        .collapse.in {
            display: block;
        }

    </style>
</head>
<body>
<div class="p-5 text-center bg-light text-dark">
    <h1 class="mb-3">List Of All Proteins</h1>
    <% if(session.getAttribute("username") != null){ %>
    <h4 text-align="center"> Hello ${username} </h4>
</div>
<div class="container">
    <div class="row">
        <div class="col text-center">
            <button type="button" class="btn btn-success btn-insert" name="CreateServlet" width : 70%> <a href="createProtein.jsp"> Insert New Entry </a>
                <i class="fas fa-times"></i>
            </button>
        </div>
    </div>
</div>
<% } %>

<div class="row justify-content-center">
    <div>
        <h3 style="text-align: center"> <a data-toggle="collapse" href="#collapseBeta" role="button" aria-expanded="false" aria-controls="collapseExample" class="advanced">
            Beta Strand  <i class="fa fa-angle-down"></i>
        </a></h3>
    </div>
    <div class="col-6 collapse" id="collapseBeta">
        <table class="table table-responsive minimalTable">
            <thead>
                <tr>
                    <th scope="col">Entry</th>
                    <th scope="col">Actions</th>
                </tr>
            </thead>
            <tbody style="text-align: center">
                <%List<Proteins > entryListBeta = (List<Proteins>) request.getAttribute("entryListBeta");%>
                    <%for( Proteins proteins : entryListBeta) { %>
                <tr>
                    <td>
                        <%=proteins.entry%>
                    </td>
                    <td>
                        <button type="button" name="ShowProteinDetailsServlet" id="ShowProteinDetailsServlet" class="btn btn-primary"> <a href="ShowProteinDetailsServlet?entry=<%=proteins.entry%>&formOfOrigin=showDetails"> See details </a></button>
                        <%if(session.getAttribute("username") != null){ %>
                        <button type="button" class="btn btn-danger" name="DeleteServlet"> <a href="DeleteProteinServlet?entry=<%=proteins.entry%>"> Delete </a>
                            <i class="fas fa-times"></i>
                        </button>
                        <button type = "button" class="btn btn-info" name="EditServlet"> <a href="ShowProteinDetailsServlet?entry=<%=proteins.entry%>&formOfOrigin=edit"> Edit </a>
                        </button>
                        <% } %>
                    </td>
                </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    <div>
        <h3 style="text-align: center"> <a data-toggle="collapse" href="#collapseHelix" role="button" aria-expanded="false" aria-controls="collapseExample" class="advanced">
            Helix  <i class="fa fa-angle-down"></i>
        </a></h3>
    </div>
    <div class="col-6 collapse" id="collapseHelix">
        <table class="table table-responsive minimalTable">
            <thead>
            <tr>
                <th scope="col">Entry</th>
                <th scope="col">Actions</th>
            </tr>
            </thead>
            <tbody style="text-align: center">
            <%List<Proteins > entryListHelix = (List<Proteins>) request.getAttribute("entryListHelix");%>
            <%for( Proteins proteins : entryListHelix) { %>
            <tr>
                <td>
                    <%=proteins.entry%>
                </td>
                <td>
                    <button type="button" name="ShowProteinDetailsServlet" id="ShowProteinDetailsServlet" class="btn btn-primary"> <a href="ShowProteinDetailsServlet?entry=<%=proteins.entry%>&formOfOrigin=showDetails"> See details </a></button>
                    <%if(session.getAttribute("username") != null){ %>
                    <button type="button" class="btn btn-danger" name="DeleteServlet"> <a href="DeleteProteinServlet?entry=<%=proteins.entry%>"> Delete </a>
                        <i class="fas fa-times"></i>
                    </button>
                    <button type = "button" class="btn btn-info" name="EditServlet"> <a href="ShowProteinDetailsServlet?entry=<%=proteins.entry%>&formOfOrigin=edit"> Edit </a>
                    </button>
                    <% } %>
                </td>
            </tr>
            <%}%>
            </tbody>
        </table>
    </div>
    <div>
        <h3 style="text-align: center"> <a data-toggle="collapse" href="#collapseTurn" role="button" aria-expanded="false" aria-controls="collapseExample" class="advanced">
            Turn  <i class="fa fa-angle-down"></i>
        </a></h3>
    </div>
    <div class="col-6 collapse" id="collapseTurn">
        <table class="table table-responsive minimalTable">
            <thead>
            <tr>
                <th scope="col">Entry</th>
                <th scope="col">Actions</th>
            </tr>
            </thead>
            <tbody style="text-align: center">
            <%List<Proteins > entryListTurn = (List<Proteins>) request.getAttribute("entryListTurn");%>
            <%for( Proteins proteins : entryListTurn) { %>
            <tr>
                <td>
                    <%=proteins.entry%>
                </td>
                <td>
                    <button type="button" name="ShowProteinDetailsServlet" id="ShowProteinDetailsServlet" class="btn btn-primary"> <a href="ShowProteinDetailsServlet?entry=<%=proteins.entry%>&formOfOrigin=showDetails"> See details </a></button>
                    <%if(session.getAttribute("username") != null){ %>
                    <button type="button" class="btn btn-danger" name="DeleteServlet"> <a href="DeleteProteinServlet?entry=<%=proteins.entry%>"> Delete </a>
                        <i class="fas fa-times"></i>
                    </button>
                    <button type = "button" class="btn btn-info" name="EditServlet"> <a href="ShowProteinDetailsServlet?entry=<%=proteins.entry%>&formOfOrigin=edit"> Edit </a>
                    </button>
                    <% } %>
                </td>
            </tr>
            <%}%>
            </tbody>
        </table>
    </div>
    <div>
        <h3 style="text-align: center"> <a data-toggle="collapse" href="#collapseUndefined" role="button" aria-expanded="false" aria-controls="collapseExample" class="advanced">
            Undefined  <i class="fa fa-angle-down"></i>
        </a></h3>
    </div>
    <div class="col-6 collapse" id="collapseUndefined">
        <table class="table table-responsive minimalTable">
            <thead>
            <tr>
                <th scope="col">Entry</th>
                <th scope="col">Actions</th>
            </tr>
            </thead>
            <tbody style="text-align: center">
            <%List<Proteins > entryListUndefined = (List<Proteins>) request.getAttribute("entryListUndefined");%>
            <%for( Proteins proteins : entryListUndefined) { %>
            <tr>
                <td>
                    <%=proteins.entry%>
                </td>
                <td>
                    <button type="button" name="ShowProteinDetailsServlet" id="ShowProteinDetailsServlet" class="btn btn-primary"> <a href="ShowProteinDetailsServlet?entry=<%=proteins.entry%>&formOfOrigin=showDetails"> See details </a></button>
                    <%if(session.getAttribute("username") != null){ %>
                    <button type="button" class="btn btn-danger" name="DeleteServlet"> <a href="DeleteProteinServlet?entry=<%=proteins.entry%>"> Delete </a>
                        <i class="fas fa-times"></i>
                    </button>
                    <button type = "button" class="btn btn-info" name="EditServlet"> <a href="ShowProteinDetailsServlet?entry=<%=proteins.entry%>&formOfOrigin=edit"> Edit </a>
                    </button>
                    <% } %>
                </td>
            </tr>
            <%}%>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
