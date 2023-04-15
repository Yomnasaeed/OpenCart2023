/**
 * Engineer Mohamed Moustafa 2022.
 * All Rights Reserved.
 *
 * ver          Creator          Date        Comments
 * ----- ---------------------  ----------  ----------------------------------------
 * 1.00     Mohamed Moustafa    08/02/2022  - Script created.
 */
package utilities;

import io.qameta.allure.Allure;

public class Reporter {

	private static final Boolean RECORD_VIDEO = true;
	private static final String RECORDING_FOLDER = System.getProperty("user.dir")+ "\\ScreenRecorder"; //System.getProperty("allureResultsFolderPath").trim() + "/" + "recordings/";


	/**
	 * Method to add system out print ln into allure report and console 
	 * @param text insert text to be displayed in console and allure report
	 */
	public static void Log(String text) {
		Allure.step(text);
		System.out.println(text);
	}

	public static Boolean getRecordVideo() {
		return RECORD_VIDEO;
	}
}
