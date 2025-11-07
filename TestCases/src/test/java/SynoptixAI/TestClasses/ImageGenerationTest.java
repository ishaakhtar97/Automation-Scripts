package SynoptixAI.TestClasses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import SynoptixAI.Pages.GraphGeneration;
import SynoptixAI.Pages.ImageGeneration;
import SynoptixAI.Setup.BaseSetup;

public class ImageGenerationTest  extends BaseSetup{
	ImageGeneration image;

	// 🔹 Initialize once before any test runs
	@BeforeClass(alwaysRun = true)
	public void setUpGraph() {
		image = new ImageGeneration(driver);    
		image.turnOnImageTool();
	}


	@Test (priority=3)
	public void imageGeneration() throws InterruptedException 
	{
		image.generateImage();
		Thread.sleep(2000);
	}
}
