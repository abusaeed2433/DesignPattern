package behavioral.cor;

public class View implements Handler {

    private String name;
    private OnClickListener onClickListener;
    private Handler parent;

    public View(String name) {
        this.name = name;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public void setParent(Handler parent) {
        this.parent = parent;
    }

    @Override
    public void handleClick(ClickEvent event) {
        if(onClickListener != null) {
            System.out.println("Click event handled at " + name);

            onClickListener.onClick(this);
            return; // Click handled
        }

        if(parent != null) {
            System.out.println("Passing click event to parent from " + name);
            parent.handleClick(event); // Pass to parent
        }
        else {
            System.out.println("Click event not handled");
        }
    }

    public interface OnClickListener {
        void onClick(Handler view);
    }

}
