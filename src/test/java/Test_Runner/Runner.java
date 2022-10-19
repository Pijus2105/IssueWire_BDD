package Test_Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) @CucumberOptions( 
	    features ="C:\\Users\\Elphill\\eclipse-workspace\\IssueWire_BDD\\src\\test\\java\\Features\\tag.feature", 
	    glue = {"stepDefinitions"},
	    
	    //format= {"pretty","html:target/cucumber"}
 plugin= {"pretty","html:target/cucumber-reports"},
	   
 monochrome=true,
 dryRun=false
	   
)

public class Runner {
	
	

}
