# Selenium Demo

A simple Selenium WebDriver automation project that demonstrates automated login testing.

## Description

This project uses Selenium WebDriver with Java to automate a login test on [The Internet](https://the-internet.herokuapp.com/login) demo website.

## Features

- Automated web browser control using Selenium WebDriver
- Explicit waits for better reliability
- Login form automation
- Success message verification

## Prerequisites

- Java 8 or higher
- Maven
- ChromeDriver (download from [ChromeDriver Downloads](https://chromedriver.chromium.org/downloads))

## Setup

1. Clone this repository
2. Download ChromeDriver and update the path in `Main.java`:
   ```java
   System.setProperty("webdriver.chrome.driver", "YOUR_PATH_TO_CHROMEDRIVER");