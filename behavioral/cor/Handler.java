package behavioral.cor;

public interface Handler {

    void setParent(Handler parent);

    abstract void handleClick(ClickEvent event);

}
