import java.nio.file.Paths;

import com.microsoft.playwright.*;

public class PlaywrightScript {

	public static void main(String[] args) {
		try (Playwright playwright = Playwright.create()) 
		{
            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();
            page.navigate("http://playwright.dev");
            System.out.println(page.title());
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
            playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
            //BrowserType.LaunchOptions().setHeadless(false)
        }

	}

}
