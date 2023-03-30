import java.io.FileOutputStream;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;

public class Start {

    @SuppressWarnings("deprecation")
	public static void main(String[] args) {
        
        // Create a model for the first RDF/XML file
        String rdfFile1 = "/Users/alejandroadriaquelozano/Desktop/FinalProjectGraphs/RDF_new_2/ChEBI2Reactome.rdf";
        Model model1 = ModelFactory.createDefaultModel();
        FileManager.get().readModel(model1, rdfFile1);
        
        // Create a model for the second RDF/XML file
        String rdfFile2 = "/Users/alejandroadriaquelozano/Desktop/FinalProjectGraphs/RDF_new_2/Chebi2formula.rdf";
        Model model2 = ModelFactory.createDefaultModel();
        FileManager.get().readModel(model2, rdfFile2);
        
        // Create a model for the second RDF/XML file
        String rdfFile3 = "/Users/alejandroadriaquelozano/Desktop/FinalProjectGraphs/RDF_new_2/chebi2mass.rdf";
        Model model3 = ModelFactory.createDefaultModel();
        FileManager.get().readModel(model3, rdfFile3);
        
        // Create a model for the first RDF/XML file
        String rdfFile4 = "/Users/alejandroadriaquelozano/Desktop/FinalProjectGraphs/RDF_new_2/Reactome2Organism.rdf";
        Model model4 = ModelFactory.createDefaultModel();
        FileManager.get().readModel(model4, rdfFile4);
        
        // Create a model for the second RDF/XML file
        String rdfFile5 = "/Users/alejandroadriaquelozano/Desktop/FinalProjectGraphs/RDF_new_2/Reactome2Description.rdf";
        Model model5 = ModelFactory.createDefaultModel();
        FileManager.get().readModel(model5, rdfFile5);
        
        // Create a model for the second RDF/XML file
        String rdfFile6 = "/Users/alejandroadriaquelozano/Desktop/FinalProjectGraphs/RDF_new_2/chebi2names.rdf";
        Model model6 = ModelFactory.createDefaultModel();
        FileManager.get().readModel(model6, rdfFile6);
        
        // Create a model for the second RDF/XML file
        String rdfFile7 = "/Users/alejandroadriaquelozano/Desktop/FinalProjectGraphs/RDF_new_2/chebi2database.rdf";
        Model model7 = ModelFactory.createDefaultModel();
        FileManager.get().readModel(model7, rdfFile7);
        
        // Create a model for the second RDF/XML file
        String rdfFile8 = "/Users/alejandroadriaquelozano/Desktop/FinalProjectGraphs/RDF_new_2/reactome2database.rdf";
        Model model8 = ModelFactory.createDefaultModel();
        FileManager.get().readModel(model8, rdfFile8);
        
        // Create a model for the second RDF/XML file
        String rdfFile9 = "/Users/alejandroadriaquelozano/Desktop/FinalProjectGraphs/RDF_new_2/chebi2description_b.rdf";
        Model model9 = ModelFactory.createDefaultModel();
        FileManager.get().readModel(model9, rdfFile9);
        
        // Create a model for the second RDF/XML file
        String rdfFile10 = "/Users/alejandroadriaquelozano/Desktop/FinalProjectGraphs/RDF_new_2/chebi2role.rdf";
        Model model10 = ModelFactory.createDefaultModel();
        FileManager.get().readModel(model10, rdfFile10);
        
        
        
        // Merge the two models into a single model
        Model combinedModel = ModelFactory.createDefaultModel();
        combinedModel.add(model1);
        combinedModel.add(model2);
        combinedModel.add(model3);
        combinedModel.add(model4);
        combinedModel.add(model5);
        combinedModel.add(model6);
        combinedModel.add(model7);
        combinedModel.add(model8);
        combinedModel.add(model9);
        combinedModel.add(model10);
       
        
        // Print the combined model in RDF/XML format
        String outputFile = "combined_10_turtle.rdf";
        try {
            FileOutputStream outputStream = new FileOutputStream(outputFile);
            combinedModel.write(outputStream, "Turtle");
        } catch (Exception e) {
            e.printStackTrace();
    }
    }
    }
