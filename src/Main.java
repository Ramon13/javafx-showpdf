import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.fit.pdfdom.PDFDomTree;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static void main(String[] args) {
        launch(args);
        }
    
    @Override
    public void start(Stage primaryStage) {
    	generateHTMLFromPDF("/home/ramon/Downloads/testp.pdf");
    	
    	primaryStage.setTitle("JavaFX WebView Example");

        WebView webView = new WebView();

        webView.getEngine().load("file:///home/ramon/temp/pdf.html");

        VBox vBox = new VBox(webView);
        Scene scene = new Scene(vBox, 960, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void generateHTMLFromPDF(String filename){
        try {
			PDDocument pdf = PDDocument.load(new File(filename));
			Writer output = new PrintWriter("/home/ramon/temp/pdf.html", "utf-8");
			new PDFDomTree().writeText(pdf, output);
			 
			output.close();
		} catch (IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
