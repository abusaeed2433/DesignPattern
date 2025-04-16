package behavioral.cor;

public class Main {
    
    public static void main(String[] args) {
        LinearLayout linearLayout = new LinearLayout();

        RelativeLayout relativeLayout = new RelativeLayout();
        relativeLayout.setParent(linearLayout);

        TextView textView = new TextView();
        textView.setParent(relativeLayout);

        int testId = 4;

        if(testId == 1)
        { // textView has click listener, so it will process the click event and won't pass it to parent
            textView.setOnClickListener( v ->{
                System.out.println("--- Processed! ---");
            });

            textView.handleClick( new ClickEvent(0, 0) ); // making a dummy click on textView
        }
        
        if(testId == 2)
        { // Setting click listener to the RelativerLayout, so click on TextView will be processed by RelativeLayout if textview don't have listener
            relativeLayout.setOnClickListener( v ->{
                System.out.println("--- Processed! ---");
            });

            textView.handleClick( new ClickEvent(0, 0) ); // making a dummy click on textView, not RelativeLayout
        }

        if(testId == 3){
            // Setting click listener to the LinearLayout, so click on TextView will go to RelativeLayout, and then linearLayout
            linearLayout.setOnClickListener( v ->{
                System.out.println("--- Processed! ---");
            });

            textView.handleClick( new ClickEvent(0, 0) ); // making a dummy click on textView, not LinearLayout
        }

        if(testId == 4){ // not handling click any where in the sequence
            textView.handleClick( new ClickEvent(0, 0) );
        }

    }

}
