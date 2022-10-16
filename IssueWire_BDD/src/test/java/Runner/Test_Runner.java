package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) @CucumberOptions( 
	    features ="C:\\Users\\PERFECT.DESKTOP-HCSN4U9\\git\\IssueWire_BDD\\IssueWire_BDD\\src\\test\\java\\Feature", 
	    glue = {"StepDefitions"}
	   // format={"pretty","json:target/"},
)
public class Test_Runner {

	

}
