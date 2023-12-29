<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
        <% if(session.getAttribute("formOfOrigin").equals("showDetails")){ %>
        $(document).ready(function(){
            $("#showOrUpdate :input").prop("disabled", true);
        });
        <%} %>
    </script>
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
        .btn-edit {
            padding: 10px 20px;
            font-size: 20px;
            border-radius: 10px;
            width: 100%;
        }
        form {
            width: 75%;
            margin: 0 auto;
        }
        body {
            padding-bottom: 40px;
        }
        label{
            font-size: 18px;
            font-weight: bold;
        }
    </style>
    <title>${Proteins.entry} Info</title>
</head>

<body>
<% if(session.getAttribute("formOfOrigin").equals("showDetails")){ %>
    <form id ="showOrUpdate" action="ShowProteinDetailsServlet" method="get">
<% } %>
<% if(session.getAttribute("formOfOrigin").equals("edit")){ %>
    <form id ="showOrUpdate" action="EditProteinServlet" method="post">
<% } %>
        <div class="p-5 text-center bg-primary bg-opacity-50 text-dark">
            <% if(session.getAttribute("formOfOrigin").equals("showDetails")){ %>
                <h1 class="mb-3">${Proteins.entry} Information</h1>
            <%} %>
            <% if(session.getAttribute("formOfOrigin").equals("edit")){ %>
                <h1 class="mb-3">Edit ${Proteins.entry} Information</h1>
            <%} %>
        </div>
        <div class="container-sm">
            <div class="form-group">
                <input type="hidden" class="form-control" id = "Entry" name="Entry" value="${Proteins.entry}">
            </div>
            <div class="form-group">
                <label for="Entry_name"> Entry Name: </label>
                <input type="text" class="form-control" id = "Entry_name" name="Entry_name" placeholder="Enter Entry name" value="${Proteins.entry_name}">
            </div>
            <div class="form-group">
                <label for="Statuss"> Status: </label>
                <input type="text" class="form-control" id = "Statuss" name="Statuss" placeholder="Enter Status" value="${Proteins.statuss}">
            </div>
            <div class="form-group">
                <label for="Protein_names"> Protein name: </label>
                <input type="text" class="form-control" id = "Protein_names" name="Protein_names" placeholder="Enter Protein Name" value="${Proteins.protein_names}">
            </div>
            <div class="form-group">
                <label for="Gene_names"> Gene name: </label>
                <input type="text" class="form-control" id = "Gene_names" name="Gene_names" placeholder="Enter Gene Name" value="${Proteins.gene_names}">
            </div>
            <div class="form-group">
                <label for="Organism"> Organism: </label>
                <input type="text" class="form-control" id = "Organism" name="Organism" placeholder="Enter Organism" value="${Proteins.organism}">
            </div>
            <div class="form-group">
                <label for="Length"> Length: </label>
                <input type="number" class="form-control" id = "Length" name="Length" placeholder="Enter Length" value="${Proteins.length}">
            </div>
            <div class="form-group">
                <label for="Keyword_ID"> Keyword ID: </label>
                <input type="text" class="form-control" id = "Keyword_ID" name="Keyword_ID" placeholder="Enter Keyword ids" value="${Proteins.keyword_ID}">
            </div>
            <div class="form-group">
                <label for="Keywords"> Keywords: </label>
                <input type="text" class="form-control" id = "Keywords" name="Keywords" placeholder="Enter Keywords" value="${Proteins.keywords}">
            </div>
            <div class="form-group">
                <label for="Annotation"> Annotation: </label>
                <input type="text" class="form-control" id = "Annotation" name="Annotation" placeholder="Enter Annotation" value="${Proteins.annotation}">
            </div>
            <div class="form-group">
                <label for="Date_of_creation"> Date of creation: </label>
                <input disabled="true" tabindex = "-1" type="date" class="form-control" id = "Date_of_creation" name="Date_of_creation" value="${Proteins.date_of_creation}">
            </div>
            <div class="form-group">
                <label for="Date_of_last_modification"> Date of last modification: </label>
                <input disabled="true" tabindex = "-1" type="date" class="form-control" id = "Date_of_last_modification" name="Date_of_last_modification" value="${Proteins.date_of_last_modification}">
            </div>
            <div class="form-group">
                <label for="structure_3d"> 3D Structure: </label>
                <input type="text" class="form-control" id = "structure_3d" name="structure_3d" placeholder="Enter 3D Structure" value="${Proteins.structure_3d}">
            </div>
            <div class="form-group">
                <label for="Beta_strand"> Beta strand: </label>
                <input type="text" class="form-control" id = "Beta_strand" name="Beta_strand" placeholder="Enter Beta strand" value="${Proteins.beta_strand}">
            </div>
            <div class="form-group">
                <label for="Helix"> Helix: </label>
                <input type="text" class="form-control" id = "Helix" name="Helix" placeholder="Enter Helix" value="${Proteins.helix}">
            </div>
            <div class="form-group">
                <label for="Turn"> Turn: </label>
                <input type="text" class="form-control" id = "Turn" name="Turn" placeholder="Enter Turn" value="${Proteins.turn}">
            </div>
            <div class="form-group">
                <label for="Topological_domain"> Topological domain: </label>
                <input type="text" class="form-control" id = "Topological_domain" name="Topological_domain" placeholder="Enter Topological domain" value="${Proteins.topological_domain}">
            </div>
            <div class="form-group">
                <label for="Subcellular_location"> Subcellular location: </label>
                <input type="text" class="form-control" id = "Subcellular_location" name="Subcellular_location" placeholder="Enter Subcellular location" value="${Proteins.subcellular_location}">
            </div>
            <div class="form-group">
                <label for="Involvement_in_disease"> Involvement in disease: </label>
                <input type="text" class="form-control" id = "Involvement_in_disease" name="Involvement_in_disease" placeholder="Enter Involvement in disease" value="${Proteins.involvement_in_disease}">
            </div>
            <% if(session.getAttribute("formOfOrigin").equals("edit")){ %>
            <button type = "submitx" class="btn btn-info btn-edit"> Edit </a> </button>
            <%} %>
        </div>
    </form>
</body>
</html>
