package com.ripplestreet.AllPutApis;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.ripplestreet.genricUtilities.putApiUtilities;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class AchivementProgrameControllerPutApi  extends putApiUtilities{
	
	@Test
	public void updateAchivementPrograme() throws IOException {
		Testcase = 13;
		File file = new File(devApiPath);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet(ExcelSheetPageName2);
		XSSFRow row2 = sheet.getRow(Testcase);
		XSSFCell cell2 = row2.getCell(2);
		PutBody = cell2.getStringCellValue();
		System.out.println(PutBody);

		response = RestAssured.given().contentType(ContentType.JSON).body(PutBody).when()
				.put("/benefits-platform/v1/achievementProgram/"+AchievementProgramId);
		
		
	}

}
