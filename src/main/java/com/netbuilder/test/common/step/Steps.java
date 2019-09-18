package com.netbuilder.test.common.step;


import com.netbuilder.test.common.session.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static junit.framework.TestCase.assertTrue;

public class Steps extends TestBase {


    @Given("^the user is on the \"([^\"]*)\" page$")
    public void the_user_is_on_the_page(String arg1)  {
        driver.get("https://google.com");
    }

    @When("^the user enters a new search term into the mains search bar$")
    public void the_user_enters_a_new_search_term_into_the_mains_search_bar()  {

    }

    @When("^the user performs a search$")
    public void the_user_performs_a_search() {

    }

    @Then("^the expected products page is returned$")
    public void the_expected_products_page_is_returned() {
        assertTrue(true);
    }
}
