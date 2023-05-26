package com.automation.dao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import com.automation.baseClass.BaseClass;
import com.automation.objectRepository.SwagLabLocators;
import com.automation.supportLibraries.Report;
import com.automation.supportLibraries.Util;
public class SwagLabDao extends BaseClass {
	private static Logger logger=LogManager.getLogger(SwagLabDao.class);
	private Util utils;
	private SwagLabLocators slLocatorsPage;

	public SwagLabDao(String scenario) throws Exception {
		this.slLocatorsPage = PageFactory.initElements(driver, SwagLabLocators.class);
		this.utils = new Util();
	}

	/* This method is used to Login into the application */
	public void userLogIn() throws Exception {
		logger.info("In enterCredentials");
		try {
			utils.waitForElement(slLocatorsPage.txtUsername);
			utils.type(slLocatorsPage.txtUsername, "Entered Username: ", configProp.getProperty("slUserName"));
			utils.type(slLocatorsPage.txtPassword, "Entered Password: ",configProp.getProperty("slPassword") , true);
			Report.passTestScreenshotEmbedded(driver, "SwagLab Log In", "UserLogin");
			utils.JSClick(slLocatorsPage.btnLogin);
		} catch (Exception e) {
		}
	}

	/* This method is used to Add the product to the cart */
	public void addproductToCart() throws Exception{
		logger.info("In addproductToCart");
		utils.waitForElement(slLocatorsPage.btnAddItemToCart);
		Report.passTestScreenshotEmbedded(driver, "SwagLab", "Products");
		utils.JSClick(slLocatorsPage.btnAddItemToCart);
		Report.passTestScreenshotEmbedded(driver, "SwagLab", "Products-Add Item to Cart");
		utils.JSClick(slLocatorsPage.btnCart);
		Report.passTestScreenshotEmbedded(driver, "SwagLab", "User Cart");
		utils.JSClick(slLocatorsPage.btnCheckOut);
	}

	/* This method is used to provide the user details */
	public void enterUserInfo() throws Exception {
		logger.info("In enterUserInfo");
		utils.waitForElement(slLocatorsPage.labelfName);
		utils.type(slLocatorsPage.labelfName, "Entered First Name: ",configProp.getProperty("infoFName"));
		utils.type(slLocatorsPage.labellName, "Entered Last Name: ",configProp.getProperty("infoLName"));
		utils.type(slLocatorsPage.labelPostalCode, "Entered Postalcode: ",configProp.getProperty("infoPostalCode"));
		Report.passTestScreenshotEmbedded(driver, "SwagLab", "User Information");
		utils.waitForElement(slLocatorsPage.btnContinue);
	}

	/* This method is used to confirm the order */
	public void productCheckout() throws Exception {
		logger.info("In productCheckout");
		utils.JSClick(slLocatorsPage.btnContinue);
		Report.passTestScreenshotEmbedded(driver, "SwagLab", "ProductInfo");
		utils.JSClick(slLocatorsPage.btnFinish);
		Report.passTestScreenshotEmbedded(driver, "SwagLab", "BackHome");
		utils.JSClick(slLocatorsPage.btnHome);
	}

	/* This method is used to Logout from apllication */
	public void userLogout() throws Exception{
		logger.info("In userLogout");
		utils.JSClick(slLocatorsPage.btnMenu);
		Report.passTestScreenshotEmbedded(driver, "SwagLab", "Logout");
		utils.JSClick(slLocatorsPage.btnLogout);
		Report.passTestScreenshotEmbedded(driver, "SwagLab", "BackToLogin");

	}
}
