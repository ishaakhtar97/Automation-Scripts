package SynoptixAI.TestClasses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import SynoptixAI.Pages.ImageGeneration;
import SynoptixAI.Setup.BaseSetup;

public class ImageGenerationTest  extends BaseSetup{
	ImageGeneration image;

	// 🔹 Initialize once before any test runs
	@BeforeClass(alwaysRun = true)
	public void setUpGraph() {
		image = new ImageGeneration(driver);    
		
	}


	@Test (priority=3)
	public void imageGeneration() throws InterruptedException 
	{
		image.checkImageGenerationTool();
		Thread.sleep(2000);
	}
}
