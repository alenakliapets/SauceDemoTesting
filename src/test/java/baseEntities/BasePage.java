package baseEntities;

import core.BrowserService;

public abstract class BasePage {
    protected static final int WAIT_FOR_PAGE_LOADING_SEC = 15;
    protected final BrowserService browserService;

    protected abstract void openPage();
    public abstract boolean isPageOpened();

    public BasePage(BrowserService browserService, boolean openPageByUrl) {
        this.browserService = browserService;
        if (openPageByUrl){
            openPage();
        }
        waitForOpen();
    }
    protected  void waitForOpen(){
        int secondsCount = 0;
        boolean isPageOpenedIndicator = isPageOpened();
        while (!isPageOpenedIndicator && secondsCount < WAIT_FOR_PAGE_LOADING_SEC){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            secondsCount++;
            isPageOpenedIndicator = isPageOpened();
        }
        if (!isPageOpenedIndicator){
            throw  new AssertionError("Page was not opened");
        }
    }
}
