package org.foden.constants;

import org.foden.enums.ConfigProperties;
import org.foden.utils.PropertyUtils;

/**
 * The type Framework constants.
 */
public final class FrameworkConstants {

    private FrameworkConstants(){}

    private static final String RESOURCEPATH = System.getProperty("user.dir") + "/src/test/resources";
    private static final String CHROMEDRIVERPATH = RESOURCEPATH + "/executables/chromedriver.exe";
    private static final String CONFIGFILEPATH = RESOURCEPATH + "/config/config.properties";
    private static final String JSONFILEPATH = RESOURCEPATH + "/config/config.json";
    private static final int EXPLICITWAIT = 10;
    private static final String EXCELPATH = RESOURCEPATH + "/excel/testdata.xlsx";
    private static final String EXTENTREPORTPATH = System.getProperty("user.dir") + "/extent-test-output";
    private static final String RUNMANAGERDATASHEET = "RUNMANAGER";
    private static final String ITERATIONDATASHEET = "DATA";

    /**
     * Get explicitwait int.
     *
     * @return the int
     */
    public static int getExplicitwait(){
        return EXPLICITWAIT;
    }

    /**
     * Get chrome driver path string.
     *
     * @return the string
     */
    public static String getChromeDriverPath(){
        return CHROMEDRIVERPATH;
    }

    /**
     * Get config file path string.
     *
     * @return the string
     */
    public static String getConfigFilePath(){
        return CONFIGFILEPATH;
    }

    /**
     * Get jsonfilepath string.
     *
     * @return the string
     */
    public static String getJsonfilepath(){
        return JSONFILEPATH;
    }

    /**
     * Get excelpath string.
     *
     * @return the string
     */
    public static String getExcelpath(){return EXCELPATH;}

    /**
     * Get extentreportpath string.
     *
     * @return the string
     */
    public static String getExtentreportpath(){
        if (PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")){
            return EXTENTREPORTPATH + "/" + System.currentTimeMillis() + "index.html";
        } else return EXTENTREPORTPATH + "/index.html";
    }

    /**
     * Get runmanagerdatasheet string.
     *
     * @return the string
     */
    public static String getRunmanagerdatasheet(){return  RUNMANAGERDATASHEET;}

    /**
     * Get iterationdatasheet string.
     *
     * @return the string
     */
    public static String getIterationdatasheet(){return ITERATIONDATASHEET;}

    /**
     * Is headless boolean.
     *
     * @return the boolean
     */
    public static boolean isHeadless(){
        try {
            return PropertyUtils.get(ConfigProperties.HEADLESS).equalsIgnoreCase("yes");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
