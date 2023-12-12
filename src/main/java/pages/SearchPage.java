package pages;

import elements.SearchResultElements;
import io.qameta.allure.Step;
import utils.ElementUtil;

import java.util.List;

public class SearchPage extends SearchResultElements {

    @Step("Get names of rearch results")
    public List<String> getSearchResults(){

        List<String> results = ElementUtil.getListOfString(getAllProducts());
        return results;
    }
}
