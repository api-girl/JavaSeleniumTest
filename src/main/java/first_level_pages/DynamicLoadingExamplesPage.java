package first_level_pages;

import page.Page;
import second_level_pages.Example1Page;
import second_level_pages.Example2Page;

public class DynamicLoadingExamplesPage extends Page {
    private String example1 = "a[href='/dynamic_loading/1']";
    private String example2 = "a[href='/dynamic_loading/2']";

    public Example1Page goToExample1Page(){
        clickByCssSelector(example1);
        return new Example1Page();
    }

    public Example2Page goToExample2Page(){
        clickByCssSelector(example2);
        return new Example2Page();
    }
}
