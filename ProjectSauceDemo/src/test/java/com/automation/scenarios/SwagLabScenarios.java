package com.automation.scenarios;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.automation.baseClass.BaseClass;
import com.automation.dao.SwagLabDao;
import com.automation.supportLibraries.Report;
public class SwagLabScenarios extends BaseClass {
	public void placeAnOrder(String scenarioName) throws Exception {
		String scenario = "";
		scenario = scenarioName+"_"+new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		BaseClass.scenarioName = scenarioName;
		log.info("Scenario: " + scenario);
		test = Report.testCreate(extent, scenarioName);
		SwagLabDao slDao = new SwagLabDao(scenario);
		slDao.userLogIn();
		slDao.addproductToCart();
		slDao.enterUserInfo();
		slDao.productCheckout();
		slDao.userLogout();
	}
}