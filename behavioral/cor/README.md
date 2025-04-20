
### Introduction
- Chain of Responsibility is a **behavioral** design pattern that lets us pass requests along a chain of handlers.
- Upon receiving a request, each handler decides either to process the request or to pass it to the next handler in the chain.
- It's like stair to reach goal, where each step can decide whether you can go next step or stop there.

<p align="center">
    <img src="https://refactoring.guru/images/patterns/diagrams/chain-of-responsibility/solution1-en-2x.png" alt="Taken from refactoring guru" height="200">
</p>

### Example Scenario
- Let's say we have a design file in Android like this:
    ```xml
    <LinearLayout>
        <RelativeLayout>
            <TextView>
            </TextView>
        </RelativeLayout>
    </LinearLayout>
    ```
- Basically our root layout is linear layout, which contains a relative layout, and the relative layout contains a text-view.
- Let's say a user clicks on the TextView. Should it respond? Yes, it should respond only if we have added a click listener on it, otherwise it should pass it to it parent RelativeLayout.
- The same thing applies for RelativeLayout.


### Implementation
1. The interface Handler
    ```java
    package behavioral.cor;

    public interface Handler {
        void setParent(Handler parent);

        abstract void handleClick(ClickEvent event);
    }
    ```
2. An optional class implementing basic functionalities and variables.
    ```java
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
    ```
3. Few concrete implmentation of the class:

4a. Text View
```java
package behavioral.cor;

public class TextView extends View {

    public TextView() {
        super("TextView");
    }
    
    // other TextView related methods
    
}
```

4b. LinearLayout
```java
package behavioral.cor;

public class LinearLayout extends View {

    public LinearLayout() {
        super("LinearLayout");
    }

    // other LinearLayout related methods

}
```

4c. Relative Layout
```java
package behavioral.cor;

public class RelativeLayout extends View {

    public RelativeLayout() {
        super("RelativeLayout");
    }
    
}
```
And it's done.

### Example usages
1. Creating the design just using parent property.
    ```java
    LinearLayout linearLayout = new LinearLayout();

    RelativeLayout relativeLayout = new RelativeLayout();
    relativeLayout.setParent(linearLayout);

    TextView textView = new TextView();
    textView.setParent(relativeLayout);
    ```
2. Our chain is like  [TextView] -> [RelativeLayout] -> [LinearLayout]. So a click on `TextView` will be handled by the first one in the chain whose condition is fulfilled. In our case, the condition is to have a `OnClickListener != null`.

3. TextView has click listener, so it will process the click event and won't pass it to parent.
    ```java
        textView.setOnClickListener( v ->{
            System.out.println("--- Processed! ---");
        });

        textView.handleClick( new ClickEvent(0, 0) ); // making a dummy click on textView
    ```
    Output:
    ```plain/text
    Click event handled at TextView
    --- Processed! ---
    ```
4. Setting click listener to the RelativerLayout, so click on TextView will be processed by RelativeLayout since textview doesn't have listener.
    ```java
    relativeLayout.setOnClickListener( v ->{
        System.out.println("--- Processed! ---");
    });

    textView.handleClick( new ClickEvent(0, 0) ); // making a dummy click on textView, not RelativeLayout
    ```
    Output:
    ```
    Passing click event to parent from TextView
    Click event handled at RelativeLayout
    --- Processed! ---
    ```
5. Setting click listener to the LinearLayout, so click on TextView will go to RelativeLayout, and then linearLayout.
    ```java
    linearLayout.setOnClickListener( v ->{
        System.out.println("--- Processed! ---");
    });

    textView.handleClick( new ClickEvent(0, 0) ); // making a dummy click on textView, not LinearLayout
    ```
    Output:
    ```
    Passing click event to parent from TextView
    Passing click event to parent from RelativeLayout
    Click event handled at LinearLayout
    --- Processed! ---
    ```
6. Not handling click any where in the sequence
    ```java
    textView.handleClick( new ClickEvent(0, 0) );
    ```
    Output:
    ```
    Passing click event to parent from TextView
    Passing click event to parent from RelativeLayout
    Click event not handled
    ```

### Definition again
- Chain of Responsibility is a **behavioral** design pattern that lets us pass requests(`ClickEvent`) along a chain of handlers(`TextView`, `RelativeLayout`, `LinearLayout`).
- Upon receiving a request, each handler((`TextView`, `RelativeLayout`, `LinearLayout`)) decides either to process the request(if `onClickListener != null`) or to pass it to the next handler in the chain(if `onClickListener == null`).

Let’s learn together!!!
