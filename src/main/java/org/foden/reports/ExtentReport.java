package org.foden.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.foden.constants.FrameworkConstants;
import org.foden.enums.CategoryType;
import org.foden.utils.PropertyUtils;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * The type Extent report.
 */
public final class ExtentReport {

    private ExtentReport(){}
    private static ExtentReports extent;
    private static String extentreportPath;

    static {
        try {
            extentreportPath = FrameworkConstants.getExtentreportpath();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Init reports.
     */
    public static void initReports(){
        if (Objects.isNull(extent)){
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(extentreportPath);
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("Foden Report");
            spark.config().setReportName("Foden AutomationFW");
        }
    }

    /**
     * Flush reports.
     */
    public static void flushReports(){
        if (Objects.nonNull(extent)){
            extent.flush();
        }
        ExtentManager.unload();
    }

    /**
     * Flush and open reports.
     */
    public static void flushAndOpenReports(){
        if (Objects.nonNull(extent)){
            extent.flush();
        }
        ExtentManager.unload();
        try {
            Desktop.getDesktop().browse(new File(extentreportPath).toURI());
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Create test.
     *
     * @param tcname the tcname
     */
    public static void createTest(String tcname){
        ExtentManager.setExtentTest(extent.createTest(tcname));
    }

    /**
     * Add authors.
     *
     * @param authors the authors
     */
    public static void addAuthors(String[] authors){
        for (String author : authors){
            ExtentManager.getExtentTest().assignAuthor(author);
        }
    }

    /**
     * Add categories.
     *
     * @param categories the categories
     */
    public static void addCategories(CategoryType[] categories){
        for (CategoryType category : categories){
            ExtentManager.getExtentTest().assignCategory(category.toString());
        }
    }
}
