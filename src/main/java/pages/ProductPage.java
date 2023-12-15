package pages;

import elements.ProductElements;
import utils.ElementUtil;

import java.util.List;

public class ProductPage extends ProductElements {
    public List<String> getFilmGenres() {
        List<String> genres = ElementUtil.getListOfString(getGeners());
        return genres;
    }
}
