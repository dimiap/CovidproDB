package com.example.covidprodb.models;

import java.sql.Date;

public class Proteins {
    public String entry;
    public String entry_name;
    public String statuss;
    public String protein_names;
    public String gene_names;
    public String organism;

    public Integer length;
    public String keyword_ID;
    public String keywords;
    public String annotation;
    public Date date_of_creation;
    public Date date_of_last_modification;
    public String structure_3d;
    public String beta_strand;
    public String helix;
    public String turn;
    public String topological_domain;
    public String subcellular_location;
    public String involvement_in_disease;

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public String getEntry_name() {
        return entry_name;
    }

    public void setEntry_name(String entry_name) {
        this.entry_name = entry_name;
    }

    public String getStatuss() {
        return statuss;
    }

    public void setStatuss(String statuss) {
        this.statuss = statuss;
    }

    public String getProtein_names() {
        return protein_names;
    }

    public void setProtein_names(String protein_names) {
        this.protein_names = protein_names;
    }

    public String getGene_names() {
        return gene_names;
    }

    public void setGene_names(String gene_names) {
        this.gene_names = gene_names;
    }

    public String getOrganism() {
        return organism;
    }

    public void setOrganism(String organism) {
        this.organism = organism;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getKeyword_ID() {
        return keyword_ID;
    }

    public void setKeyword_ID(String keyword_ID) {
        this.keyword_ID = keyword_ID;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public Date getDate_of_creation() {
        return date_of_creation;
    }

    public void setDate_of_creation(Date date_of_creation) {
        this.date_of_creation = date_of_creation;
    }

    public Date getDate_of_last_modification() {
        return date_of_last_modification;
    }

    public void setDate_of_last_modification(Date date_of_last_modification) {
        this.date_of_last_modification = date_of_last_modification;
    }

    public String getStructure_3d() {
        return structure_3d;
    }

    public void setStructure_3d(String structure_3d) {
        this.structure_3d = structure_3d;
    }

    public String getBeta_strand() {
        return beta_strand;
    }

    public void setBeta_strand(String beta_strand) {
        this.beta_strand = beta_strand;
    }

    public String getHelix() {
        return helix;
    }

    public void setHelix(String helix) {
        this.helix = helix;
    }

    public String getTurn() {
        return turn;
    }

    public void setTurn(String turn) {
        this.turn = turn;
    }

    public String getTopological_domain() {
        return topological_domain;
    }

    public void setTopological_domain(String topological_domain) {
        this.topological_domain = topological_domain;
    }

    public String getSubcellular_location() {
        return subcellular_location;
    }

    public void setSubcellular_location(String subcellular_location) {
        this.subcellular_location = subcellular_location;
    }

    public String getInvolvement_in_disease() {
        return involvement_in_disease;
    }

    public void setInvolvement_in_disease(String involvement_in_disease) {
        this.involvement_in_disease = involvement_in_disease;
    }

    public String ShowAll() { //query pou emfanizei mia lista me ola ta entry numbers ton proteinon kathos kai ton tropo pou exei
        String ShowAllStatement = "SELECT a.Entry,b.beta_strand,b.helix,b.turn FROM General_info as a NATURAL JOIN structure_location as b";
        return (ShowAllStatement);
    }
    public String ShowProteinDetails(){ //query pou emfanizei oles tis plirofories tis proteinis
        String ShowProteinDetailsStatement = "SELECT * FROM General_info NATURAL JOIN annotation NATURAL JOIN Structure_Location WHERE Entry = ?;";
        return (ShowProteinDetailsStatement);
    }
    public String Search(){ //query pou kanei anazitisi onomaton proteinon kai keywords kai emfanizei ta entry tous
        String SearchStatement = "SELECT structure_location.beta_strand,structure_location.helix,structure_location.turn,general_info.Entry FROM general_info NATURAL JOIN annotation NATURAL JOIN structure_location WHERE (general_info.protein_names LIKE ? or annotation.keywords LIKE ?)";
        return (SearchStatement);
    }
}
