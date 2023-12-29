<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
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
    <title>Create New Protein</title>
</head>

<body>
    <form action="CreateProteinServlet" method="post">
        <div class="p-5 text-center bg-primary bg-opacity-50 text-dark">
                <h1 class="mb-3">Create New Protein</h1>
        </div>
        <div class="container-sm">
            <div class="form-group">
                <label for="Entry"> Entry: </label>
                <input type="text" class="form-control" id = "Entry" name="Entry" placeholder="Enter Entry code">
            </div>
            <div class="form-group">
                <label for="Entry_name"> Entry Name: </label>
                <input type="text" class="form-control" id = "Entry_name" name="Entry_name" placeholder="Enter Entry name">
            </div>
            <div class="form-group">
                <label for="Statuss"> Status: </label>
                <input type="text" class="form-control" id = "Statuss" name="Statuss" placeholder="Enter Status">
            </div>
            <div class="form-group">
                <label for="Protein_names"> Protein name: </label>
                <input type="text" class="form-control" id = "Protein_names" name="Protein_names" placeholder="Enter Protein Name">
            </div>
            <div class="form-group">
                <label for="Gene_names"> Gene name: </label>
                <input type="text" class="form-control" id = "Gene_names" name="Gene_names" placeholder="Enter Gene Name">
            </div>
            <div class="form-group">
                <label for="Organism"> Organism: </label>
                <input type="text" class="form-control" id = "Organism" name="Organism" placeholder="Enter Organism">
            </div>
            <div class="form-group">
                <label for="Length"> Length: </label>
                <input type="number" class="form-control" id = "Length" name="Length" placeholder="Enter Length">
            </div>
            <div class="form-group">
                <label for="Keyword_ID"> Keyword ID: </label>
                <input type="text" class="form-control" id = "Keyword_ID" name="Keyword_ID" placeholder="Enter Keyword ids">
            </div>
            <div class="form-group">
                <label for="Keywords"> Keywords: </label>
                <input type="text" class="form-control" id = "Keywords" name="Keywords" placeholder="Enter Keywords" >
            </div>
            <div class="form-group">
                <label for="Annotation"> Annotation: </label>
                <input type="text" class="form-control" id = "Annotation" name="Annotation" placeholder="Enter Annotation" >
            </div>
            <div class="form-group">
                <label for="structure_3d"> 3D Structure: </label>
                <input type="text" class="form-control" id = "structure_3d" name="structure_3d" placeholder="Enter 3D Structure" >
            </div>
            <div class="form-group">
                <label for="Beta_strand"> Beta strand: </label>
                <input type="text" class="form-control" id = "Beta_strand" name="Beta_strand" placeholder="Enter Beta strand" >
            </div>
            <div class="form-group">
                <label for="Helix"> Helix: </label>
                <input type="text" class="form-control" id = "Helix" name="Helix" placeholder="Enter Helix" >
            </div>
            <div class="form-group">
                <label for="Turn"> Turn: </label>
                <input type="text" class="form-control" id = "Turn" name="Turn" placeholder="Enter Turn" >
            </div>
            <div class="form-group">
                <label for="Topological_domain"> Topological domain: </label>
                <input type="text" class="form-control" id = "Topological_domain" name="Topological_domain" placeholder="Enter Topological domain">
            </div>
            <div class="form-group">
                <label for="Subcellular_location"> Subcellular location: </label>
                <input type="text" class="form-control" id = "Subcellular_location" name="Subcellular_location" placeholder="Enter Subcellular location" >
            </div>
            <div class="form-group">
                <label for="Involvement_in_disease"> Involvement in disease: </label>
                <input type="text" class="form-control" id = "Involvement_in_disease" name="Involvement_in_disease" placeholder="Enter Involvement in disease" >
            </div>
            <button type = "submit" class="btn btn-success btn-edit" > Create </a> </button>
        </div>
    </form>
</body>
</html>
