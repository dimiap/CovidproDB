package com.example.covidprodb.models;

public class Admin {
    public String username;
    public String pass;

    public Admin(String username, String pass) {
        this.username = username;
        this.pass = pass;
    }
    public String LoginAdmin(){ //query gia na kanei login o admin stin efarmogi
        String loginAdminStatement ="SELECT username,pass FROM administrator WHERE username=? AND pass = ?";
        return(loginAdminStatement);
    }
    public String DeleteProtein(){ //query gia na kanei delete mia proteini apo olous tous pinakes
        String deleteProteinStatement = "DELETE FROM general_info WHERE Entry = ?";
        return (deleteProteinStatement);
    }
    public String EditProtein(){ //query gia na kanei edit mia proteini se olous tous pinakes
        String editProteinStatement = "UPDATE general_info INNER JOIN annotation on General_info.Entry = annotation.Entry INNER JOIN Structure_Location on General_info.Entry = Structure_Location.Entry" +
                " SET general_info.Entry_name = ?, general_info.Statuss = ?, general_info.Protein_names = ?, " +
                "general_info.Gene_names = ?, general_info.Organism = ?, general_info.Length=?, annotation.Keyword_ID = ?, annotation.Keywords = ?, annotation.Annotation = ?, " +
                "structure_location.Date_of_last_modification = ?, structure_location.structure_3d = ?, " +
                "structure_location.Beta_strand =?, structure_location.Helix = ?, structure_location.Turn = ?, structure_location.Topological_domain=?, structure_location.Subcellular_location = ?, structure_location.Involvement_in_disease = ? " +
                "WHERE general_info.Entry = ?";
        return (editProteinStatement);
    }
    public String CreateProteinTableGeneral_Info(){ //query gia tin dimiourgia mia neas proteinis ston pinaka general_info
        String createProteinStatementGeneral_Info = "INSERT INTO general_info(Entry, Entry_name, Statuss, Protein_names, Gene_names, Organism, Length) VALUES(?,?,?,?,?,?,?)";
        return (createProteinStatementGeneral_Info);
    }
    public String CreateProteinTableAnnotation(){ //query gia tin dimiourgia mia neas proteinis ston pinaka annotation
        String createProteinStatementAnnotation = "INSERT INTO annotation (Entry, Keyword_ID, Keywords, Annotation) VALUES(?,?,?,?)";
        return (createProteinStatementAnnotation);
    }
    public String CreateProteinTableStructure_Location(){ //query gia tin dimiourgia mia neas proteinis ston pinaka structure_location
        String createProteinStatementStructure_Location = "INSERT INTO Structure_Location (Entry, Date_of_creation, Date_of_last_modification, structure_3d, Beta_strand, Helix, Turn, Topological_domain, Subcellular_location, Involvement_in_disease) VALUES(?,?,?,?,?,?,?,?,?,?)";
        return (createProteinStatementStructure_Location);
    }
}
