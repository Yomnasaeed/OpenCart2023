package tests;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TabletsPage;

public class CheckOnBreadcrumbTest extends TestBase {

    HomePage homeObj;
    TabletsPage tabletsObj;

    @BeforeMethod
    public void beforeTest (){

        homeObj = new HomePage(driver);
        tabletsObj = new TabletsPage(driver);
    }

    @Test
    public void tabletDisplayedInBreadCrumb(){

        homeObj.openTabletsPage();
        tabletsObj.checkTabletBreadCrumb();

    }
}
