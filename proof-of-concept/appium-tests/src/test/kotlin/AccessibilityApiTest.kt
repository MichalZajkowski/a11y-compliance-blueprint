/*
 * SPDX-License-Identifier: MIT
 * Copyright (c) 2025 Michał Zajkowski
 */

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
        val targetDevice = System.getenv("ANDROID_DEVICE_NAME") ?: "Pixel_6_API_36"
        val appiumHost = System.getenv("APPIUM_HOST") ?: "127.0.0.1"
        val appiumPort = System.getenv("APPIUM_PORT") ?: "4723"

        println("Initializing Driver for Device: '$targetDevice' on $appiumHost:$appiumPort")

        val options = UiAutomator2Options()
            .setPlatformName("Android")
            .setAutomationName("UiAutomator2")
            .setDeviceName(targetDevice)
            .setAppPackage("com.example.a11yblueprintapp")
            .setAppActivity(".MainActivity")
            .setNoReset(true)

        val url = URL("http://$appiumHost:$appiumPort")

        driver = AndroidDriver(url, options)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10))
    }

    @Test
    fun test_osCorrectlyReportsContentDescription() {
        // Step 1: Find the button by its full resource ID
        val buttonId = "com.example.a11yblueprintapp:id/test_button"
        val testButton = driver.findElement(By.id(buttonId))

        // Step 2: Query the OS for the accessibility label (contentDescription)
        val reportedDescription = testButton.getAttribute("content-desc")

        // Step 3: Assert that the OS's response is correct
        val expectedDescription = "Acceptance Button"
        assertEquals(
            "The Operating System failed to report the correct contentDescription.",
            expectedDescription,
            reportedDescription
        )

        println("Test PASSED! The OS correctly reported the contentDescription as: '$reportedDescription'")
    }

    @After
    fun tearDown() {
        if (::driver.isInitialized) {
            driver.quit()
        }
    }
}