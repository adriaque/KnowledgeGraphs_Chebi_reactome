import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.jena.datatypes.xsd.XSDDatatype;
import org.apache.jena.rdf.model.*;
import org.apache.jena.vocabulary.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class XLSXToRDF {
    
    public static void main(String[] args) throws IOException {
        
        // Create a new RDF model
        Model model = ModelFactory.createDefaultModel();
        
        // Read the xlsx file using POI
        Workbook workbook = WorkbookFactory.create(new File("/Users/alejandroadriaquelozano/Desktop/FinalProjectGraphs/Graph_triplets_xlsx/chebi2database.xlsx"));
        Sheet sheet = workbook.getSheetAt(0);
        
        // Loop through each row of the sheet and create a statement for each row
        for (Row row : sheet) {
            String subjectURI = row.getCell(0).getStringCellValue();
            String predicateURI = row.getCell(1).getStringCellValue();
            Cell objectCell = row.getCell(2);
            RDFNode object;
            if (objectCell.getCellType() == CellType.NUMERIC) {
                object = model.createTypedLiteral(objectCell.getNumericCellValue());
            } else if (objectCell.getCellType() == CellType.STRING) {
                object = model.createTypedLiteral(objectCell.getStringCellValue());
            } else if (objectCell.getCellType() == CellType.ERROR) {
                object = model.createTypedLiteral(objectCell.getErrorCellValue(), XSDDatatype.XSDstring);
            } else {
                object = model.createResource(objectCell.getStringCellValue());
            }
            Resource subject = model.createResource(subjectURI);
            Property predicate = model.createProperty(predicateURI);
            model.add(subject, predicate, object);
        }
        
        // Write the RDF model to a file
        try (FileOutputStream out = new FileOutputStream("/Users/alejandroadriaquelozano/Desktop/FinalProjectGraphs/RDF_new_2/chebi2database.rdf")) {
            model.write(out, "RDF/XML");
        }
    }

}

