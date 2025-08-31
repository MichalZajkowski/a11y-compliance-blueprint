import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.options.UiAutomator2Options
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.openqa.selenium.By
import java.net.URL
import java.time.Duration

class AccessibilityApiTest {

    lateinit var driver: AndroidDriver

    @Before
    fun setUp() {
        // Configuration for connecting to the emulator and the app
        val options = UiAutomator2Options()
            .setPlatformName("Android")
            .setAutomationName("UiAutomator2")
            // IMPORTANT: Change the deviceName below to the EXACT name of your emulator from the AVD Manager
            .setDeviceName("Pixel_6_API_33")
            .setAppPackage("com.example.a11yblueprintapp")
            .setAppActivity(".MainActivity")
            // Optional: prevents the app from being reset for each test
            .setNoReset(true)

        // The address where the running Appium server is listening
        val url = URL("http://127.0.0.1:4723")

        // Initialize the Appium driver
        driver = AndroidDriver(url, options)
        // Set the default implicit wait time for finding elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10))
        println("Driver initialized successfully.")
    }

    @Test
    fun test_osCorrectlyReportsContentDescription() {
        println("Starting test: test_osCorrectlyReportsContentDescription")

        // Step 1: Find the button by its full resource ID
        val buttonId = "com.example.a11yblueprintapp:id/test_button"
        println("Finding element with ID: $buttonId")
        val testButton = driver.findElement(By.id(buttonId))

        // Step 2: Query the OS for the accessibility label (contentDescription)
        val reportedDescription = testButton.getAttribute("content-desc")
        println("Reported content-desc by OS: '$reportedDescription'")

        // Step 3: Assert that the OS's response is correct
        val expectedDescription = "Acceptance Button"
        assertEquals(
            "The Operating System failed to report the correct contentDescription.",
            expectedDescription,
            reportedDescription
        )

        // If we've reached this point, the test has passed
        println("✅ Test PASSED! The OS correctly reported the contentDescription as: '$reportedDescription'")
    }

    @After
    fun tearDown() {
        // Quit the driver session after the test
        driver.quit()
        println("Driver session closed.")
    }
}