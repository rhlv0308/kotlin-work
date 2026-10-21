# UML Class Diagram

Here is a UML class diagram, specified using [Mermaid][mer].

```mermaid
%% Replace this line and the two below
classDiagram
  class Customer {
    name  
    address
    placeOrder()
  }
  class Order {
    orderNumber
    datePlaced
    deliveryDate
    checkStock()
    takePayment()
  }
  class OrderItem{ 
    name
    description
  }
  Customer -- Order : places
  Order -- OrderItem : includes
```


[mer]: https://mermaid.js.org/
